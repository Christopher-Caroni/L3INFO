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
	pid_t pid;
  pid_t gid;
	int i;
  int j;
	char whole_cmd[MAXLINE];
  int first_cmd;

  first_cmd = 1;

  fd = malloc((nbcmd-1)*sizeof(int*));
  for (i=0; i<nbcmd-1; i++)
  {
    fd[i] = malloc(2 * sizeof(int));
    assert(fd[i]);
  }

  for (i=0;i<nbcmd;i++) {
    j=0;
    while (cmds[i][j] != NULL)
    {
      if (first_cmd)
      {
        sprintf(whole_cmd, "%s ", cmds[i][j]);
      } else {
        sprintf(whole_cmd + strlen(whole_cmd), "%s ", cmds[i][j]);
      }
      first_cmd = 0;
      j++;
    }
    if (i != nbcmd-1)
    {
      strcat(whole_cmd, "| ");
    }
  }


	assert(pipe(fd[0]) != -1);

	switch(pid = fork()) {
		case -1:
			printf("Error while piping\n");
		case 0 :
			setpgid(0, 0);
			dup2(fd[0][1], STDOUT_FILENO);
			close(fd[0][1]);
			close(fd[0][0]);
			execvp(cmds[0][0], cmds[0]);
			assert(0);
	}

  gid = pid;

	for(i = 1; i<nbcmd- 1; i++){
		assert(pipe(fd[i]) != -1);

		switch(fork()){
			case -1:
  			printf("Error while piping\n");
		case 0 :
			setpgid(0, gid);
			dup2(fd[i][1], STDOUT_FILENO);
			dup2(fd[i-1][0], STDIN_FILENO);

      for(j=0; j<i; j++){
				close(fd[j][0]);
				close(fd[j][1]);
			}

			execvp(cmds[i][0],cmds[i]);
			assert(0);
		}
	}

	switch(fork()){
		case -1:
			printf("Error while piping\n");
		case 0 :
			setpgid(0, gid);
			dup2(fd[i-1][0],STDIN_FILENO);
			for(j=0; j<i; j++){
				close(fd[j][0]);
				close(fd[j][1]);
			}

			execvp(cmds[i][0],cmds[i]);
			assert(0);
	}

	for(j=0; j<nbcmd-1; j++){
		close(fd[j][0]);
		close(fd[j][1]);
	}

	if(bg) {
		jobs_addjob(gid, BG, whole_cmd);
	} else {
		jobs_addjob(gid, FG, whole_cmd);
		waitfg(gid);
	}

	return;
}
