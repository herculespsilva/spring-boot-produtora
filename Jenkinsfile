node{
   stage ('SCM Checkout'){
      git 'https://github.com/herculespsilva/spring-boot-produtora'
   }
   stage('Compile-Package'){
      //path maven
      def mvnHome = tool name: 'Maven 3', type: 'maven'
      bat "${mvnHome}/bin/mvn package"
   }
   
}
