def createImage() {
    sh "docker build -t harbor.cssp.tech/nginx-image:${build_number} ."
    }
 def pushToDockerHub() {
    withCredentials([string(credentialsId: 'Ducker_Hub_Pass', variable: 'Docker_Hub_Pass')]) {
			    sh "docker login -u production -p ${Docker_Hub_Pass}"
         }
          sh "docker push harbor.cssp.tech/nginx-image:${build_number}"
 }
return this
