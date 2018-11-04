pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
                echo "in build"
                bat 'mvn --v'
                bat "docker build . -t tomcatwebapp:${$env.BUILD_ID}"
            }//steps
        }//stage
    }//stages    
}//pipeline
