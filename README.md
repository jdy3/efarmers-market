# efarmers-market

### *A mobile-payment enabled, farmer's market, for rural East African smallholders.*

## Databse info

- The database with all four populated produce, livestock, produceTransactions and livestockTransactions tables, has been exported to dump_file.sql in src/main/resources.

- There is also a data.sql file in src/main/resources with sql scripts to populate the produce and livestock tables only. *The following property has been set: spring.sql.init.mode=never. Change to spring.sql.init.mode=always to populate tables with the data.sql file.*

## Tests

- To run tests, use the following command ./mvnw test
  
- There is currently one test suite in ./src/test/java/com/jdy3/efarmersmarket/livestock/LivestockServiceTest.java

## API

- To start the API, use the following command from the directory root ./mvnw spring-boot:run

### Endpoints

Produce Endpoints
***

 - POST /products/produce<br> 

    >{<br> 
    >"date": LocalDate,<br> 
    >"expiry": LocalDate,<br> 
    >"price": BigDecimal,<br> 
    >"weight": BigDecimal,<br> 
    >"description": String,<br>
    >"location": String,<br>
    >"name": String,<br>
    >"picture": String,<br>
    >"provenance": String,<br>
    >"variety": String,<br>
    >"category": enum {"Cereal", "Vegetable", "Fruit"}<br>
    >}<br>

 - PUT /products/produce/{id}<br> 
 - GET /products/produce<br>
 - GET /products/produce?name={name}<br>
 - GET /products/produce?provenance={provenance}<br>
 - GET /products/produce?expiry={expiry}<br>
 - GET /products/produce/{id}<br>
 - DELETE /products/produce/{id}<br>
 *** 

Livestock Endpoints
***
    
 - POST /products/livestock<br>

    >{<br>
    >"age": double,<br>
    >"date": LocalDate,<br>
    >"price": BigDecimal,<br>
    >"quantity": int,<br>
    >"weight": BigDecimal,<br>
    >"certification": String,<br>
    >"description": String,<br>
    >"location": String,<br>
    >"name": String,<br>
    >"picture": String,<br>
    >"provenance": String,<br>
    >"breed": String<br>
    >}<br>

  - PUT /products/livestock/{id}<br>
  - GET /products/livestock<br>
  - GET /products/livestock?name={name}<br>
  - GET /products/livestock/?provenance={provenance}<br>
  - GET /products/livestock/{id}<br>
  - DELETE /products/livestock/{id}<br>
    ***

 - Produce Transaction Endpoints<br>
 ***
  - POST /transactions/produce-transactions<br> 
    
     >{
     >"productId": UUID,
     >"purchaseWeight": BigDecimal
     >}<br>
     
    *productId is obtained from produce ID field and purchaseWeight will be deducted from produce weight*

  - GET /transactions/produce-transactions<br>
  - GET /transactions/produce-transactions?productId={productId}<br>
  - GET /transactions/produce-transactions/{transactionId}<br>
  - GET /transactions/produce-transactions/high<br>
  - GET /transactions/produce-transactions/low<br>
  - DELETE /transactions/produce-transactions/{transactionId}<br>
  ***
  - Livestock Transaction Endpoints<br>
 ***
  - POST /transactions/livestock-transactions<br> 
    
     >{
     >"productId": UUID,
     >"purchaseQuantity": int
     >}<br>
     
    *productId is obtained from livestock ID field and purchaseQuantity will be deducted from livestock weight*

  - GET /transactions/livestock-transactions<br>
  - GET /transactions/livestock-transactions?productId={productId}<br>
  - GET /transactions/livestock-transactions/{transactionId}<br>
  - GET /transactions/livestock-transactions/high<br>
  - GET /transactions/livestock-transactions/low<br>
  - DELETE /transactions/livestock-transactions/{transactionId}<br>
  
