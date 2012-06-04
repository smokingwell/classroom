#include <stdio.h>
#include <stdlib.h>
#include "../util/c_test.h"
int main(){
  assertEquals(4, sizeof(int));
  assertEquals(4, sizeof(long));
  assertEquals(8, sizeof(long long));
	assertEquals(2,(1+1));
	assertEquals(4,2<<1);
	assertEquals(1,2<<32);

	//assertEquals("5","23");
	assertEquals(2,1+1);
	assertEquals(2,3-1);
	assertNever((1==2));
	assertTrue("t"=="t");
	assertTrue('t'=='t');
	printf("test successull!\n");

	return 0;
}
