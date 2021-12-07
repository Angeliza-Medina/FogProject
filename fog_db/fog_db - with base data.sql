-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fog_db_v3
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `ccp`
--

DROP TABLE IF EXISTS `ccp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccp` (
  `ccp_id` int NOT NULL AUTO_INCREMENT,
  `fk_ccpWidth` int NOT NULL,
  `fk_ccpLength` int NOT NULL,
  `fk_ccpHeight` int NOT NULL,
  `middlePilar` tinyint NOT NULL DEFAULT '0',
  `fk_rafterSpacing` double NOT NULL,
  `fk_ccpRoofType_id` int NOT NULL,
  `fk_ccpRoofAngle` int NOT NULL,
  `fk_ccpRoofMaterial_id` int NOT NULL,
  `fk_cts_id` int DEFAULT NULL,
  `price` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`ccp_id`),
  UNIQUE KEY `customcarport_id_UNIQUE` (`ccp_id`),
  KEY `fk_ccpWidth` (`fk_ccpWidth`),
  KEY `fk_ccpLength` (`fk_ccpLength`),
  KEY `fk_ccpHeight` (`fk_ccpHeight`),
  KEY `fk_rafterSpacing` (`fk_rafterSpacing`),
  KEY `fk_ccpRoofType_id` (`fk_ccpRoofType_id`),
  KEY `fk_ccpRoofAngle` (`fk_ccpRoofAngle`),
  KEY `fk_ccpRoofMaterial_id` (`fk_ccpRoofMaterial_id`),
  KEY `fk_cts_id` (`fk_cts_id`),
  CONSTRAINT `fk_ccpHeight` FOREIGN KEY (`fk_ccpHeight`) REFERENCES `ccp_height_options` (`ccpHeight`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_ccpLength` FOREIGN KEY (`fk_ccpLength`) REFERENCES `ccp_length_options` (`ccpLength`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_ccpRoofAngle` FOREIGN KEY (`fk_ccpRoofAngle`) REFERENCES `ccp_roof_angle_options` (`ccpRoofAngle`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_ccpRoofMaterial_id` FOREIGN KEY (`fk_ccpRoofMaterial_id`) REFERENCES `ccp_roof_material_options` (`roofMaterial_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_ccpRoofType_id` FOREIGN KEY (`fk_ccpRoofType_id`) REFERENCES `ccp_roof_type_options` (`roofType_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_ccpWidth` FOREIGN KEY (`fk_ccpWidth`) REFERENCES `ccp_width_options` (`ccpWidth`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_cts_id` FOREIGN KEY (`fk_cts_id`) REFERENCES `cts` (`cts_id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccp`
--

LOCK TABLES `ccp` WRITE;
/*!40000 ALTER TABLE `ccp` DISABLE KEYS */;
/*!40000 ALTER TABLE `ccp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccp_components`
--

DROP TABLE IF EXISTS `ccp_components`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccp_components` (
  `ccpComponent_id` int NOT NULL AUTO_INCREMENT,
  `productName` varchar(150) NOT NULL,
  `widthInMM` int DEFAULT NULL,
  `lengthInCM` int DEFAULT NULL,
  `thicknessInMM` int DEFAULT NULL,
  `piecesPrPack` int DEFAULT NULL,
  `price` double NOT NULL,
  `fk_unit_id` int NOT NULL,
  `desc` varchar(500) NOT NULL,
  PRIMARY KEY (`ccpComponent_id`),
  UNIQUE KEY `ccpComponent_id_UNIQUE` (`ccpComponent_id`),
  KEY `fk_unit_id_idx` (`fk_unit_id`),
  CONSTRAINT `fk_unit_id` FOREIGN KEY (`fk_unit_id`) REFERENCES `units` (`unit_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccp_components`
--

LOCK TABLES `ccp_components` WRITE;
/*!40000 ALTER TABLE `ccp_components` DISABLE KEYS */;
INSERT INTO `ccp_components` VALUES (1,'Trykimp. bræt',200,360,25,NULL,140.22,1,'Understernbrædder til for & bag ende'),(2,'Trykimp. bræt',200,540,25,NULL,210.33,1,'Understernbrædder til siderne'),(3,'Trykimp. bræt',125,360,25,NULL,140.22,1,'Oversternbrædder til forenden'),(4,'Trykimp. bræt',125,540,25,NULL,210.33,1,'Oversternbrædder til siderne'),(5,'Lægte ubh.',73,420,38,NULL,188.79,1,'Til z på bagside af dør'),(6,'Reglar. ubh.',95,270,45,NULL,102.46,1,'Løsholter til skur gavle'),(7,'Reglar ubh.',95,240,45,NULL,91.08,1,'Løsholter til skur sider'),(8,'Spærtræ ubh.',195,600,45,NULL,636,1,'Remme i sider, sadles ned i stopler'),(9,'Spærtræ ubh.',195,480,45,NULL,508.8,1,'Remme i sider, sadles ned i stopler (skur del, deles)'),(10,'Spærtræ ubh.',195,600,45,NULL,636,1,'Spær, monteres på rem'),(11,'Trykimp. stolpe',97,300,97,NULL,248.85,1,'Stolper nedgraves 90 cm. i jord'),(12,'Trykimp. bræt',100,210,19,NULL,48.19,1,'Til beklædning af skur 1 på 2'),(13,'Trykimp. bræt',100,540,19,NULL,123.9,1,'Vandbræt på stern i sider'),(14,'Trykimp.bræt',100,360,19,NULL,82.61,1,'Vandbræt på stern i forende'),(15,'Tagplade',109,600,NULL,NULL,284,1,'Tagplader monteres på spær'),(16,'Tagplade',109,360,NULL,NULL,169,1,'Tagplader monteres på spær'),(17,'Plastmo bundskruer',NULL,NULL,NULL,200,359,2,'Skruer til tagplader'),(18,'Hulbånd 1x20mm',NULL,1000,NULL,1,269,3,'Til vindkryds på spær'),(19,'Universalbeslag 190mm højre',NULL,NULL,NULL,1,24.95,1,'Til montering af spær på rem'),(20,'Universalbeslag 190mm venstre',NULL,NULL,NULL,1,24.95,1,'Til montering af spær på rem'),(21,'NKT Basic skruer 4,5x60mm',NULL,NULL,NULL,200,79.95,2,'Til montering af stern og vandbrædt'),(22,'Beslagskruer 4,5x50mm',NULL,NULL,NULL,250,244.95,2,'Til montering af universalbeslag og hulbånd'),(23,'Bræddebolte 10x120mm',NULL,NULL,NULL,25,23.03,1,'Til montering af rem på stolper'),(24,'Firkantskiver 40x40x11mm',NULL,NULL,NULL,50,11.86,1,'Til montering af rem på stolper'),(25,'NKT Basic skruer 4,5x70mm',NULL,NULL,NULL,400,199,2,'Til montering af yderste beklædning'),(26,'NKT Basic skruer 4,5x50mm',NULL,NULL,NULL,300,109,2,'Til montering af inderste beklædning'),(27,'Stalddørsgreb 50x75',NULL,NULL,NULL,1,249,4,'Til lås på dør i skur'),(28,'T-hængsel 390mm',NULL,NULL,NULL,1,69.95,1,'Til skurdør'),(29,'Vinkelbeslag S35 VFZ 50x50x2,5x35mm',NULL,NULL,NULL,100,12.95,1,'Til montering af løsholter i skur');
/*!40000 ALTER TABLE `ccp_components` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccp_height_options`
--

DROP TABLE IF EXISTS `ccp_height_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccp_height_options` (
  `ccpHeight` int NOT NULL,
  PRIMARY KEY (`ccpHeight`),
  UNIQUE KEY `height_UNIQUE` (`ccpHeight`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccp_height_options`
--

LOCK TABLES `ccp_height_options` WRITE;
/*!40000 ALTER TABLE `ccp_height_options` DISABLE KEYS */;
INSERT INTO `ccp_height_options` VALUES (180),(210),(240),(270),(300);
/*!40000 ALTER TABLE `ccp_height_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccp_inquiries`
--

DROP TABLE IF EXISTS `ccp_inquiries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccp_inquiries` (
  `custom_carport_inquiry_id` int NOT NULL AUTO_INCREMENT,
  `inquiryDate` date NOT NULL,
  `fk_status_id` int NOT NULL DEFAULT '1',
  `fk_user_id` int DEFAULT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phoneNum` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `postalcode` int NOT NULL,
  `city` varchar(100) NOT NULL,
  `note` varchar(1000) NOT NULL,
  `fk_ccp_id` int NOT NULL,
  PRIMARY KEY (`custom_carport_inquiry_id`),
  UNIQUE KEY `custom_carport_inquiry_id_UNIQUE` (`custom_carport_inquiry_id`),
  UNIQUE KEY `fk_ccp_id_UNIQUE` (`fk_ccp_id`),
  KEY `fk_status_id_idx` (`fk_status_id`),
  KEY `fk_user_id_idx` (`fk_user_id`),
  CONSTRAINT `fk_ccp_id` FOREIGN KEY (`fk_ccp_id`) REFERENCES `ccp` (`ccp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_status_id` FOREIGN KEY (`fk_status_id`) REFERENCES `ccp_inquiry_statuses` (`status_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccp_inquiries`
--

LOCK TABLES `ccp_inquiries` WRITE;
/*!40000 ALTER TABLE `ccp_inquiries` DISABLE KEYS */;
/*!40000 ALTER TABLE `ccp_inquiries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccp_inquiry_statuses`
--

DROP TABLE IF EXISTS `ccp_inquiry_statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccp_inquiry_statuses` (
  `status_id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`status_id`),
  UNIQUE KEY `idstatuses_UNIQUE` (`status_id`),
  UNIQUE KEY `status_UNIQUE` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccp_inquiry_statuses`
--

LOCK TABLES `ccp_inquiry_statuses` WRITE;
/*!40000 ALTER TABLE `ccp_inquiry_statuses` DISABLE KEYS */;
INSERT INTO `ccp_inquiry_statuses` VALUES (4,'cancelled'),(3,'completed'),(2,'in progress'),(1,'pending');
/*!40000 ALTER TABLE `ccp_inquiry_statuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccp_length_options`
--

DROP TABLE IF EXISTS `ccp_length_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccp_length_options` (
  `ccpLength` int NOT NULL,
  PRIMARY KEY (`ccpLength`),
  UNIQUE KEY `length_UNIQUE` (`ccpLength`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccp_length_options`
--

LOCK TABLES `ccp_length_options` WRITE;
/*!40000 ALTER TABLE `ccp_length_options` DISABLE KEYS */;
INSERT INTO `ccp_length_options` VALUES (240),(270),(300),(330),(360),(390),(420),(450),(480),(510),(540),(570),(600),(630),(660),(690),(720),(750),(780);
/*!40000 ALTER TABLE `ccp_length_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccp_orders`
--

DROP TABLE IF EXISTS `ccp_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccp_orders` (
  `ccpOrder_id` int NOT NULL AUTO_INCREMENT,
  `orderDate` date NOT NULL,
  `fk_ccp_id` int NOT NULL,
  `fk_user_id` int DEFAULT NULL,
  PRIMARY KEY (`ccpOrder_id`),
  UNIQUE KEY `fk_ccp_id_UNIQUE` (`fk_ccp_id`),
  KEY `fk_user_id_idx` (`fk_user_id`),
  CONSTRAINT `fk_ccp_id2` FOREIGN KEY (`fk_ccp_id`) REFERENCES `ccp` (`ccp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_user_id_on_ccp_orders` FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccp_orders`
--

LOCK TABLES `ccp_orders` WRITE;
/*!40000 ALTER TABLE `ccp_orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `ccp_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccp_roof_angle_options`
--

DROP TABLE IF EXISTS `ccp_roof_angle_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccp_roof_angle_options` (
  `ccpRoofAngle` int NOT NULL,
  PRIMARY KEY (`ccpRoofAngle`),
  UNIQUE KEY `angle_UNIQUE` (`ccpRoofAngle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccp_roof_angle_options`
--

LOCK TABLES `ccp_roof_angle_options` WRITE;
/*!40000 ALTER TABLE `ccp_roof_angle_options` DISABLE KEYS */;
INSERT INTO `ccp_roof_angle_options` VALUES (15),(20),(25),(30),(35),(40),(45),(180);
/*!40000 ALTER TABLE `ccp_roof_angle_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccp_roof_material_options`
--

DROP TABLE IF EXISTS `ccp_roof_material_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccp_roof_material_options` (
  `roofMaterial_id` int NOT NULL AUTO_INCREMENT,
  `fk_roofType_id` int NOT NULL,
  `material` varchar(100) NOT NULL,
  `materialWidth` double DEFAULT NULL,
  `materialLength` double DEFAULT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`roofMaterial_id`),
  UNIQUE KEY `idcarport_roof_materials_UNIQUE` (`roofMaterial_id`),
  UNIQUE KEY `material_UNIQUE` (`material`),
  KEY `fk_roofType_id_idx` (`fk_roofType_id`),
  CONSTRAINT `fk_roofType_id2` FOREIGN KEY (`fk_roofType_id`) REFERENCES `ccp_roof_type_options` (`roofType_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccp_roof_material_options`
--

LOCK TABLES `ccp_roof_material_options` WRITE;
/*!40000 ALTER TABLE `ccp_roof_material_options` DISABLE KEYS */;
INSERT INTO `ccp_roof_material_options` VALUES (1,1,'Trapezplader i plast',NULL,NULL,114),(2,1,'Trapezplader i stål',NULL,NULL,114),(3,1,'Tagpap',NULL,NULL,114),(4,2,'Betontagsten - Rød',NULL,NULL,114),(5,2,'Betontagsten - Teglrød',NULL,NULL,114),(6,2,'Betontagsten - Brun',NULL,NULL,114),(7,2,'Betontagsten - Sort',NULL,NULL,114),(8,2,'Eternittag B6 - Grå',NULL,NULL,114),(9,2,'Eternittag B6 - Sort ',NULL,NULL,114),(10,2,'Eternittag B6 - Mokka (brun)',NULL,NULL,114),(11,2,'Eternittag B6 - Rødbrun',NULL,NULL,114),(12,2,'Eternittag B6 - Teglrød',NULL,NULL,114),(13,2,'Eternittag B7 - Grå',NULL,NULL,114),(14,2,'Eternittag B7 - Sort',NULL,NULL,114),(15,2,'Eternittag B7 - Mokka (brun)',NULL,NULL,114),(16,2,'Eternittag B7 - Rødbrun',NULL,NULL,114),(17,2,'Eternittag B7 - Teglrød',NULL,NULL,114),(18,2,'Eternittag B7 - Rødflammet',NULL,NULL,114);
/*!40000 ALTER TABLE `ccp_roof_material_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccp_roof_type_options`
--

DROP TABLE IF EXISTS `ccp_roof_type_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccp_roof_type_options` (
  `roofType_id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`roofType_id`),
  UNIQUE KEY `roofType_id_UNIQUE` (`roofType_id`),
  UNIQUE KEY `type_UNIQUE` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccp_roof_type_options`
--

LOCK TABLES `ccp_roof_type_options` WRITE;
/*!40000 ALTER TABLE `ccp_roof_type_options` DISABLE KEYS */;
INSERT INTO `ccp_roof_type_options` VALUES (2,'angled'),(1,'flat');
/*!40000 ALTER TABLE `ccp_roof_type_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccp_width_options`
--

DROP TABLE IF EXISTS `ccp_width_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccp_width_options` (
  `ccpWidth` int NOT NULL,
  PRIMARY KEY (`ccpWidth`),
  UNIQUE KEY `width_UNIQUE` (`ccpWidth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccp_width_options`
--

LOCK TABLES `ccp_width_options` WRITE;
/*!40000 ALTER TABLE `ccp_width_options` DISABLE KEYS */;
INSERT INTO `ccp_width_options` VALUES (240),(270),(300),(330),(360),(390),(420),(450),(480),(510),(540),(570),(600);
/*!40000 ALTER TABLE `ccp_width_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cts`
--

DROP TABLE IF EXISTS `cts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cts` (
  `cts_id` int NOT NULL AUTO_INCREMENT,
  `fk_ctsWidth` int NOT NULL,
  `fk_ctsLength` int NOT NULL,
  `fk_cladding_id` int NOT NULL,
  PRIMARY KEY (`cts_id`),
  UNIQUE KEY `cts_id_UNIQUE` (`cts_id`),
  KEY `fk_ctsWidth` (`fk_ctsWidth`),
  KEY `fk_ctsLength` (`fk_ctsLength`),
  KEY `fk_cladding_id` (`fk_cladding_id`),
  CONSTRAINT `fk_cladding_id` FOREIGN KEY (`fk_cladding_id`) REFERENCES `cts_cladding_options` (`cts_cladding_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_ctsLength` FOREIGN KEY (`fk_ctsLength`) REFERENCES `cts_length_options` (`ctsLength`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_ctsWidth` FOREIGN KEY (`fk_ctsWidth`) REFERENCES `cts_width_options` (`ctsWidth`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cts`
--

LOCK TABLES `cts` WRITE;
/*!40000 ALTER TABLE `cts` DISABLE KEYS */;
/*!40000 ALTER TABLE `cts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cts_cladding_options`
--

DROP TABLE IF EXISTS `cts_cladding_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cts_cladding_options` (
  `cts_cladding_id` int NOT NULL AUTO_INCREMENT,
  `cladding` varchar(100) NOT NULL,
  `thickness` double NOT NULL,
  `width` double NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`cts_cladding_id`),
  UNIQUE KEY `cladding_id_UNIQUE` (`cts_cladding_id`),
  UNIQUE KEY `cladding_UNIQUE` (`cladding`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cts_cladding_options`
--

LOCK TABLES `cts_cladding_options` WRITE;
/*!40000 ALTER TABLE `cts_cladding_options` DISABLE KEYS */;
INSERT INTO `cts_cladding_options` VALUES (1,'fyr',19,100,54.95),(2,'ask',19,100,124.95),(3,'eg',19,100,119.95),(4,'mahogni',19,100,144.95),(5,'gran',19,100,45.95),(6,'teak',19,100,249.95);
/*!40000 ALTER TABLE `cts_cladding_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cts_length_options`
--

DROP TABLE IF EXISTS `cts_length_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cts_length_options` (
  `ctsLength` int NOT NULL,
  PRIMARY KEY (`ctsLength`),
  UNIQUE KEY `length_UNIQUE` (`ctsLength`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cts_length_options`
--

LOCK TABLES `cts_length_options` WRITE;
/*!40000 ALTER TABLE `cts_length_options` DISABLE KEYS */;
INSERT INTO `cts_length_options` VALUES (0),(150),(180),(210),(240),(270),(300),(330),(360),(390),(420),(450),(480),(510),(540),(570),(600),(630),(660),(690);
/*!40000 ALTER TABLE `cts_length_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cts_width_options`
--

DROP TABLE IF EXISTS `cts_width_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cts_width_options` (
  `ctsWidth` int NOT NULL,
  PRIMARY KEY (`ctsWidth`),
  UNIQUE KEY `width_UNIQUE` (`ctsWidth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cts_width_options`
--

LOCK TABLES `cts_width_options` WRITE;
/*!40000 ALTER TABLE `cts_width_options` DISABLE KEYS */;
INSERT INTO `cts_width_options` VALUES (0),(210),(240),(270),(300),(330),(360),(390),(420),(450),(480),(510),(540),(570),(600),(630),(660),(690),(720);
/*!40000 ALTER TABLE `cts_width_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rafter_spacing_options`
--

DROP TABLE IF EXISTS `rafter_spacing_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rafter_spacing_options` (
  `rafterSpacingInM` double NOT NULL,
  PRIMARY KEY (`rafterSpacingInM`),
  UNIQUE KEY `rafterSpacing_UNIQUE` (`rafterSpacingInM`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rafter_spacing_options`
--

LOCK TABLES `rafter_spacing_options` WRITE;
/*!40000 ALTER TABLE `rafter_spacing_options` DISABLE KEYS */;
INSERT INTO `rafter_spacing_options` VALUES (0.86);
/*!40000 ALTER TABLE `rafter_spacing_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_id_UNIQUE` (`role_id`),
  UNIQUE KEY `role_UNIQUE` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'admin'),(2,'customer');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `units`
--

DROP TABLE IF EXISTS `units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `units` (
  `unit_id` int NOT NULL AUTO_INCREMENT,
  `unit` varchar(50) NOT NULL,
  PRIMARY KEY (`unit_id`),
  UNIQUE KEY `unit_id_UNIQUE` (`unit_id`),
  UNIQUE KEY `unit_UNIQUE` (`unit`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (2,'pk.'),(3,'rulle(r)'),(4,'sæt'),(1,'stk.');
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `fk_role_id` int NOT NULL DEFAULT '2',
  `email` varchar(100) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `idusers_UNIQUE` (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_role_id_idx` (`fk_role_id`),
  CONSTRAINT `fk_role_id` FOREIGN KEY (`fk_role_id`) REFERENCES `roles` (`role_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,'admin@gmail.com','John','Doe','123'),(2,2,'customer@gmail.com','Jane','Doe','123');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-07 19:12:24
