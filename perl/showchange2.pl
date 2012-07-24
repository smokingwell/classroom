#!/usr/bin/perl -w

use strict;

my @revision_list;
my $i=0;
my $ii=0;
#my $SVNURL="https://svn.devel.redhat.com/repos/jboss-soa";
#my $FreezeRev=3200;
my $SVNURL="https://svn.jboss.org/repos/labs/labs/jbossrules/trunk/";
my $FreezeRev=26591;

open(safe_fh, ">safe_mergelist.txt") || die "Can't open file safe_mergelist.txt: $!\n";
open(risky_fh, ">risky_mergelist.txt") || die "Can't open file risky_mergelist.txt: $!\n";

print scalar(@ARGV);

for ($i=0; $i<=scalar(@ARGV); $i++){
  my $jira=shift;
  print "current proceed $jira\n";
  my @rev_infos= `search-svnlog.pl "$jira\[^0\-9\]" |egrep '^r[0-9]+'`;
  foreach my $rev_info (@rev_infos) {
#    print "relate:$rev_info";
    if ( $rev_info =~ /2009-([0-9]+)-([0-9]+)/ ) {
      if ( $1 >= 5 && $2 >= 18) {
        if( $rev_info =~ /r([0-9]+)|.*/ ) {
          print "target: $rev_info";
          $revision_list[$ii]=$1;
          my $rev_id=$1;
          $ii++;
          my @log_infos= `svn log -v --incremental -r$rev_id`;

          foreach my $log_info (@log_infos) {
            if ($log_info =~ /^\s+[MUA] (.*)$/) {
              print "target file:$1\n";
              system("svn log -v --incremental -r${rev_id}:$FreezeRev ${SVNURL}$1>>$rev_id.txt");
             
#              my @file_logs=`svn log -v --incremental -r${rev_id}:$FreezeRev ${SVNURL}$1 |egrep '^r[0-9]+`;
#              print $#file_logs;
#                 if ($#file_logs >1 ){
#                  print risky_fh "${SVNURL}$1 ";
#                  foreach my $file_log (@file_logs) {
#                    if ($file_log =~ /(r[0-9]+)|.*/ ) {
#                      print risky_fh "$1 ";
#                    }
#                  }
#                  print risky_fh "\n";
#                 } elsif ($#file_logs == 1){
#                  print safe_fh "${SVNURL}$1 ";
#                  if ($file_logs[0] =~ /(r[0-9]+)|.*/ ) {
#                    print safe_fh "$1 \n";
#                 }

            }

          }

        }
      } else {
      print "filter:$rev_info";

    }
    }

  }
}

#for($i=0; $i<=$#revision_list;$i++){
#  print $revision_list[$i];
#  system ("svn log -v --incremental -r${revision_list[$i]} ");
#}
close(safe_fh);
close(risky_fh);
exit;

#if ($revision =~ /([A-Z]{2,}-[0-9]+)/) {
#  print $1;
#  my @rev_infos= `search-svnlog.pl "$1\[^0\-9\]" |egrep '^r[0-9]+'`;
#  foreach my $rev_info (@rev_infos) {
#    if( $rev_info =~ /r([0-9]+)|.*/ ) {
#      #print $1;
#      $revision_list[$i]=$1;
#      $i++;
#    }
#  }
#my @info_lines = `${svn} info`;
#  foreach my $info_line (@info_lines) {
#    if ($info_line =~ s/^Repository Root: (.*)$/$1/e) {
#      $url = $info_line;
#    }
#  }
#
#for($i=0; $i<=$#revision_list;$i++){
#  system ("${svn} log -v --incremental -r${revision_list[$i]} $url");
#}
