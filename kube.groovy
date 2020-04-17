def deployToKubeCluster() {
           kubernetesDeploy(
				       configs: 'nginx.yaml',
				       kubeconfigId: 'KUBERNETES_CONFIG'
				   ) 
}
return this
