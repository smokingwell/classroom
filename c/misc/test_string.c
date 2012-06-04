#include <stdio.h>
#include <string.h>
#include "../util/c_test.h"

void printf_ascii(){
	int i;
	for(i=0; i<255; i++){
		printf("%d[%c]\t", i, i);
		if(i%10==0)printf("\n");
	}
}
int main( void ) {
	
	printf_ascii();
	assertTrue( strcmp( "abc", "abc" ) == 0 );
	char *source;
	source="AbC";
//	strlwr(source);
	
	//assertTrue( strcmp(source, "AbC") != 0 );
	
	//assertTrue( strcmp(source, "abc") == 0 );
	
	printf("test successull!\n");
	return 0;
}
