#!/bin/bash

NAME="alaska"
SOURCE=${BASH_SOURCE[0]}

if [[ "$(docker images | grep azshoo/alaska | grep "1\.0")" == "" ]]; then
    docker pull azshoo/alaska:1.0
fi

case $1 in
    "run"     ) docker run -d -p 8091:8091 --name $NAME azshoo/alaska:1.0 java -jar alaska1.0.jar
                while [[ "$(docker logs $NAME | grep "========== ALASKA ==========")" == "" ]]; do
                sleep 0
                done
                ;;
    "stop"    ) docker stop $NAME ;;
    "delete"  ) docker rm $NAME ;;
    "restart" ) bash $SOURCE stop
                bash $SOURCE delete
                bash $SOURCE run ;;
    *         ) echo "command $1 not found"
                exit 1 ;;
esac