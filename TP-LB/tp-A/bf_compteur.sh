#!/bin/bash

Hello1=0
Hello2=0

for i in {1..500}
do
    response=$(curl http://localhost:83)

    if echo "$response" | grep -q "Hello 1"; then
        ((count1++))
    elif echo "$response" | grep -q "Hello 2"; then
        ((count2++))
    fi
done

echo "Hello1 : $count1"
echo "Hello2 : $count2"

