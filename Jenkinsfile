pipeline {
    agent any
    
    environment { 
        github_URL = 'https://github.com/cssp007/forjenkins'
    }
    
    
    
    stages {       
        
        stage('Getting Code from SCM') {
            steps {
                script {
                   git credentialsId: 'Git_Pass', url: '${github_URL}' 
                }
            }
         }
       
        
        stage('Creating Docker images') {
            steps {
                script {
                    sh "docker build -t cssp007143/nginx-image ."
                }
            }
        }
		
		stage('Push to Docker Hub') {
            steps {
                script {
                    sh "docker login -u cssp007143 -p Pandey@2020"
					          sh "docker push cssp007143/nginx-image"
                }
            }
        }
        
      
      
  }
  }
