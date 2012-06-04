#include <assert.h>
#include <string.h>
#include <stdio.h>
#include "../util/c_test.h"

int main(){
	char *s="01234567890";
	char *p=index(s, '0');
	assertEquals(11, strlen(p));
	p++;
	p=index(p, '0');
	assertEquals(1, strlen(p));
	
	p=rindex(s, '0');
	assertEquals(0, strcmp("0", p));
	
	//memccpy ���ص���Ŀ�ĵش����ҵ����ض��ַ�����һ���ַ�ָ��λ�ã� ���Ҹ���Ҳֻ�������ض��ַ�Ϊֹ�����Ŀ�괮�в��޷����ض��ַ����򲻷������ƣ�����ֵ��ΪNULL��
	char a[]="string[a]";
	char b[]="string(b)";
	p = memccpy(a, b, 'b', sizeof(a));
	assert(printf("a:%s\tp:%s\n",a, p)>0);
	assertEquals(0, strcmp("string(b]", a));
	assertEquals(0, strcmp("]", p));
	p = memccpy(a, b, 'c', sizeof(a));
	assertEquals(NULL, p);
	
	char a1[]="hello moto";
	assertEquals(11, sizeof(a1));
	p = (char*)memchr((void *)a1, 'o', sizeof(a1));
	assertEquals(0, strcmp("o moto", p));
	
#if 0
	//memfrob is only supported by linux
	char a2[]="this is a critical section data";
	p = (char*)memfrob( (void*)a2, sizeof(a2));
	printf("First call memfrob: %s length:%d", p, strlen(p));
	
	p = (char*)memfrob( (void*)a2, sizeof(a2));
	printf("Second call memfrob: %s length:%d", p, strlen(p));
#endif
	
	strcspn();
	
	return 0;
}
