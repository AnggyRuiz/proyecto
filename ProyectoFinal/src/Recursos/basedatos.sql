/*
SQLyog Community v8.71 
MySQL - 5.5.5-10.1.13-MariaDB : Database - proyecto
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`proyecto` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `proyecto`;

/*Table structure for table `estadisticas` */

DROP TABLE IF EXISTS `estadisticas`;

CREATE TABLE `estadisticas` (
  `idEstadisticas` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `Juego_idJuego` int(11) NOT NULL,
  PRIMARY KEY (`idEstadisticas`),
  KEY `fk_Estadisticas_Juego1_idx` (`Juego_idJuego`),
  CONSTRAINT `fk_Estadisticas_Juego1` FOREIGN KEY (`Juego_idJuego`) REFERENCES `juego` (`idJuego`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `estadisticas` */

/*Table structure for table `juego` */

DROP TABLE IF EXISTS `juego`;

CREATE TABLE `juego` (
  `idJuego` int(11) NOT NULL,
  `cantidadParticipantes` int(11) DEFAULT NULL,
  `fecha_Juego` varchar(50) NOT NULL,
  PRIMARY KEY (`idJuego`),
  KEY `fk_Juego_Resumen1_idx` (`fecha_Juego`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `juego` */

insert  into `juego`(`idJuego`,`cantidadParticipantes`,`fecha_Juego`) values (0,2,'2017/11/13'),(1,2,'2017/11/13'),(2,1,'2017/11/13'),(3,4,'2017/11/13'),(4,1,'2017/11/13'),(5,0,'2017/11/13'),(6,1,'2017/11/13'),(7,1,'2017/11/13'),(8,0,'2017/11/13'),(9,1,'2017/11/13'),(10,1,'2017/11/13'),(11,1,'2017/11/13'),(12,1,'2017/11/13'),(13,1,'2017/11/13'),(14,2,'2017/11/13'),(15,1,'2017/11/13'),(16,2,'2017/11/13'),(17,2,'2017/11/13'),(18,2,'2017/11/13'),(19,2,'2017/11/13'),(20,2,'2017/11/13'),(21,2,'2017/11/13'),(22,3,'2017/11/13'),(23,3,'2017/11/13'),(24,2,'2017/11/13'),(25,0,'2017/11/13'),(26,0,'2017/11/13'),(27,1,'2017/11/13'),(28,1,'2017/11/13'),(29,0,'2017/11/13'),(30,1,'2017/11/13'),(31,1,'2017/11/13'),(32,1,'2017/11/13'),(33,0,'2017/11/14'),(34,0,'2017/11/14'),(35,2,'2017/11/14'),(36,2,'2017/11/14'),(37,2,'2017/11/14'),(38,2,'2017/11/14'),(39,3,'2017/11/14'),(40,0,'2017/11/14'),(41,2,'2017/11/14'),(42,3,'2017/11/14'),(43,3,'2017/11/14'),(44,0,'2017/11/14'),(45,0,'2017/11/14'),(46,0,'2017/11/14'),(47,1,'2017/11/14'),(48,2,'2017/11/14'),(49,2,'2017/11/14'),(50,1,'2017/11/14');

/*Table structure for table `partida` */

DROP TABLE IF EXISTS `partida`;

CREATE TABLE `partida` (
  `idPartida` int(11) NOT NULL AUTO_INCREMENT,
  `idResultado` int(11) DEFAULT NULL,
  `pregunta1` varchar(50) DEFAULT NULL,
  `pregunta2` varchar(50) DEFAULT NULL,
  `pregunta3` varchar(50) DEFAULT NULL,
  `pregunta4` varchar(50) DEFAULT NULL,
  `pregunta5` varchar(50) DEFAULT NULL,
  `pregunta6` varchar(50) DEFAULT NULL,
  `pregunta7` varchar(50) DEFAULT NULL,
  `pregunta8` varchar(50) DEFAULT NULL,
  `pregunta9` varchar(50) DEFAULT NULL,
  `pregunta10` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idPartida`),
  KEY `idResultado` (`idResultado`),
  CONSTRAINT `partida_ibfk_1` FOREIGN KEY (`idResultado`) REFERENCES `resultado` (`idResultado`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `partida` */

insert  into `partida`(`idPartida`,`idResultado`,`pregunta1`,`pregunta2`,`pregunta3`,`pregunta4`,`pregunta5`,`pregunta6`,`pregunta7`,`pregunta8`,`pregunta9`,`pregunta10`) values (1,1,'67','62','68','63','69','64','70','65','71','66');

/*Table structure for table `pregunta_juego` */

DROP TABLE IF EXISTS `pregunta_juego`;

CREATE TABLE `pregunta_juego` (
  `idPregunta_juego` int(11) NOT NULL,
  `Juego_idJuego` int(11) NOT NULL,
  `PreguntaMultiple_idTipo` int(11) NOT NULL,
  `PreguntaUnica_idTipo` int(11) NOT NULL,
  PRIMARY KEY (`idPregunta_juego`),
  KEY `fk_Pregunta_juego_Juego1_idx` (`Juego_idJuego`),
  KEY `fk_Pregunta_juego_PreguntaMultiple1_idx` (`PreguntaMultiple_idTipo`),
  KEY `fk_Pregunta_juego_PreguntaUnica1_idx` (`PreguntaUnica_idTipo`),
  CONSTRAINT `fk_Pregunta_juego_Juego1` FOREIGN KEY (`Juego_idJuego`) REFERENCES `juego` (`idJuego`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pregunta_juego_PreguntaMultiple1` FOREIGN KEY (`PreguntaMultiple_idTipo`) REFERENCES `preguntamultiple` (`idpreguntaMultiple`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pregunta_juego_PreguntaUnica1` FOREIGN KEY (`PreguntaUnica_idTipo`) REFERENCES `preguntaunica` (`idPreguntaUnica`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pregunta_juego` */

/*Table structure for table `preguntamultiple` */

DROP TABLE IF EXISTS `preguntamultiple`;

CREATE TABLE `preguntamultiple` (
  `idpreguntaMultiple` int(11) NOT NULL AUTO_INCREMENT,
  `opcion1` varchar(45) DEFAULT NULL,
  `opcion2` varchar(45) DEFAULT NULL,
  `opcion3` varchar(100) DEFAULT NULL,
  `opcion4` varchar(45) DEFAULT NULL,
  `opcionesCorrectas` varchar(45) DEFAULT NULL,
  `enunciado` varchar(45) DEFAULT NULL,
  `Tema_idTema` int(11) NOT NULL,
  `idtipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpreguntaMultiple`),
  KEY `fk_PreguntaMultiple_Tema1_idx` (`Tema_idTema`),
  KEY `FK_preguntamultiple` (`idtipo`),
  CONSTRAINT `FK_preguntamultiple` FOREIGN KEY (`idtipo`) REFERENCES `tipopregunta` (`idTipo`),
  CONSTRAINT `fk_PreguntaMultiple_Tema1` FOREIGN KEY (`Tema_idTema`) REFERENCES `tema` (`idTema`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `preguntamultiple` */

insert  into `preguntamultiple`(`idpreguntaMultiple`,`opcion1`,`opcion2`,`opcion3`,`opcion4`,`opcionesCorrectas`,`enunciado`,`Tema_idTema`,`idtipo`) values (3,'si','no','talvez','depronto','1;2','¿como hacer una conexion con java?',1,2),(4,'si','no','talvez','depronto','1;2','¿Qué es una derivada?',2,2),(5,'si','no','talvez','depronto','1;2','¿¿como se dice abuela?',3,2),(6,'si','no','talvez','depronto','1;2','Quien es mister bin?',4,2),(7,'si','no','talvez','depronto','1;2','como se llama la policia?',4,2),(8,'si','no','talvez','depronto','1;2','como hacer un hijo?',4,2),(9,'si','no','talvez','depronto','1;2','quien es su papá?',4,2),(10,'si','no','talvez','depronto','1;2','quien es su mamá?',4,2),(11,'si','no','talvez','depronto','1;2','quien es su abuela?',4,2),(12,'si','no','talvez','depronto','1;2','quien es su hermana?',4,2),(13,'4','1','3','1+3','1;4','2+2',2,2);

/*Table structure for table `preguntaunica` */

DROP TABLE IF EXISTS `preguntaunica`;

CREATE TABLE `preguntaunica` (
  `idPreguntaUnica` int(11) NOT NULL AUTO_INCREMENT,
  `opcion1` varchar(200) DEFAULT NULL,
  `opcion2` varchar(200) DEFAULT NULL,
  `opcion3` varchar(200) DEFAULT NULL,
  `opcion4` varchar(200) DEFAULT NULL,
  `opcionCorrecta` varchar(45) DEFAULT NULL,
  `enunciado` varchar(45) DEFAULT NULL,
  `Tema_idTema` int(11) NOT NULL,
  `idTipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPreguntaUnica`),
  KEY `fk_PreguntaUnica_Tema1_idx` (`Tema_idTema`),
  KEY `FK_preguntaunica` (`idTipo`),
  CONSTRAINT `FK_preguntaunica` FOREIGN KEY (`idTipo`) REFERENCES `tipopregunta` (`idTipo`),
  CONSTRAINT `fk_PreguntaUnica_Tema1` FOREIGN KEY (`Tema_idTema`) REFERENCES `tema` (`idTema`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `preguntaunica` */

insert  into `preguntaunica`(`idPreguntaUnica`,`opcion1`,`opcion2`,`opcion3`,`opcion4`,`opcionCorrecta`,`enunciado`,`Tema_idTema`,`idTipo`) values (7,'you\'re welcome','you to welcome','thanks you','your thanks','1','si yo te digo gracias como debes de responder',3,1),(8,'Polo Norte','Alaska','El oceano','La antartida','4','¿Cuál es el lugar más frío de la tierra?',4,1),(9,'Magdalena','Nilo','Amazonas','Mar Negro','2','¿Cuál es el río más largo del mundo?',4,1),(10,'Africa','Europa','America','Asia','3','¿En qué continente está Ecuador?',4,1),(11,'Inglaterra','Grecia','Colombia','EEUU','2','¿Dónde originaron los juegos olímpicos?',4,1),(12,'will/were','go/goes','will/wont','was/were','4','¿Cuál es el pasado del verbo to be?',3,1);

/*Table structure for table `respuestamultiple` */

DROP TABLE IF EXISTS `respuestamultiple`;

CREATE TABLE `respuestamultiple` (
  `idRespuesta` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `idPregunta` int(11) DEFAULT NULL,
  `idJuego` int(11) DEFAULT NULL,
  `respuesta` varchar(15) DEFAULT NULL,
  `correcta` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idRespuesta`),
  KEY `idUsuario` (`idUsuario`),
  KEY `idPregunta` (`idPregunta`),
  KEY `idJuego` (`idJuego`),
  CONSTRAINT `respuestamultiple_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`codigo`) ON DELETE CASCADE,
  CONSTRAINT `respuestamultiple_ibfk_2` FOREIGN KEY (`idPregunta`) REFERENCES `preguntamultiple` (`idpreguntaMultiple`) ON DELETE CASCADE,
  CONSTRAINT `respuestamultiple_ibfk_3` FOREIGN KEY (`idJuego`) REFERENCES `juego` (`idJuego`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `respuestamultiple` */

insert  into `respuestamultiple`(`idRespuesta`,`idUsuario`,`idPregunta`,`idJuego`,`respuesta`,`correcta`) values (4,88,13,23,'1;4','1;4'),(6,88,5,23,'2;3;4','1;2'),(7,88,3,23,'2;4','1;2'),(8,88,12,23,'1;2','1;2'),(9,88,5,24,'1;3','1;2'),(10,88,3,24,'1;2','1;2'),(11,88,13,24,'1;2;3','1;4'),(12,88,9,24,'1;2','1;2'),(13,88,11,24,'1;2;4','1;2'),(14,88,10,25,'2;3','1;2'),(15,88,10,27,'2;3','1;2'),(16,88,4,28,'1;2','1;2'),(17,88,12,29,'2;3','1;2'),(18,88,13,32,'2;3','1;4'),(19,88,3,34,'3;4','1;2'),(20,88,7,34,'3;4','1;2'),(21,88,9,37,'','1;2'),(22,88,4,37,'','1;2'),(23,88,8,37,'','1;2'),(24,88,9,38,'3;4','1;2'),(25,88,4,38,'2;3','1;2'),(26,88,5,38,'2;3','1;2'),(27,88,11,39,'3;4','1;2'),(28,88,12,39,'2;3','1;2'),(29,88,5,39,'1;2','1;2'),(30,88,8,40,'1;2','1;2'),(31,88,12,40,'1;2','1;2'),(32,88,11,40,'1;2','1;2'),(33,88,10,40,'1;2','1;2'),(34,88,4,40,'3;4','1;2'),(35,88,11,41,'1;2','1;2'),(36,88,9,41,'1;2','1;2'),(37,88,6,42,'1;2','1;2'),(38,88,12,42,'1;2','1;2'),(39,88,3,42,'3;4','1;2'),(40,88,5,42,'1;2','1;2'),(41,88,9,42,'2;3','1;2'),(42,88,7,43,'1;2','1;2'),(43,88,10,43,'1;2','1;2'),(44,88,5,43,'1;3','1;2'),(45,88,9,43,'3;4','1;2'),(46,88,11,43,'1;3','1;2'),(47,88,9,47,'1;2','1;2'),(48,88,7,47,'1;2','1;2'),(49,88,6,47,'2;3','1;2'),(50,88,12,47,'2;3','1;2'),(51,88,11,47,'1;3','1;2'),(52,88,5,48,'1;2','1;2'),(53,88,11,48,'1;2','1;2'),(54,88,12,48,'1;2','1;2'),(55,88,6,48,'1;2','1;2'),(56,88,3,48,'1;2','1;2'),(57,88,9,49,'1;2','1;2'),(58,88,3,49,'1;2','1;2'),(59,88,13,49,'1;4','1;4'),(60,88,11,49,'1;2','1;2'),(61,88,7,49,'1;2','1;2'),(62,88,10,50,'1;2','1;2'),(63,88,12,50,'1;2','1;2'),(64,88,6,50,'1;2','1;2'),(65,88,3,50,'1;2','1;2'),(66,88,5,50,'3;4','1;2');

/*Table structure for table `respuestaunica` */

DROP TABLE IF EXISTS `respuestaunica`;

CREATE TABLE `respuestaunica` (
  `idRespuesta` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `idPregunta` int(11) DEFAULT NULL,
  `idJuego` int(11) DEFAULT NULL,
  `respuesta` varchar(15) DEFAULT NULL,
  `correcta` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idRespuesta`),
  KEY `idUsuario` (`idUsuario`),
  KEY `idPregunta` (`idPregunta`),
  KEY `idJuego` (`idJuego`),
  CONSTRAINT `respuestaunica_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`codigo`) ON DELETE CASCADE,
  CONSTRAINT `respuestaunica_ibfk_2` FOREIGN KEY (`idPregunta`) REFERENCES `preguntaunica` (`idPreguntaUnica`) ON DELETE CASCADE,
  CONSTRAINT `respuestaunica_ibfk_3` FOREIGN KEY (`idJuego`) REFERENCES `juego` (`idJuego`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `respuestaunica` */

insert  into `respuestaunica`(`idRespuesta`,`idUsuario`,`idPregunta`,`idJuego`,`respuesta`,`correcta`) values (1,88,8,14,'1','4'),(2,88,9,23,'2','2'),(3,88,11,23,'4','2'),(5,88,7,23,'1','1'),(6,88,10,23,'1','3'),(7,88,10,24,'3','3'),(9,88,7,24,'4','1'),(11,88,12,24,'4','4'),(15,88,10,27,'1','3'),(17,88,12,28,'1','4'),(18,88,10,28,'3','3'),(19,88,12,29,'1','4'),(20,88,10,29,'3','3'),(21,88,10,30,'2','3'),(23,88,9,32,'1','2'),(24,88,12,32,'2','4'),(25,88,10,34,'2','3'),(26,88,11,34,'2','2'),(27,88,12,37,'1','4'),(28,88,11,37,'1','2'),(29,88,8,37,'3','4'),(30,88,11,38,'1','2'),(32,88,12,38,'2','4'),(33,88,11,39,'1','2'),(34,88,10,39,'1','3'),(35,88,7,39,'4','1'),(36,88,11,40,'2','2'),(37,88,12,40,'2','4'),(38,88,7,40,'1','1'),(39,88,9,40,'2','2'),(40,88,10,40,'3','3'),(42,88,12,41,'4','4'),(43,88,9,42,'2','2'),(45,88,8,42,'4','4'),(46,88,7,42,'2','1'),(47,88,11,43,'1','2'),(48,88,10,43,'3','3'),(49,88,12,43,'4','4'),(50,88,9,43,'2','2'),(51,88,7,43,'1','1'),(52,88,7,47,'1','1'),(53,88,10,47,'1','3'),(54,88,8,47,'2','4'),(55,88,12,47,'2','4'),(56,88,9,47,'2','2'),(57,88,9,48,'2','2'),(58,88,10,48,'2','3'),(59,88,8,48,'2','4'),(60,88,11,48,'2','2'),(61,88,12,48,'2','4'),(62,88,7,49,'1','1'),(63,88,11,49,'2','2'),(64,88,8,49,'1','4'),(65,88,12,49,'1','4'),(66,88,9,49,'2','2'),(67,88,11,50,'2','2'),(68,88,10,50,'3','3'),(69,88,8,50,'2','4'),(70,88,9,50,'2','2'),(71,88,12,50,'4','4');

/*Table structure for table `resultado` */

DROP TABLE IF EXISTS `resultado`;

CREATE TABLE `resultado` (
  `idResultado` int(11) NOT NULL AUTO_INCREMENT,
  `idJuego` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `campo1` varchar(10) DEFAULT NULL,
  `campo2` varchar(10) DEFAULT NULL,
  `campo3` varchar(10) DEFAULT NULL,
  `campo4` varchar(10) DEFAULT NULL,
  `campo5` varchar(10) DEFAULT NULL,
  `campo6` varchar(10) DEFAULT NULL,
  `campo7` varchar(10) DEFAULT NULL,
  `campo8` varchar(10) DEFAULT NULL,
  `campo9` varchar(10) DEFAULT NULL,
  `campo10` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idResultado`),
  KEY `idJuego` (`idJuego`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `resultado_ibfk_1` FOREIGN KEY (`idJuego`) REFERENCES `juego` (`idJuego`),
  CONSTRAINT `resultado_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `resultado` */

insert  into `resultado`(`idResultado`,`idJuego`,`idUsuario`,`campo1`,`campo2`,`campo3`,`campo4`,`campo5`,`campo6`,`campo7`,`campo8`,`campo9`,`campo10`) values (1,50,88,'si','si','si','si','no','si','si','si','si','no');

/*Table structure for table `resumen` */

DROP TABLE IF EXISTS `resumen`;

CREATE TABLE `resumen` (
  `idResumen` int(11) NOT NULL,
  `pregunta` varchar(45) DEFAULT NULL,
  `respuesta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idResumen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `resumen` */

/*Table structure for table `tema` */

DROP TABLE IF EXISTS `tema`;

CREATE TABLE `tema` (
  `idTema` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTema`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tema` */

insert  into `tema`(`idTema`,`descripcion`) values (1,'Desarrollo'),(2,'Calculo'),(3,'Ingles'),(4,'Cultura General'),(6,'amor');

/*Table structure for table `tipopregunta` */

DROP TABLE IF EXISTS `tipopregunta`;

CREATE TABLE `tipopregunta` (
  `idTipo` int(11) NOT NULL,
  `tipo` varchar(59) DEFAULT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipopregunta` */

insert  into `tipopregunta`(`idTipo`,`tipo`) values (1,'unica'),(2,'multiple');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `nombreUsuario` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `tipoUsuario` varchar(45) NOT NULL,
  `semestre` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `nombreUsuario` (`nombreUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`codigo`,`nombre`,`nombreUsuario`,`password`,`correo`,`telefono`,`tipoUsuario`,`semestre`) values (22,'alde','demar','22','AAAAAA','11111','2','4'),(88,'','88','88','88','88','2','88');

/*Table structure for table `usuario_juego` */

DROP TABLE IF EXISTS `usuario_juego`;

CREATE TABLE `usuario_juego` (
  `idUsuario_juego` int(11) NOT NULL,
  `idProcentaje` int(11) DEFAULT NULL,
  `Juego_idJuego` int(11) NOT NULL,
  `Usuario_codigo` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario_juego`),
  KEY `fk_Usuario_juego_Juego1_idx` (`Juego_idJuego`),
  KEY `fk_Usuario_juego_Usuario1_idx` (`Usuario_codigo`),
  CONSTRAINT `fk_Usuario_juego_Juego1` FOREIGN KEY (`Juego_idJuego`) REFERENCES `juego` (`idJuego`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_juego_Usuario1` FOREIGN KEY (`Usuario_codigo`) REFERENCES `usuario` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `usuario_juego` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
