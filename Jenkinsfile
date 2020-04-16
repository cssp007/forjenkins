pipeline {
    agent any
    
    environment { 
        github_URL = 'https://github.com/cssp007/forjenkins.git'
	build_number = "${currentBuild.number}"
    }
    
    
    
    stages {       
        
        stage('Getting Code from SCM') {
            steps {
                script {
                   git credentialsId: 'Git_Pass', url: 'https://github.com/cssp007/forjenkins.git' 
                }
            }
         }
       
        
        stage('Creating Docker images') {
            steps {
                script {
			sh "docker build -t cssp007143/nginx-image:${build_number} ."
                }
            }
        }
		
		stage('Push to Docker Hub') {
            steps {
                script {
                    sh "docker login -u cssp007143 -p Pandey@2020"
		    sh "docker push cssp007143/nginx-image:${build_number}"
                }
            }
        }
        
         stage('Deploy Application in K8s Cluster') {
            steps {
                script {
                   kubernetesDeploy(
				      configs: 'nginx.yaml',
				      kubeconfigId: 'KUBERNETES_CONFIG'
				   ) 
                }
            }
        }
      
  }
  }
