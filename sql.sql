-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: zoo
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `source` varchar(100) DEFAULT NULL,
  `dateofbirth` date DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `enclosureid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fka_idx` (`enclosureid`),
  CONSTRAINT `fka` FOREIGN KEY (`enclosureid`) REFERENCES `enclosure` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (29,'meo','cai','vn1','2024-01-03','meo',10),(30,'ca xau','duc','vn','2020-01-05','casau',10),(33,'1','2','chau phi','2004-01-02','34',10);
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal_diet`
--

DROP TABLE IF EXISTS `animal_diet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal_diet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `animalid` int DEFAULT NULL,
  `breakfast` varchar(255) DEFAULT NULL,
  `lunch` varchar(255) DEFAULT NULL,
  `dinner` varchar(255) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `animalid` (`animalid`),
  KEY `fk1_idx` (`breakfast`),
  KEY `fk2_idx` (`lunch`),
  KEY `fk3_idx` (`dinner`),
  CONSTRAINT `animal_diet_ibfk_1` FOREIGN KEY (`animalid`) REFERENCES `animal` (`id`),
  CONSTRAINT `fk1` FOREIGN KEY (`breakfast`) REFERENCES `food` (`id`),
  CONSTRAINT `fk2` FOREIGN KEY (`lunch`) REFERENCES `food` (`id`),
  CONSTRAINT `fk3` FOREIGN KEY (`dinner`) REFERENCES `food` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_diet`
--

LOCK TABLES `animal_diet` WRITE;
/*!40000 ALTER TABLE `animal_diet` DISABLE KEYS */;
INSERT INTO `animal_diet` VALUES (15,30,'chuoi','thit','thit','2024-05-31 06:24:36'),(22,29,'chuoi','chuoi','chuoi','2024-06-01 08:12:00'),(24,29,'chuoi','thit','thit','2024-06-01 08:12:49');
/*!40000 ALTER TABLE `animal_diet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animal_health`
--

DROP TABLE IF EXISTS `animal_health`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal_health` (
  `id` int NOT NULL AUTO_INCREMENT,
  `animalid` int DEFAULT NULL,
  `doctorid` int DEFAULT NULL,
  `dateofcheckup` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `disease` varchar(255) DEFAULT NULL,
  `medicine` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `animalid` (`animalid`),
  KEY `doctorid` (`doctorid`),
  KEY `fk_price_idx` (`medicine`),
  CONSTRAINT `animal_health_ibfk_1` FOREIGN KEY (`animalid`) REFERENCES `animal` (`id`),
  CONSTRAINT `animal_health_ibfk_2` FOREIGN KEY (`doctorid`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_price` FOREIGN KEY (`medicine`) REFERENCES `medicine` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_health`
--

LOCK TABLES `animal_health` WRITE;
/*!40000 ALTER TABLE `animal_health` DISABLE KEYS */;
INSERT INTO `animal_health` VALUES (16,29,15,'2023-05-31 07:41:38','C','B'),(17,29,15,'2024-02-01 17:00:00','B','B'),(18,29,15,'2024-01-05 17:00:00','S','B'),(20,29,15,'2023-12-31 17:00:00','cd12','B'),(21,29,15,'2024-06-01 08:18:46','fgdfgdf','B');
/*!40000 ALTER TABLE `animal_health` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `dateofbirth` date DEFAULT NULL,
  `entrydate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `type` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (11,'1','324324','nam','2024-01-01','2024-05-30 14:50:41','người lớn',100),(12,'2','213','3','2024-01-01','2024-05-30 14:50:48','trẻ em',50),(13,'2','0213123','3','2024-01-01','2024-05-30 14:50:50','trẻ em',50),(17,'tien','1','234','2004-01-01','2024-06-01 07:03:50','người lớn',100),(18,'Tiến đtrai','039148','Nam','2004-11-09','2024-06-01 08:26:34','người lớn',100),(19,'1','1','1','2002-01-01','2024-06-01 08:32:51','người lớn',100);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `shift` varchar(50) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `dateofbirth` date DEFAULT NULL,
  `dateofjoining` date DEFAULT NULL,
  `designation` varchar(100) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (10,'mr tien','Nam','Sáng','0395527028','2020-09-11','2021-09-11','Quản lí','1','1',1),(15,'miessi','1','Sáng','1','2020-09-11','2020-09-11','Bác sĩ','3','3',2),(19,'tien dep trai','Nam','Chiều','0395572082','2004-01-01','2024-01-01','Thu ngân','2','2',3);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_enclosure`
--

DROP TABLE IF EXISTS `employee_enclosure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_enclosure` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enclosureid` int DEFAULT NULL,
  `employeeid` int DEFAULT NULL,
  `startdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `enddate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `enclosureid` (`enclosureid`),
  KEY `employeeid` (`employeeid`),
  CONSTRAINT `employee_enclosure_ibfk_1` FOREIGN KEY (`enclosureid`) REFERENCES `enclosure` (`id`),
  CONSTRAINT `employee_enclosure_ibfk_2` FOREIGN KEY (`employeeid`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_enclosure`
--

LOCK TABLES `employee_enclosure` WRITE;
/*!40000 ALTER TABLE `employee_enclosure` DISABLE KEYS */;
INSERT INTO `employee_enclosure` VALUES (81,10,10,'2024-05-03 13:18:32',NULL),(83,10,19,'2024-05-03 13:18:32',NULL),(98,10,15,'2024-06-01 05:52:35',NULL),(99,12,10,'2024-06-01 06:14:52',NULL),(100,12,15,'2024-06-01 06:14:52',NULL);
/*!40000 ALTER TABLE `employee_enclosure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enclosure`
--

DROP TABLE IF EXISTS `enclosure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enclosure` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `area` double DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `numberofanimals` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enclosure`
--

LOCK TABLES `enclosure` WRITE;
/*!40000 ALTER TABLE `enclosure` DISABLE KEYS */;
INSERT INTO `enclosure` VALUES (10,'A',2341,'cat','1',NULL),(12,'C',234.123,'câsau','good',NULL);
/*!40000 ALTER TABLE `enclosure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES ('chuoi','chuoi','chuoi','1'),('thit','thit','thit','2');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `price` double DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES ('B','ia chay','dung cho dong vat khi bi ia chay',20);
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-02 21:58:26
