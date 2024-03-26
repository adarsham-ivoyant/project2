FROM openjdk:17

WORKDIR /app
COPY target/Film-0.0.1-SNAPSHOT.jar /app/Film.jar

ENTRYPOINT ["java", "-jar", "Film.jar"]