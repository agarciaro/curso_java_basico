-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `exemplars`
--

DROP TABLE IF EXISTS `exemplars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exemplars` (
  `num_exemplar` int AUTO_INCREMENT NOT NULL,
  `codi_llibre` int DEFAULT NULL,
  `any_edicio` int DEFAULT NULL,
  `num_edicio` int DEFAULT NULL,
  PRIMARY KEY (`num_exemplar`),
  KEY `codillibre_ind` (`codi_llibre`),
  CONSTRAINT `fk_exemplars` FOREIGN KEY (`codi_llibre`) REFERENCES `llibres` (`codi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exemplars`
--

LOCK TABLES `exemplars` WRITE;
/*!40000 ALTER TABLE `exemplars` DISABLE KEYS */;
INSERT INTO `exemplars` VALUES (1,1,1993,5),(2,1,1993,5),(3,2,NULL,2),(4,2,NULL,2),(5,2,NULL,3);
/*!40000 ALTER TABLE `exemplars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `llibres`
--

DROP TABLE IF EXISTS `llibres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `llibres` (
  `codi` int AUTO_INCREMENT NOT NULL,
  `titol` varchar(50) DEFAULT NULL,
  `editorial` varchar(50) DEFAULT NULL,
  `idioma` varchar(50) DEFAULT NULL,
  `autor` varchar(50) DEFAULT NULL,
  `num_eds` int DEFAULT NULL,
  PRIMARY KEY (`codi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `llibres`
--

LOCK TABLES `llibres` WRITE;
/*!40000 ALTER TABLE `llibres` DISABLE KEYS */;
INSERT INTO `llibres` VALUES (1,'introduccion a los sistemas de Bases de Datos','Addison-Wesley','Castella','Date',5),(2,'A guide to the SQL standard','Addison-Wesley','Angles','Date',3),(3,'Un nou llibre sobre SQL','Prentice-Hall','Catal�','Martin',7),(4,'Un altre llibre sobre SQL','Prentice-Hall','Catal�','Codd',NULL);
/*!40000 ALTER TABLE `llibres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestecs`
--

DROP TABLE IF EXISTS `prestecs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestecs` (
  `codi_soci` int NOT NULL,
  `num_exemplar` int NOT NULL,
  `data_prestec` date NOT NULL,
  `data_limit` date DEFAULT NULL,
  `data_devolucio` date DEFAULT NULL,
  PRIMARY KEY (`codi_soci`,`num_exemplar`,`data_prestec`),
  KEY `codisoci_ind` (`codi_soci`),
  KEY `exemplar_ind` (`num_exemplar`),
  CONSTRAINT `fk_prestecs1` FOREIGN KEY (`codi_soci`) REFERENCES `socis` (`codi`),
  CONSTRAINT `fk_prestecs2` FOREIGN KEY (`num_exemplar`) REFERENCES `exemplars` (`num_exemplar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestecs`
--

LOCK TABLES `prestecs` WRITE;
/*!40000 ALTER TABLE `prestecs` DISABLE KEYS */;
INSERT INTO `prestecs` VALUES (1,1,'1997-10-15','1997-10-30','1997-10-20'),(1,4,'1997-11-20','1997-12-05','1997-12-05'),(2,2,'1997-09-10','1997-10-10','1997-10-01'),(2,5,'1998-09-15','1998-10-15',NULL),(3,3,'1998-09-30','1998-10-30',NULL);
/*!40000 ALTER TABLE `prestecs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socis`
--

DROP TABLE IF EXISTS `socis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `socis` (
  `codi` int AUTO_INCREMENT NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `cognom` varchar(50) DEFAULT NULL,
  `dni` varchar(20) DEFAULT NULL,
  `adreca` varchar(50) DEFAULT NULL,
  `codi_postal` varchar(50) DEFAULT NULL,
  `ciutat` varchar(50) DEFAULT NULL,
  `provincia` varchar(50) DEFAULT NULL,
  `telefon` varchar(50) DEFAULT NULL,
  `data_alta` date DEFAULT NULL,
  PRIMARY KEY (`codi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socis`
--

LOCK TABLES `socis` WRITE;
/*!40000 ALTER TABLE `socis` DISABLE KEYS */;
INSERT INTO `socis` VALUES (1,'Ernest','Valveny','11111111','elpont','25600','Balaguer','Lleida','111 11 11','1993-01-01'),(2,'Enric','Marti','22222222','elriu','25600','Balaguer','Lleida','222 22 22','1990-01-01'),(3,'David','Lloret','33333333','lacarretera','25600','Balaguer','Lleida',NULL,'1995-01-01');
/*!40000 ALTER TABLE `socis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temes`
--

DROP TABLE IF EXISTS `temes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temes` (
  `codi_llibre` int NOT NULL,
  `tema` varchar(50) NOT NULL,
  PRIMARY KEY (`codi_llibre`,`tema`),
  KEY `codillibre_ind` (`codi_llibre`),
  CONSTRAINT `fk_temes` FOREIGN KEY (`codi_llibre`) REFERENCES `llibres` (`codi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temes`
--

LOCK TABLES `temes` WRITE;
/*!40000 ALTER TABLE `temes` DISABLE KEYS */;
INSERT INTO `temes` VALUES (1,'Bases de dades'),(2,'Bases de dades'),(2,'SQL');
/*!40000 ALTER TABLE `temes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'biblioteca'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-24 16:41:42
