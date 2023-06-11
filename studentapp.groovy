pipeline {
    agent any
    stages {
        stage ('pull') {
            steps{
                git 'https://github.com/shubhamkalsait/studentapp-ui.git'
            }
        }
        stage ('build') {
            steps {
               sh  '/opt/apache-maven/bin/mvn clean package'
            }
        }
        stage ('test') {
            steps {
                withSonarQubeEnv(installationName: 'sonar-server', credentialsId: 'sonar-token') {
                    sh ' /opt/apache-maven/bin/mvn sonar:sonar -Dsonar.projectKey=studentapp' 
                }
            }
        }
        // stage('quality-gate'){
        //     steps {
        //         timeout(time: 1, unit: 'HOURS') {
        //             waitForQualityGate abortPipeline: true                    
        //             }
        //     }
        // }
        stage ('deploy') {
            steps {
                deploy adapters: [tomcat8(credentialsId: 'tomcat-token', path: '', url: 'http://18.182.11.228:8080')], contextPath: '/', war: '**/*.war'
            }
        }
    }
}