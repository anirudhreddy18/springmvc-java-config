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
           docker.image('maven:3-alpine').inside {
            bat 'mvn --v'
        }
     }

}
