#!/bin/bash

start=`date +%s`

sleep 5

end=`date +%s`
duration=$(( $end - $start ))
echo $duration
h=$(( $duration/3600 ))
duration=$(( $duration - $h*3600 ))
m=$(( $duration/60 ))
duration=$(( $duration - $m*60 ))

echo "Time cost:$m hour $m minute $duration second"

