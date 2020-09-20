#!/bin/bash

LOG_DIR=`pwd`/logs

echo "日志目录：${LOG_DIR}"

mkdir -p ${LOG_DIR}

JAR_NAME=`ls | grep api-web-*.jar`

echo "jar名称：${JAR_NAME}"

echo "JAVA_HOME：${JAVA_HOME}"

source /etc/profile

nohup ${JAVA_HOME}/bin/java -Xms512m -Xmx512m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${LOG_DIR} -XX:ErrorFile=${LOG_DIR}/java_error_%p.log -jar `pwd`/${JAR_NAME} > ${LOG_DIR}/api-web.log 2>&1 &

echo `jobs`

sleep 10s

echo "api-web 启动成功..."