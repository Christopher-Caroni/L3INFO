#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <assert.h>
#include <sys/types.h>
#include <wait.h>

static int conjunction;
static int disjunction;
static int short_circuit;

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

  status = (int*) malloc(argc * sizeof(int));
  single_arg[1] = NULL;
  return_value = conjunction ? 1 : 0;

  for (i=0;i<argc;i++)
  {
      pid = fork();
      switch (pid)
      {
        case -1:
          exit(EXIT_FAILURE);
        case 0:
          printf("will exc %s\n", argv[i]);
          single_arg[0] = argv[i];
          execvp(argv[i], single_arg);
          exit(EXIT_FAILURE);
        default:
          waitpid(-1, &status[i], 0);

          if (i == 0)
          {
            return_value = WEXITSTATUS(status[i]);
          } else if (disjunction)
          {
            return_value &= WEXITSTATUS(status[i]);
          } else if (!disjunction){
            return_value |= WEXITSTATUS(status[i]);
          }

          if (short_circuit && disjunction && !return_value)
          {
            exit(EXIT_SUCCESS);
          } else if (short_circuit && conjunction && return_value) {
            exit(EXIT_FAILURE);
          }
      }
  }
  return return_value;
}

int main(int argc, char **argv)
{
  char ch;
  int nb_opts_found;
  /* conjonction par défaut */
  conjunction = 0;
  short_circuit = 0;
  nb_opts_found = 0;

  while ((ch = getopt(argc, argv, "aoc")) != -1)
  {
    switch (ch) {
    case 'a':
      conjunction = 1;
      nb_opts_found++;
      break;
    case 'o':
      disjunction = 1;
      nb_opts_found++;
      break;
    case 'c':
      short_circuit = 1;
      nb_opts_found++;
      break;
    }
  }

  if (!conjunction && !disjunction)
    conjunction = 1;

  /* on ne peut pas avoir les deux en même temps */
  assert( !(conjunction && disjunction));

  return mdo(argc-nb_opts_found-1, argv+nb_opts_found+1);
}
