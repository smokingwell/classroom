#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *mythread(void *arg) {
  int *p = (int*)arg;
	while((*p)<=200) {
		(*p)+=50;
		sleep(2);
	}
	return NULL;
}
int main(void) {
  int total=1000;
	pthread_t th;
  fprintf(stderr, "Show percentage from 0-20%\n");
	
  int current =0;
	if ( pthread_create(&th, NULL, mythread, &current) != 0) exit(0);
  fprintf(stderr, "Processing......");
  while(current<=200){
    fprintf(stderr, "%3d%%", (int)( (current*100)/total )  );
    sleep(1);
    fprintf(stderr, "\b\b\b\b");
  }

  fprintf(stderr, "\n");
  pthread_join(th, NULL);
	return 0;
}
