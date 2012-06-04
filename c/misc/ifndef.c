#include <stdlib.h>

#ifdef MAIN1
int main(void){
	printf("it's main1");
return 1;
}
#endif

#ifdef MAIN2
int main(void){
	printf("it's main2");
	return 1;
}
#endif

/*
int main(void){
	printf("it's main\n");
return 0;
}
*/