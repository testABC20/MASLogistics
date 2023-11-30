FROM openjdk:21-ea-21-jdk
WORKDIR /app
COPY target/MasLogistics-0.0.1-SNAPSHOT.jar MasLogistics-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","MasLogistics-0.0.1-SNAPSHOT.jar"]