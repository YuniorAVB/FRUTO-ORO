-- MariaDB dump 10.18  Distrib 10.4.17-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: fruto_oro
-- ------------------------------------------------------
-- Server version	10.4.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `app_conductor`
--

DROP TABLE IF EXISTS `app_conductor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_conductor` (
  `con_id` int(11) NOT NULL AUTO_INCREMENT,
  `con_nombre` varchar(50) NOT NULL,
  `con_dni` char(8) NOT NULL,
  `con_apellido` varchar(50) NOT NULL,
  PRIMARY KEY (`con_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_conductor`
--

LOCK TABLES `app_conductor` WRITE;
/*!40000 ALTER TABLE `app_conductor` DISABLE KEYS */;
INSERT INTO `app_conductor` VALUES (1,'Yunior','12345678','vergara blas'),(8,'Pedro','23456787','FLORES');
/*!40000 ALTER TABLE `app_conductor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_empleado`
--

DROP TABLE IF EXISTS `app_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_empleado` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_dni` char(8) DEFAULT NULL,
  `emp_nombre` varchar(50) DEFAULT NULL,
  `emp_apellido` varchar(100) DEFAULT NULL,
  `emp_edad` int(11) DEFAULT NULL,
  `emp_sexo` char(1) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_empleado`
--

LOCK TABLES `app_empleado` WRITE;
/*!40000 ALTER TABLE `app_empleado` DISABLE KEYS */;
INSERT INTO `app_empleado` VALUES (1,'12345678','admin','admin',21,'M'),(14,'123456','yunior','vergara',11,'M');
/*!40000 ALTER TABLE `app_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_empresa`
--

DROP TABLE IF EXISTS `app_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_empresa` (
  `epr_id` int(11) NOT NULL AUTO_INCREMENT,
  `epr_ruc` varchar(50) NOT NULL,
  `epr_nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`epr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_empresa`
--

LOCK TABLES `app_empresa` WRITE;
/*!40000 ALTER TABLE `app_empresa` DISABLE KEYS */;
INSERT INTO `app_empresa` VALUES (1,'Leche Gloria','Leche Gloria'),(3,'123ASDASD','PUMANI');
/*!40000 ALTER TABLE `app_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_empresa_conductor_detalle`
--

DROP TABLE IF EXISTS `app_empresa_conductor_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_empresa_conductor_detalle` (
  `eprcondet_id` int(11) NOT NULL AUTO_INCREMENT,
  `eprcondet_con_id` int(11) NOT NULL,
  `eprcondet_epr_id` int(11) NOT NULL,
  PRIMARY KEY (`eprcondet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_empresa_conductor_detalle`
--

LOCK TABLES `app_empresa_conductor_detalle` WRITE;
/*!40000 ALTER TABLE `app_empresa_conductor_detalle` DISABLE KEYS */;
INSERT INTO `app_empresa_conductor_detalle` VALUES (15,8,1),(16,1,1);
/*!40000 ALTER TABLE `app_empresa_conductor_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_empresa_movilidad_detalle`
--

DROP TABLE IF EXISTS `app_empresa_movilidad_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_empresa_movilidad_detalle` (
  `eprmovdet_id` int(11) NOT NULL AUTO_INCREMENT,
  `eprmovdet_epr_id` int(11) NOT NULL,
  `eprmovdet_mov_id` int(11) NOT NULL,
  PRIMARY KEY (`eprmovdet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_empresa_movilidad_detalle`
--

LOCK TABLES `app_empresa_movilidad_detalle` WRITE;
/*!40000 ALTER TABLE `app_empresa_movilidad_detalle` DISABLE KEYS */;
INSERT INTO `app_empresa_movilidad_detalle` VALUES (11,1,2),(12,1,5),(13,3,3),(14,3,4);
/*!40000 ALTER TABLE `app_empresa_movilidad_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_modelo_ticket`
--

DROP TABLE IF EXISTS `app_modelo_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_modelo_ticket` (
  `modtic_id` int(11) NOT NULL AUTO_INCREMENT,
  `modtic_titulo` varchar(100) NOT NULL,
  `modtic_pie_pagina` varchar(100) NOT NULL,
  `modtic_sub_titulo` varchar(100) NOT NULL,
  PRIMARY KEY (`modtic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_modelo_ticket`
--

LOCK TABLES `app_modelo_ticket` WRITE;
/*!40000 ALTER TABLE `app_modelo_ticket` DISABLE KEYS */;
INSERT INTO `app_modelo_ticket` VALUES (1,'FRUTO DE ORO','GRACIAS POR SU VISITA','Sistema de pesaje automatico');
/*!40000 ALTER TABLE `app_modelo_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_movilidad`
--

DROP TABLE IF EXISTS `app_movilidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_movilidad` (
  `mov_id` int(11) NOT NULL AUTO_INCREMENT,
  `mov_destino` varchar(50) NOT NULL,
  `mov_procedencia` varchar(50) NOT NULL,
  `mov_placa` varchar(50) NOT NULL,
  PRIMARY KEY (`mov_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_movilidad`
--

LOCK TABLES `app_movilidad` WRITE;
/*!40000 ALTER TABLE `app_movilidad` DISABLE KEYS */;
INSERT INTO `app_movilidad` VALUES (2,'PISCO','CHINCHA ALTA','abc-abc'),(3,'PISCO','NAZCA','hyb342'),(4,'asdasd','asdasd','asdasdas'),(5,'PISCO','CHINCHA','nbgcbva');
/*!40000 ALTER TABLE `app_movilidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_pesaje`
--

DROP TABLE IF EXISTS `app_pesaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_pesaje` (
  `pes_id` int(11) NOT NULL AUTO_INCREMENT,
  `pes_mov_id` int(11) NOT NULL,
  `pes_emp_id` int(11) NOT NULL,
  `pes_con_id` int(11) NOT NULL,
  `pes_fecha_ingreso` date NOT NULL,
  `pes_fecha_salida` date NOT NULL,
  `pes_peso_ingreso` double NOT NULL,
  `pes_peso_salida` double NOT NULL,
  `pes_hora_ingreso` varchar(20) NOT NULL,
  `pes_hora_salida` varchar(20) NOT NULL,
  `pes_tara` double NOT NULL,
  PRIMARY KEY (`pes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_pesaje`
--

LOCK TABLES `app_pesaje` WRITE;
/*!40000 ALTER TABLE `app_pesaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_pesaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_pesaje_ticket`
--

DROP TABLE IF EXISTS `app_pesaje_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_pesaje_ticket` (
  `tic_id` int(11) NOT NULL AUTO_INCREMENT,
  `tic_pes_id` int(11) NOT NULL,
  `tic_serie_numero` int(11) NOT NULL,
  PRIMARY KEY (`tic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_pesaje_ticket`
--

LOCK TABLES `app_pesaje_ticket` WRITE;
/*!40000 ALTER TABLE `app_pesaje_ticket` DISABLE KEYS */;
INSERT INTO `app_pesaje_ticket` VALUES (1,1,1),(2,2,3);
/*!40000 ALTER TABLE `app_pesaje_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_session`
--

DROP TABLE IF EXISTS `app_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `app_session` (
  `ses_id` int(11) NOT NULL AUTO_INCREMENT,
  `ses_usuario` varchar(50) DEFAULT NULL,
  `ses_contrasenia` varchar(50) DEFAULT NULL,
  `ses_tipo` int(11) DEFAULT NULL,
  `ses_emp_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ses_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_session`
--

LOCK TABLES `app_session` WRITE;
/*!40000 ALTER TABLE `app_session` DISABLE KEYS */;
INSERT INTO `app_session` VALUES (1,'admin','qwerty',0,1),(5,'yunior','qwerty',1,14);
/*!40000 ALTER TABLE `app_session` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-02 22:44:11
