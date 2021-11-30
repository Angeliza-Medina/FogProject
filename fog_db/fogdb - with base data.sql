-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fog_db
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
-- Table structure for table `carport_height_options`
--

DROP TABLE IF EXISTS `carport_height_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport_height_options` (
  `carportHeightOption_id` int NOT NULL AUTO_INCREMENT,
  `height` int NOT NULL,
  PRIMARY KEY (`carportHeightOption_id`),
  UNIQUE KEY `carportHeightOption_id_UNIQUE` (`carportHeightOption_id`),
  UNIQUE KEY `height_UNIQUE` (`height`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport_height_options`
--

LOCK TABLES `carport_height_options` WRITE;
/*!40000 ALTER TABLE `carport_height_options` DISABLE KEYS */;
INSERT INTO `carport_height_options` VALUES (1,180),(2,210),(3,240),(4,270),(5,300);
/*!40000 ALTER TABLE `carport_height_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carport_length_options`
--

DROP TABLE IF EXISTS `carport_length_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport_length_options` (
  `carportLengthOption_id` int NOT NULL AUTO_INCREMENT,
  `length` int NOT NULL,
  PRIMARY KEY (`carportLengthOption_id`),
  UNIQUE KEY `idcarport_length_options_UNIQUE` (`carportLengthOption_id`),
  UNIQUE KEY `length_UNIQUE` (`length`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport_length_options`
--

LOCK TABLES `carport_length_options` WRITE;
/*!40000 ALTER TABLE `carport_length_options` DISABLE KEYS */;
INSERT INTO `carport_length_options` VALUES (1,240),(2,270),(3,300),(4,330),(5,360),(6,390),(7,420),(8,450),(9,480),(10,510),(11,540),(12,570),(13,600),(14,630),(15,660),(16,690),(17,720),(18,750),(19,780);
/*!40000 ALTER TABLE `carport_length_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carport_roof_angle_options`
--

DROP TABLE IF EXISTS `carport_roof_angle_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport_roof_angle_options` (
  `roofAngleOption_id` int NOT NULL AUTO_INCREMENT,
  `angle` int NOT NULL,
  PRIMARY KEY (`roofAngleOption_id`),
  UNIQUE KEY `carportRoofAngleOption_id_UNIQUE` (`roofAngleOption_id`),
  UNIQUE KEY `angle_UNIQUE` (`angle`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport_roof_angle_options`
--

LOCK TABLES `carport_roof_angle_options` WRITE;
/*!40000 ALTER TABLE `carport_roof_angle_options` DISABLE KEYS */;
INSERT INTO `carport_roof_angle_options` VALUES (1,15),(2,20),(3,25),(4,30),(5,35),(6,40),(7,45);
/*!40000 ALTER TABLE `carport_roof_angle_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carport_roof_material_options`
--

DROP TABLE IF EXISTS `carport_roof_material_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport_roof_material_options` (
  `roofMaterial_id` int NOT NULL AUTO_INCREMENT,
  `fk_roofType_id` int NOT NULL,
  `material` varchar(100) NOT NULL,
  PRIMARY KEY (`roofMaterial_id`),
  UNIQUE KEY `idcarport_roof_materials_UNIQUE` (`roofMaterial_id`),
  UNIQUE KEY `material_UNIQUE` (`material`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport_roof_material_options`
--

LOCK TABLES `carport_roof_material_options` WRITE;
/*!40000 ALTER TABLE `carport_roof_material_options` DISABLE KEYS */;
INSERT INTO `carport_roof_material_options` VALUES (12,1,'Trapezplader i plast'),(13,1,'Trapezplader i stål'),(14,1,'Tagpap'),(15,2,'Betontagsten - Rød'),(16,2,'Betontagsten - Teglrød'),(17,2,'Betontagsten - Brun'),(18,2,'Betontagsten - Sort'),(19,2,'Eternittag B6 - Grå'),(20,2,'Eternittag B6 - Sort '),(21,2,'Eternittag B6 - Mokka (brun)'),(22,2,'Eternittag B6 - Rødbrun'),(23,2,'Eternittag B6 - Teglrød'),(24,2,'Eternittag B7 - Grå'),(25,2,'Eternittag B7 - Sort'),(26,2,'Eternittag B7 - Mokka (brun)'),(27,2,'Eternittag B7 - Rødbrun'),(28,2,'Eternittag B7 - Teglrød'),(29,2,'Eternittag B7 - Rødflammet');
/*!40000 ALTER TABLE `carport_roof_material_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carport_roof_type_options`
--

DROP TABLE IF EXISTS `carport_roof_type_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport_roof_type_options` (
  `roofType_id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`roofType_id`),
  UNIQUE KEY `roofType_id_UNIQUE` (`roofType_id`),
  UNIQUE KEY `type_UNIQUE` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport_roof_type_options`
--

LOCK TABLES `carport_roof_type_options` WRITE;
/*!40000 ALTER TABLE `carport_roof_type_options` DISABLE KEYS */;
INSERT INTO `carport_roof_type_options` VALUES (2,'angled'),(1,'flat');
/*!40000 ALTER TABLE `carport_roof_type_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carport_width_options`
--

DROP TABLE IF EXISTS `carport_width_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport_width_options` (
  `carportWidthOption_id` int NOT NULL AUTO_INCREMENT,
  `width` int NOT NULL,
  PRIMARY KEY (`carportWidthOption_id`),
  UNIQUE KEY `idcarport_width_options_UNIQUE` (`carportWidthOption_id`),
  UNIQUE KEY `width_UNIQUE` (`width`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport_width_options`
--

LOCK TABLES `carport_width_options` WRITE;
/*!40000 ALTER TABLE `carport_width_options` DISABLE KEYS */;
INSERT INTO `carport_width_options` VALUES (1,240),(2,270),(3,300),(4,330),(5,360),(6,390),(7,420),(8,450),(9,480),(10,510),(11,540),(12,570),(13,600);
/*!40000 ALTER TABLE `carport_width_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `custom_carport_inquiries`
--

DROP TABLE IF EXISTS `custom_carport_inquiries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `custom_carport_inquiries` (
  `custom_carport_inquiry_id` int NOT NULL AUTO_INCREMENT,
  `inquiryDate` date NOT NULL,
  `fk_status_id` int NOT NULL,
  `fk_user_id` int DEFAULT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phoneNum` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `postalcode` int NOT NULL,
  `city` varchar(100) NOT NULL,
  `fk_carportWidth_id` int NOT NULL,
  `fk_carportLength_id` int NOT NULL,
  `fk_carportHeight_id` int NOT NULL,
  `fk_roofType_id` int NOT NULL,
  `fk_roofMaterial_id` int NOT NULL,
  `fk_roofAngle_id` int NOT NULL,
  `fk_toolshedWidth_id` int NOT NULL,
  `fk_toolshedLength_id` int NOT NULL,
  PRIMARY KEY (`custom_carport_inquiry_id`),
  UNIQUE KEY `custom_carport_inquiry_id_UNIQUE` (`custom_carport_inquiry_id`),
  KEY `fk_status_id_idx` (`fk_status_id`),
  KEY `fk_user_id_idx` (`fk_user_id`),
  KEY `fk_carportWidth_id_idx` (`fk_carportWidth_id`),
  KEY `fk_carportLength_id_idx` (`fk_carportLength_id`),
  KEY `fk_carportHeight_id_idx` (`fk_carportHeight_id`),
  KEY `fk_roofType_id_idx` (`fk_roofType_id`),
  KEY `fk_roofMaterial_id_idx` (`fk_roofMaterial_id`),
  KEY `fk_roofAngle_id_idx` (`fk_roofAngle_id`),
  KEY `fk_toolshedWidth_id_idx` (`fk_toolshedWidth_id`),
  KEY `fk_toolshedLength_id_idx` (`fk_toolshedLength_id`),
  CONSTRAINT `fk_carportHeight_id` FOREIGN KEY (`fk_carportHeight_id`) REFERENCES `carport_height_options` (`carportHeightOption_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_carportLength_id` FOREIGN KEY (`fk_carportLength_id`) REFERENCES `carport_length_options` (`carportLengthOption_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_carportWidth_id` FOREIGN KEY (`fk_carportWidth_id`) REFERENCES `carport_width_options` (`carportWidthOption_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_roofAngle_id` FOREIGN KEY (`fk_roofAngle_id`) REFERENCES `carport_roof_angle_options` (`roofAngleOption_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_roofMaterial_id` FOREIGN KEY (`fk_roofMaterial_id`) REFERENCES `carport_roof_material_options` (`roofMaterial_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_roofType_id` FOREIGN KEY (`fk_roofType_id`) REFERENCES `carport_roof_type_options` (`roofType_id`),
  CONSTRAINT `fk_status_id` FOREIGN KEY (`fk_status_id`) REFERENCES `inquiry_statuses` (`status_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_toolshedLength_id` FOREIGN KEY (`fk_toolshedLength_id`) REFERENCES `toolshed_length_options` (`toolshedLengthOption_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_toolshedWidth_id` FOREIGN KEY (`fk_toolshedWidth_id`) REFERENCES `toolshed_width_options` (`toolshedWidthOption_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`users_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `custom_carport_inquiries`
--

LOCK TABLES `custom_carport_inquiries` WRITE;
/*!40000 ALTER TABLE `custom_carport_inquiries` DISABLE KEYS */;
/*!40000 ALTER TABLE `custom_carport_inquiries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `custom_carport_inquiries_view`
--

DROP TABLE IF EXISTS `custom_carport_inquiries_view`;
/*!50001 DROP VIEW IF EXISTS `custom_carport_inquiries_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `custom_carport_inquiries_view` AS SELECT 
 1 AS `inquiry_id`,
 1 AS `inquiryDate`,
 1 AS `status`,
 1 AS `user_id`,
 1 AS `firstName`,
 1 AS `lastName`,
 1 AS `email`,
 1 AS `phoneNum`,
 1 AS `address`,
 1 AS `postalcode`,
 1 AS `city`,
 1 AS `carportWidth`,
 1 AS `carportLength`,
 1 AS `carportHeight`,
 1 AS `roofType`,
 1 AS `roofMaterial`,
 1 AS `roofAngle`,
 1 AS `toolshedLength`,
 1 AS `toolshedWidth`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `inquiry_statuses`
--

DROP TABLE IF EXISTS `inquiry_statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inquiry_statuses` (
  `status_id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`status_id`),
  UNIQUE KEY `idstatuses_UNIQUE` (`status_id`),
  UNIQUE KEY `status_UNIQUE` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inquiry_statuses`
--

LOCK TABLES `inquiry_statuses` WRITE;
/*!40000 ALTER TABLE `inquiry_statuses` DISABLE KEYS */;
INSERT INTO `inquiry_statuses` VALUES (4,'cancelled'),(3,'completed'),(2,'in progress'),(1,'pending');
/*!40000 ALTER TABLE `inquiry_statuses` ENABLE KEYS */;
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
-- Table structure for table `toolshed_length_options`
--

DROP TABLE IF EXISTS `toolshed_length_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `toolshed_length_options` (
  `toolshedLengthOption_id` int NOT NULL AUTO_INCREMENT,
  `length` int NOT NULL,
  PRIMARY KEY (`toolshedLengthOption_id`),
  UNIQUE KEY `toolshedLengthOption_id_UNIQUE` (`toolshedLengthOption_id`),
  UNIQUE KEY `length_UNIQUE` (`length`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toolshed_length_options`
--

LOCK TABLES `toolshed_length_options` WRITE;
/*!40000 ALTER TABLE `toolshed_length_options` DISABLE KEYS */;
INSERT INTO `toolshed_length_options` VALUES (1,150),(2,180),(3,210),(4,240),(5,270),(6,300),(7,330),(8,360),(9,390),(10,420),(11,450),(12,480),(13,510),(14,540),(15,570),(16,600),(17,630),(18,660),(19,690);
/*!40000 ALTER TABLE `toolshed_length_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toolshed_width_options`
--

DROP TABLE IF EXISTS `toolshed_width_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `toolshed_width_options` (
  `toolshedWidthOption_id` int NOT NULL AUTO_INCREMENT,
  `width` int NOT NULL,
  PRIMARY KEY (`toolshedWidthOption_id`),
  UNIQUE KEY `toolshedWidthOption_id_UNIQUE` (`toolshedWidthOption_id`),
  UNIQUE KEY `width_UNIQUE` (`width`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toolshed_width_options`
--

LOCK TABLES `toolshed_width_options` WRITE;
/*!40000 ALTER TABLE `toolshed_width_options` DISABLE KEYS */;
INSERT INTO `toolshed_width_options` VALUES (1,210),(2,240),(3,270),(4,300),(5,330),(6,360),(7,390),(8,420),(9,450),(10,480),(11,510),(12,540),(13,570),(14,600),(15,630),(16,660),(17,690),(18,720);
/*!40000 ALTER TABLE `toolshed_width_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `users_id` int NOT NULL AUTO_INCREMENT,
  `fk_role_id` int NOT NULL DEFAULT '2',
  `email` varchar(100) NOT NULL,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`users_id`),
  UNIQUE KEY `idusers_UNIQUE` (`users_id`),
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

--
-- Final view structure for view `custom_carport_inquiries_view`
--

/*!50001 DROP VIEW IF EXISTS `custom_carport_inquiries_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `custom_carport_inquiries_view` AS select `custom_carport_inquiries`.`custom_carport_inquiry_id` AS `inquiry_id`,`custom_carport_inquiries`.`inquiryDate` AS `inquiryDate`,`inquiry_statuses`.`status` AS `status`,`custom_carport_inquiries`.`fk_user_id` AS `user_id`,`custom_carport_inquiries`.`firstName` AS `firstName`,`custom_carport_inquiries`.`lastName` AS `lastName`,`custom_carport_inquiries`.`email` AS `email`,`custom_carport_inquiries`.`phoneNum` AS `phoneNum`,`custom_carport_inquiries`.`address` AS `address`,`custom_carport_inquiries`.`postalcode` AS `postalcode`,`custom_carport_inquiries`.`city` AS `city`,`carport_width_options`.`width` AS `carportWidth`,`carport_length_options`.`length` AS `carportLength`,`carport_height_options`.`height` AS `carportHeight`,`carport_roof_type_options`.`type` AS `roofType`,`carport_roof_material_options`.`material` AS `roofMaterial`,`carport_roof_angle_options`.`angle` AS `roofAngle`,`toolshed_length_options`.`length` AS `toolshedLength`,`toolshed_width_options`.`width` AS `toolshedWidth` from (((((((((`custom_carport_inquiries` join `inquiry_statuses` on((`custom_carport_inquiries`.`fk_status_id` = `inquiry_statuses`.`status_id`))) join `carport_width_options` on((`custom_carport_inquiries`.`fk_carportWidth_id` = `carport_width_options`.`carportWidthOption_id`))) join `carport_length_options` on((`custom_carport_inquiries`.`fk_carportLength_id` = `carport_length_options`.`carportLengthOption_id`))) join `carport_height_options` on((`custom_carport_inquiries`.`fk_carportHeight_id` = `carport_height_options`.`carportHeightOption_id`))) join `carport_roof_type_options` on((`custom_carport_inquiries`.`fk_roofType_id` = `carport_roof_type_options`.`roofType_id`))) join `carport_roof_material_options` on((`custom_carport_inquiries`.`fk_roofMaterial_id` = `carport_roof_material_options`.`roofMaterial_id`))) join `carport_roof_angle_options` on((`custom_carport_inquiries`.`fk_roofAngle_id` = `carport_roof_angle_options`.`roofAngleOption_id`))) join `toolshed_length_options` on((`custom_carport_inquiries`.`fk_toolshedWidth_id` = `toolshed_length_options`.`toolshedLengthOption_id`))) join `toolshed_width_options` on((`custom_carport_inquiries`.`fk_toolshedWidth_id` = `toolshed_width_options`.`toolshedWidthOption_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-30  7:37:43
