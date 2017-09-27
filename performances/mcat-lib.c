#include <assert.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <assert.h>
#include <stdio.h>
#include <unistd.h>

void mcat_scd(char *pathname)
{
  int fdRead;
  int nbLu;
  int nbOctets;
  char *contenu;

  nbOctets = 8;
  contenu = (char*) malloc(nbOctets * sizeof(char));

  fdRead = open(pathname, O_RDONLY);
  assert(fdRead != -1);

  while ( (nbLu = read(fdRead, contenu, nbOctets)) > 0 )
  {
    write(STDOUT_FILENO, contenu, nbLu);
  }
  close(fdRead);
  free(contenu);
}


int main(int argc, char **argv)
{
  assert(argc == 2);
  mcat_scd(argv[1]);
  return 0;
}
