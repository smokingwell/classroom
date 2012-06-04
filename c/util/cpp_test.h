#include <iostream.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define assertTrue(value)  if ( !(value))        {printf("assertTrue fails at: %s %d\n", __FILE__, __LINE__); exit(1);}
#define assertNever(value) if (!(value))             {printf("assertNever fails at: %s %d\n", __FILE__, __LINE__); exit(1);}
#define assertEquals(a, b) if ( !isEquals(a,b) ) {printf("assertEquals fails at: %s %d \n", __FILE__, __LINE__); exit(1);}
#define assertNotEquals(a, b) if ( isEquals(a,b) ) {printf("assertEquals fails at: %s %d \n", __FILE__, __LINE__); exit(1);}
#define fail(message) {printf("%s ,assert fails at: %s %d\n", message,__FILE__, __LINE__); exit(1);}

  template < class T >
 	bool isEquals(T expected,T actual){
	 		if (expected == actual) return true;;
	        cout << "expected:" <<expected << ", actual:" << actual<<", ";
	      	return false;
        	//fail("assertEquals failed!");
 	}
 	bool isEquals(char *expected,char* actual){
 		if(strcmp(expected,actual)==0)return true;
 		cout << "expected:" <<expected << ", actual:" << actual<<", ";
 		return false;
 		}
