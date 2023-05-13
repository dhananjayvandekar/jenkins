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
                 sh '/opt/apache-maven/bin mvn sonar:sonar -Dsonar.projectKey=student.key -Dsonar.host.url=http://54.193.113.234:9000 -Dsonar.login=a0bb8570f57ed8843256f5b562fd4bd7f94388d8'
            }
        }
        stage ('deploy') {
            steps {
                echo 'deploy ok'
            }
        }
        }
        
    }