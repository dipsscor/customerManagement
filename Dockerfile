FROM openjdk:8-jdk-alpine
MAINTAINER Dipankar Chatterjee <dipankar.c@hcl.com>
ADD target/Customer-Management-1.0.jar Customer-Management-1.0.jar
ENTRYPOINT ["java", "-jar", "/Customer-Management-1.0.jar"]
EXPOSE 12001