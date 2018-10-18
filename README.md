Target is to show how to build and run application as per profile

There are mainly 5 profiles
-development
-demo
-test
-staging
-production

common properties are exist in application.properties
can be overrien by application-{profile}.properties 

to add custom files other than application.properties and either want to apply profiling on them
config/ds-{profile}.properties applies the same manner
and configured in ProfilingApplication by  @PropertySource("classpath:config/ds-${spring.profiles.active}.properties")


To build application for development environment
mvn clean install -Dspring.profiles.active=TargetedProfile

To run application
java -jar   -Dspring.profiles.active=TargetedProfile target/spring-profiling-example.jar


To test application

visit http://localhost:8080/getActiveDatasourceProperties
shows json contains datasource properties as per run profile profile 
for example 

{"datasourceUserName":"AwesomeServiceUserName","datasourcePassword":"&43w43cxjkn__43d","datasourceUrl":"jdbc:mysql://10.33.4.3:3306/AwesomeServiceDB"}


