-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: super_mastershop
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `tb_boleta`
--

DROP TABLE IF EXISTS `tb_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_boleta` (
  `cod_boleta` int NOT NULL AUTO_INCREMENT,
  `cod_cliente` int DEFAULT NULL,
  `cod_estado` int DEFAULT NULL,
  `fecha_boleta` date DEFAULT NULL,
  `monto_boleta` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`cod_boleta`),
  KEY `fk06` (`cod_cliente`),
  KEY `fk07` (`cod_estado`),
  CONSTRAINT `fk06` FOREIGN KEY (`cod_cliente`) REFERENCES `tb_cliente` (`cod_cliente`),
  CONSTRAINT `fk07` FOREIGN KEY (`cod_estado`) REFERENCES `tb_estadousuario` (`cod_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_categoria`
--

DROP TABLE IF EXISTS `tb_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_categoria` (
  `cod_categoria` int NOT NULL AUTO_INCREMENT,
  `descripcion_categoria` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`cod_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cliente` (
  `cod_cliente` int NOT NULL AUTO_INCREMENT,
  `login_cliente` varchar(60) DEFAULT NULL,
  `password` varchar(160) DEFAULT NULL,
  `nombre_cliente` varchar(80) DEFAULT NULL,
  `apellido_cliente` varchar(80) DEFAULT NULL,
  `cod_sexo` int DEFAULT NULL,
  `fechaNacimiento_cliente` date DEFAULT NULL,
  `rol_cliente` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_cliente`),
  KEY `fk05` (`cod_sexo`),
  CONSTRAINT `fk05` FOREIGN KEY (`cod_sexo`) REFERENCES `tb_sexocliente` (`cod_sexo`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_detallebotela`
--

DROP TABLE IF EXISTS `tb_detallebotela`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_detallebotela` (
  `cod_boleta` int DEFAULT NULL,
  `cod_producto` int DEFAULT NULL,
  `precio_detalle` decimal(10,0) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  KEY `cod_boleta` (`cod_boleta`),
  KEY `cod_producto` (`cod_producto`),
  CONSTRAINT `tb_detallebotela_ibfk_1` FOREIGN KEY (`cod_boleta`) REFERENCES `tb_boleta` (`cod_boleta`),
  CONSTRAINT `tb_detallebotela_ibfk_2` FOREIGN KEY (`cod_producto`) REFERENCES `tb_producto` (`cod_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_direccionproveedor`
--

DROP TABLE IF EXISTS `tb_direccionproveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_direccionproveedor` (
  `cod_proveedor` int NOT NULL AUTO_INCREMENT,
  `descripcion_proveedor` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`cod_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_enlace`
--

DROP TABLE IF EXISTS `tb_enlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_enlace` (
  `cod_enlace` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(60) DEFAULT NULL,
  `ruta` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`cod_enlace`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_estadousuario`
--

DROP TABLE IF EXISTS `tb_estadousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_estadousuario` (
  `cod_estado` int NOT NULL AUTO_INCREMENT,
  `descripcion_estado` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`cod_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_menuventa`
--

DROP TABLE IF EXISTS `tb_menuventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_menuventa` (
  `cod_menuVenta` int NOT NULL AUTO_INCREMENT,
  `descripcion_menuVenta` varchar(60) DEFAULT NULL,
  `url_menuVenta` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`cod_menuVenta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_producto`
--

DROP TABLE IF EXISTS `tb_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_producto` (
  `cod_producto` int NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(80) DEFAULT NULL,
  `descripcion_producto` varchar(200) DEFAULT NULL,
  `precio_producto` decimal(10,0) DEFAULT NULL,
  `imagen_producto` varchar(300) DEFAULT NULL,
  `stock_producto` int DEFAULT NULL,
  `cod_categoria` int DEFAULT NULL,
  `cod_proveedor` int DEFAULT NULL,
  `cod_estado` int DEFAULT NULL,
  PRIMARY KEY (`cod_producto`),
  KEY `cod_categoria` (`cod_categoria`),
  KEY `cod_proveedor` (`cod_proveedor`),
  KEY `cod_estado` (`cod_estado`),
  CONSTRAINT `tb_producto_ibfk_1` FOREIGN KEY (`cod_categoria`) REFERENCES `tb_categoria` (`cod_categoria`),
  CONSTRAINT `tb_producto_ibfk_2` FOREIGN KEY (`cod_proveedor`) REFERENCES `tb_proveedor` (`cod_proveedor`),
  CONSTRAINT `tb_producto_ibfk_3` FOREIGN KEY (`cod_estado`) REFERENCES `tb_estadousuario` (`cod_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_proveedor`
--

DROP TABLE IF EXISTS `tb_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_proveedor` (
  `cod_proveedor` int NOT NULL AUTO_INCREMENT,
  `descripcion_proveedor` varchar(90) DEFAULT NULL,
  `cod_proveedor_con` int DEFAULT NULL,
  PRIMARY KEY (`cod_proveedor`),
  KEY `cod_proveedor_con` (`cod_proveedor_con`),
  CONSTRAINT `tb_proveedor_ibfk_1` FOREIGN KEY (`cod_proveedor_con`) REFERENCES `tb_direccionproveedor` (`cod_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_rolenlace`
--

DROP TABLE IF EXISTS `tb_rolenlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rolenlace` (
  `cod_rol` int DEFAULT NULL,
  `cod_enlace` int DEFAULT NULL,
  KEY `fk03` (`cod_rol`),
  KEY `fk04` (`cod_enlace`),
  CONSTRAINT `fk03` FOREIGN KEY (`cod_rol`) REFERENCES `tb_rolusuario` (`cod_rol`),
  CONSTRAINT `fk04` FOREIGN KEY (`cod_enlace`) REFERENCES `tb_enlace` (`cod_enlace`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_rolusuario`
--

DROP TABLE IF EXISTS `tb_rolusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rolusuario` (
  `cod_rol` int NOT NULL AUTO_INCREMENT,
  `descripcion_rol` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`cod_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_sexocliente`
--

DROP TABLE IF EXISTS `tb_sexocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_sexocliente` (
  `cod_sexo` int NOT NULL AUTO_INCREMENT,
  `descripcion_sexo` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`cod_sexo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `cod_usuario` int NOT NULL AUTO_INCREMENT,
  `login` varchar(60) DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL,
  `nombre` varchar(60) DEFAULT NULL,
  `apellido` varchar(60) DEFAULT NULL,
  `correo` varchar(60) DEFAULT NULL,
  `cod_estado` int DEFAULT NULL,
  `cod_rol` int DEFAULT NULL,
  PRIMARY KEY (`cod_usuario`),
  KEY `fk01` (`cod_estado`),
  KEY `fk02` (`cod_rol`),
  CONSTRAINT `fk01` FOREIGN KEY (`cod_estado`) REFERENCES `tb_estadousuario` (`cod_estado`),
  CONSTRAINT `fk02` FOREIGN KEY (`cod_rol`) REFERENCES `tb_rolusuario` (`cod_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-17  3:05:46
