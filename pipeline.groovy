pipeline {
    agent any
    stages {
        stage ('pull') {
            steps {
                echo 'https://github.com/dhananjayvandekar/All-task-and-doc.-of-AWS.git'
            }
        }
        stage ('build') {
            steps {
                echo 'build ok'
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
