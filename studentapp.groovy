pipeline {
    agent any
    stages{
        stage ('pull') {
            steps {
                 git 'https://github.com/dhananjayvandekar/devans.git/helloworld.txt'
            }
        }
    }
}