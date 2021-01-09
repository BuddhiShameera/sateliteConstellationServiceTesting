FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} constellation.jar
ENTRYPOINT ["java","-jar","/constellation.jar"]