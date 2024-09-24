-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: db_libros
-- ------------------------------------------------------
-- Server version	5.5.5-10.11.2-MariaDB

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
-- Table structure for table `autores`
--

DROP TABLE IF EXISTS `autores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autores` (
  `IdAutor` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Apellido` varchar(100) NOT NULL,
  PRIMARY KEY (`IdAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autores`
--

LOCK TABLES `autores` WRITE;
/*!40000 ALTER TABLE `autores` DISABLE KEYS */;
INSERT INTO `autores` VALUES (1,'Paul','Deitel'),(2,'Harvey','Deitel'),(3,'Abbey','Deitel'),(4,'Dan','Quirk'),(5,'Michael','Morgano');
/*!40000 ALTER TABLE `autores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autorisbn`
--

DROP TABLE IF EXISTS `autorisbn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autorisbn` (
  `IdAutor` int(10) unsigned NOT NULL,
  `ISBN` varchar(32) DEFAULT NULL,
  KEY `autorisbn_titulos_FK` (`ISBN`),
  KEY `fk_autoresisbn_autores` (`IdAutor`),
  CONSTRAINT `autorisbn_titulos_FK` FOREIGN KEY (`ISBN`) REFERENCES `titulos` (`ISBN`),
  CONSTRAINT `fk_autoresisbn_autores` FOREIGN KEY (`IdAutor`) REFERENCES `autores` (`IdAutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autorisbn`
--

LOCK TABLES `autorisbn` WRITE;
/*!40000 ALTER TABLE `autorisbn` DISABLE KEYS */;
INSERT INTO `autorisbn` VALUES (1,'0132151006'),(2,'0132151006'),(3,'0132151006'),(1,'0133807800'),(2,'0133807800'),(1,'0132575655'),(2,'0132575655'),(1,'013299044X'),(2,'013299044X'),(1,'0132990601'),(2,'0132990601'),(3,'0132990601'),(1,'0133406954'),(2,'0133406954'),(3,'0133406954'),(1,'0133379337'),(2,'0133379337'),(1,'0136151574'),(2,'0136151574'),(4,'0136151574'),(1,'0133378713'),(2,'0133378713'),(1,'0132121360'),(2,'0132121360'),(3,'0132121360'),(5,'0132121360'),(1,'0133570924'),(2,'0133570924'),(3,'0133570924');
/*!40000 ALTER TABLE `autorisbn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direcciones`
--

DROP TABLE IF EXISTS `direcciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direcciones` (
  `IdDireccion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Apellido` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Telefono` varchar(100) NOT NULL,
  PRIMARY KEY (`IdDireccion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones`
--

LOCK TABLES `direcciones` WRITE;
/*!40000 ALTER TABLE `direcciones` DISABLE KEYS */;
INSERT INTO `direcciones` VALUES (1,'José','Pino','josapino@uacam.mx','12345678'),(2,'José','Canepa','jcaguilc@uacam.mx','9821035310');
/*!40000 ALTER TABLE `direcciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `titulos`
--

DROP TABLE IF EXISTS `titulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `titulos` (
  `ISBN` varchar(32) NOT NULL,
  `Titulo` varchar(255) NOT NULL,
  `Edicion` int(10) unsigned NOT NULL,
  `Publicacion` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titulos`
--

LOCK TABLES `titulos` WRITE;
/*!40000 ALTER TABLE `titulos` DISABLE KEYS */;
INSERT INTO `titulos` VALUES ('0132121360','Android for Programmers: An App-Driven Approach',1,2012),('0132151006','Internet & World Wide Web Hot to Program',5,2012),('0132575655','Java How to Program, Late Objects Version',10,2015),('013299044X','C How to Program',7,2013),('0132990601','Simply Visual Basic 2010',4,2013),('0133378713','C++ How to Program',9,2014),('0133379337','Visual C++ 2008 How to Program',2,2008),('0133406954','Visual Basic 2012 How to Program',6,2014),('0133570924','Android How to Program',2,2015),('0133807800','Java How to Program',10,2015),('0136151574','Visual C# 2012 How to Program',5,2014);
/*!40000 ALTER TABLE `titulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_libros'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-24  9:33:21
