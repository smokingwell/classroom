#ifndef _STDIOSET_C_
#define _STDIOSET_C_

#include <stdio.h>
#include <assert.h>

/*
 * learn to use the following standard io funciton set.
 * printf, fprintf, sprintf, vprintf, vfprintf, and vsprintf
 *
 */
void testPrintf();
void testFPrintf();
void testSPrintf();
void testVPrintf();
void testVFPrintf();
void testVSPrintf();
int main(){
	testPrintf();
	testFPrintf();
	testSPrintf();
	testVPrintf();
	testVFPrintf();
	testVSPrintf();

	return 0;
}

/*
 * only printf is system calling.others are application calling.
 * output buffer to screen.
 */
void testPrintf(){
		long l=2007012;
	printf("I want long: %u,",l);
}

/*
 * output buffer to filestream 
 */
void testFPrintf(){
	FILE *fp;
			
	char *filename;
	
	
	//block[1023]=0;
	
	
	filename = "1M.size";
	
	fp = fopen(filename, "a+");
	
	/*int var, var2;
	for (var = 0; var < 1024; ++var) {
		for (var2 = 0; var2 < 1024; ++var2) {
			fprintf(fp,"a,");			
		}
	}
	*/
	long x=2007012;
	fprintf(fp, "%u,",x);

	fclose(fp);
	
}

void testSPrintf(){

}

void testVPrintf(){

}

void testVFPrintf(){

}

void testVSPrintf(){

}

#endif //_STDIOSET_C_
