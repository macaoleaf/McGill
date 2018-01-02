#include "Consumer.c"
/*
Alex Li 260678992
Zisheng Ye 260714548
*/
void producer(){
  FILE *mydata = fopen("mydata.txt", "rt"); //mydata file
  FILE *TURN = fopen("TURN.txt", "rt");
  int n = fgetc(TURN);
	fclose(TURN);
  if ((char) n == '0') { //if good to run
    int c = fgetc(mydata); //read one char at a time
    if (c != EOF) { //end when mydata is finished
      printf("everytime: %c", (char) c);

      FILE *DATA = fopen("DATA.txt", "wt");
      fprintf(DATA, "%c", (char) c); //pass current char to DATA
      fclose(DATA);

      FILE *TURN = fopen("TURN.txt", "wt");
      fprintf(TURN, "%c", '1'); //pass 1 to TURN for consumer
      fclose(TURN);
    } else {
      puts("All data in the file transferred.");
      fclose(mydata);
      return;
    }
  }
}
