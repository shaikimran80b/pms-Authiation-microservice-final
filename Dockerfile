FROM openjdk:8
EXPOSE 8400
ADD target/Authorization-Microservice.jar Authorization-Microservice.jar
ENTRYPOINT ["java","-jar","/Authorization-Microservice.jar"]