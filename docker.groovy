def createImage() {
    sh "docker build -t harbor.cssp.tech/production/nginx ."
    }
 def pushToDockerHub() {
    withCredentials([string(credentialsId: 'Docker_Hub_Pass', variable: 'Docker_Hub_Pass')]) {
			    sh "docker login harbor.cssp.tech -u production -p ${Docker_Hub_Pass}"
         }
          sh "docker push harbor.cssp.tech/production/nginx"
 }
return this
