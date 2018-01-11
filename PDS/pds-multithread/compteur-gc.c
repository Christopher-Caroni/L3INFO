#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <assert.h>
#include <pthread.h>


struct gc_fichier {
  char *bloc;
  unsigned long taille;
  unsigned long thread_number;
  unsigned long taux;
};

void *compteur_gc_thread(void *arg)
{
  unsigned long i;
  struct gc_fichier *fic = (struct gc_fichier *) arg;

/*
  printf("calc for thread %lu\n", fic->thread_number);
  printf("i = %lu taille = %lu\n", fic->thread_number, fic->taille);
  */

  for (i = 0; i < fic->taille; i++)
  {
    if (fic->bloc[i] == 'G' || fic->bloc[i] == 'C')
    {
      fic->taux++;
    }
  }

  return NULL;
}

unsigned long compteur_gc(char *bloc, unsigned long taille, unsigned long n_thread) {
    unsigned long i, cptr = 0;
    pthread_t *tid;
    struct gc_fichier *params;
    unsigned long single_offset;

    single_offset = (taille / n_thread);

    tid = malloc(n_thread * sizeof(pthread_t));
    params = malloc(n_thread * sizeof(struct gc_fichier));

/*
    printf("taille totale %lu\n", taille);
    printf("single_offset = %lu\n", single_offset);
*/
    for (i=0;i<n_thread;i++)
    {
      params[i].bloc = bloc + (i * single_offset);
      params[i].taille = single_offset;
      params[i].thread_number = i;
      params[i].taux = 0;;
  /*
      printf("i = %lu, did set %lu, with taille %lu\n", i, params[i].thread_number, params[i].taille);
      */
    }

    for (i=0;i<n_thread;i++)
    {
      pthread_create(&tid[i], NULL, compteur_gc_thread, &params[i]);
    }


    for (i=0;i<n_thread;i++)
    {
      int result;
      pthread_join(tid[i], NULL);
      result = params[i].taux;
      cptr += result;
    }

    return cptr;
}

int main(int argc, char *argv[]) {
    struct stat st;
    int fd;
    char *tampon;
    int lus;
    unsigned long cptr = 0;
    off_t taille = 0;
    struct timespec debut, fin;
    unsigned long n_thread;

    if (argc != 3)
    {
        printf("Usage: %s <bloc genome> <n thread>\n", argv[0]);
        printf("Calcule le taux de GC dans bloc avec n threads\n");
        exit(EXIT_FAILURE);
    }

    n_thread = atoi(argv[2]);

    /* Quelle taille ? */
    assert(stat(argv[1], &st) != -1);
    tampon = malloc(st.st_size);
    assert(tampon != NULL);

    /* Chargement en mémoire */
    fd = open(argv[1], O_RDONLY);
    assert(fd != -1);
    while ((lus = read(fd, tampon + taille, st.st_size - taille)) > 0)
        taille += lus;
    assert(lus != -1);
    assert(taille == st.st_size);
    close(fd);

    /* Calcul proprement dit */
    assert(clock_gettime(CLOCK_MONOTONIC, &debut) != -1);
    cptr = compteur_gc(tampon, taille, n_thread);
    assert(clock_gettime(CLOCK_MONOTONIC, &fin) != -1);

    /* Affichage des résultats */
    printf("Nombres de GC:   %ld\n", cptr);
    printf("Taux de GC:      %lf\n", ((double) cptr) / ((double) taille));

    fin.tv_sec  -= debut.tv_sec;
    fin.tv_nsec -= debut.tv_nsec;
    if (fin.tv_nsec < 0) {
        fin.tv_sec--;
        fin.tv_nsec += 1000000000;
    }
    printf("Durée de calcul: %ld.%09ld\n", fin.tv_sec, fin.tv_nsec);
    printf("(Attention: très peu de chiffres après la virgule sont réellement significatifs !)\n");

    return 0;
}
