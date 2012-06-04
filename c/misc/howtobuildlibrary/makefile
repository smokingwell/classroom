all:clean hello.exe hello_static.exe

hello.exe: hello.o simpleFunc.dll
	gcc -o hello.exe hello.o  -L./ -lsimpleFunc

hello_static.exe: hello.o simpleFunc.o
	gcc -o $@ $^

hello.o:hello.c
	gcc -c hello.c

simpleFunc.dll:simpleFunc.o
	gcc -shared -o $@ $^

simpleFunc.o:simpleFunc.c
	gcc -DBUILD_DLL -c $^
clean:
	del hello.exe *.dll