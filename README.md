### Description

An exchange RESTful API built with Spring Boot

## Endpoints

### Exchange Controller:

- show all exchange rates:
  ```GET - http://localhost:8080/rates```
- show exchange rate by id:
  ```GET - http://localhost:8080/rates/{id}```
- show exchange rate by query string(fromCurrency):
  ```GET - http://localhost:8080/rates?fromCurrency={currency}```
- add a new exchange rate:
  ```POST - http://localhost:8080/rates/```
- update a specific exchange rate (partial update is working aswell):
  ```PATCH - http://localhost:8080/rates/{id}```
- delete a specific exchange rate:
  ```DELETE - http://localhost:8080/rates/{id}```

### Transaction Controller:

- show all exchange rates:
  ```GET - http://localhost:8080/transactions```
- show exchange rate by id:
  ```GET - http://localhost:8080/transactions/{id}```
- add a new exchange rate:
  ```POST - http://localhost:8080/transactions/```
- update a specific exchange rate (partial update is working aswell):
  ```PATCH - http://localhost:8080/transactions/{id}```
- delete a specific exchange rate:
  ```DELETE - http://localhost:8080/transactions/{id}``` spring-exchange
