pipeline {
    agent any
    tools{
        maven 'Maven-3'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/cndiaye-dev/atos-devops-automation-demo']]])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t cheikhn414/atos-devops-automation-demo .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                    bat 'docker login -u cheikhn414 -p LINdepoule88'
                }
                script{
                    bat 'docker push cheikhn414/atos-devops-automation-demo'
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
}