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
                nexusPolicyEvaluation advancedProperties: '', 
                    failBuildOnNetworkError: false, 
                    iqApplication: selectedApplication('local-iq-app'), 
                    iqStage: 'build',
                    iqScanPatterns: [[scanPattern: '**/*.jar'], [scanPattern: '**/*.war']]
            }
        }
    }
    
    post {
        always {
            deleteDir()
        }
    }
}
