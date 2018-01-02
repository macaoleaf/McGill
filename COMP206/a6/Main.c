#include "Producer.c"
/*
Alex Li 260678992
Zisheng Ye 260714548
*/
int main(){
	FILE *TURN = fopen("TURN.txt", "wt");
	fprintf(TURN, "%c", '0'); //initialization
	fclose(TURN);
	int pid = fork();
	printf("pid: %d\n", pid);
	if (pid > 0) {
		producer();
		usleep(3000);
	} else if (pid == 0) {
		consumer();
	}
	return 0;
}
