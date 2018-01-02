#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include "list.h"

struct NODE *head; //set as private

void newList(){
  head = NULL;
}

int addNode(int n){
  if (n > 0) {
    struct NODE *add = (struct NODE*) malloc(sizeof(struct NODE));
    add -> data = n;
    add -> next = head; //to change the sequence
    head = add;
    return 0; //true
  } else {
    return 1; //false
  }
}

void prettyPrint(){
  //should print from the head, this is the reversed sequence
  struct NODE *position = head;
  while (position != NULL) { //traverse the whole list
    printf("%d\t", position -> data);
    position = position -> next; //change to the next node
  }
}
