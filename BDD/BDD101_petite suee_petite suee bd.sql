CREATE DATABASE  IF NOT EXISTS `petitesuee` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `petitesuee`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: petitesuee
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `aparticipea`
--

DROP TABLE IF EXISTS `aparticipea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aparticipea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `coureur_id` int(11) NOT NULL,
  `etape_id` int(11) NOT NULL,
  `tempsEt` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aparticipea`
--

LOCK TABLES `aparticipea` WRITE;
/*!40000 ALTER TABLE `aparticipea` DISABLE KEYS */;
INSERT INTO `aparticipea` VALUES (1,1,2,'03:42:20'),(2,1,3,'02:05:36'),(3,2,4,'03:43:00'),(4,3,5,'02:54:20'),(5,3,6,'04:02:03'),(6,4,4,'03:20:00'),(7,5,4,'02:59:00'),(8,6,1,'05:26:15'),(9,3,2,'02:06:58');
/*!40000 ALTER TABLE `aparticipea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coureur`
--

DROP TABLE IF EXISTS `coureur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coureur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomC` varchar(45) NOT NULL,
  `dateNaiss` date NOT NULL,
  `equipe_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coureur`
--

LOCK TABLES `coureur` WRITE;
/*!40000 ALTER TABLE `coureur` DISABLE KEYS */;
INSERT INTO `coureur` VALUES (1,'ali','1998-10-16',1),(2,'fanny','2000-05-20',1),(3,'clement','1992-10-20',2),(4,'arthur','2001-10-25',3),(5,'baptiste','1995-11-17',3),(6,'mick','1993-10-03',2),(7,'paulo','1985-02-06',3),(8,'eve','2003-06-04',2);
/*!40000 ALTER TABLE `coureur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `responsable` varchar(45) NOT NULL,
  `sponsor` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe`
--

LOCK TABLES `equipe` WRITE;
/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` VALUES (1,'Yannick','mafia'),(2,'Topher','Apple'),(3,'Maxime','Coca');
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etape`
--

DROP TABLE IF EXISTS `etape`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etape` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `Depart` varchar(45) NOT NULL,
  `arrivee` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etape`
--

LOCK TABLES `etape` WRITE;
/*!40000 ALTER TABLE `etape` DISABLE KEYS */;
INSERT INTO `etape` VALUES (1,'2019-12-03','paris','rouen'),(2,'2019-12-05','rouen','caen'),(3,'2019-12-07','caen','saint-malo'),(4,'2019-12-09','saint-malo','saint-brieuc'),(5,'2019-12-11','saint brieuc','guingamp'),(6,'2019-12-13','guingamp','callac');
/*!40000 ALTER TABLE `etape` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-04  9:28:05
