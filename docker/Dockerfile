FROM openjdk:8-jdk-alpine
#ARG DEPENDENCY=target/dependency
#ADD ./webapp /WEB-INF/jsp
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
ARG WAR_FILE=/target/Projet-LO54-0.0.1-SNAPSHOT.war
COPY ${WAR_FILE} app.war

ENTRYPOINT ["java","-jar","app.war"]