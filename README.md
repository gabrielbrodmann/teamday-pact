# Teamday Pact 
## Prerequisite
 * docker installed
 * java 11 
 ## Source code
 Checkout the master branch to start the exercise.
 ## Startup
 It is recommended to start the Spring Boot applications using the IntelliJ Services view `alt + 8`
 ### Consumer
 Start the ConsumerApplication Sprint Boot application in the consumer directory.
 ### Provider
 Start the ProviderApplication Spring Boot application in the provider directory.
 ### Broker
 Do this prior the workshop day if possible.
  
  
Start the broker and the database using 
 `pact-broker-docker/docker-compose up` (it takes quite a while the first time).
 
 
 After the first run is complete use `ctrl + c` to gracefully end the broker and use the `pact-broker-docker/docker-compose up` command again. Now the broker should be up and running.
 Test this by visiting `localhost:9292` with the browser.
 