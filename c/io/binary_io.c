#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int main(){
	int fd = open("binary.txt", O_RDONLY);
	if(fd<0){
			printf("Error open!\n");
			exit(1);
	}
	short int a=0;
	read(fd, &a, 1);
	printf("%c\n", a);
	read(fd, &a, 1);
	printf("%c\n", a);
	close(fd);
	return 0;
}
