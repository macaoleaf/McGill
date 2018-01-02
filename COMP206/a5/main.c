#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include "list.h"

int main() {
  int n;
  puts("Please enter a positive number:");
  scanf("%d", &n);
  if (n > 0) {
    newList();
    while(addNode(n) == 0){ //while true
      puts("Please enter a positive number:");
      scanf("%d", &n);
    }
    prettyPrint();
  }
  return 0;
}
