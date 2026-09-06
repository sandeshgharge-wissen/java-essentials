pipeline {
    agent any

    tools {
        maven 'Maven'   // must match the exact name configured in Manage Jenkins → Tools → Maven installations
        jdk 'JDK'      // must match the exact name configured in Manage Jenkins → Tools → JDK installations
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}