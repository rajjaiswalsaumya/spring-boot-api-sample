# Steps to try

- Clone this repository using command
git clone https://github.com/<git username>/spring-boot-api-sample.git

- Run below command to build 
mvn clean install spring-boot:repackage
  
- Create a dir named user-data in C drive, this is configurable, but default is C:\user-data
  mkdir C:\user-data
  
- Add multiple files in user-data dir
  touch abc.jil
  touch cde.jil
  
- Sample file added, copy abc.jil from resources dir to user-data dir
  
- Run as jar 
  java -jar target/spring-boot-api-sample-0.0.1-SNAPSHOT.jar
  
- Goto browser and type
  http://localhost:8080/files/list
  http://localhost:8080/jobs/us/list
  http://localhost:8080/jobs/US/list
  http://localhost:8080/jobs/local/list
  http://localhost:8080/jobs/LOCAL/list
  
