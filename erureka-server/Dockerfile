FROM maven:3.8.3-openjdk-17 AS build

COPY target/my-eureka-server.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8761
ENTRYPOINT ["java","-jar","my-eureka-server.jar"]