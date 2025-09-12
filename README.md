# efarmers-market

A mobile-payment enabled, farmer's market platform, for rural East African smallholders.

The database with all four populated produce, livestock, produceTransactions and livestockTransactions tables, has been exported to dump_file.sql in src/main/resources.

There is also a data.sql file in src/main/resources with sql scripts to populate the produce and livestock tables only. The following property has been set: spring.sql.init.mode=never. Change to spring.sql.init.mode=always to populate tables with the data.sql file.
