node{
   stage ('SCM Checkout'){
      git 'https://github.com/herculespsilva/spring-boot-produtora'
   }
   stage('Compile-Package'){
      sh 'mvn package'
   }
   
}
