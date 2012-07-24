#!/usr/bin/perl -w

use strict;

# ====================================================================
# Show the log message and diff for a revision.
#
#    $ showmodified.pl [WPATH] -c ""


my $svn = "svn";

my $url= "";

my @info_lines= `${svn} info`;

foreach my $info_line (@info_lines) {
  if ($info_line =~ s/^URL: (.*)\s+$/$1/e) {
    $url = $info_line;
  }
}
my $target= shift || "";

my @status_lines = `${svn} status $target`;
print "Code change summary:\n";
print "===================================================================\n";

foreach my $status_line (@status_lines) {
  if ($status_line =~ s/^[M]\s+(.*)\s+$/$1/e) {
    print "${url}/$status_line is to be Changed!\n";

  } elsif ($status_line =~ s/^[A]\s+(.*)\s+$/$1/e) {
    print "${url}/$status_line is to be Added!\n";

  } elsif ($status_line =~ s/^[D]\s+(.*)\s+$/$1/e) {
    print "${url}/$status_line is to be Deleted!\n";

  }
}

print "\n\nDetails:\n";
print "===================================================================\n";

@status_lines = `${svn} status $target`;
foreach  my $status_line (@status_lines) {
  if ($status_line =~ s/^[MAD]\s+(.*)$/$1/e) {
# -w used for igonore space difference
    system ("${svn} diff  -x -w --no-diff-deleted $status_line");
#    system ("${svn} diff  $status_line");
  }
}

