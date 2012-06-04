#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

int markEnd=0;
void *mythread(void *arg) {
  int *count =(int*)arg;
	while((*count)<4) {
		printf("my thread\n");
		sleep(1);
    (*count)++;
	}
  markEnd=1;
  
	return ;
}
int main(void) {
	pthread_t th=NULL;
	
  printf("th:%p", th);

  int i=0;
	if ( pthread_create(&th, NULL, mythread, &i) != 0) exit(0);
	int count = 0;
  printf("\nnow th:%p", th);
  while(!markEnd){
    fprintf(stderr, "\nsleep 1 sec.");
    sleep(1);
  }

  printf("\nafter end th:%p", th);
  pthread_join(th, NULL);
  printf("\nafter join th:%p", th);

	return 0;
}
