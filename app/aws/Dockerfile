FROM maven:3.8-jdk-11 as builder

ARG ARTIFACTS_AUTH

WORKDIR /app/aws

RUN mkdir -p /root/.m2/repository
COPY settings.xml /root/.m2

COPY src ./src
COPY pom.xml ./pom.xml
RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk11:alpine-jre

ADD https://github.com/aws/aws-lambda-runtime-interface-emulator/releases/latest/download/aws-lambda-rie /usr/bin/aws-lambda-rie
RUN chmod +x /usr/bin/aws-lambda-rie

ADD entrypoint.sh ./entrypoint.sh
RUN chmod +x /entrypoint.sh
ENTRYPOINT ["/entrypoint.sh"]

ENV JAR_DIR="/jar"
ADD target/* $JAR_DIR/

CMD ["com.wheeler.aws.controller.LambdaHandler::handleRequest"]
