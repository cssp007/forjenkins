def createImage() {
    sh "docker build -t cssp007143/nginx-image:${build_number} ."
    }
 def pushToDockerHub() {
    withCredentials([string(credentialsId: 'Ducker_Hub_Pass', variable: 'Docker_Hub_Pass')]) {
			    sh "docker login -u cssp007143 -p ${Docker_Hub_Pass}"
         }
          sh "docker push cssp007143/nginx-image:${build_number}"
 }
return this
