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
	   
        stage('Delete secret') {
            steps {
                script {
                   sh "kubectl delete secret regcred"
                }
            }
        }
	    
         stage('Delete Deploy Application in K8s Cluster') {
            steps {
                script {
                   sh "kubectl delete -f nginx.yaml" 
                }
            }
        }
	    
        stage('Create secret') {
            steps {
                script {
                   sh "kubectl create secret docker-registry regcred --docker-server=harbor.cssp.tech --docker-username=production --docker-password=Pass1234"
                }
            }
        }
	
        
         stage('Create Deploy Application in K8s Cluster') {
            steps {
                script {
                   sh "kubectl apply -f nginx.yaml" 
                }
            }
        }
      
  }
  }
