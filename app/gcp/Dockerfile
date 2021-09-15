FROM maven:3.8-jdk-11 as builder

WORKDIR /app/gcp
COPY . .

RUN export ARTIFACTS_AUTH=$(aws codeartifact get-authorization-token --domain wheelercloudguru --query authorizationToken --output text) && mvn package -DskipTests

FROM adoptopenjdk/openjdk11:alpine-jre

COPY --from=builder /app/target/resume-gcp-1.0.0.jar /resume-gcp-1.0.0.jar

CMD ["java", "-jar", "/resume-gcp-1.0.0.jar"]
