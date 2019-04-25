FROM openjdk:8-jre-slim
COPY ./target/springdatajpademo-0.0.1-SNAPSHOT.jar /usr/src/demo/
WORKDIR /usr/src/demo
EXPOSE 8080
CMD ["java", "-jar", "springdatajpademo-0.0.1-SNAPSHOT.jar"]