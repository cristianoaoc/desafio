#Stage 1: build da aplicação
FROM maven:3.8.4-openjdk-17 as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

#Stage 1: build da aplicação
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/desafio-0.0.1-SNAPSHOT.jar ./desafio.jar
EXPOSE 8080
CMD ["java", "-jar", "desafio.jar"]
