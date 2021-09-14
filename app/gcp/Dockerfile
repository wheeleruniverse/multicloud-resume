FROM maven:3.8-jdk-11 as builder

WORKDIR /app
RUN mkdir core
COPY /core/pom.xml ./core/pom.xml
COPY /core/src ./core/src

RUN mkdir gcp
COPY /gcp/pom.xml ./gcp/pom.xml
COPY /gcp/src ./gcp/src

WORKDIR ./core
RUN mvn clean install

WORKDIR ./gcp
RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk11:alpine-jre

COPY --from=builder /app/gcp/target/resume-gcp-1.0.0.jar /resume-gcp-1.0.0.jar

CMD ["java", "-jar", "/resume-gcp-1.0.0.jar"]
