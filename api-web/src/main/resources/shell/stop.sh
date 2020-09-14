#!/bin/bash

PID=`ps -ef | grep api-web-*.jar | grep -v grep | awk '{print $2}'`

echo "正在关闭${PID}进程...."

kill ${PID}

sleep 10s

echo "进程${PID}成功...."