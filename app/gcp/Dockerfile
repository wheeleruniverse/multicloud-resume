FROM maven:3.8-jdk-11 as builder

WORKDIR /app/gcp
COPY pom.xml .
COPY src ./src

RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk11:alpine-jre

COPY --from=builder /app/gcp/target/resume-gcp-1.0.0.jar /resume-gcp-1.0.0.jar

CMD ["java", "-jar", "/resume-gcp-1.0.0.jar"]