FROM maven:3.5-jdk-8-alpine AS build
COPY /src /usr/src/javaspring/src
COPY pom.xml /usr/src/javaspring
COPY Dockerfile /usr/src/javaspring
RUN mvn -f /usr/src/javaspring/pom.xml clean install


FROM openjdk:8u181-jre-slim
RUN apt update && apt install -y net-tools netcat tcpdump
COPY --from=build /usr/src/javaspring/target/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
