#!/bin/bash

CPU_UTILIZATION=`grep 'cpu ' /proc/stat | awk '{usage=($2+$4)*100/($2+$4+$5)} END {print usage "%"}'`
CPU_UTILIZATION=${CPU_UTILIZATION%.*}

echo "CPU: "$CPU_UTILIZATION"%"

if (( $CPU_UTILIZATION > 75 ));
then
    exit 2
fi

if (( $CPU_UTILIZATION > 50 ));
then
    exit 1
fi

exit 0
