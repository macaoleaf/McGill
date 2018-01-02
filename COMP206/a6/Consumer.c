#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <string.h>
/*
Alex Li 260678992
Zisheng Ye 260714548
*/
void consumer(){
	FILE *TURN = fopen("TURN.txt", "rt");
	int c = fgetc(TURN);
	fclose(TURN);
	if ((char) c == '1') { //if good to run
		FILE *DATA = fopen("DATA.txt", "rt");
		printf("%c", (char) fgetc(DATA));
		fclose(DATA); //print out the char
		FILE *TURN = fopen("TURN.txt", "wt");
		fprintf(TURN, "%c", '0'); //pass 0 to TURN for producer
		fclose(TURN);
	}
}
