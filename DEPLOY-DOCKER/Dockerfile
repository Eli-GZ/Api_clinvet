FROM openjdk:21-jdk-slim
ARG JAR_FILE=./DEPLOY-DOCKER/target/clinica_veterinaria-0.0.1.jar
COPY ${JAR_FILE} app_veterinaria.jar
EXPOSE 8080
entrypoint ["java","-jar","app_veterinaria.jar"]

ENV DB_URL=jdbc:mysql://mysql-34a7aca3-clinveterinaria.e.aivencloud.com:21146/defaultdb?createDatabaseIfNotExist=true&serverTimezone=UTC
ENV DB_USER_NAME=avnadmin
ENV DB_PASSWORD=AVNS_kTc0FthMTHiWubEvwsb
