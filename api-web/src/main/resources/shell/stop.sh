#!/bin/bash

ps -ef | grep api-web-*.jar | grep -v grep | awk '{print $2}' | xargs kill

sleep 10s