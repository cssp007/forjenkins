def getCodeFromGithub() {
    def github_URL = "https://github.com/cssp007/forjenkins.git"
        if ('${github_URL}' == "https://github.com/cssp007/forjenkins.git") {
                 git '${github_URL}'
        }
        else {
                 echo "Github URL is NOT match"
        }
    }
return this
