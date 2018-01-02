#include<stdio.h>
#include<stdlib.h>
#include<string.h>
/*
	Name: Zisheng Ye
	McGill ID: 260714548
*/
int main(void){
	//enter the sentence and the key
	char sentence[10000];
	int key;
	int i,j;
	char encrypted[10000];

	printf("Sentence: ");
	scanf("%[^\n]s", sentence);
	//fgets(sentence, 100, stdin);
	printf("Key: ");
	scanf("%d", &key);
	if (key < 1 || key > 25){
		printf("Invalid key input!\n");
		exit(0);
	}

	//display the original message
	printf("Original message: %s", sentence);
	printf("\n");

	//encrypting	
	for (i = 0; i <= strlen(sentence); i++){
		if (sentence[i]==' '){
			encrypted[i]=sentence[i]; //space case
		}else if((sentence[i]-key>='A' && sentence[i]<='Z') || sentence[i]-key>='a'){
			encrypted[i]=sentence[i]-key; //not exceed case
		}else if(sentence[i]-key<'A' || (sentence[i]>='a' && sentence[i]-key<'a')){
			encrypted[i]=sentence[i]+26-key; //exceed case
		}
	}
	printf("Encrypted message: %s", encrypted);
	printf("\n");

	//decrypting
	char decrypted[10000];
	for (j = 0; j < strlen(encrypted); j++){
		if (encrypted[j]==' '){
			decrypted[j]=encrypted[j]; //space case
		}else if((encrypted[j]+key<='z' && encrypted[j]>='a') || encrypted[j]+key<='Z'){
			decrypted[j]=encrypted[j]+key; //not exceed case
		}else if(encrypted[j]+key>'z' || (encrypted[j]<='Z' && encrypted[j]+key>'Z')){
			decrypted[j]=encrypted[j]+key-26; //exceed case
		}
	}
	printf("Decrypted message: %s", decrypted);
	printf("\n");
	return 0;
}

