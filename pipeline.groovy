pipeline {
    agent any
    stages {
        stage ('pull') {
            steps {
                echo 'pull ok'
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
