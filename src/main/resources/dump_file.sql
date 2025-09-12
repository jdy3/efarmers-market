-- MySQL dump 10.13  Distrib 9.4.0, for Linux (x86_64)
--
-- Host: localhost    Database: efarmersmarket
-- ------------------------------------------------------
-- Server version	9.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `efarmersmarket`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `efarmersmarket` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `efarmersmarket`;

--
-- Table structure for table `livestock`
--

DROP TABLE IF EXISTS `livestock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livestock` (
  `age` double NOT NULL,
  `date` date DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  `quantity` int NOT NULL,
  `weight` decimal(38,2) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `breed` varchar(255) DEFAULT NULL,
  `certification` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `provenance` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livestock`
--

LOCK TABLES `livestock` WRITE;
/*!40000 ALTER TABLE `livestock` DISABLE KEYS */;
INSERT INTO `livestock` VALUES (24,'2025-09-08',360.00,23,80.00,_binary '\Ê\ÆÒ™\\I¿š¤4%\ß%','Masai Sheep','eOrganic Certification','','Dimo Creek Farm','Sheep','','Dimo Creek Farm'),(1,'2025-09-08',2.00,58,1.40,_binary 'ˆ\òF¦¢x\ïÄ‰}iü','Rainbow','eOrganic Certification','Brooded kroilers','Dimo Creek Farm','Chicken','','Dimo Creek Farm'),(18,'2025-09-08',1150.00,490,700.00,_binary '¾¾u5\ÝI†\×}8³ù]','Ankole-Watusi','eOrganic Certification','','Nimule Hills Farm','Cow','','Nimule Hills Farm'),(3,'2025-09-08',88.00,0,18.00,_binary '\Ý×žvyH›ŠŠâ“¹ÿ­(','Nubian','eOrganic Certification','','Nimule Hills Farm','Goat','','Nimule Hills Farm'),(6.5,'2025-09-08',88.00,39,66.00,_binary '\ñyz&‰˜@™=¨X)\çº','Masai Sheep','eOrganic Certification','','Dimo Creek Farm','Lamb','','Nimule Creek Farm');
/*!40000 ALTER TABLE `livestock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livestock_transactions`
--

DROP TABLE IF EXISTS `livestock_transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livestock_transactions` (
  `cost` decimal(38,2) DEFAULT NULL,
  `livestock_age` double NOT NULL,
  `product_price` decimal(38,2) DEFAULT NULL,
  `purchase_quantity` int NOT NULL,
  `time_stamp` datetime(6) DEFAULT NULL,
  `transaction_id` bigint NOT NULL,
  `product_id` binary(16) NOT NULL,
  `livestock_breed` varchar(255) DEFAULT NULL,
  `livestock_certification` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_location` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_picture` varchar(255) DEFAULT NULL,
  `product_provenance` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livestock_transactions`
--

LOCK TABLES `livestock_transactions` WRITE;
/*!40000 ALTER TABLE `livestock_transactions` DISABLE KEYS */;
INSERT INTO `livestock_transactions` VALUES (4.00,1,2.00,2,'2025-09-12 08:57:27.118176',52,_binary 'ˆ\òF¦¢x\ïÄ‰}iü','Rainbow','eOrganic Certification','Brooded kroilers','Dimo Creek Farm','Chicken','','Dimo Creek Farm'),(3520.00,3,88.00,40,'2025-09-12 09:02:42.366190',53,_binary '\Ý×žvyH›ŠŠâ“¹ÿ­(','Nubian','eOrganic Certification','','Nimule Hills Farm','Goat','','Nimule Hills Farm'),(88.00,6.5,88.00,1,'2025-09-12 09:05:13.370436',54,_binary '\ñyz&‰˜@™=¨X)\çº','Masai Sheep','eOrganic Certification','','Dimo Creek Farm','Lamb','','Nimule Creek Farm'),(720.00,24,360.00,2,'2025-09-12 09:07:44.856842',55,_binary '\Ê\ÆÒ™\\I¿š¤4%\ß%','Masai Sheep','eOrganic Certification','','Dimo Creek Farm','Sheep','','Dimo Creek Farm'),(11500.00,18,1150.00,10,'2025-09-12 09:09:56.446106',56,_binary '¾¾u5\ÝI†\×}8³ù]','Ankole-Watusi','eOrganic Certification','','Nimule Hills Farm','Cow','','Nimule Hills Farm');
/*!40000 ALTER TABLE `livestock_transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produce`
--

DROP TABLE IF EXISTS `produce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produce` (
  `date` date DEFAULT NULL,
  `expiry` date DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  `weight` decimal(38,2) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `provenance` varchar(255) DEFAULT NULL,
  `variety` varchar(255) DEFAULT NULL,
  `category` enum('Cereal','Fruit','None','Vegetable') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produce`
--

LOCK TABLES `produce` WRITE;
/*!40000 ALTER TABLE `produce` DISABLE KEYS */;
INSERT INTO `produce` VALUES ('2025-09-08','2027-09-01',5.00,600.00,_binary ';\ß¢\ÛI\ïžE{š>t','','Yei Town','Rice','','Dimo Creek Farm','Jasmine','Cereal'),('2025-09-08','2025-09-20',0.80,97.00,_binary '<\í…þ®Hs¶\ÏmPø\ó•','','Dimo','Pineapple','','Yei River Orchard','Queen','Fruit'),('2025-09-08','2026-10-01',0.25,480.00,_binary 'R†q\0²J„¾\á:H\'j\ë‰','','Nimule','Sorghum','','Nimule Hills Farm','Milo','Cereal'),('2025-09-08','2025-09-15',2.00,75.00,_binary 'oe—\ËFV…±ŸÒ‚€\î\Z','','Dimo','Mango','','Yei River Orchard','Ngowe','Fruit'),('2025-09-08','2025-09-13',1.50,9.00,_binary 's‚3w»DL~·5G #*®','','Nimule','Khoodra','','Nimule Hills Farm','','Vegetable'),('2025-09-08','2025-09-15',0.90,9000.00,_binary '¸RŸyEú@‡¶szó¡“¿Á','','Yei Town','Cassava','','Dimo Creek Farm','Hope','Vegetable'),('2025-09-08','2026-11-01',0.25,470.00,_binary '\Ùq\Ò\r\ä\ÈN`Žvs>Ï„\î\Ñ','','Nimule','Maize','','Nimule Hills Farm','TELA','Cereal'),('2025-09-08','2025-09-30',2.50,0.00,_binary '\Ü3\àv³Bˆ‘W \"B\Î\ó','','Dimo','Guava','','Yei River Orchard','Bassateen Edfina','Fruit');
/*!40000 ALTER TABLE `produce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produce_transactions`
--

DROP TABLE IF EXISTS `produce_transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produce_transactions` (
  `cost` decimal(38,2) DEFAULT NULL,
  `produce_expiry` date DEFAULT NULL,
  `product_price` decimal(38,2) DEFAULT NULL,
  `purchase_weight` decimal(38,2) DEFAULT NULL,
  `time_stamp` datetime(6) DEFAULT NULL,
  `transaction_id` bigint NOT NULL,
  `product_id` binary(16) NOT NULL,
  `produce_category` varchar(255) DEFAULT NULL,
  `produce_variety` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_location` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_picture` varchar(255) DEFAULT NULL,
  `product_provenance` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produce_transactions`
--

LOCK TABLES `produce_transactions` WRITE;
/*!40000 ALTER TABLE `produce_transactions` DISABLE KEYS */;
INSERT INTO `produce_transactions` VALUES (8.00,'2025-09-20',0.80,10.00,'2025-09-12 08:19:15.261317',1,_binary '<\í…þ®Hs¶\ÏmPø\ó•','Fruit','Queen','','Dimo','Pineapple','','Yei River Orchard'),(10.00,'2025-09-15',2.00,5.00,'2025-09-12 08:21:36.878456',2,_binary 'oe—\ËFV…±ŸÒ‚€\î\Z','Fruit','Ngowe','','Dimo','Mango','','Yei River Orchard'),(187.50,'2025-09-30',2.50,75.00,'2025-09-12 08:24:37.911253',3,_binary '\Ü3\àv³Bˆ‘W \"B\Î\ó','Fruit','Bassateen Edfina','','Dimo','Guava','','Yei River Orchard'),(1.50,'2025-09-13',1.50,1.00,'2025-09-12 08:28:35.169445',4,_binary 's‚3w»DL~·5G #*®','Vegetable','','','Nimule','Khoodra','','Nimule Hills Farm'),(5.00,'2026-10-01',0.25,20.00,'2025-09-12 08:31:54.269836',5,_binary 'R†q\0²J„¾\á:H\'j\ë‰','Cereal','Milo','','Nimule','Sorghum','','Nimule Hills Farm'),(450.00,'2025-09-15',0.90,500.00,'2025-09-12 08:36:24.284111',7,_binary '¸RŸyEú@‡¶szó¡“¿Á','Vegetable','Hope','','Yei Town','Cassava','','Dimo Creek Farm'),(2500.00,'2027-09-01',5.00,500.00,'2025-09-12 08:41:30.038057',8,_binary ';\ß¢\ÛI\ïžE{š>t','Cereal','Jasmine','','Yei Town','Rice','','Dimo Creek Farm');
/*!40000 ALTER TABLE `produce_transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` binary(16) NOT NULL,
  `date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `farm` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  `weight` decimal(38,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_seq`
--

DROP TABLE IF EXISTS `transaction_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_seq`
--

LOCK TABLES `transaction_seq` WRITE;
/*!40000 ALTER TABLE `transaction_seq` DISABLE KEYS */;
INSERT INTO `transaction_seq` VALUES (151);
/*!40000 ALTER TABLE `transaction_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-12  9:53:23
