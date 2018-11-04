pipeline {
   agent any
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
