pipeline {
    agent any
    tools{
        maven 'Maven-3'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/delivery']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/devOpsProjet/devOpsProjetCv']]])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t devopsprojet/devOpsProjetCv .'
                }
            }
        }
         stage('Run Docker Container') {
            steps {
                bat 'docker run -d -p 8090:8080 --name test-container devopsprojet/devOpsProjetCv:latest'
                bat 'sleep 15s'
            }
        }
        stage('Test Docker Container') {
            steps {
               bat 'curl http://localhost:8090'
            }
        }
        stage('Clean Environment') {
            steps {
                bat 'docker stop test-container'
                bat 'docker rm test-container'
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                    bat 'docker login -u devopsprojet -p Atos@2023'
                }
                script{
                    bat 'docker push devopsprojet/devOpsProjetCv'
                }
            }
        }
        stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy (configs: 'deployment-service.yaml', kubeconfigId: 'k8sminikubepwd')
                }
            }
        }
    }
    post {
        success {
            slackSend message:"A new version of devopsprojet/devOpsProjetCv is succesful build - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        }
    }
}
