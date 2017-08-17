FROM java:8
VOLUME /tmp
ADD WS4-Car.jar WS4-Car.jar
RUN bash -c 'touch /WS4-Car.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/WS4-Car.jar"]