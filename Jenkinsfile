pipeline {
  agent any
  stages {
    stage('Lint & Unit Test') {
      parallel {
        stage('checkStyle') {
          steps {
            // We use checkstyle gradle plugin to perform this
            sh './gradlew build'
          }
        }

        stage('Unit Test') {
          steps {
            // Execute your Unit Test
            sh './gradlew test'
          }
        }
      }
    }
}
  post {
    always {
      archiveArtifacts(allowEmptyArchive: true, artifacts: 'app/build/outputs/apk/**/*.apk')
    }
  }
}