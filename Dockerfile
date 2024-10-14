FROM amazoncorretto:17-alpine-jdk
LABEL maintainer="Kaouther Ben Sassi bensassi.kaouther@gmail.com"
COPY target/customersService-0.0.1-SNAPSHOT.jar customersService-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "customersService-0.0.1-SNAPSHOT.jar"]