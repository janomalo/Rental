/*
SQLyog Community v8.71 
MySQL - 5.7.26 : Database - rental
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `categorias` */

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `roles` */

insert  into `roles`(`id`,`nombre`) values (1,'Administrador'),(2,'Usuario');

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
  `fecha_registro` datetime NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `habilitado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_email` (`email`),
  KEY `fk_usuarios_rol` (`rol_id`),
  CONSTRAINT `fk_usuarios_rol` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `usuarios` */

insert  into `usuarios`(`id`,`dni`,`rol_id`,`nombres`,`apellidos`,`telefono`,`email`,`password`,`fecha_registro`,`direccion`,`usuario`,`habilitado`) values (2,'34860732',1,'Ale','Molina','+542944335790','ale@ale.com','2be88ca4242c76e8253ac62474851065032d6833','2019-11-07 00:00:00','casa','alelala',1),(3,'34555222',2,'nonono','Molina1','55555','newemail@gmail.com','2be88ca4242c76e8253ac62474851065032d6833','0000-00-00 00:00:00','primero de mayo','aaaa',0),(6,'31555000',2,'Jorge','ref','154131351','jorge@gmail.com','45645646','0000-00-00 00:00:00','su casa','',0),(17,'124124124',2,'Alejandro','Molina','0192384847575','lala@lalala.com','2be88ca4242c76e8253ac62474851065032d6833','2019-11-27 00:00:00','jojojo 1234','',0),(18,'0192388485',2,'Ale1','bobo','02020202','bobo@gmail.com','c129b324aee662b04eccf68babba85851346dff9','2019-12-07 00:00:00','bobo 1234','bobo_baba',0),(20,'0192388485',2,'Ale1','bobo','02020202','bobo1@gmail.com','c129b324aee662b04eccf68babba85851346dff9','2019-12-07 00:00:00','bobo 1234','bobo_baba',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
