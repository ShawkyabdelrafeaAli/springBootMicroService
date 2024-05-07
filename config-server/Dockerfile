FROM maven:3.8.3-openjdk-17 AS build

COPY target/my-config-server.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8888
ENTRYPOINT ["java","-jar","my-config-server.jar"]