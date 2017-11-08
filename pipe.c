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

  fd = calloc(2, (nbcmd-1) * sizeof(int));
  assert(fd);

  for (i=0;i<nbcmd;i++) {
    while (cmds[i][j] != NULL)
    {
      printf("cmd[%d][%d] :",i , j);
      printf("%s\n",cmds[i][j]);
      fflush(stdout);
      j++;
    }
    j=0;
  }

  pipe(fd[0]);
  assert(status == 0);

  ch = fork();
  if (ch == 0)
  {
    close(fd[0][0]);
    assert(dup2(fd[0][1], STDOUT_FILENO) != -1);
    close(fd[0][1]);

    execvp(cmds[0][0], cmds[0]);
    exit(EXIT_FAILURE);
  }

  ch = fork();
  if (ch == 0)
  {
    close(fd[0][1]);
    assert(dup2(fd[0][0], STDIN_FILENO) != -1);
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
