FROM openjdk:17.0.1-jdk-slim
COPY target/Employee_System_New-0.0.1-*.jar application.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/application.jar"]
