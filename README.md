# efarmers-market

<font size="10">A mobile-payment enabled, farmer's market platform, for rural East African smallholders.</font>

## Databse info

- The database with all four populated produce, livestock, produceTransactions and livestockTransactions tables, has been exported to dump_file.sql in src/main/resources.

- There is also a data.sql file in src/main/resources with sql scripts to populate the produce and livestock tables only. The following property has been set: spring.sql.init.mode=never. Change to spring.sql.init.mode=always to populate tables with the data.sql file.

## Tests

- To run tests, use the following command: ./mvnw test
  
- There is currently one test file: ./src/test/java/com/jdy3/efarmersmarket/livestock/LivestockServiceTest.java

To start the API, use the following command: ./mvnw spring-boot:run
