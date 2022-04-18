FROM openjdk:17-alpine
EXPOSE 9091
COPY target/pfe.jar pfe.jar
ENTRYPOINT ["java","-jar","/pfe.jar"]