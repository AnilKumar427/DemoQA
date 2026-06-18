pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK11'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Cloning repository...'
                git 'https://github.com/AnilKumar427/DemoQA.git'
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Running Maven build...'
                bat 'mvn clean test'
            }
        }
    }

    post {
        success {
            echo '✅ Build SUCCESS'
        }
        failure {
            echo '❌ Build FAILED'
        }
    }
}
