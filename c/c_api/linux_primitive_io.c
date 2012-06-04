#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <assert.h>

#include "../util/c_test.h"

#define TEST_FILE "test_primitive_io.txt"

void testWriteFile(){	
//	int fd = open(TEST_FILE, O_WRONLY|O_CREAT|S_IRWXU|S_IRGRP|S_IROTH);
	int fd = open(TEST_FILE, O_WRONLY|O_CREAT, S_IRWXU|S_IRGRP|S_IROTH);//or 0744(don't miss 0, 0 means octor decimal)
	system("ls -l "TEST_FILE);
	assertTrue(fd > 0);
	
	if( fd < 0){
		fprintf(stderr, "%s:%d\tFailed to open %s\n", __FILE__, __LINE__, TEST_FILE);
		return;
	}
		
	char *input[]={"line 1:\t1.24\t1.28\t1.33\t1.44\t1.52\t1.88",
				   "line 2:\t2.33\t2.48\t2.55\t2.90\t2.44\t2.55",
				   "line 3:\t3.23\t3.28\t3.55\t3.20\t3.74\t3.28",
				   "line 4:\t4.23\t4.28\t4.55\t4.20\t4.54\t4.28",
			""
	};
	
	int i=0, ret =0;
	while(strlen(input[i])>0){
		ret=write(fd, input[i], strlen(input[i]));
		assertEquals(ret, strlen(input[i]));
		assert(printf("write:%d\n")!=0);
		write(fd, "\n", 1);
		i++;
	}
	
	ret=close(fd);	
	assertEquals(0, ret);
}

void testReadFile(){
	int fd = open(TEST_FILE, O_RDONLY);
	
	if( fd < 0){
		fprintf(stderr, "%s:%d\tFailed to open %s\n", __FILE__, __LINE__, TEST_FILE);
		return;
	}
	
#define BUFFER_SIZE 1024
	
	char buf[BUFFER_SIZE];
	printf("%s contents:\n", TEST_FILE);
	
	int ret = 0;
	
	do{
		memset(buf, 0, BUFFER_SIZE);		
		ret = read(fd, buf, BUFFER_SIZE);
		assert(printf("ret=%d\n", ret)!=0);
		assertTrue(ret >= 0);
		printf("%s\n", buf);		
	}while(ret > 0);
		
	close(fd);
	
}

void testUpdateFile(){
	//try to use standerlize io function
}

void testCreateUniqueTempFile(){
	char template[]="haha-XXXXXX";//xxxxxx is not correct	
	int fd = mkstemp(template);
	printf("%s file has been genrated\n", template);
	char tmp[32]={0};
	close(fd);
	
	sprintf(tmp, "ls -l %s", template);
	system(tmp);
	
}

int main(){	
	system("rm -rf "TEST_FILE);
	
	//write a file
	testWriteFile();
	
	//read a file
	testReadFile();
	
	testCreateUniqueTempFile();
	//update a file
	//testUpdateFile();
	
	
	return 0;
}
