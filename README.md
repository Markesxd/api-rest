# My first api rest with Spring-boot.

Simple project of an API in wich you can manage people (A simple CRUD is set up).

## Models

### Person
Person have id, firstName, lastName, cpf, birthDate and phones(wich is a diferent entity).

### Phone
Phone have id, type and number.

## Runnig

To run the project with Maven:
```
mvn spring-boot:run
```
and the service will be available at localhost:8080

## endpoints

To create a new person send a JSON on the body of a POST request for /person\
to retrieve all people send a GET request to /person\
to retrieve a person send a GET request to /person/&lt;id>\
to update send a JSON on the body of a PUT request tp /person/&lt;id>\
to delete send a DELETE request to /person/&lt;id>.
