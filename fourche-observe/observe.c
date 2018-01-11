#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

void child_work()
{
  while (1)
  {
    printf("%d still alive\n", getpid());
    sleep(5);
  }
}

int observe()
{
  int nb_fils;
  int i;
  int pid;
  int status;

  nb_fils = 10;

  for (i=0;i<nb_fils;i++)
  {
    switch (pid = fork())
    {
      case -1:
        perror("creation de fils");
        exit(EXIT_FAILURE);
      case 0:
        child_work();
        exit(EXIT_SUCCESS);
      default:
        break;
    }
  }

  system("ps");

  for (i=0;i<nb_fils;i++)
  {
    pid = wait(&status);
    printf("dans père: fils %d a terminé\n", pid);
  }

  return 0;
}

int main(void)
{
  return observe();
}
