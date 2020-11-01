#!/bin/bash

docker pull sadsamba/heatclinic:0.9.0
docker run -it --rm -p 8080:8080 -p 8443:8443 -p 9001:9001 sadsamba/heatclinic:0.9.0
