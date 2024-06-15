from openjdk:17
workdir /app
copy ./rest-0.0.1-SNAPSHOT.jar /app/rest-0.0.1-SNAPSHOT.jar
cmd ["java", "-jar", "rest-0.0.1-SNAPSHOT.jar"]
