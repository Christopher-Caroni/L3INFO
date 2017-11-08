/* mshell - a job manager */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <assert.h>
#include <sys/wait.h>
#include "pipe.h"

void do_pipe(char *cmds[MAXCMDS][MAXARGS], int nbcmd, int bg) {
  int **fd;
  int i;
  int status;
  pid_t ch;
  int j;


  for (i=0;i<nbcmd;i++) {
    while (cmds[i][j] != NULL)
    {
      printf("cmd[%d][%d] :%s\n",i , j, cmds[i][j]);
      j++;
    }
  }

  fd = malloc(2 * (nbcmd-1) * sizeof(int));

  pipe(fd[0]);
  assert(status == 0);

  ch = fork();
  if (ch == 0)
  {
    close(fd[0][0]);
    dup2(fd[0][1], STDOUT_FILENO);
    close(fd[0][1]);

    execvp(cmds[0][0], cmds[0]);
    exit(EXIT_FAILURE);
  }

  ch = fork();
  if (ch == 0)
  {
    close(fd[0][1]);
    dup2(fd[0][0], STDIN_FILENO);
    close(fd[0][0]);

    execvp(cmds[1][0], cmds[1]);
    exit(EXIT_FAILURE);
  }

  close(fd[0][0]);
  close(fd[0][1]);

  wait(NULL);
  wait(NULL);
  return;
}
