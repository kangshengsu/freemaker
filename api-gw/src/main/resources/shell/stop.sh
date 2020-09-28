#!/bin/bash

JAR_NAME=`ls | grep api-gw-*.jar`

echo "jar名称：${JAR_NAME}"

PID=`ps -ef | grep "${JAR_NAME}" | grep -v grep | awk '{print $2}' `

echo "java 进程ID：${PID}"

ps -ef | grep "${JAR_NAME}" | grep -v grep | awk '{print $2}' | xargs kill

sleep 10s

echo "关闭进程成功...."