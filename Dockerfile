FROM openjdk:15
EXPOSE 8080
ADD target/jenkins-sonar-docker.jar jenkins-sonar-docker.jar
ENTRYPOINT["java","-jar","/jenkins-sonar-docker.jar"]