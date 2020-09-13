#!/bin/bash

LOG_DIR=`pwd`/logs

JAR_NAME=`ls | grep api-web-*.jar`

echo "JAVA_HOME：${JAVA_HOME}"

export PATH
echo `java -version`

${JAVA_HOME}/bin/java -Xms512m -Xmx512m -XX:+HeapDumpOnOutOfMemoryError \
 -XX:HeapDumpPath=${LOG_DIR} -XX:ErrorFile=${LOG_DIR}/java_error_%p.log \
 -jar `pwd`/${JAR_NAME}

echo "api-web 启动成功..."