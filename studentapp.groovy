pipeline {
    agent any
    stages{
        stage ('pull') {
            steps {
                 git 'https://github.com/shubhamkalsait/studentapp-ui.git'
            }
        }
        stage ('build') {
            steps {
                 sh '/opt/apache-maven/bin/mvn clean package'
            }
        }
        stage ('test') {
            steps {
              withSonarQubeEnv(installationName: 'sonar-server', credentialsId: 'sonar-token') {
                    sh ' /opt/apache-maven/bin/mvn sonar:sonar -Dsonar.projectKey=studentapp' 
                }
                    
          
            }
        }
        stage ('deploy') {
            steps { 
                time out ( time: 1, unit:'HOURS') {
                    waitforQualitygate abort pipeline: true
                    credentialID: 'sonar-token'
                }
            }
        }
        stage ('deploy') {
            steps {
                echo 'deploy ok'
            }
        }
    }
}