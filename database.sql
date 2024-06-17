-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: zoos
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (37,'Hổ A','Hổ','Trung Quốc','2022-09-09','Đực',17),(38,'Hổ B','Cái','Trung Quốc','2021-10-14','Hổ',17),(39,'Sư Tử C','Cái','Nam Phi','2020-08-23','Sư Tử',18),(40,'Hươu Cao Cổ D','Đực','Kenya','2021-05-15','Hươu Cao Cổ',19),(41,'Gấu E','Cái','Nga','2018-07-28','Gấu',20),(42,'Ngựa Vằn F','Đực','Tanzania','2022-02-19','Ngựa Vằn',21),(43,'Hổ C','Đực','Ấn Độ','2023-01-10','Hổ',17),(44,'Sư Tử D','Đực','Nam Phi','2022-11-22','Sư Tử',18),(45,'Hươu Cao Cổ E','Cái','Nam Phi','2023-03-04','Hươu Cao Cổ',19),(46,'Gấu F','Đực','Canada','2019-09-13','Gấu',20),(47,'Ngựa Vằn G','Cái','Nam Phi','2020-12-05','Ngựa Vằn',21);
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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_diet`
--

LOCK TABLES `animal_diet` WRITE;
/*!40000 ALTER TABLE `animal_diet` DISABLE KEYS */;
INSERT INTO `animal_diet` VALUES (27,37,'thịt bò','thịt gà','thịt lợn','2024-06-17 10:05:09'),(28,38,'thịt bò','thịt lợn','thịt gà','2024-06-17 10:16:57'),(29,39,'thịt bò','thịt lợn','thịt gà','2024-06-17 10:19:28'),(30,40,'quả mọng','quả mọng','quả mọng','2024-06-17 10:19:28'),(31,41,'mật ong','côn trùng','nội tạng','2024-06-17 10:19:28'),(33,39,'thịt bò','thịt lợn','thịt gà','2024-06-17 10:20:22'),(34,40,'quả mọng','quả mọng','quả mọng','2024-06-17 10:20:27'),(35,41,'mật ong','côn trùng','nội tạng','2024-06-17 10:20:30'),(36,45,'quả mọng','quả mọng','quả mọng','2024-06-17 10:21:09'),(37,46,'mật ong','côn trùng','nội tạng','2024-06-17 10:21:12'),(39,47,'cỏ tươi','cỏ tươi','cỏ tươi','2024-06-17 10:21:51');
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_health`
--

LOCK TABLES `animal_health` WRITE;
/*!40000 ALTER TABLE `animal_health` DISABLE KEYS */;
INSERT INTO `animal_health` VALUES (23,37,15,'2024-06-17 10:26:46','Đau chân','giảm đau'),(24,39,15,'2024-06-17 10:27:14','Tiêu chảy','tiêu chảy'),(25,42,15,'2024-06-17 10:27:39','Viêm chân tay','chống viêm');
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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (20,'Nguyễn Cao Quyền','','Nam','2010-05-06','2024-06-17 09:47:16','trẻ em',50),(21,'Lê Văn Anh','0987654321','Nam','2012-07-14','2024-06-17 09:49:58','trẻ em',50),(22,'Phạm Ngọc Lan','0123456789','Nữ','2011-09-30','2024-06-17 09:49:58','trẻ em',50),(23,'Trần Minh Tú','0912345678','Nam','2010-11-22','2024-06-17 09:49:58','trẻ em',50),(24,'Nguyễn Hải Yến','0934567890','Nữ','2012-03-05','2024-06-17 09:49:58','trẻ em',50),(25,'Hoàng Khánh Linh','0945678901','Nữ','2013-06-18','2024-06-17 09:49:58','trẻ em',50),(26,'Bùi Đức Minh','0956789012','Nam','2011-12-24','2024-06-17 09:49:58','trẻ em',50),(27,'Đỗ Thu Hằng','0967890123','Nữ','2012-10-10','2024-06-17 09:49:58','trẻ em',50),(28,'Phan Tuấn Kiệt','0978901234','Nam','2010-01-15','2024-06-17 09:49:58','trẻ em',50),(29,'Trương Thị Mai','0989012345','Nữ','2011-02-08','2024-06-17 09:49:58','trẻ em',50),(30,'Ngô Đăng Khoa','0990123456','Nam','2013-05-20','2024-06-17 09:49:58','trẻ em',50),(31,'Nguyễn Văn Nam','0901234567','Nam','1985-04-25','2024-06-17 09:49:58','người lớn',100),(32,'Trần Thị Bích','0912345678','Nữ','1990-06-30','2024-06-17 09:49:58','người lớn',100),(33,'Lê Thanh Hùng','0923456789','Nam','1983-09-10','2024-06-17 09:49:58','người lớn',100),(34,'Phạm Thị Ngọc','0934567890','Nữ','1978-12-12','2024-06-17 09:49:58','người lớn',100),(35,'Nguyễn Đăng Huy','0945678901','Nam','1982-02-14','2024-06-17 09:49:58','người lớn',100),(36,'Trần Thị Mai','0956789012','Nữ','1975-08-20','2024-06-17 09:49:58','người lớn',100),(37,'Vũ Văn Quang','0967890123','Nam','1992-11-11','2024-06-17 09:49:58','người lớn',100),(38,'Lê Thị Xuân','0978901234','Nữ','1988-07-07','2024-06-17 09:49:58','người lớn',100),(39,'Đỗ Thành Công','0989012345','Nam','1995-01-22','2024-06-17 09:49:58','người lớn',100),(40,'Ngô Thị Thu','0990123456','Nữ','1980-03-18','2024-06-17 09:49:58','người lớn',100);
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (10,'Phạm Ngọc Tiến','Nam','Sáng','0395527028','2004-09-11','2024-05-05','Quản lí','admin','admin',1),(15,'Đào Việt Anh','Nam','Chiều','0123456789','2000-02-11','2023-09-11','Bác sĩ','doctor','doctor',2),(19,'Nguyễn Ngọc Thạch','Nam','Chiều','0395572222','2004-01-02','2024-01-01','Thu ngân','cashier','cashier',3),(26,'Phạm Thanh Trì','Nam','Sáng','0395527088','1990-02-02','2010-02-03','Nhân viên','','',NULL),(27,'Trần Hữu Hòa','Nữ','Sáng','0122312131','2001-03-20','2021-06-06','Thu ngân','cashier','cashierhoa',NULL),(28,'Nguyễn Thị Lan','Nữ','Chiều','0987654321','1995-12-10','2023-01-15','Nhân viên','pass123','nguyenlan',NULL),(29,'Lê Văn An','Nam','Sáng','0976543210','1990-08-25','2022-09-01','Nhân viên','manager2023','levanan',NULL),(30,'Phạm Minh Hoàng','Nam','Tối','0965432109','1985-05-30','2021-11-11','Nhân viên','secure2023','phamhoang',NULL),(31,'Đặng Thị Thu','Nữ','Chiều','0943210987','1998-07-19','2023-04-20','Nhân viên','cashier456','dangthu',NULL),(32,'Trần Văn Kiên','Nam','Sáng','0912345678','1992-11-15','2020-12-01','Nhân viên','account2023','trankien',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enclosure`
--

LOCK TABLES `enclosure` WRITE;
/*!40000 ALTER TABLE `enclosure` DISABLE KEYS */;
INSERT INTO `enclosure` VALUES (17,'Chuồng Hổ',300,'Hổ','Hoạt động',NULL),(18,'Chuồng Sư Tử',400,'Sư Tử','Hoạt động',NULL),(19,'Chuồng Hươu Cao Cổ',600,'Hươu Cao Cổ','Hoạt động',NULL),(20,'Chuồng Gấu',250,'Gấu','Bảo trì',NULL),(21,'Chuồng Ngựa Vằn',350,'Ngựa Vằn','Có sẵn',NULL);
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
INSERT INTO `food` VALUES ('Cá','Cá tươi từ biển','dành cho động vật ăn thịt','1.00'),('Cỏ tươi','Cỏ','dành cho động vật ăn cỏ','0.5'),('Côn trùng','Côn trùng tươi','dành cho động vật ăn côn trùng','1.00'),('Hạt','Hạt dẻ rang','dành cho động vật ăn chay','1.00'),('Mật ong','Mật ong rừng nguyên chất','dành cho gấu','1.00'),('Nội tạng','Nội tạng gia súc','dành cho động vật ăn thịt','1.00'),('Quả mọng','Quả mọng tự nhiên','dành cho động vật ăn quả','1.00'),('thịt bò','thịt bò mỹ','dành cho động vật ăn thịt','1'),('Thịt gà','Thịt gà hữu cơ','dành cho động vật ăn thịt','1.00'),('Thịt lợn','Thịt heo tươi','dành cho động vật ăn thịt','1.00'),('Xương','Xương bò','dành cho động vật ăn thịt','1.00');
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
INSERT INTO `medicine` VALUES ('Cảm lạnh','Thuốc cảm lạnh','cho động vật bị cảm lạnh',1),('Chống dị ứng','Thuốc chống dị ứng','cho động vật bị dị ứng',1),('Chống viêm','Thuốc chống viêm','cho động vật bị viêm',1),('Đau bụng','Đau bụng','cho động vật đau bụng',1),('Giảm đau','Thuốc giảm đau','cho động vật bị đau',1),('Tiêu chảy','Thuốc tiêu chảy','cho động vật bị tiêu chảy',1);
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

-- Dump completed on 2024-06-17 17:43:56
