-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: ljgames
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(8) NOT NULL auto_increment,
  `Nome` varchar(50) NOT NULL,
  `CPF` varchar(20) NOT NULL,
  `DataNasc` datetime DEFAULT NULL,
  `DataCadastro` datetime NOT NULL,
  `Endereco` varchar(70) DEFAULT NULL,
  `Numero` varchar(8) DEFAULT NULL,
  `Complemento` varchar(70) DEFAULT NULL,
  `Bairro` varchar(40) DEFAULT NULL,
  `Sexo` varchar(16) DEFAULT NULL,
  `RG` varchar(12) DEFAULT NULL,
  `Telefone` varchar(15) DEFAULT NULL,
  `Celular` varchar(15) DEFAULT NULL,
  `Email` varchar(70) NOT NULL,
  `obs` varchar(150) DEFAULT NULL,
  `Disable` bit(1) NOT NULL DEFAULT b'0',
  `CodCliente` int(8) NOT NULL,
  `UF` varchar(2),
  `Cidade` varchar(50),
  `CEP` varchar(15),
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itensvenda`
--

DROP TABLE IF EXISTS `itensvenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itensvenda` (
  `idVenda` int(8) NOT NULL,
  `idProduto` int(8) NOT NULL,
  `Quantidade` int(8) NOT NULL,
  `Valor` float NOT NULL,
  PRIMARY KEY (`idVenda`,`idProduto`),
  KEY `ProdutoItensVenda_idx` (`idProduto`),
  CONSTRAINT `ProdutoItensVenda` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `VendaItemVenda` FOREIGN KEY (`idVenda`) REFERENCES `vendas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itensvenda`
--

LOCK TABLES `itensvenda` WRITE;
/*!40000 ALTER TABLE `itensvenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `itensvenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `Codigo` int(8) NOT NULL,
  `Nome` varchar(250) NOT NULL,
  `Quantidade` int(8) DEFAULT NULL,
  `Tipo` varchar(30) DEFAULT NULL,
  `Plataforma` varchar(30) DEFAULT NULL,
  `Preco` float DEFAULT NULL,
  `Fornecedor` varchar(50) DEFAULT NULL,
  `Descricao` varchar(200) DEFAULT NULL,
  `DataCadastro` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1052 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1001,9900,'007: Blood Stone',10,'Jogo','PC',100,'Activision','',NULL),(1002,9901,'007 Legends',10,'Jogo','PC',155,'Activision','',NULL),(1003,9902,'007: Quantum of Solace',10,'Jogo','PC',120.5,'Activision','',NULL),(1004,9903,'11Eyes: CrossOver',10,'Jogo','PC',100,'5pb.','',NULL),(1005,9904,'2006 FIFA World Cup',10,'Jogo','PC',50,'EA Sports','',NULL),(1006,9905,'2010 FIFA World Cup South Africa',10,'Jogo','PC',54,'EA Sports','',NULL),(1007,9906,'2014 FIFA World Cup Brazil',10,'Jogo','PC',99,'EA Sports','',NULL),(1008,9907,'50 Cent: Blood on the Sand',10,'Jogo','PC',100,'THQ','',NULL),(1009,9908,'A-Train HX',10,'Jogo','PC',125,'Artdink','',NULL),(1010,9909,'Absolute: Blazing Infinity',10,'Jogo','PC',135.25,'Idea Factory','',NULL),(1011,9910,'AC/DC Live: Rock Band Track Pack',10,'Jogo','PC',100,'MTV Games','',NULL),(1012,9911,'Ace Combat 6: Fires of Liberation',10,'Jogo','PC',100,'Namco Bandai','',NULL),(1013,9912,'Ace Combat: Assault Horizon',10,'Jogo','PC',100,'Namco Bandai','',NULL),(1014,9913,'Hesaw',10,'Jogo','Playstation 4',100,'Namco Bandai','',NULL),(1015,9914,'3D Realms┬á/┬áInterceptor Entertainment',10,'Jogo','Playstation 4',100,'Namco Bandai','',NULL),(1016,9915,'Spiders',10,'Jogo','Playstation 4',100,'Idea Factory','',NULL),(1017,9916,'Free Lives Games',10,'Jogo','Playstation 4',100,'Idea Factory','',NULL),(1018,9917,'Frogwares',10,'Jogo','Playstation 4',100,'EA Sports','',NULL),(1019,9918,'Sledgehammer Games',10,'Jogo','Playstation 4',100,'EA Sports','',NULL),(1020,9919,'Infinity Ward',10,'Jogo','Playstation 4',100,'EA Sports','',NULL),(1021,9920,'Treyarch',10,'Jogo','Playstation 4',100,'Ubisoft','',NULL),(1022,9921,'Stainless Games',10,'Jogo','Playstation 4',100,'Ubisoft','',NULL),(1023,9922,'Zen Studios',10,'Jogo','Playstation 4',100,'Ubisoft','',NULL),(1024,9923,'Finish Line Games',10,'Jogo','Playstation 4',100,'por anunciar','',NULL),(1025,9924,'Frima Studio',10,'Jogo','Playstation 4',100,'2014','',NULL),(1026,9925,'Discord Games, Inc.',10,'Jogo','Playstation 4',100,'2014','',NULL),(1027,9926,'Ubisoft Montreal',10,'Jogo','Playstation 4',100,'2014','',NULL),(1028,9927,'Behold Studios',10,'Jogo','Playstation 4',100,'por anunciar','',NULL),(1029,9928,'CrashGem',10,'Jogo','Playstation 4',100,'por anunciar','',NULL),(1030,9929,'Atlus',10,'Jogo','Playstation 4',100,'2014','',NULL),(1031,9930,'Compulsion Games',10,'Jogo','Playstation 4',100,'2014','',NULL),(1032,9931,'Zeboyd Games',10,'Jogo','Playstation 4',100,'por anunciar','',NULL),(1033,9932,'Double Fine Productions',10,'Jogo','Playstation 4',100,'por anunciar','',NULL),(1034,9933,'Dynamighty',10,'Jogo','Playstation 4',100,'2014','',NULL),(1035,9934,'Vicarious Visions',10,'Jogo','Playstation 4',100,'2017','',NULL),(1036,9935,'Nichibutsu',10,'Jogo','Playstation 4',100,'2014','',NULL),(1037,9936,'Zomboko Entertainment',10,'Jogo','Playstation 4',100,'por anunciar','',NULL),(1038,9937,'CD Projekt RED',10,'Jogo','Playstation 4',100,'2015','',NULL),(1039,9938,'Zombie Studios',10,'Jogo','Playstation 4',100,'2014','',NULL),(1040,9939,'Bohemia Interactive',10,'Jogo','Playstation 4',100,'por anunciar','',NULL),(1041,9940,'Behaviour Interactive',10,'Jogo','Playstation 4',100,'2017','',NULL),(1042,9941,'Yager Development',10,'Jogo','Playstation 4',100,'por anunciar','',NULL),(1043,9942,'Housemarque',10,'Jogo','Playstation 4',100,'por anunciar','',NULL),(1044,9943,'Tecmo Koei',10,'Jogo','Playstation 4',100,'por anunciar','',NULL),(1045,9944,'Hidden Path Entertainment',10,'Jogo','Playstation 4',100,'por anunciar','',NULL),(1046,9945,'Controle x-box one S/F',5,'Perif├®rico',NULL,120,'Microsoft',NULL,NULL),(1047,9946,'Caneca Marvel Heroes',50,'Itens diversos',NULL,35,'Canecas Legal',NULL,NULL),(1048,9947,'Controle PS4 ',15,'Itens Diversos',NULL,130,'PS Store',NULL,'2017-12-06 18:40:08'),(1049,19952,'FIFA 18',10,'Jogo','Xbox One',125.4,'EA Sports','','2017-12-08 12:34:12'),(1050,19953,'Metro Redux Bundle',5,'Jogo','Xbox One',59,'Deep Silver','','2017-12-08 13:20:08'),(1051,19954,'STAR WARSÔäó BattlefrontÔäó II',10,'Jogo','Xbox One',135.85,'EA Games','','2017-12-08 13:23:19');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendas`
--

DROP TABLE IF EXISTS `vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendas` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `idCliente` int(8) NOT NULL,
  `Data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ValorTotal` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ClienteVenda_idx` (`idCliente`),
  CONSTRAINT `ClienteVenda` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendas`
--

LOCK TABLES `vendas` WRITE;
/*!40000 ALTER TABLE `vendas` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-08 22:19:49
