/*
SQLyog Community v8.71 
MySQL - 5.7.21-log : Database - gestionale_sportivo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gestionale_sportivo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `gestionale_sportivo`;

/*Table structure for table `biglietto` */

DROP TABLE IF EXISTS `biglietto`;

CREATE TABLE `biglietto` (
  `seriale_biglietto` char(45) NOT NULL,
  `id_cliente` int(11) unsigned NOT NULL,
  `id_partecipazione` int(10) unsigned NOT NULL,
  `id_sconto` int(10) unsigned DEFAULT NULL,
  `id_stato_biglietto` int(10) unsigned NOT NULL,
  PRIMARY KEY (`seriale_biglietto`),
  UNIQUE KEY `idx_biglietto_id_cliente` (`id_cliente`),
  KEY `id_partecipazione_idx` (`id_partecipazione`),
  KEY `id_sconto_idx` (`id_sconto`),
  KEY `id_stato_biglietto_idx` (`id_stato_biglietto`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `fk_biglietto_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_partecipazione_on_biglietto` FOREIGN KEY (`id_partecipazione`) REFERENCES `partecipazione` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sconto_on_biglietto` FOREIGN KEY (`id_sconto`) REFERENCES `sconto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_stato_biglietto_on_biglietto` FOREIGN KEY (`id_stato_biglietto`) REFERENCES `stato_biglietto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `biglietto` */

insert  into `biglietto`(`seriale_biglietto`,`id_cliente`,`id_partecipazione`,`id_sconto`,`id_stato_biglietto`) values ('ffff',4,3,1,2);

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `data_nascita` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `cliente` */

insert  into `cliente`(`id`,`nome`,`cognome`,`data_nascita`) values (4,'ronny','guzman','1996-12-17'),(5,'Maria','zambrano','1976-05-08'),(7,'Maria','zambrano','3876-06-08'),(8,'Rodry','Espinoza','1977-04-08'),(13,'Mariana','villegas','1977-04-08'),(14,'Elisa ','Segura','1977-04-08'),(16,'Elisa ','Segura','1977-04-08'),(17,'melissa','raul','2018-02-27'),(18,'melissa','guzman','2018-02-27'),(19,'melissa','guzman','2018-02-27'),(20,'ronny','raul','2018-02-27'),(21,'ronny','raul','2018-02-27'),(22,'melissa','weffew','2018-02-27'),(23,'ronny','weffew','2018-02-27'),(24,'ronny','weffew','2018-02-27'),(25,'ronny','zambrano','2018-02-27'),(26,'sndkjis','dfjkoejn','2015-03-15');

/*Table structure for table `partecipazione` */

DROP TABLE IF EXISTS `partecipazione`;

CREATE TABLE `partecipazione` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `stato` tinyint(4) DEFAULT NULL,
  `id_cliente` int(10) unsigned NOT NULL,
  `id_partita` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente_idx` (`id_cliente`),
  KEY `id_partita_idx` (`id_partita`),
  CONSTRAINT `fk_cliente_on_partecipazione` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_partita_on_partecipazione` FOREIGN KEY (`id_partita`) REFERENCES `partita` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `partecipazione` */

insert  into `partecipazione`(`id`,`stato`,`id_cliente`,`id_partita`) values (3,0,5,3);

/*Table structure for table `partita` */

DROP TABLE IF EXISTS `partita`;

CREATE TABLE `partita` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `data_partita` datetime DEFAULT NULL,
  `goal_sq_home` int(11) DEFAULT NULL,
  `goal_sq_visitor` int(11) DEFAULT NULL,
  `id_sq_home` int(10) unsigned NOT NULL,
  `id_sq_visitor` int(10) unsigned NOT NULL,
  `id_stadio` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_sq_home_idx` (`id_sq_home`),
  KEY `id_sq_visitor_idx` (`id_sq_visitor`),
  KEY `id_stadio_idx` (`id_stadio`),
  CONSTRAINT `fk_sq_home_on_partita` FOREIGN KEY (`id_sq_home`) REFERENCES `squadra` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sq_visitor_on_partita` FOREIGN KEY (`id_sq_visitor`) REFERENCES `squadra` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_stadio_on_partita` FOREIGN KEY (`id_stadio`) REFERENCES `stadio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

/*Data for the table `partita` */

insert  into `partita`(`id`,`data_partita`,`goal_sq_home`,`goal_sq_visitor`,`id_sq_home`,`id_sq_visitor`,`id_stadio`) values (3,'2018-12-12 15:00:00',0,1,1,2,1),(62,'2018-03-14 12:34:00',NULL,NULL,3,29,1),(70,'2018-03-01 12:34:00',NULL,NULL,1,3,7),(71,'2018-05-12 12:34:00',NULL,NULL,45,28,6),(72,'2018-04-05 13:45:00',NULL,NULL,3,2,1),(73,'2018-06-07 13:34:00',NULL,NULL,45,2,1);

/*Table structure for table `sconto` */

DROP TABLE IF EXISTS `sconto`;

CREATE TABLE `sconto` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(45) DEFAULT NULL,
  `perc_scon` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sconto` */

insert  into `sconto`(`id`,`descrizione`,`perc_scon`) values (1,'sconto per studente','20'),(2,'Non è scontato','0');

/*Table structure for table `squadra` */

DROP TABLE IF EXISTS `squadra`;

CREATE TABLE `squadra` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

/*Data for the table `squadra` */

insert  into `squadra`(`id`,`nome`) values (3,'Barcellona'),(89,'Computer'),(45,'emelec'),(25,'fiorentina'),(2,'inter'),(88,'liga'),(1,'milan'),(27,'Nacional'),(29,'Napoli'),(28,'penarol'),(81,'verona');

/*Table structure for table `stadio` */

DROP TABLE IF EXISTS `stadio`;

CREATE TABLE `stadio` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `capienza` int(11) NOT NULL,
  `costo_blg` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `stadio` */

insert  into `stadio`(`id`,`nome`,`capienza`,`costo_blg`) values (1,'san siro',1200,'4'),(6,'olimpico',1200,'5'),(7,'artemio franki',500,'4'),(9,'atahualpa',700,'4');

/*Table structure for table `stato_biglietto` */

DROP TABLE IF EXISTS `stato_biglietto`;

CREATE TABLE `stato_biglietto` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `stato_biglietto` */

insert  into `stato_biglietto`(`id`,`descrizione`) values (2,'biglietto partita');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
