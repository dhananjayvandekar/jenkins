pipeline {
    agent any
    stages{
        stage ('pull') {
            steps {
                 git 'https://github.com/dhananjayvandekar/All-task-and-doc.-of-AWS.git'
            }
        }
    }
}