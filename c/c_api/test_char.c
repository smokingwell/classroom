#include <stdio.h>
#include <ctype.h>


/* test character check function*/
int main(){	
	int i;	
	for(i=0; i<128; i++){		
		char *zTestChar=(isalpha(i))?"is a alpha char":NULL;
		char *zTestNum=(isdigit(i))?"is number":NULL;
		char *zTestCntrl=(iscntrl(i))?"is a control char":NULL;
		char *zTestUpper=(isupper(i))?"is a upper case":NULL;
		char *zTestLower=(islower(i))?"is a lower case":NULL;
		char *zTestPunct=(ispunct(i))?"is a punctual char":NULL;
		printf("ascii %d %c:", i, i);
		if(zTestChar)printf("%s\t", zTestChar);
		if(zTestNum)printf("%s\t", zTestNum);
		if(zTestCntrl)printf("%s\t", zTestCntrl);
		if(zTestUpper)printf("%s\t", zTestUpper);
		if(zTestLower)printf("%s\t", zTestLower);
		if(zTestPunct)printf("%s\t", zTestPunct);
		printf("\n");
	}
	
	int x=0xff25;
	char *zTestHex=(isxdigit)?"is a hexadecimal":NULL;
	char *zTestDigit=(isdigit)?"is a digit":NULL;
	printf("hex:%xd, %d:",x, x);
	if(zTestHex)printf("%s\t", zTestHex);
	if(zTestDigit)printf("%s\t\n", zTestDigit);
	printf(":~\n");
	
}
