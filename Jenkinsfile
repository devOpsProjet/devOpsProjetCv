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
                    bat 'docker build -t devopsprojet/devopsprojetcv .'
                }
            }
        }
        stage('Prepare Environement') {
            steps
            {
                script {
                    containerName = bat(returnStdout: true, script: "docker ps -a -f 'name=test-container' --format '{{.Names}}'").trim()
                    if(containerName == "test-container")
                    {
                        bat 'docker rm test-container --force'
                        bat "echo 'Nettoyage environnement OK'"
                    }
                    else
                    {
                        bat "echo 'Ennvironnement OK'"
                    }
                }
            }
        }
        stage('Run Docker Container') {
            steps {
                bat 'docker run -d -p 8090:8080 --name test-container devopsprojet/devopsprojetcv:latest'
                // bat 'sleep 15s'
            }
        }
        // stage('Test Docker Container') {
        //     steps {
        //        bat 'curl http://localhost:8090'
        //     }
        // }
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
                    bat 'docker push devopsprojet/devopsprojetcv'
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
            slackSend message:"A new version of devopsprojet/devopsprojetcv is succesful build - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        }
    }
}
