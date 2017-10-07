#include <assert.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/fcntl.h>

/**
 *
 * @param fd the file descriptor of the file to print
 * @param ligne_debut the number of the line to print from
 * @param read_offset the offset from which we will start reading to dertermine where ligne_debut is
 */
void print_file(int fd, int ligne_debut, int read_offset) {
    char *readBuffer;
    char *printBuffer;
    int status;
    int nb_lignes_lus;
    int i;
    int print_offset;

    assert(fd != -1);
    assert(ligne_debut >= 0);
    i = 0;
    status = 0;
    nb_lignes_lus = 0;
    print_offset = 0;

    readBuffer = malloc(4096 * sizeof(char));
    printBuffer = malloc(4096 * sizeof(char));

    lseek(fd, read_offset, SEEK_SET);


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

    lseek(fd, print_offset + read_offset, SEEK_SET);
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
        print_file(fd, 0, 0);
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

    print_file(fd, ligne_debut, 0);
    return 0;
}


/**
 *
 * @param fd the file descriptor to tail
 * @param size_buffer  the size of the buffer
 * @param ntail the number of last lines
 * @return 0 if success
 */
int tail_last_lines(int fd, int *size_buffer, int ntail) {
    int status;
    int total_newline;
    int i;
    int total_size_file;
    char *buffer;

    assert(fd != -1);
    assert(*size_buffer > 0);

    status = 0;
    total_newline = 0;
    i = 0;
    total_size_file = 0;

    total_size_file = lseek(fd, 0, SEEK_END);

    /*
    if the buffer is bigger than the file's size, print everything
    */
    if (*size_buffer > total_size_file) {
        /*
        printf("buffer bigger than filesize, will print everything\n");
         */
        print_file(fd, 0, 0);
        return 0;
    }

    buffer = malloc(*size_buffer * sizeof(char));


    lseek(fd, -*size_buffer, SEEK_END);
    while ((status = read(fd, buffer, *size_buffer))) {
        for (i = 0; i < status; i++) {
            if (buffer[i] == '\n') {
                total_newline++;
            }
        }
        /*
        printf("with buffer %d, read: \"%s\"\n", *size_buffer, buffer);
         */
    }

    /*
    printf("found %d newlines\n", total_newline);
     */

    if (total_newline < ntail) {
        *size_buffer *= 2;
        return tail_last_lines(fd, size_buffer, ntail);
    } else {
        print_file(fd, total_newline - ntail, total_size_file - *size_buffer);
    }

    close(fd);
    free(buffer);
    return 0;
}

/**
 *
 * @param path  the path of the file to tail
 * @param ntail the number of last lines
 * @return 0 if success
 */
int tail_efficace(const char *path, int ntail) {
    int fd;
    int size_buffer;

    size_buffer = 4;

    fd = open(path, O_RDONLY);
    assert(fd != -1);
    return tail_last_lines(fd, &size_buffer, ntail);
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

    return tail_efficace(argv[3], nb_lignes);
}