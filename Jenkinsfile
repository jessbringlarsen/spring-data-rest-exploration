pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        git 'https://github.com/jessbringlarsen/spring-data-rest-exploration.git'
        sh 'mvn install'
      }
    }
  }
}