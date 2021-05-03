pipeline {
    agent any

    tools {
        maven "Maven"
    }

    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('IQ Policy Evaluation') {
            steps {
                nexusPolicyEvaluation failBuildOnNetworkError: false, iqApplication: selectedApplication('local-iq-app'), iqStage: 'build', 
                    iqScanPatterns: [[scanPattern: '*.csproj']]
            }
        }
    }
    
    post {
        always {
            deleteDir()
        }
    }
}
