# Sakila  API
## This is a Rest and Soap API for the Sakila database, which is a sample database provided by MySQL for testing and demonstration purposes.

### Technologies
* Java 
* Maven 
* JPA - Hibernate 
* Sakila database installed on MySQL
* Jersy 

### Getting Started
Clone this repository: git clone https://github.com/Ahmed-Rohoma/Sakila-API.git
Configure the application.properties file with your MySQL database credentials.
Build the project: mvn clean compile tomcat7:redeploy

## Endpoints
### Films
* GET /films: get a list of all films
* GET /films/{id}: get a film by ID
* POST /films: create a new film
* PUT /films/{id}: update an existing film by ID
* DELETE /films/{id}: delete a film by ID

### Actors
* GET /actors: get a list of all actors
* GET /actors/{id}: get a actor by ID
* POST /actors: create a new actor
* PUT /actors/{id}: update an existing actor by ID
* DELETE /actors/{id}: delete a actor by ID

### Other Endpoints
* #### Categories
* #### Stores
* #### Customer
* #### Staff
* #### Rentals
* #### Address
* #### City
* #### Country

