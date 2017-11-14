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

insert  into `juego`(`idJuego`,`cantidadParticipantes`,`fecha_Juego`) values (0,2,'2017/11/13'),(1,2,'2017/11/13'),(2,1,'2017/11/13'),(3,4,'2017/11/13'),(4,1,'2017/11/13'),(5,0,'2017/11/13'),(6,1,'2017/11/13'),(7,1,'2017/11/13'),(8,0,'2017/11/13'),(9,1,'2017/11/13'),(10,1,'2017/11/13'),(11,1,'2017/11/13'),(12,1,'2017/11/13'),(13,1,'2017/11/13'),(14,2,'2017/11/13'),(15,1,'2017/11/13'),(16,2,'2017/11/13'),(17,2,'2017/11/13'),(18,2,'2017/11/13'),(19,2,'2017/11/13'),(20,2,'2017/11/13'),(21,2,'2017/11/13'),(22,3,'2017/11/13'),(23,3,'2017/11/13'),(24,2,'2017/11/13');

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
  `opcion1` varchar(45) DEFAULT NULL,
  `opcion2` varchar(45) DEFAULT NULL,
  `opcion3` varchar(100) DEFAULT NULL,
  `opcion4` varchar(45) DEFAULT NULL,
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

insert  into `preguntaunica`(`idPreguntaUnica`,`opcion1`,`opcion2`,`opcion3`,`opcion4`,`opcionCorrecta`,`enunciado`,`Tema_idTema`,`idTipo`) values (3,'chao','adios','Re hola','super hola','1','hola',4,1),(4,'chao','adios','Re hola','super hola','2','hola',4,1),(5,'chao','adios','Re hola','super hola','3','chao',4,1),(6,'chao','adios','Re hola','super hola','4','sisas',4,1),(7,'chao','adios','Re hola','super hola','1','nonas',4,1),(8,'si','mucho','Re mucho','super siiiii','4','alvarito me quiere?',4,1),(9,'si','mucho','Re mucho','super siiiii','2','alvarito no me quiere?',4,1),(10,'si','mucho','Re mucho','super siiiii','3','dani no me quiere?',4,1),(11,'si','mucho','Re mucho','super siiiii','2','el befo no me quiere?',4,1),(12,'si','mucho','Re mucho','super siiiii','4','la gaby no me quiere?',4,1);

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

insert  into `respuestamultiple`(`idRespuesta`,`idUsuario`,`idPregunta`,`idJuego`,`respuesta`,`correcta`) values (4,88,13,23,'1;4','1;4'),(6,88,5,23,'2;3;4','1;2'),(7,88,3,23,'2;4','1;2'),(8,88,12,23,'1;2','1;2'),(9,88,5,24,'1;3','1;2'),(10,88,3,24,'1;2','1;2'),(11,88,13,24,'1;2;3','1;4'),(12,88,9,24,'1;2','1;2'),(13,88,11,24,'1;2;4','1;2');

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

insert  into `respuestaunica`(`idRespuesta`,`idUsuario`,`idPregunta`,`idJuego`,`respuesta`,`correcta`) values (1,88,8,14,'1','4'),(2,88,9,23,'2','2'),(3,88,11,23,'4','2'),(4,88,5,23,'3','3'),(5,88,7,23,'1','1'),(6,88,10,23,'1','3'),(7,88,10,24,'3','3'),(8,88,3,24,'2','1'),(9,88,7,24,'4','1'),(10,88,5,24,'2','3'),(11,88,12,24,'4','4');

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

CREATE TABLE resultado (
idResultado INT AUTO_INCREMENT,
idJuego INT (11),
idUsuario INT (11),
campo1 VARCHAR (10),
campo2 VARCHAR (10),
campo3 VARCHAR (10),
campo4 VARCHAR (10),
campo5 VARCHAR (10),
campo6 VARCHAR (10),
campo7 VARCHAR (10),
campo8 VARCHAR (10),
campo9 VARCHAR (10),
campo10 VARCHAR (10),
PRIMARY KEY (idResultado),
FOREIGN KEY (idJuego) REFERENCES juego (idJuego),
FOREIGN KEY (idUsuario) REFERENCES usuario (codigo)
);

CREATE TABLE partida (
idPartida INT AUTO_INCREMENT,
idResultado INT (11),
pregunta1 VARCHAR (50),
pregunta2 VARCHAR (50),
pregunta3 VARCHAR (50),
pregunta4 VARCHAR (50),
pregunta5 VARCHAR (50),
pregunta6 VARCHAR (50),
pregunta7 VARCHAR (50),
pregunta8 VARCHAR (50),
pregunta9 VARCHAR (50),
pregunta10 VARCHAR (50),
PRIMARY KEY (idPartida),
FOREIGN KEY (idResultado) REFERENCES resultado (idResultado)
);