pipeline {
    agent any
    stages{
        stage ('pull') {
            git 'https://github.com/shubhamkalsait/studentapp-ui'
        }
    }
}