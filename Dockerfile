from openjdk:17
copy ./rest-0.0.1-SNAPSHOT.jar /rest-0.0.1-SNAPSHOT.jar
workdir /
cmd ["java", "-jar", "rest-0.0.1-SNAPSHOT.jar"]