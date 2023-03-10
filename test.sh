#!/usr/bin/sh

docker run -d \
    --rm \
    --name some-mysql \
    -e MYSQL_ROOT_PASSWORD=10101010 \
    -e MYSQL_DATABASE=ccs \
    -e TZ=Asia/Shanghai \
    -p 3306:3306 \
    mysql:8-debian --character-set-server=utf8mb4 --collation-server=utf8mb4_general_ci

# -v "$PWD/data":/var/lib/mysql \

docker run -d \
    --rm \
    --name some-mq \
    -e RABBITMQ_DEFAULT_USER=rbmq \
    -e RABBITMQ_DEFAULT_PASS=10101010 \
    -p 5672:5672 \
    rabbitmq:alpine
