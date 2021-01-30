#!/bin/bash
myvariable=$(whoami)
echo removing and creating new spring container
docker stop springWorking1
docker rm springWorking1
docker build . --tag springworkingwontainer
docker run --name springWorking1 -v /Users/$myvariable/projectContainerData2:/myApp/folder -p 8082:8082 --network=my-net springworkingwontainer:latest