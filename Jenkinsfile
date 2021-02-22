pipeline {
 environment {
    registry = "woualabs07/jenkins-sonar-docker"
    registryCredential = 'Swetha07!'
    dockerImage = ''
  }
    agent any
    stages{


stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonarserver') {
                    sh "mvn sonar:sonar"
                }
            }
        }
        stage("Quality gate") {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }
           stage('Building image') {
                 steps{
                   script {
                     dockerImage = docker.build registry + ":$BUILD_NUMBER"
                   }
                 }
               }
                stage('Deploy Image') {
                    steps{
                      script {
                        docker.withRegistry( '', registryCredential ) {
                          dockerImage.push()
                        }
                      }
                    }
                  }
    }
}