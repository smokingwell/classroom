#the makefile can only worked on linux
#run all the app
CPP=g++
CC=gcc
CPPFLAGS= -Wno-deprecated
#CCFLAGS= -DNDEBUG
CCFLAGS= 
EXEFLAG=-o
VPATH=D:\e7104c\classroom\c\basic

AppTarget= \
			linux_convert_data.exe\
			linux_char.exe\
			linux_regex.exe\
			linux_primitive_io.exe\
			linux_string.exe\
			
RunTarget =linux_string.exe
			

TestCaseTarget= \

	

all: AllApp AllTestCase

clean:
	rm -rf  *.o *.exe
	
AllApp:$(AppTarget)
	@echo "*********************************"
	@./$(RunTarget)
	@echo "*********************************"

$(AppTarget):$(subst .exe,.o,$(AppTarget))
	$(CC) -o $@ $(subst .exe,.o,$@)


AllTestCase:$(TestCaseTarget)

$(TestCaseTarget):$(subst .exe,.o,$(TestCaseTarget))
	$(CC) -o $@ $(subst .exe,.o,$@) ../TestSuite/Test.o
	@echo "*********************************"
	@./$@
	@echo "*********************************"


../TestSuite/Test.o:
	cd ../TestSuite && make

%.o:%.c
	$(CC) $(CCFLAGS) -c $<

#--------------special case------------------
#test the usage of ifndef

#test cpp call c

