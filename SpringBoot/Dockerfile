FROM openjdk17.0.1-jdk-slim
ARG JAR_FILE=SpringBoot/target/*.jar
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch app.jar'
ENTRYPOINT [java,-Djava.security.egd=filedev.urandom,-jar,app.jar]