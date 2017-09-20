#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <dirent.h>
#include <stdio.h>
#include <assert.h>
#include <string.h>
#include <sys/stat.h>
#include <linux/limits.h>
#include <stdlib.h>

#define MAX_INODES 1024

typedef struct inodepair {
  dev_t st_dev;
  ino_t st_ino;
} dev_inode;

static int opt_apparent_size;
static int opt_follow_links;
static int verified_inodes;
dev_inode inode_pairs[MAX_INODES];

int is_valid(char* path) {
  return strncmp("..", path, strlen(path)) != 0 && strncmp(".", path, strlen(path)) != 0;
}

int already_found_inode(struct stat* stat)
{
  int i;
  for (i=0;i<verified_inodes;i++)
  {
    if (stat->st_dev == inode_pairs[i].st_dev && stat->st_ino == inode_pairs[i].st_ino)
    {
      return 1;
    }
  }
  verified_inodes++;
  inode_pairs[verified_inodes].st_dev = stat->st_dev;
  inode_pairs[verified_inodes].st_ino = stat->st_ino;
  return 0;
}

int du_file(const char* pathname)
{
  struct stat st;
  int status;
  status = opt_follow_links ? stat(pathname, &st) : lstat(pathname, &st);
  if (status)
  {
    char error[1024];
      snprintf(error, 1024, "mdu: impossible d'accéder à \'%s\'", pathname);
      perror(error);
      return 0;
  }

  if (already_found_inode(&st))
  {
    return 0;
  }
  if (S_ISREG(st.st_mode) || S_ISLNK(st.st_mode))
  {
    return opt_apparent_size ? st.st_size : st.st_blocks;
  } else if (S_ISDIR(st.st_mode))
  {
    DIR *dirp;
    struct dirent *dp;
    char entry[PATH_MAX];
    int size;
    size = opt_apparent_size ? st.st_size : st.st_blocks;
    dirp = opendir(pathname);
    assert(dirp != NULL);

    while ((dp = readdir(dirp)))
    {
      if (is_valid(dp->d_name))
      {
        snprintf(entry, PATH_MAX, "%s/%s", pathname, dp->d_name);
        size += du_file(entry);
      }
    }
    printf("%d\t%s\n", size, pathname);
    closedir(dirp);
    return size;
  }
  return -1;
}

int main(int argc, char** argv)
{
  char ch;
  argc = argc;
  opt_follow_links = 0;
  opt_apparent_size = 0;
  verified_inodes = 0;

  while ((ch = getopt(argc, argv, "Lb")) != -1)
  {
    switch (ch) {
    case 'L':
      opt_follow_links = 1;
      break;
    case 'b':
      opt_apparent_size = 1;
      break;
    }
  }
  return du_file(argv[argc-1]);
}
