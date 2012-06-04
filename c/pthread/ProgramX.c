/**
 *  测试用多个线程打开多个文件
 */
#include <pthread.h>
#include <stdio.h>


void *thief_open(void *arg){
	printf("I am not gonna let it go\n");
	FILE *fp;
	fp=fopen((char *)arg,"wt+");
	if(fp==NULL){
			fprintf(stderr, "can't open\n");
			return;
	}
	printf("open %s success\n", (char *)arg);
	char buf[1024]={'a'};
	fwrite(buf,1024,1,fp);
	fflush(fp);
	sleep(1000);
	
	printf("I am quit\n");	
	fclose(fp);
}

int main(int argc, char **argv){
	if(argc<=1){
		printf("At lease, give me one file\nEg:programx file1 file2\n");
		exit(1);
	}
	pthread_t th;
	int i;
	for(i=1;i<argc;i++){
		printf("argv[%d]:%s\n", i, argv[i]);
		pthread_create(&th, NULL, thief_open, argv[i]);	
	}

	pthread_join(th,NULL);
	printf("bye\n");	
	return 0;
}

