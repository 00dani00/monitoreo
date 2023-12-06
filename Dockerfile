
FROM openjdk:17
WORKDIR /app
COPY target/monitoreo-0.0.1-SNAPSHOT.jar /app/monitoreo.jar
EXPOSE 8080
CMD ["java", "-jar", "monitoreo.jar"]