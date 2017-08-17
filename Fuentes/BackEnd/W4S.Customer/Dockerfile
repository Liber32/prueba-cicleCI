FROM java:8
VOLUME /tmp
ADD WS4-Car.jar WS4-Customer.jar
RUN bash -c 'touch /WS4-Customer.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/WS4-Customer.jar"]