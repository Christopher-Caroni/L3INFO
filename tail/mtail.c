#include <assert.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/fcntl.h>

void print_file(int fd, int ligne_debut) {
    char *readBuffer;
    char *printBuffer;
    int status;
    int nb_lignes_lus;
    int i;
    int print_offset;

    assert(fd != -1);
    i = 0;
    status = 0;
    nb_lignes_lus = 0;
    print_offset = 0;

    readBuffer = malloc(4096 * sizeof(char));
    printBuffer = malloc(4096 * sizeof(char));

    lseek(fd, 0, SEEK_SET);


    /*
     * Set a variable "print index", the index of the byte from which we will print
     * "newline print number" => the number of newline from which we will print
     * For the whole file, read in chunks of 4096 bytes.
     * For each chunk, if the number of newlines found is less than the number of the newline print number:
     *      scan each char =>
     *           If we encounter a newline, increment the number of newlines found
     *           If the number of newlines found equals the number of the newline from which we need to print
     *                  add the byte position of the (newline+1) to the print index.
     * If we don't encounter a newline in the whole chunk
     *      add the number of bytes in the chunk to the print index.
     */
    while ((status = read(fd, readBuffer, 4096)) && nb_lignes_lus < ligne_debut) {
        while (i < status && nb_lignes_lus < ligne_debut) {
            if (readBuffer[i] == '\n') {
                nb_lignes_lus++;
                if (nb_lignes_lus == ligne_debut) {
                    print_offset += i + 1;
                }
            }
            i++;
        }
        if (nb_lignes_lus < ligne_debut) {
            print_offset += status;
        }
    }

    lseek(fd, print_offset, SEEK_SET);
    while ((status = read(fd, printBuffer, 4096))) {
        printf("%s", printBuffer);
    }

    close(fd);
    free(readBuffer);
    free(printBuffer);
}

/*
 * Counts the number of lines, then calls print_file() with the index of where to start printing
 */
int mtail(const char *path, int nb_lignes_voulu) {
    char contenu[4096];
    int status;
    int nb_lignes_total;
    int fd;
    int i;

    int ligne_debut;

    nb_lignes_total = 0;

    fd = open(path, O_RDONLY);
    assert(fd != -1);

    if (!nb_lignes_voulu) {
        print_file(fd, 0);
        return 0;
    }

    while ((status = read(fd, contenu, 4096))) {
        for (i = 0; i < status; i++) {
            if (contenu[i] == '\n') {
                nb_lignes_total++;
            }
        }
    }

    /*
     * nb_lignes_total already contains (separators+1) because of how files are read
     */

    if (nb_lignes_total < nb_lignes_voulu) {
        ligne_debut = 0;
    } else {
        ligne_debut = nb_lignes_total - nb_lignes_voulu;
    }

    print_file(fd, ligne_debut);
    return 0;
}

/*
 * Accepts ./mtail -n N file
 */
int main(int argc, char **argv) {
    char ch;
    int nb_lignes;

    assert(argc == 2 || argc == 4);
    nb_lignes = 0;

    while ((ch = getopt(argc, argv, "n:")) != -1) {
        switch (ch) {
            case 'n':
                nb_lignes = atoi(optarg);
                break;
            default:
                break;
        }
    }

    return mtail(argv[3], nb_lignes);
}