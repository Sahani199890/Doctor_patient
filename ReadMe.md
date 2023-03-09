# Doctor_Patient
### Requirements
* IntelliJIDEA
* ServerPort: 8080 (use: localhost:8080)
* Java version: 17
* Everything is present in the pom.xml (no need to download any library)
### Steps to run the Project
* Download the source code and import in intellijIDEA.
* Go to localhost:8080/
* Put specific end_points besides the port accordingly to run the project to access and modify the data
# Dependencies
## Validation
* Bean Validation with Hibernate validator.
## H2 Database
* Provides a fast in-memory database that supports JDBC API and R2DBC access, with a small (2mb) footprint. Supports embedded and server modes as well as a browser based console application.
## Spring Web
* Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
## Spring Boot DevTools
* Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
## Spring Data JPA
* Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
## Lombok
* Java annotation library which helps to reduce boilerplate code.
## JSON
* JSON is a light-weight, language independent, data interchange format. See http://www.JSON.org/ The files in this package implement JSON encoders/decoders in Java. It also includes the capability to convert between JSON and XML, HTTP headers, Cookies, and CDL. This is a reference implementation.

# Working
## Doctor
* There are two models in the project where one is doctor model where number of doctors are added removed and updated as per the need 
## Patient
* The other model in the project is patient where we perform similar opeartions as did in the doctor's model all the CRUD operations are done 
## Doctor_Patient
* Now we have doctors and patients there are some relations between doctor and patient as patients visit doctor regarding health as one doctor can have more than one patient so we make a SQL relation between the doctor's data and patient's data for ease access the relationship present in the project is ManyToOne where one doctor has many patients and the details can be accesses through database and even can do manipulations in the data if needed easily and efficiently    