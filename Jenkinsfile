pipeline {
    agent 
    {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }//docker
    }//agent
    stages {
        stage('Build') { 
            steps {
                echo "in build"
                bat 'mvn --v'
            }//steps
        }//stage
    }//stages    
}//pipeline
