all: ifndef CppCallC

%.o:%.c
	$(CC) $(CCFLAGS) -c $<

#--------------special case------------------
#test the usage of ifndef
ifndef:
	gcc  -DMAIN1 -g -o ifndef ifndef.c
#check the reason of the following failed .
#gcc  -DMAIN1  -o ifndef.exe ifndef.c

#test cpp call c
CppCallC:
	gcc -c -g second.c 
	g++ -g -o  first first.cpp second.o
	g++ -g -c forth.cpp 
	gcc -g -o third third.c forth.o
	

clean:
	del *.exe
	
	