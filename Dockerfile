FROM openjdk:8-jre-alpine
LABEL maintainer="ablocker ablocker@163.com"

WORKDIR /ccs
COPY ./target/ccs-1.0.0-SNAPSHOT.jar /ccs/ccs.jar

ENTRYPOINT [ "java", "-jar", "ccs.jar" ]
