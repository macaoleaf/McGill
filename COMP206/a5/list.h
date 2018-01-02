#ifndef LIST_H
#define LIST_H
struct NODE {
  int data;
  struct NODE *next;
};
//function signatures
void newList();
int addNode(int n);
void prettyPrint();
#endif
