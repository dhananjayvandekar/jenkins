pipeline {
    agent any
    stages {
        stage ('pull') {
            steps {
                 git 'https://github.com/shubhamkalsait/studentapp-ui'
            }
        }
        stage ('build') {
            steps {
                sh '/opt/apache-maven/bin/mvn clean package'
            }
        }
        stage ('test') {
            steps {
                echo 'test ok'
            }
        }
        stage ('deploy') {
            steps {
                echo 'deploy ok'
            }
        }
        }
    }