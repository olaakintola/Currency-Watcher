FROM openjdk:8-jre-alpine

COPY target/blogit-0.0.1-SNAPSHOT.jar /blogit.jar
CMD java -jar blogit.jar