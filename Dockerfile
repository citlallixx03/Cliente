FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/rest-0.0.1-SNAPSHOT.jar /app/rest-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "rest-0.0.1-SNAPSHOT.jar"]
