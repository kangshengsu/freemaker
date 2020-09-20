#!/bin/bash

ps -ef | grep 'api-web-1.0-SNAPSHOT.jar' | grep -v grep | awk '{print $2}' | xargs kill

sleep 10s

echo "关闭进程成功...."