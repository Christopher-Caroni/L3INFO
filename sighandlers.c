/* mshell - a job manager */

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <signal.h>
#include <sys/wait.h>
#include <errno.h>


#include "jobs.h"
#include "common.h"
#include "sighandlers.h"

/*
 * wrapper for the sigaction function
 */
int sigaction_wrapper(int signum, handler_t * handler) {
  struct sigaction action;

  action.sa_handler = handler;

  sigemptyset(&action.sa_mask);
  sigaddset(&action.sa_mask, SIGSTOP);
  sigaddset(&action.sa_mask, SIGKILL);
  sigaddset(&action.sa_mask, SIGCONT);
  sigaddset(&action.sa_mask, SIGINT);

  action.sa_flags = SA_RESTART;
  if (sigaction(signum, &action, NULL) < 0)
  {
    unix_error("sigaction_wrapper error");
  }

  return 0;
}

/*
 * sigchld_handler - The kernel sends a SIGCHLD to the shell whenever
 *     a child job terminates (becomes a zombie), or stops because it
 *     received a SIGSTOP or SIGTSTP signal. The handler reaps all
 *     available zombie children
 */
void sigchld_handler(int sig) {
  pid_t child_pid;
  int status;
  struct job_t *job;

    if (verbose)
    {
      printf("sigchld_handler: entering\n");
    }

    child_pid = waitpid(-1, &status, WNOHANG|WUNTRACED);


    if (child_pid != -1 ) {
      if (WIFSTOPPED(status)) {
        job = jobs_getjobpid(child_pid);
        if (job != NULL) {
          job->jb_state = ST;
          if (verbose)
            printf("[%d] Arrêté\t %s\n", job->jb_jid, job->jb_cmdline);
        } else if(verbose) {
          printf("Erreur stop job\n");
        }
      } else
      {
        if (verbose && WIFEXITED(status))
        {
          printf("Child finished naturally %d\n", child_pid);
        } else {
          printf("Force kill child %d\n", child_pid);
        }
        jobs_deletejob(child_pid);
      }
    }


    if (verbose)
    {
      printf("sigchld_handler: exiting\n");
    }

    return;
}

/*
 * sigint_handler - The kernel sends a SIGINT to the shell whenver the
 *    user types ctrl-c at the keyboard.  Catch it and send it along
 *    to the foreground job.
 */
void sigint_handler(int sig) {
  pid_t child_pid;
    if (verbose)
    {
      printf("sigint_handler: entering\n");
    }

    child_pid = jobs_fgpid();
    kill(child_pid, sig);

    if (verbose)
    {
      printf("sigint_handler: exiting\n");
    }
    return;
}

/*
 * sigtstp_handler - The kernel sends a SIGTSTP to the shell whenever
 *     the user types ctrl-z at the keyboard. Catch it and suspend the
 *     foreground job by sending it a SIGTSTP.
 */
void sigtstp_handler(int sig) {
  pid_t child_pid;
    if (verbose)
    {
      printf("sigtstp_handler: entering\n");
    }

    child_pid = jobs_fgpid();
    kill(child_pid, sig);

    if (verbose)
    {
      printf("sigtstp_handler: exiting\n");
    }

    return;
}
