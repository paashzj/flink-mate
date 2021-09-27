#!/bin/bash

mkdir /opt/sh/flink/logs

java -Xmx128M -Xms128M -XX:MaxDirectMemorySize=256M -jar /opt/sh/flink/mate/flink-mate.jar >/opt/sh/flink/logs/flink_mate.stdout.log 2>/opt/sh/flink/logs/flink_mate.stderr.log
tail -f /dev/null