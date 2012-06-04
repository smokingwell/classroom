#the makefile can only worked on linux
#run all the app

VPATH=$(RYANHOME)\classroom\c\io

AppTarget= \
			StdIoSet.exe\
			readfile.exe\
			showPercentage.exe\


TestCaseTarget= \
	
all: $(AppTarget) $(TestCaseTarget)


$(AppTarget):$(subst .exe,.o,$(AppTarget))
	$(CC) -o $@ $(subst .exe,.o,$@)
#	@echo "*********************************"
#	@./$@
#	@echo "*********************************"


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
include ../Makefile
