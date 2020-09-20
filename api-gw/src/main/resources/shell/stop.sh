#!/bin/bash

JAR_NAME=`ls | grep api-gw-*.jar`

ps -ef | grep '${JAR_NAME}' | grep -v grep | awk '{print $2}' | xargs kill

sleep 10s

echo "关闭进程成功...."