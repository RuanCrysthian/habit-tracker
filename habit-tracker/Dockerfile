FROM openjdk:17-alpine

WORKDIR /app

COPY target/habit-tracker-0.0.1-SNAPSHOT.jar /app/habit-tracker-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "habit-tracker-0.0.1-SNAPSHOT.jar"]