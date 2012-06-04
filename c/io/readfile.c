#include <stdio.h>
#include <assert.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>


int main(){
	system("echo 'first line'> test.txt");
	system("echo 'second line'>> test.txt");
	system("echo 'third line'>> test.txt");

	FILE *fp=fopen("test.txt", "rt");
	assert(fp!=NULL);
	int i=0;
	while(!feof(fp)){
		char buffer[40];
//		do{
				memset(buffer,0,40);
				fgets(buffer, 40, fp);

//		}while(!feof(fp)&&buffer[0]==0);//ignore the empty line case
		i++;
		printf("output %d: %s\n", i,buffer);
	

	}
	printf("can I call feof ag:%d", feof(fp));
	fclose(fp);
	system("rm -rf test.txt");
	return 0;
}
