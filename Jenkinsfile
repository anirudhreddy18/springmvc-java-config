pipeline {
      agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                echo "in build"
                bat 'mvn --v'
                //bat "docker build . -t tomcatwebapp"
            }//steps
        }//stage
    }//stages    
}//pipeline
