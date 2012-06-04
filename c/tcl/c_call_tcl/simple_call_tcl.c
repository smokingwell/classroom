#include <stdio.h>
#include <stdlib.h>
#include <tcl.h>
//int InitProc(Tcl_Interp *interp);
int main(int argc,char *argv){
	Tcl_Interp * interp;
	int code;
	interp=Tcl_CreateInterp();
	code=Tcl_Eval(interp,"puts \"hello world\"");
	code=Tcl_Eval(interp,"set a 12");
	printf("the result is:%s\n",interp->result);
	if(code!=TCL_OK){
		exit(1);
	}
	exit(0);
}
