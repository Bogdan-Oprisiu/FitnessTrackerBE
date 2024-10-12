FROM openjdk:21-jdk-oracle

WORKDIR /app
COPY target/fitness_v1.jar /tmp/fitness_v1.jar
COPY .env /app/.env
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/tmp/fitness_v1.jar"]
