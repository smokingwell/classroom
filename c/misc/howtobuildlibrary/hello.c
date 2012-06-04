#include <stdio.h>
#include "simpleFunc.h"

int main(){
	int x=10, y=5;
	printf("hello,dare!\n");
	printf("call library:%d + %d =%d\n", x, y, add(x,y) );
	return 0;

}
