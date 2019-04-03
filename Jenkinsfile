pipeline {
  agent {
    node { label 'android' }
  }
  stages {
    stage('Lint & Unit Test') {
      parallel {
        stage('checkStyle') {
          steps {
            // We use checkstyle gradle plugin to perform this
            sh './gradlew checkStyle'
          }
        }

        stage('Unit Test') {
          steps {
            // Execute your Unit Test
            sh './gradlew testStagingDebug'
          }
        }
      }
    }
}
  post {
    always {
      archiveArtifacts(allowEmptyArchive: true, artifacts: 'app/build/outputs/apk/**/*.apk')
      // And kill the emulator?
      sh 'adb emu kill'
    }
  }
}