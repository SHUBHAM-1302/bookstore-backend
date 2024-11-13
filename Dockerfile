FROM openjdk:18-jdk-alpine3.14
ADD /target/*.jar journal.jar
ENTRYPOINT ["java", "-jar", "./journal.jar"]

