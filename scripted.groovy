node {
    stage ('pull') {
        echo 'pull success'
    }
    stage ('build') {
        echo 'build ok'
    }
    stage ('test') {
        echo 'test ok'
    }
    stage ('deploy') {
        echo 'deploy ok'
    }
}