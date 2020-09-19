#!/bin/bash

ps -ef | grep `pwd` | grep -v grep | awk '{print $2}' | xargs kill

sleep 10s

echo "关闭进程成功...."