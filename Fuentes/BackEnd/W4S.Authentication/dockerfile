FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/WS4-Authentication.jar WS4-Authentication.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /WS4-Authentication.jar" ]