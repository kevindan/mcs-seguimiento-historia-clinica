FROM openjdk:8-jdk-alpine
MAINTAINER kpinchi-prov@trabajo.gob.pe
ARG TZ="America/Latina"
ADD mcs-consulta-trabajador-hogar-1.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
