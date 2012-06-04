BEGIN {print "***WARNING WARNING WARNING****"} 
/\<92%/ {print "Partition " $6 "\t: " $5 "  full!"}
END {print "Give money for new disks URGENTLY!"}
