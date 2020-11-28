#!/bin/bash

echo CREATING DOCKER NETWORK AND DB FROM compose
pwd
cd ./filesToUseWithDocker/compose/ 
docker network create -d bridge my-net
docker-compose up -d
pwd
cd ../..
pwd
docker build . --tag springworkingwontainer
docker run --name springWorking1 -d -p 8082:8082 --network=my-net springworkingwontainer:latest
