FROM openjdk:17-alpine
VOLUME /app
ADD /target/post_management-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]