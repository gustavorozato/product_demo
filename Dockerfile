FROM openjdk:19-jdk-alpine
COPY target/spring_demo-0.0.1-SNAPSHOT.jar spring_demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring_demo-0.0.1-SNAPSHOT.jar"]
