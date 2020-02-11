/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.4.10-MariaDB : Database - rental
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rental` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `rental`;

/*Table structure for table `categorias` */

DROP TABLE IF EXISTS `categorias`;

CREATE TABLE `categorias` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `categorias` */

insert  into `categorias`(`id`,`nombre`,`estado`) values 
(1,'Ski',1),
(2,'Snowboard',1),
(3,'General',1);

/*Table structure for table `lista_productos` */

DROP TABLE IF EXISTS `lista_productos`;

CREATE TABLE `lista_productos` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `reserva_id` int(255) NOT NULL,
  `producto_id` int(255) NOT NULL,
  `cantidad` int(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reserva_id` (`reserva_id`),
  KEY `fk_producto_id` (`producto_id`),
  CONSTRAINT `fk_producto_id` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`),
  CONSTRAINT `fk_reserva_id` FOREIGN KEY (`reserva_id`) REFERENCES `reservas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `lista_productos` */

/*Table structure for table `productos` */

DROP TABLE IF EXISTS `productos`;

CREATE TABLE `productos` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `categoria_id` int(255) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `stock` int(100) NOT NULL,
  `precio` float NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_categoria_id` (`categoria_id`),
  CONSTRAINT `fk_categoria_id` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `productos` */

insert  into `productos`(`id`,`categoria_id`,`nombre`,`descripcion`,`stock`,`precio`,`estado`) values 
(1,3,'Antiparras','Antiparras adulto',1,100,0),
(2,1,'Completo Deportivo Adulto','Equipo completo deportivo para persona adulta',1,700,1),
(3,1,'campera','Talle XL',1,50,1),
(4,2,'botas','stepone',1,100,1),
(5,1,'antiparras','hombre',1,150,1),
(6,1,'tabla sola','155 cm nieve onda',1,400,0),
(7,1,'pantalon','negro',1,50,1),
(8,2,'tabla+fijaciones','niÃ±o',1,600,1),
(9,2,'campera-h-xl-salomon','Talle XL',1,100,1);

/*Table structure for table `reservas` */

DROP TABLE IF EXISTS `reservas`;

CREATE TABLE `reservas` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `temporada_id` int(255) NOT NULL,
  `usuario_id` int(255) NOT NULL,
  `precio` float NOT NULL,
  `fecha_reserva` date NOT NULL,
  `cantidad_dias` int(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_temporada_id` (`temporada_id`),
  KEY `fk_usuario_id` (`usuario_id`),
  CONSTRAINT `fk_temporada_id` FOREIGN KEY (`temporada_id`) REFERENCES `temporadas` (`id`),
  CONSTRAINT `fk_usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `reservas` */

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `roles` */

insert  into `roles`(`id`,`nombre`) values 
(1,'Administrador'),
(2,'Usuario');

/*Table structure for table `temporadas` */

DROP TABLE IF EXISTS `temporadas`;

CREATE TABLE `temporadas` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(300) NOT NULL,
  `fecha_desde` date NOT NULL,
  `fecha_hasta` date NOT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `temporadas` */

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `dni` varchar(50) NOT NULL,
  `rol_id` int(10) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fecha_registro` datetime NOT NULL DEFAULT current_timestamp(),
  `direccion` varchar(255) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `habilitado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_email` (`email`),
  KEY `fk_usuarios_rol` (`rol_id`),
  CONSTRAINT `fk_usuarios_rol` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*Data for the table `usuarios` */

insert  into `usuarios`(`id`,`dni`,`rol_id`,`nombres`,`apellidos`,`telefono`,`email`,`password`,`fecha_registro`,`direccion`,`usuario`,`habilitado`) values 
(2,'34860732',1,'Ale234','Molina','+542944335790','ale@ale.com','aversiseguarda','2019-11-07 00:00:00','casa','alelala',1),
(3,'34555222',2,'nonono','Molina1','55555','newemail@gmail.com','2be88ca4242c76e8253ac62474851065032d6833','0000-00-00 00:00:00','primero de mayo','aaaa',0),
(6,'31555000',2,'Jorge','ref','154131351','jorge@gmail.com','1234','0000-00-00 00:00:00','su casa','Alejandro',0),
(20,'0192834',2,'JorgeL','Reffi','1029384','jor@gmail.com','null','2020-01-29 21:22:01','primerodemayo','jorgell',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
