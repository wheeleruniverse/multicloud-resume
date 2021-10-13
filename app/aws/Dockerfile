FROM maven:3.8-jdk-11 as builder

ARG ARTIFACTS_AUTH

WORKDIR /app/aws

RUN mkdir -p /root/.m2/repository
COPY settings.xml /root/.m2

COPY src ./src
COPY pom.xml ./pom.xml
RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk11:alpine-jre

COPY --from=builder /app/aws/target/resume-aws-1.0.0.jar /resume-aws-1.0.0.jar

CMD ["java", "-jar", "/resume-aws-1.0.0.jar"]
