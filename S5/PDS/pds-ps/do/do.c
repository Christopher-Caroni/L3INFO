#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <assert.h>
#include <sys/types.h>
#include <wait.h>

static int conjunction_opt;
static int disjunction_opt;
static int short_circuit_opt;
static int kill_children_opt;

void kill_children(int nb_pids, int pids[])
{
  int i;
  for (i=0;i<nb_pids;i++)
  {
  kill(pids[i], SIGKILL);
  }
}

/*
returns:
0: no problem
1: one or more errors
*/
int mdo(int argc, char **argv)
{
  int *status;
  int pid;
  int i;
  int return_value;
  char *single_arg[2];
  int *children_pids;

  status = (int*) malloc(argc * sizeof(int));
  children_pids = (int*) malloc(argc * sizeof(int));

  single_arg[1] = NULL;
  return_value = conjunction_opt ? 1 : 0;

  for (i=0;i<argc;i++)
  {
      pid = fork();
      switch (pid)
      {
        case -1:
          exit(EXIT_FAILURE);
        case 0:
          /*
          printf("will exc %s\n", argv[i]);
          */

          single_arg[0] = argv[i];
          execvp(argv[i], single_arg);
          exit(EXIT_FAILURE);
        default:
          children_pids[i] = pid;
          break;
      }
  }

  for (i=0;i<argc;i++)
  {
    waitpid(-1, &status[i], 0);
    /*
    printf("waited for pid %d, index %d with status %d\n", wait_pid_result, i, WEXITSTATUS(status[i]));
    */

    if (i == 0 && !short_circuit_opt)
    {
      return_value = WEXITSTATUS(status[i]);
    } else if (!short_circuit_opt && disjunction_opt)
    {
      return_value &= WEXITSTATUS(status[i]);
    } else if (!short_circuit_opt && !disjunction_opt){
      return_value |= WEXITSTATUS(status[i]);
    }

    if (kill_children_opt && disjunction_opt && !return_value)
    {
      kill_children(argc, children_pids);
      exit(EXIT_SUCCESS);
    } else if (short_circuit_opt && conjunction_opt && return_value) {
      kill_children(argc, children_pids);
      exit(EXIT_FAILURE);
    }
  }

  return return_value;
}

int main(int argc, char **argv)
{
  char ch;
  int nb_opts_found;
  /* conjonction par défaut */
  conjunction_opt = 0;
  short_circuit_opt = 0;
  nb_opts_found = 0;

  while ((ch = getopt(argc, argv, "aock")) != -1)
  {
    switch (ch) {
    case 'a':
      conjunction_opt = 1;
      nb_opts_found++;
      break;
    case 'o':
      disjunction_opt = 1;
      nb_opts_found++;
      break;
    case 'c':
      short_circuit_opt = 1;
      nb_opts_found++;
      break;
    case 'k':
      kill_children_opt = 1;
      nb_opts_found++;
      break;
    }
  }

  if (!conjunction_opt && !disjunction_opt)
    conjunction_opt = 1;

  /* on ne peut pas avoir les deux en même temps */
  assert( !(conjunction_opt && disjunction_opt));

  return mdo(argc-nb_opts_found-1, argv+nb_opts_found+1);
}
