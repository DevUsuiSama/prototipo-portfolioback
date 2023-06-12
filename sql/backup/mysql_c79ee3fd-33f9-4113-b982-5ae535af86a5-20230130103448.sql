-- MySQL dump 10.13  Distrib 8.0.15-5, for Linux (x86_64)
--
-- Host: localhost    Database: bzkbgvwg3tnvaarchrsa
-- ------------------------------------------------------
-- Server version	8.0.15-5

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*!50717 SELECT COUNT(*) INTO @rocksdb_has_p_s_session_variables FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'performance_schema' AND TABLE_NAME = 'session_variables' */;
/*!50717 SET @rocksdb_get_is_supported = IF (@rocksdb_has_p_s_session_variables, 'SELECT COUNT(*) INTO @rocksdb_is_supported FROM performance_schema.session_variables WHERE VARIABLE_NAME=\'rocksdb_bulk_load\'', 'SELECT 0') */;
/*!50717 PREPARE s FROM @rocksdb_get_is_supported */;
/*!50717 EXECUTE s */;
/*!50717 DEALLOCATE PREPARE s */;
/*!50717 SET @rocksdb_enable_bulk_load = IF (@rocksdb_is_supported, 'SET SESSION rocksdb_bulk_load = 1', 'SET @rocksdb_dummy_bulk_load = 0') */;
/*!50717 PREPARE s FROM @rocksdb_enable_bulk_load */;
/*!50717 EXECUTE s */;
/*!50717 DEALLOCATE PREPARE s */;

--
-- Table structure for table `acerca_de`
--

DROP TABLE IF EXISTS `acerca_de`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `acerca_de` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acerca_de`
--

LOCK TABLES `acerca_de` WRITE;
/*!40000 ALTER TABLE `acerca_de` DISABLE KEYS */;
INSERT INTO `acerca_de` VALUES (1,'Soy una persona autodidacta, en busca de nuevas tecnologías o técnicas que me permitan realizar mi trabajo más eficaz y eficiente. Actualmente trabajo en el desarrollo de un proyecto e-commerce, a la par del desarrollo del portfolio para obtener el certificado de Desarrollador Full Stack JR. de Argentina Programa. // Test'),(2,NULL),(11,NULL);
/*!40000 ALTER TABLE `acerca_de` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle`
--

DROP TABLE IF EXISTS `detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `detalle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `titulo` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `ubicacion` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle`
--

LOCK TABLES `detalle` WRITE;
/*!40000 ALTER TABLE `detalle` DISABLE KEYS */;
INSERT INTO `detalle` VALUES (1,'Usui','José Fernando','Téc. En Programación y Análisis de Sistemas | Dev. Full Stack','Misiones, Argentina'),(2,NULL,NULL,NULL,NULL),(11,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educacion`
--

DROP TABLE IF EXISTS `educacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `educacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `fecha_final` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `titulo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `titulo_de_la_carrera` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `url` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `id_portfolio` int(11) DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5s5b43l002owxq6yyurgmlfr2` (`id_portfolio`),
  CONSTRAINT `FK5s5b43l002owxq6yyurgmlfr2` FOREIGN KEY (`id_portfolio`) REFERENCES `portfolio` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educacion`
--

LOCK TABLES `educacion` WRITE;
/*!40000 ALTER TABLE `educacion` DISABLE KEYS */;
INSERT INTO `educacion` VALUES (1,'Lleve a cabo el desarrollo de una App Web E-Commerce de nombre Juguetería GOYMAR. Utilizando PHP y JS puros.','2022-08-08','2019-03-01','ITEC3','Técnico Superior en Programación y Análisis de Sistemas ','https://devusuisama.github.io/assets/img/itec3.jpg',1,1),(2,'Curse un aproximado de dos años, con algunas materias de segundo año.','2018-12-31','2016-09-08','Universidad Gaston Dachary','Ingeniería en Informática ','https://devusuisama.github.io/assets/img/UniversidadGast%C3%B3nDachary.jpg',1,2),(3,'Fundamentos de la Programación, Programación Imperativa y Programación Orientada a Objetos.','2022-07-01','2022-03-01','Argentina Programa','#SéProgramar','https://devusuisama.github.io/assets/img/ArgentinaPrograma.jpg',1,1);
/*!40000 ALTER TABLE `educacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experiencia`
--

DROP TABLE IF EXISTS `experiencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `experiencia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_portfolio` int(11) DEFAULT NULL,
  `descripcion` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `fecha_final` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `titulo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `url` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK143exn3m119a8wk0sodr1ymg` (`id_portfolio`),
  CONSTRAINT `FK143exn3m119a8wk0sodr1ymg` FOREIGN KEY (`id_portfolio`) REFERENCES `portfolio` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiencia`
--

LOCK TABLES `experiencia` WRITE;
/*!40000 ALTER TABLE `experiencia` DISABLE KEYS */;
INSERT INTO `experiencia` VALUES (1,1,'Lleve a cabo el relevamiento, modelado de datos, modelo ambiental y de comportamiento, diseñe la interfaz, lleve a cabo la implantación, realice prueba de caja negra y caja blanca. ',NULL,'2021-07-31','Juguetería GOYMAR','https://devusuisama.github.io/assets/img/goymar.jpg');
/*!40000 ALTER TABLE `experiencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habilidades_blandas`
--

DROP TABLE IF EXISTS `habilidades_blandas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `habilidades_blandas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habilidades_blandas`
--

LOCK TABLES `habilidades_blandas` WRITE;
/*!40000 ALTER TABLE `habilidades_blandas` DISABLE KEYS */;
INSERT INTO `habilidades_blandas` VALUES (1,'Trabajo en Equipo'),(2,'Comunicación'),(3,'Pensamiento Análitico'),(4,'Gestión del Tiempo'),(5,'Resolución de Conflictos'),(6,'Autonomía'),(7,'Ganas de Aprender'),(8,'Inteligencia Emocional'),(9,'Toma de Decisiones'),(10,'Flexibilidad');
/*!40000 ALTER TABLE `habilidades_blandas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habilidades_duras`
--

DROP TABLE IF EXISTS `habilidades_duras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `habilidades_duras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imagen` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `sitioweb` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habilidades_duras`
--

LOCK TABLES `habilidades_duras` WRITE;
/*!40000 ALTER TABLE `habilidades_duras` DISABLE KEYS */;
INSERT INTO `habilidades_duras` VALUES (1,'https://cdn.worldvectorlogo.com/logos/arduino-1.svg','Arduino','https://www.arduino.cc/'),(2,'https://raw.githubusercontent.com/devicons/devicon/master/icons/cplusplus/cplusplus-original.svg','c++','https://www.w3schools.com/cpp/'),(3,'https://raw.githubusercontent.com/devicons/devicon/master/icons/csharp/csharp-original.svg','C#','https://www.w3schools.com/cs/'),(4,'https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original-wordmark.svg','CSS','https://www.w3schools.com/css/'),(5,'https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original-wordmark.svg','HTML','https://www.w3.org/html/'),(6,'https://raw.githubusercontent.com/devicons/devicon/master/icons/dot-net/dot-net-original-wordmark.svg','DOTNET','https://dotnet.microsoft.com/'),(7,'https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg','GIT','https://git-scm.com/'),(8,'https://upload.wikimedia.org/wikipedia/commons/7/71/GTK_logo.svg','GTK','https://www.gtk.org/'),(9,'https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-original.svg','JavaScript','https://developer.mozilla.org/en-US/docs/Web/JavaScript'),(10,'https://raw.githubusercontent.com/devicons/devicon/master/icons/linux/linux-original.svg','Linux','https://www.linux.org/'),(11,'https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg','MySQL','https://www.mysql.com/'),(12,'https://upload.wikimedia.org/wikipedia/commons/2/27/PHP-logo.svg','PHP','https://www.php.net'),(13,'https://raw.githubusercontent.com/devicons/devicon/master/icons/typescript/typescript-original.svg','TypeScript','https://www.typescriptlang.org/'),(14,'https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg','Java','https://www.java.com/es/download/help/whatis_java.html'),(15,'https://angular.io/assets/images/logos/angular/angular.svg','Angular','https://angular.io/guide/what-is-angular'),(16,'https://raw.githubusercontent.com/devicons/devicon/master/icons/bootstrap/bootstrap-plain-wordmark.svg','Bootstrap','https://getbootstrap.com/'),(17,'https://www.vectorlogo.zone/logos/springio/springio-icon.svg','Spring','https://spring.io/');
/*!40000 ALTER TABLE `habilidades_duras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habilidades_nivel`
--

DROP TABLE IF EXISTS `habilidades_nivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `habilidades_nivel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habilidades_nivel`
--

LOCK TABLES `habilidades_nivel` WRITE;
/*!40000 ALTER TABLE `habilidades_nivel` DISABLE KEYS */;
INSERT INTO `habilidades_nivel` VALUES (1,'BÁSICO'),(2,'INTERMEDIO'),(3,'AVANZADO');
/*!40000 ALTER TABLE `habilidades_nivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `perfil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rol` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portfolio`
--

DROP TABLE IF EXISTS `portfolio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `portfolio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url_banner` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `url_profile_picture` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `id_detalle` int(11) DEFAULT NULL,
  `id_acerca_de` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq4wixdb6buocn8sb0srvq7vu1` (`id_detalle`),
  KEY `FKdkl5edacubfbmaov2vdx6cjqs` (`id_acerca_de`),
  CONSTRAINT `FKdkl5edacubfbmaov2vdx6cjqs` FOREIGN KEY (`id_acerca_de`) REFERENCES `acerca_de` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKq4wixdb6buocn8sb0srvq7vu1` FOREIGN KEY (`id_detalle`) REFERENCES `detalle` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portfolio`
--

LOCK TABLES `portfolio` WRITE;
/*!40000 ALTER TABLE `portfolio` DISABLE KEYS */;
INSERT INTO `portfolio` VALUES (1,'https://utulsa.edu/wp-content/uploads/2020/09/tech-1200x460-1-1200x455.jpg','https://devusuisama.github.io/assets/img/usuario.jpeg',1,1),(2,NULL,NULL,2,2),(11,NULL,NULL,11,11);
/*!40000 ALTER TABLE `portfolio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portfolio_habilidades_blandas`
--

DROP TABLE IF EXISTS `portfolio_habilidades_blandas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `portfolio_habilidades_blandas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_habilidades_blandas` int(11) DEFAULT NULL,
  `id_portfolio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbrn2079ts6uvh2fx43466q56a` (`id_habilidades_blandas`),
  KEY `FKnd8mw815as33bwfmk1vfnf2pv` (`id_portfolio`),
  CONSTRAINT `FKbrn2079ts6uvh2fx43466q56a` FOREIGN KEY (`id_habilidades_blandas`) REFERENCES `habilidades_blandas` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKnd8mw815as33bwfmk1vfnf2pv` FOREIGN KEY (`id_portfolio`) REFERENCES `portfolio` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portfolio_habilidades_blandas`
--

LOCK TABLES `portfolio_habilidades_blandas` WRITE;
/*!40000 ALTER TABLE `portfolio_habilidades_blandas` DISABLE KEYS */;
INSERT INTO `portfolio_habilidades_blandas` VALUES (6,5,1),(7,3,1),(8,10,1),(9,7,1),(10,8,1),(11,6,1);
/*!40000 ALTER TABLE `portfolio_habilidades_blandas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portfolio_habilidades_duras`
--

DROP TABLE IF EXISTS `portfolio_habilidades_duras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `portfolio_habilidades_duras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_habilidades_duras` int(11) DEFAULT NULL,
  `id_habilidades_nivel` int(11) DEFAULT NULL,
  `id_portfolio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3mbgpbx9omkshnafjx9hsdl28` (`id_habilidades_duras`),
  KEY `FKcu7iraaynpdrfxfuklbf9nkv5` (`id_habilidades_nivel`),
  KEY `FKba3qtv3wxtdggj97dv4b691h9` (`id_portfolio`),
  CONSTRAINT `FK3mbgpbx9omkshnafjx9hsdl28` FOREIGN KEY (`id_habilidades_duras`) REFERENCES `habilidades_duras` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKba3qtv3wxtdggj97dv4b691h9` FOREIGN KEY (`id_portfolio`) REFERENCES `portfolio` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKcu7iraaynpdrfxfuklbf9nkv5` FOREIGN KEY (`id_habilidades_nivel`) REFERENCES `habilidades_nivel` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portfolio_habilidades_duras`
--

LOCK TABLES `portfolio_habilidades_duras` WRITE;
/*!40000 ALTER TABLE `portfolio_habilidades_duras` DISABLE KEYS */;
INSERT INTO `portfolio_habilidades_duras` VALUES (15,1,1,1),(16,2,1,1),(17,12,2,1),(18,3,1,1),(19,13,1,1),(21,4,2,1),(22,14,1,1),(23,5,2,1),(24,15,1,1),(26,7,2,1),(27,9,1,1),(28,16,1,1),(29,10,2,1),(40,11,2,1),(41,17,1,1);
/*!40000 ALTER TABLE `portfolio_habilidades_duras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proyecto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `imagen` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `repositorio` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `titulo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_portfolio` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoefho8hecoheegj9f1h2b7wj5` (`id_portfolio`),
  CONSTRAINT `FKoefho8hecoheegj9f1h2b7wj5` FOREIGN KEY (`id_portfolio`) REFERENCES `portfolio` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (1,'Aplicación Web E-Commerce (En desarrollo). ','https://devusuisama.github.io/assets/img/jugueteria-goymar.com.png','https://github.com/DevUsuiSama/jugueteria-goymar.com.git','Juguetería GOYMAR [Hola Mundo Gente]',1);
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre_de_usuario` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_portfolio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK96sotin2i7dcer0vu6b5uvpkq` (`id_portfolio`),
  CONSTRAINT `FK96sotin2i7dcer0vu6b5uvpkq` FOREIGN KEY (`id_portfolio`) REFERENCES `portfolio` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'$2a$10$KSt/OCbJmUSaX0Sw6gEXkeFEouPL7BOP0pN74kF.1Br4PbsV7wfDa','joesesilvae@gmail.com','DevUsuiSama',1),(2,'$2a$10$OEJok7XjqCdoYQg9IR10n.qbL/Kkc.idGnqygHvOR6kKUAY1UACxW','test@gmail.com','test1234',2),(11,'$2a$10$LVNWzIJ9qUylOjor6/OooulJn454aRHsapLfecYlxhYbHroAmCJBK','asdfa@gmail.com','olaketal',11);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_perfil`
--

DROP TABLE IF EXISTS `usuario_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario_perfil` (
  `id_usuario` int(11) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_perfil`),
  KEY `FK3cxlmf5q4y8mllkos025n9px8` (`id_perfil`),
  CONSTRAINT `FK2qe6tjawyl6ojl32uhbwllldh` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK3cxlmf5q4y8mllkos025n9px8` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_perfil`
--

LOCK TABLES `usuario_perfil` WRITE;
/*!40000 ALTER TABLE `usuario_perfil` DISABLE KEYS */;
INSERT INTO `usuario_perfil` VALUES (1,1),(2,1),(11,1),(1,2);
/*!40000 ALTER TABLE `usuario_perfil` ENABLE KEYS */;
UNLOCK TABLES;
/*!50112 SET @disable_bulk_load = IF (@is_rocksdb_supported, 'SET SESSION rocksdb_bulk_load = @old_rocksdb_bulk_load', 'SET @dummy_rocksdb_bulk_load = 0') */;
/*!50112 PREPARE s FROM @disable_bulk_load */;
/*!50112 EXECUTE s */;
/*!50112 DEALLOCATE PREPARE s */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-30 10:34:49
