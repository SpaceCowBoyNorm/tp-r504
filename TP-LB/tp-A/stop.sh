#!/bin/bash

docker stop nginx1 2>/dev/null
docker stop nginx2 2>/dev/null
docker stop nginx-lb 2>/dev/null
docker network rm tplb 2>/dev/null