node {
  stage('Configure') {
    env.M2_HOME = "${tool 'maven-3.3.1'}"
    def JAVA_HOME = "${tool 'jdk8'}"
    env.PATH = "${JAVA_HOME}/bin;${env.M2_HOME}/bin;${env.PATH}" 
  }
  stage('Checkout') {
      checkout scm
  }
  stage('Build') {
    bat 'mvn -V -U -e verify'
  }
  stage('Report') {
    junit '**/target/**/TEST*.xml' 
  }
  stage('Analysis') {
    // bat 'mvn sonar:sonar -P Sonar -Dsonar.branch=${BRANCH_NAME} 
  }
  stage('Deploy') {
    //bat 'mvn deploy' 
  }
}
