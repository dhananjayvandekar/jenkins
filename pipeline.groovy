pipeline {
    agent any
    stages {
        stage ('pull') {
            steps {
                 git 'https://github.com/dhananjayvandekar/devans.git'
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
