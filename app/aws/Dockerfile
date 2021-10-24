FROM maven:3.8-jdk-11 as builder

ARG ARTIFACTS_AUTH
RUN mkdir -p /root/.m2/repository
COPY settings.xml /root/.m2

WORKDIR /app/aws
COPY src ./src
COPY pom.xml ./pom.xml
RUN mvn package

FROM adoptopenjdk/openjdk11:alpine-jre

COPY --from=builder /app/aws/target/resume-aws-1.0.0.jar ./resume-aws-1.0.0.jar

# configure the runtime startup as main
ENTRYPOINT [ "java", "-cp", "./resume-aws-1.0.0.jar", "com.amazonaws.services.lambda.runtime.api.client.AWSLambda" ]

# pass the name of the function handler as an argument to the runtime
CMD [ "com.wheeler.aws.controller.LambdaHandler::handleRequest" ]
