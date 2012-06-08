#!/bin/bash
# this is a lession training according to awk
#question 1
echo "Username:Firstname:Lastname:Telephone number" >/tmp/lesson_awk.input
echo "BEGIN {FS=\":\"}" >/tmp/lesson_awk.awk

	  echo {print "\"dn: uid=\"\$1 \", dc=example, dc=com\n\t\""} >>/tmp/lesson_awk.awk
	  echo {print "\"cn:\" \$2 \"\t \" \$3\"\n\t\""} >>/tmp/lesson_awk.awk
	  echo {print "\"sn: \"\$3 \"\n\t\""} >>/tmp/lesson_awk.awk
	  echo {print "\"telephoneNumber: \"\$4 \"\n\t\""} >>/tmp/lesson_awk.awk
awk -f /tmp/lesson_awk.awk /tmp/lesson_awk.input
#question 2

