#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <assert.h>
#include <sys/types.h>
#include <wait.h>

#define conjunction_opt "-a"
#define disjunction_opt "-o"

static int conjunction;
static int disjunction;

int verify_command(char *arg)
{
  return strcmp(arg, conjunction_opt) && strcmp(arg, disjunction_opt);
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

  status = (int*) malloc(argc * sizeof(int));
  single_arg[1] = NULL;
  return_value = conjunction_opt ? 1 : 0;

  for (i=0;i<argc;i++)
  {
    if (verify_command(argv[i]))
    {
      pid = fork();
      switch (pid)
      {
        case -1:
          exit(EXIT_FAILURE);
        case 0:
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
      }
    }
  }
  return return_value;
}

int main(int argc, char **argv)
{
  char ch;
  /* conjonction par défaut */
  conjunction = 0;

  while ((ch = getopt(argc, argv, "o")) != -1)
  {
    switch (ch) {
    case 'a':
      conjunction = 1;
      break;
    case 'o':
      disjunction = 1;
      break;
    }
  }

  if (!conjunction && !disjunction)
    conjunction = 1;

  /* on ne peut pas avoir les deux en même temps */
  assert( !(conjunction && disjunction));

  return mdo(argc-1, argv+1);
}
