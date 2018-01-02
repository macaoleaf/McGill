#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/*
Name: Zisheng Ye
McGill ID: 260714548
*/
void FindRecord(char *filename, char *name, char record[]) {
	char buffer[1000] = {'\0'};
	FILE *info = fopen(filename, "rt");
	if (info == NULL) {
		exit(1); //if the file does not exist, show error message
	}
	while(fgets(buffer, 1000, info)) {
		int tf = 1;
		for (int i = 0; buffer[i]!=','; i++) {
			if(name[i] != buffer[i]){
				tf = 0;
				break;
			}
		}
		if (tf == 1) {
			for(int j = 0; j < sizeof(buffer); j++){
				record[j]=buffer[j];
			}
		}
	}
	if (record[0] == '\0') {
		printf("Record not found!\n");
		exit(0);
	}
	fclose(info);
}

void Replace(char *name, char *newname, char record[]) {
	char temp[1000] = {'\0'};
	int i = 0;
	while(*(record+i) != ','){
		i++;
	} //i is the position of the comma
	int j = 0;
	while (*(newname+j) != '\n') {
		*(temp+j) = *(newname+j);
		j++;
	} //j is the length of newname
	int k = 0;
	while (*(record+i+k) != '\0') {
		*(temp+j+k) = *(record+i+k);
		k++;
	}
	*(temp+j+k) = '\0';
	int l = 0;
	while (*(temp+l) != '\0') {
		*(record+l) = *(temp+l);
		l++;
	}
	*(record+l)='\0';
}

void SaveRecord(char *filename, char *name, char record[]) {
	char buffer[1000] = {'\0'};
	//copy the new version to a temp file
	FILE *info = fopen(filename, "rt");
	FILE *temp = fopen("temp.csv", "wt");
	int n = 0;
	while(fgets(buffer, 1000, info)) {
		int tf = 1;
		for (int i = 0; buffer[i]!=','; i++) {
			if(name[i] != buffer[i]){
				tf = 0;
				break;
			}
		}
		if (tf == 1) {
			fprintf(temp, "%s", record);
		} else {
			fprintf(temp, "%s", buffer);
		}
		n++;
	}
	fclose(temp);
	fclose(info);
	//rewrite the original file according to the temp file
	char anotherBuffer[1000] = {'\0'};
	FILE *tempAgain = fopen("temp.csv", "rt");
	FILE *newinfo = fopen(filename, "wt");
	while(fgets(anotherBuffer, 1000, tempAgain)) {
		fprintf(newinfo, "%s", anotherBuffer);
	}
	fclose(newinfo);
	fclose(tempAgain);
}

int main() {
	char name[1000] = "\0", newname[1000] = "\0"; //expecting inputs
	char *filename = "phonebook.csv";
	char record[1000] = {'\0'};
	printf("Enter the name you want to replace: ");
	fgets(&name, 1000, stdin);
	FindRecord(filename, name, record);
	printf("One matched record: %s\n", record);
	printf("Enter the new name: ");
	fgets(&newname, 1000, stdin);
	Replace(name, newname, record);
	printf("New entered record: %s\n", record);
	SaveRecord(filename, name, record);
	return 0;
}
