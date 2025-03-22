FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/clinica_veterinaria-0.0.1.jar
COPY ${JAR_FILE} app_veterinaria.jar
EXPOSE 8080
entrypoint ["java","-jar","app_veterinaria.jar"]
