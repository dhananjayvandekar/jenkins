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
                 sh '/opt/apache-mvn/bin/mvn clean package'
            }
        }
    }
}