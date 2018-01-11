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
  FILE *file;
  int ch;

  file = fopen(pathname, "r");
  while ((ch = fgetc(file)) != EOF)
  {
    fputc(ch, stdout);
  }
}


int main(int argc, char **argv)
{
  assert(argc == 2);
  mcat_scd(argv[1]);
  return 0;
}
