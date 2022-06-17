FROM openjdk:17-alpine
VOLUME /app
ADD /target/post_management-0.0.1-SNAPSHOT.jar post_management.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","post_management.jar"]