FROM openjdk:15
EXPOSE 8080
ADD target/Jenkins-sonar-docker.jar Jenkins-sonar-docker.jar
ENTRYPOINT["java","-jar","/jenkins-sonar-docker.jar"]
