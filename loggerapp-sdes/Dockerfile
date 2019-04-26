FROM openjdk:8-jre-slim
COPY ./target/loggerapp-sdes-0.0.1-SNAPSHOT.jar /usr/src/loggerapp-sdes/
WORKDIR /usr/src/loggerapp-sdes
EXPOSE 8280
CMD ["java", "-jar", "loggerapp-sdes-0.0.1-SNAPSHOT.jar"]