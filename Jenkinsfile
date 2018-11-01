pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                echo "in build"
                sh 'mvn --version'
                sh 'java --version'
            }
        }
    }    
}
