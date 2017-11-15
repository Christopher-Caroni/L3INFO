/* mshell - a job manager */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <assert.h>
#include <sys/wait.h>
#include <string.h>

#include "pipe.h"
#include "cmd.h"
#include "jobs.h"

void do_pipe(char *cmds[MAXCMDS][MAXARGS], int nbcmd, int bg)
{
  int **fd;
  int i;
  int status;
  pid_t ch;
  pid_t gid;
  int j;
	char *finalcmd;

  fd = malloc((nbcmd-1)*sizeof(int*));
  for (i=0; i<nbcmd-1; i++)
  {
    fd[i] = malloc(2 * sizeof(int));
    assert(fd[i]);
  }
  assert(fd);

  if (verbose)
  {
    for (i=0;i<nbcmd;i++) {
      j=0;
      while (cmds[i][j] != NULL)
      {
        printf("cmd[%d][%d] :",i , j);
        printf("%s\n",cmds[i][j]);
        fflush(stdout);
        j++;
      }
    }
  }

  status = pipe(fd[0]);
  assert(status == 0);

  ch = fork();
  if (ch == 0)
  {
    setpgid(ch, ch);
    close(fd[0][0]);
    dup2(fd[0][1], STDOUT_FILENO);
    close(fd[0][1]);

    execvp(cmds[0][0], cmds[0]);
    exit(EXIT_FAILURE);
  }

  gid = ch;

  for (i=1;i<nbcmd-1;i++)
  {
    status = pipe(fd[i]);
    assert(status == 0);

    ch = fork();
    if (ch == 0)
    {
      setpgid(ch, gid);
      close(fd[i][0]);

			dup2(fd[i-1][0], STDIN_FILENO);
			dup2(fd[i][1], STDOUT_FILENO);

      close(fd[i][1]);

      execvp(cmds[i][0], cmds[i]);
      exit(EXIT_FAILURE);
    }
  }

  ch = fork();
  if (ch == 0)
  {
    setpgid(ch, gid);
    close(fd[nbcmd][1]);
    dup2(fd[nbcmd-1][0], STDIN_FILENO);
    close(fd[nbcmd-1][0]);

    execvp(cmds[nbcmd][0], cmds[nbcmd]);
    exit(EXIT_FAILURE);
  }

  for (i=0;i<nbcmd-1;i++)
  {
    close(fd[i][0]);
    close(fd[i][1]);
  }


	finalcmd = strcat(cmds[0][0], "|");
	finalcmd = strcat(finalcmd, cmds[1][0]);

  if (bg)
  {
    /* TODO bg */
  } else {
		jobs_addjob(ch, FG, finalcmd);
    waitfg(ch);
  }

  return;
}
