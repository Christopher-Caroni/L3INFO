#include <sys/types.h>

// inet
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#include <unistd.h>
#include <netdb.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define h_addr h_addr_list[0] /* Compatibilité anciennes versions */
#define PORT 49500


int main(int argc, char** argv) {

	int sock = socket(AF_INET, SOCK_DGRAM, 0);
	struct sockaddr_in sin;
	struct hostent *hostinfo;

	if (argv[1] == NULL || argv[2] == NULL) {
		printf("Utilisation: %s <hostname> <message>\n", argv[0]);
		exit(1);
	}

	if(sock == -1) {
	    perror("socket()");
	    exit(errno);
	}

	// Connexion
	hostinfo = gethostbyname(argv[1]); /* on récupère les informations de l'hôte auquel on veut se connecter */
	if (hostinfo == NULL) { /* l'hôte n'existe pas */
    	fprintf (stderr, "Unknown host: %s.\n", argv[1]);
    	exit(EXIT_FAILURE);
	}

  if (argv[2] == NULL) {
    fprintf(stderr, "Invalid message\n");
    exit(1);
  }

	sin.sin_addr = *(struct in_addr *) hostinfo->h_addr;
	sin.sin_port = htons(PORT); /* get the port with htons */
	sin.sin_family = AF_INET;

	if(connect(sock,(struct sockaddr *) &sin, sizeof(struct sockaddr)) == -1) {
    	perror("connect()");
    	exit(errno);
	}

	// equivalent to sendto(sockfd, buf, len, flags, NULL, 0);
	if(send(sock, argv[2], strlen(argv[2]), 0) < 0) {
	    perror("send()");
	    exit(errno);
	}


	close(sock);
	return 0;
}
