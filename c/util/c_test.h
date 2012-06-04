
/* include <stdio.h> for printf, <stdlib.h> for exit */

#define assertTrue(value)  if ( !(value) )        {printf("assertTrue fails: %s %d\n", __FILE__, __LINE__); exit(1);}
#define assertNever(value) if (value)             {printf("assertNever fails: %s %d\n", __FILE__, __LINE__); exit(1);}
#define assertEquals(a, b) if ( !( (a) == (b) ) ) {printf("assertEquals fails: %s %d expected:%d, actual:%d\n", __FILE__, __LINE__, a, b); exit(1);}
