#!/bin/bash
# ------------------------------------------------------
# Usage: used to start mockapp
# ------------------------------------------------------


DIR=$(dirname `readlink -m $0`)
cd $DIR/..

JAVA_OPTS="-Xms200m -Xmx512m"
MOCKAPP_OPTS="--spring.config.location=config/application.properties"

exec java $JAVA_OPTS -jar target/mockapp.jar $MOCKAPP_OPTS

