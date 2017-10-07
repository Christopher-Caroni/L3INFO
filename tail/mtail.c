
#include <assert.h>
#include <getopt.h>
#include <stdlib.h>
#include <sys/fcntl.h>
#include <stdio.h>
#include <unistd.h>


/**
 *
 * @param fd the file descriptor for which we want to count the lines for
 * @return -1 if the file is empty, or the number of lines
 */
int count_total_lines(int fd)
{
    int nb_lines = -1;
    char *buffer;
    int bufferSize;
    int status;
    int i;

    assert(fd != -1);

    if (!lseek(fd, 0, SEEK_END))
    {
        return -1;
    }

    lseek(fd, 0, SEEK_SET);

    nb_lines = 0;
    bufferSize = 4096;
    buffer = (char *) malloc(bufferSize * sizeof(char));

    while ((status = read(fd, buffer, bufferSize)))
    {
        /*
        printf("did read %d bytes: \"%.*s\"", status, status, buffer);
         */
        i = 0;
        while (i < status)
        {
            if (buffer[i] == '\n')
            {
                nb_lines++;
            }
            i++;
        }
    }
    return nb_lines;
}

/**
 *
 * Resets the read offset of the file and reads the file until the last newline, where the next character will belong to wanted_line_index.
 *
 * @param fd the file descriptor for which we want to count the lines for
 * @param wanted_line_index the index of the line that we want
 * @return the offset for the wanted line or -1 if failed to find
 */
int seek_until_line(int fd, int wanted_line_index)
{
    /**
     * index of the current line, starts at 0. Incremented immediately once a '\n' is found
     */
    int current_line_index;
    char currentChar;
    int status;
    int i;
    int offset;

    /*
     * If the wanted line is the first line (index 0), the offset value for this line is 0;
     */
    if (!wanted_line_index)
    {
        return 0;
    }

    assert(fd != -1);
    current_line_index = 0;
    offset = 0;

    lseek(fd, 0, SEEK_SET);

    while (current_line_index < wanted_line_index && (status = read(fd, &currentChar, 1)))
    {
        i = 0;
        while (i < status)
        {
            if (currentChar == '\n')
            {
                current_line_index++;
            }
            i++;
        }
        offset++;
    }
    if (current_line_index == wanted_line_index)
    {
        /*
        printf("current line index: %d\n", current_line_index);
        printf("offset for wanted line : %d\n", offset);
         */
        return offset;
    }
    return -1;
}

/**
 *
 * @param fd the file descriptor for which we want to count the lines for
 * @param offset the offset of the line that we will start printing at
 */
void print_file_from_line(int fd, int offset)
{
    char *buffer;
    int status;
    int bufferSize;

    lseek(fd, offset, SEEK_SET);

    bufferSize = 4096;
    buffer = (char *) malloc(bufferSize * sizeof(char));

    /*
    printf("start actual printing\n");
     */

    while ((status = read(fd, buffer, bufferSize)))
    {
        printf("%.*s", status, buffer);
    }

}

/**
 *
 * Counts the number of total lines to start printing from (total-ntail)
 *
 * @param path the path to the file we want to read
 * @param ntail the number of last lines we want to print
 * @return 0 if no error
 */
int tail_simpliste(char *path, int ntail)
{
    int fd;
    int total_lines;
    int offset_for_print_line_index;

    /**
     * the index of the line that we will start printing with
     */
    int start_print_line_index;

    fd = open(path, O_RDONLY);
    assert(fd != -1);

    total_lines = count_total_lines(fd);
    /*
    printf("found %d lines\n", total_lines);
    empty file if (lines == -1)
    */

    if (total_lines)
    {
        start_print_line_index = total_lines - ntail;
        offset_for_print_line_index = seek_until_line(fd, start_print_line_index);
        print_file_from_line(fd, offset_for_print_line_index);
    }
    return 0;
}

int tail_last_lines(int fd, int ntail, int *buffer_size)
{
    int ending_line_count;
    int start_print_line_index;
    int offset_for_print_line_index;

    assert(fd != -1);

    lseek(fd, -*buffer_size, SEEK_END);
    ending_line_count = count_total_lines(fd);

    if (!ending_line_count)
    {
        if (ending_line_count < ntail)
        {
            *buffer_size *= 2;
            return tail_last_lines(fd, ntail, buffer_size);
        } else
        {
            start_print_line_index = ending_line_count - ntail;
            offset_for_print_line_index = seek_until_line(fd, start_print_line_index);
            print_file_from_line(fd, offset_for_print_line_index);
        }
    }
    return 0;
}

int tail_efficace(char *path, int ntail)
{
    int start_buffer_size;
    int fd;
    /**
     * the index of the line that we will start printing with
     */

    if (!ntail)
    {
        return 0;
    }

    fd = open(path, O_RDONLY);
    assert(fd != -1);

    start_buffer_size = 16;
    return tail_last_lines(fd, ntail, &start_buffer_size);
}

/*
 * Accepts ./mtail -n N file
 */
int main(int argc, char **argv)
{
    char ch;
    int nb_lignes;

    assert(argc == 2 || argc == 4);
    nb_lignes = 0;

    while ((ch = getopt(argc, argv, "n:")) != -1)
    {
        switch (ch)
        {
            case 'n':
                nb_lignes = atoi(optarg);
                break;
            default:
                break;
        }
    }

    return tail_simpliste(argv[3], nb_lignes);
}