FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/backend-3.2.2.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]