pipeline {
    agent any
    tools{
        maven 'Maven-3'
    }
    stages{
        stage('Maven Compile'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/cndiaye-dev/atos-devops-automation-demo']]])
                sh 'mvn clean compile'
            }
        }
        stage('Maven Test'){
         steps{
               sh 'mvn  test'
         }
        }
       stage('Maven Install'){
             steps{
                    sh 'mvn  install'
             }
       }

        stage('Build image') {
               dockerImage = docker.build("devopsprojet/devopsprojetatos-app:latest")
        }
        stage('Docker Push'){
            withDockerRegistry([ credentialsId: "docker-hub", url: "" ]) {
                dockerImage.push()
            }
        }

    }
}