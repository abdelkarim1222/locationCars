pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from the Git repository
                script {
                    git credentialsId: 'abdelkarim', url: 'https://github.com/abdelkarim1222/locationCars.git'
                }
            }
        }

        stage('Build') {
            steps {
                // Build your project, replace with actual build commands
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run tests, replace with actual test commands
                sh 'mvn test'
            }
        }

        // Add more stages as needed for deployment, additional testing, etc.
    }

    post {
        success {
            // Actions to perform if the pipeline is successful
            echo 'Pipeline succeeded! Deploying...'
            // Add deployment steps here
        }

        failure {
            // Actions to perform if the pipeline fails
            echo 'Pipeline failed! Not deploying...'
            // Add rollback or notification steps here
        }
    }
}
