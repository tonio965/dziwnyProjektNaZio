FROM openjdk:14-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=./target/id-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} id-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/id-0.0.1-SNAPSHOT.jar"]