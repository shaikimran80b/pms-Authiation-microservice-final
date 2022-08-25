FROM openjdk:8
EXPOSE 8400
ADD target/authorization-microservice.jar authorization-microservice.jar
ENTRYPOINT ["java","-jar","/authorization-microservice.jar"]
