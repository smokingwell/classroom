#!/usr/bin/perl -w

use strict;

if ((scalar(@ARGV) == 0)
    or ($ARGV[0] eq '-?')
    or ($ARGV[0] eq '-h')
    or ($ARGV[0] eq '--help')) {
    print <<EOF;
SVN client tools. Show the log message and diff for a revision.
search-svnlog.pl is needed when search code change via JIRA-number
usage: 
$0 JIRA-number
Scenario: To show all code change which the JIRA-number is contained in the code change logs
e.g: $0 SOA-1419 , $0 BRMS-99
$0 REVISION [WC_PATH|URL]
Scenario: To show a specific revision code change
e.g: $0 r2144 .
$0 REVISION [WC_PATH|URL]
Scenario:  To show a specific revision range code change
e.g: $0 r2144-r2556 . 
EOF
    exit 0;
}

my $revision = shift || die ("Revision argument required.\n");
my $url = shift || "";
my $svn = "svn";

my $prev_revision=0;
my @revision_list;
my $i=0;

if ($revision =~ /r([0-9]+)-r([0-9]+)/) {
  for (my $rev=$1; $rev<=$2; $rev++) {
    $revision_list[$i]=$rev;
    $i++;
  }
} elsif ($revision =~ /r([0-9]+)/) {
  $revision = $1;
  $revision_list[0]=$1;
}elsif ($revision =~ /([A-Za-z]{2,}-[0-9]+)/) {
#  print $1;
  my @rev_infos= `search-svnlog.pl -i "$1\[^0\-9\]" $url |egrep '^r[0-9]+'`;
  foreach my $rev_info (@rev_infos) {
    if( $rev_info =~ /r([0-9]+)|.*/ ) {
      #print "revision is:$1";
      $revision_list[$i]=$1;
      $i++;
    }
  }
}


if (not $url) {
  # If no URL was provided, use the repository root from the current
  # directory's working copy.  We want the root, rather than the URL
  # of the current dir, because when someone's asking for a change
  # by name (that is, by revision number), they generally don't want
  # to have to cd to a particular working copy directory to get it.
  my @info_lines = `${svn} info`;
  foreach my $info_line (@info_lines) {
    if ($info_line =~ s/^Repository Root: (.*)$/$1/e) {
      $url = $info_line;
    }
  }
}

for($i=0; $i<=$#revision_list;$i++){
  system ("${svn} log -v --incremental -r${revision_list[$i]} $url");
}

for($i=0; $i<=$#revision_list;$i++){
  my $prev_revision = ${revision_list[$i]} - 1;
  system ("${svn} diff -r${prev_revision}:${revision_list[$i]} $url");
}

