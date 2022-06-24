FROM openjdk:11
WORKDIR /app
COPY pom.xml .
COPY target/*.jar app.jar
CMD ["java","-jar","/app/app.jar","--spring.profiles.active=docker"]