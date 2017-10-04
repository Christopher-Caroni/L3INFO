#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <string.h>

/*
ligne debut >= a partir de 1
*/
void print_file(int fd, int ligne_debut)
{
  char contenu[4096];
  char print[4096];
  int status;
  int nb_lignes_lus;
  int i;
  int index_octet_print;

  status = 0;
  nb_lignes_lus = 0;
  index_octet_print = 0;

  lseek(fd, 0, SEEK_SET);

  while ((status = read(fd, contenu, 4096)) && nb_lignes_lus < ligne_debut)
  {
    while (i<status && nb_lignes_lus < ligne_debut)
    {
      if (contenu[i] == '\n')
      {
        nb_lignes_lus++;
        if (nb_lignes_lus == ligne_debut)
        {
          index_octet_print += i + 1;
        }
      }
      i++;
    }
    if (nb_lignes_lus < ligne_debut)
    {
      index_octet_print += status;
    }
  }

  lseek(fd, index_octet_print, SEEK_SET);
  while ((status = read(fd, print, 4096)))
  {
    printf("%s\n", print);
  }
}

int mtail(const char *path, int nb_lignes)
{
  char contenu[4096];
  int status;
  int nb_lignes_total;
  int fd;
  int i;

  int ligne_debut;

  fd = open(path, O_RDONLY);
  assert(fd != -1);

  if (!nb_lignes)
  {
    print_file(fd, 0);
    return 0;
  }


  while ( (status = read(fd, contenu, 4096)) )
  {
    for (i=0;i<status;i++) {
      if (contenu[i] == '\n')
      {
        nb_lignes_total++;
      }
    }
  }
  if (nb_lignes_total)
  {
    nb_lignes_total++;
  }

  if (nb_lignes_total <= nb_lignes)
  {
    ligne_debut = 0;
  } else
  {
    ligne_debut = nb_lignes_total - nb_lignes;
  }
  printf("found %d lines\n", nb_lignes_total);
  printf("need to print %d\n", nb_lignes);
  printf("print from %d\n", ligne_debut);
  print_file(fd, ligne_debut);
  return 0;
}

int main(int argc, char **argv)
{
  char ch;
  char *string_nb_lignes = NULL;
  int nb_lignes;

  assert(argc == 2 || argc == 4);
  nb_lignes = 0;

  while ((ch = getopt(argc, argv, "n:")) != -1)
  {
    switch (ch) {
    case 'n':
      nb_lignes = 1;
      string_nb_lignes = malloc(strlen(optarg));
      strcpy(string_nb_lignes, optarg);
      break;
    }
  }

  if (nb_lignes)
  {
    nb_lignes = atoi(string_nb_lignes);
  }

  return mtail(argv[3], nb_lignes);
}
