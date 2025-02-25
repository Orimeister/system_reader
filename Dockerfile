FROM openjdk:17-oracle
WORKDIR /app
COPY systerm_reader-0.0.1-SNAPSHOT.jar /app/systerm_reader-0.0.1-SNAPSHOT.jar
EXPOSE 8081
CMD ["java", "-jar", "systerm_reader-0.0.1-SNAPSHOT.jar"]
