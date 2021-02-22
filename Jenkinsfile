pipeline {
 environment {
    registry = "woualabs07/jenkins-sonar-docker"
    registryCredential = 'Swetha07!'
    dockerImage = ''
  }
    agent any
    stages{
//     stage('Quality Gate Status Check'){
//         steps{
//             script{
//                 withSonarQubeEnv('sonarserver') {
//                          sh "mvn sonar:sonar"
//                 };
//                 timeout(time: 1, unit: 'HOURS'){
//                                def qg = waitForQualityGate()
//                                   if (qg.status != 'OK') {
//                                   error "Pipeline aborted due to quality gate failure: ${qg.status}"
//                                   }
//                 }
//

//            }
//          }
//        }
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
                stage('Push image') {
                       docker.withRegistry('https://registry.hub.docker.com', 'docker-jenkins') {
                           dockerImage.push("${env.BUILD_NUMBER}")
                           dockerImage.push("latest")
                           }
    }
}