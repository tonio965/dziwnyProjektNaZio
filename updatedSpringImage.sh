#!/bin/bash
echo removing and creating new spring container
docker stop springWorking1
docker rm springWorking1
docker build . --tag springworkingwontainer
docker run --name springWorking1 -d -p 8082:8082 --network=my-net springworkingwontainer:latest