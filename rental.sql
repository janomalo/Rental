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
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_email` (`email`),
  KEY `fk_usuarios_rol` (`rol_id`),
  CONSTRAINT `fk_usuarios_rol` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `usuarios` */

insert  into `usuarios`(`id`,`dni`,`rol_id`,`nombres`,`apellidos`,`telefono`,`email`,`password`,`fecha_registro`,`direccion`) values (2,'34860733',1,'34860730','Molina','+542944335790','ale@ale.com','2be88ca4242c76e8253ac62474851065032d6833','2019-11-07 00:00:00','casa'),(3,'34555222',2,'34555222','Molina1','55555','newemail@gmail.com','2be88ca4242c76e8253ac62474851065032d6833','0000-00-00 00:00:00','primero de mayo'),(6,'31555000',2,'Jorge','ref','154131351','jorge@gmail.com','45645646','0000-00-00 00:00:00','su casa'),(7,'34555222',2,'Ale11','lala','111111','janomalo_moli@hotmail.com','123456789','2019-11-26 00:00:00','lalalala'),(16,'111222333',2,'prueba','prueba','111111','prueba@prueba','880c32165546680789340bcfdfbc921b91cd379a','2019-11-25 00:00:00','prueba 1234'),(17,'123123123',2,'Prueba2','Molina','0192384847575','lala@lalala.com','24c1f4b4103e7017eccfe8baf33202f27fa4c197','2019-11-27 00:00:00','jojojo 1234');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
