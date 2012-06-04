AppTarget= \
			SimpleThread.exe\
			ProgramX.exe\
			threadPercentageShow.exe\

TestCaseTarget= \

all: $(AppTarget) $(TestCaseTarget)

$(AppTarget):$(subst .exe,.o,$(AppTarget))
	$(CC) -o $@ $(subst .exe,.o,$@)

$(TestCaseTarget):$(subst .exe,.o,$(TestCaseTarget))
	$(CC) -o $@ $(subst .exe,.o,$@) ../TestSuite/Test.o
	@echo "*********************************"
	@./$@
	@echo "*********************************"


../TestSuite/Test.o:
	cd ../TestSuite && make

%.o:%.c
	$(CC) $(CCFLAGS) -c $< -lpthread

#--------------special case------------------
#test the usage of ifndef

#test cpp call c
include ../Makefile
