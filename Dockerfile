FROM openjdk:21-ea-21-jdk
WORKDIR /the/workdir/path
COPY target/MasLogistics-0.0.1-SNAPSHOT.war MasLogistics-0.0.1-SNAPSHOT.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","MasLogistics-0.0.1-SNAPSHOT.jar"]