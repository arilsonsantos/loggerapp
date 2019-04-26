FROM openjdk:8-jre-slim
COPY ./target/loggerapp-0.0.1-SNAPSHOT.jar /usr/src/loggerapp/
WORKDIR /usr/src/loggerapp
EXPOSE 8080
CMD ["java", "-jar", "loggerapp-0.0.1-SNAPSHOT.jar"]