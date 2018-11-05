node
{
     stage('checkout scm')
     { 
          checkout scm
     }     
        
     stage('build')
     {
        bat 'mvn --v'
     }
     
     stage('docker maven')
     {
           bat 'docker --version'
     }

}
