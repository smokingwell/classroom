#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(){

  int i;
  fprintf(stderr, "\nTotal.................. 100%%");
  fprintf(stderr, "\nProcessing.................. 0%%");
  for (i=1; i<100; i++) {
    fprintf(stderr, "\b\b\b");
    fprintf(stderr, "%2d%%", i);
    //fprintf(stderr, "\%");
    sleep(1);
  }
  fprintf(stderr, "\n");
}
