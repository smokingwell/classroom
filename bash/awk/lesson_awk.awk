Begin {}
{print dn: uid=$1 , dc=example, dc=com\n\t}
{print cn: $2 \t  $3\n\t}
{print sn: $3 \n\t}
{print telephoneNumber: $4 \n\t}
