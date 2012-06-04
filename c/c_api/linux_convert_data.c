#include <stdio.h>
#include "../util/c_test.h"

/*test convert function*/
int main(){	
	assertEquals(123, atoi("123abc"));
	assertEquals(123.56, atof(" 123.56"));
	assertEquals(2.003, atof(200.3e-2));
	assertEquals(12345678, atol("1234568"));

}
