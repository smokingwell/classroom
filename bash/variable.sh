#!/bin/bash -v
#
echo "$@"
echo $*
echo "$1"
echo $#
echo "Your home is:$HOME"
echo "Your Name is:$USER"
echo "Your terminal type is:$TERM"
echo "`date`"
echo "pid:$PPID"
echo "line:${#COMP_LINR}"
echo ${LINENO}

