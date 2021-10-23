# Amazon Linux 2 + Corretto 11 as our base
FROM amazoncorretto:11 as base

# configure the build environment
FROM base as build

# install Maven
RUN yum install -y maven
WORKDIR /app/aws/src


RUN mvn help:evaluate -Dexpression=settings.localRepository -q -DforceStdout


# update Maven settings to authenticate to CodeArtifact
ARG ARTIFACTS_AUTH
RUN mkdir -p /root/.m2/repository
COPY settings.xml /root/.m2

# cache and copy dependencies
ADD pom.xml .
RUN mvn dependency:go-offline dependency:copy-dependencies

# compile the function
ADD . .
RUN mvn package

# copy the function artifact and dependencies onto a clean base
FROM base
WORKDIR /function

COPY --from=build /src/target/dependency/*.jar ./
COPY --from=build /src/target/*.jar ./

# configure the runtime startup as main
ENTRYPOINT [ "/usr/bin/java", "-cp", "./*", "com.amazonaws.services.lambda.runtime.api.client.AWSLambda" ]

# pass the name of the function handler as an argument to the runtime
CMD [ "com.wheeler.aws.controller.LambdaHandler::handleRequest" ]
