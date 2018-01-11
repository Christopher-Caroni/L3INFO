#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

void count(int time)
{
  int max;
  int i;
  int counter;

  counter = 0;
  max = 100000000;

/*
  printf("started counting for %d\n", getpid());
*/
  for (i=0;i<max;i++) {
    counter++;
  }
  printf("finished counting for the %dst time %d\n", time, getpid());
}

int course()
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
        count(1);
        count(2);
        exit(EXIT_SUCCESS);
      default:
        break;
    }
  }

  for (i=0;i<nb_fils;i++)
  {
    pid = wait(&status);
    printf("dans père: fils %d a terminé\n", pid);
  }
  return 0;
}

int main(void)
{
  return course();
}
