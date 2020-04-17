pipeline {
    agent any
    
    environment { 
        github_URL = "https://github.com/cssp007/forjenkins.git"
	build_number = "${currentBuild.number}"
    }
    
    
    
    stages {       
        
        stage('Getting Code from SCM') {
            steps {
                script {
			scmCheckOut = load 'git.groovy'  
                        scmCheckOut.getCodeFromGithub()
                }
            }
         }
       
        
        stage('Creating Docker images') {
            steps {
                script {
			docker = load 'docker.groovy'
			docker.createImage()
			docker.pushToDockerHub()
                }
            }
        }
	
        
         stage('Deploy Application in K8s Cluster') {
            steps {
                script {
                   kube = load 'kube.groovy'
		   kube.deployToKubeCluster()
                }
            }
        }
      
  }
  }
