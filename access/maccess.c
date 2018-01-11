#include <unistd.h>
#include <stdio.h>
#include <limits.h>
#include <errno.h>

  int vflag, rflag, wflag, xflag;

/* affiche la valeur des constantes NAME_MAX et PATH_MAX */
void prlimit() {
  printf("%d\n", NAME_MAX);
  printf("%d\n", PATH_MAX);
}

void usage(char * prog) {
  printf("usage : %s [rvwx] file\n", prog);
}

/* test les droits rwx sur un ou plusieurs fichiers */
int maccess(int argc, char * * argv) {
  int i, mode, result;

  /* if the user didn't specify any permissions to test, exit */
  if (!rflag && !wflag && !xflag)
  {
    usage("maccess");
    return 1;
  }

  if (vflag)
  {
    printf("OPTIONS verbose:%i, read:%i, write:%i, exec:%i\n", vflag, rflag, wflag, xflag);
    printf("REMAINING %i ARGS:\n", argc);
  }

  for (i = 0; i < argc; i++)
  {
    if (vflag)
    {
      printf("\t%s\n", argv[i]);
    }

    mode = 0;
    if (rflag)
    {
      mode = mode | R_OK;
    }
    if (wflag)
    {
      mode = mode | W_OK;
    }
    if (xflag)
    {
      mode = mode | X_OK;
    }

    result = access(argv[i], mode);
    if (result)
    {
      if (vflag) {
        perror("erreur");
      }
      return 1;
    } else {
      if (vflag)
      {
        printf("%s\n", "acces confirmé");
      }
    }
  }
  return result; /* last result is the global result for all the files */
}

int main(int argc, char * * argv) {
  int ch;
  vflag = 0;
  rflag = 0;
  wflag = 0;
  xflag = 0;
  while ((ch = getopt(argc, argv, "vrwxh")) != -1) {
    switch (ch) {
    case 'v':
      vflag = 1;
      break;
    case 'r':
      rflag = 1;
      break;
    case 'w':
      wflag = 1;
      break;
    case 'x':
      xflag = 1;
      break;
    case 'h':
    default:
      usage(argv[0]);
    }
  }
  argc -= optind;
  argv += optind;
  return maccess(argc, argv);
}
