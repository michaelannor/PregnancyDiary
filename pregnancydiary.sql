CREATE DATABASE  IF NOT EXISTS `PregnancyDiary` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `PregnancyDiary`;
-- MySQL dump 10.13  Distrib 5.6.17, for osx10.6 (i386)
--
-- Host: localhost    Database: PregnancyDiary
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `Appointments`
--

DROP TABLE IF EXISTS `Appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Appointments` (
  `appointmentID` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `purpose` varchar(250) NOT NULL,
  `hospital` varchar(100) NOT NULL,
  `doctor` varchar(100) DEFAULT NULL,
  `time` varchar(15) NOT NULL,
  `mother` varchar(100) NOT NULL,
  `month` int(11) NOT NULL,
  PRIMARY KEY (`appointmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Appointments`
--

LOCK TABLES `Appointments` WRITE;
/*!40000 ALTER TABLE `Appointments` DISABLE KEYS */;
INSERT INTO `Appointments` VALUES (1,'2014-12-23','Tonsil Check-up','37 Military Hospital','37 Military Hospital','Morning','araba.wilson',12),(2,'2014-12-23','General Health Check-up','Korle-Bu','Korle-Bu','Morning','araba.wilson',12),(3,'2014-12-31','Pregnancy Test','Dansoman Polyclinic','Dansoman Polyclinic','Afternoon','adjoa.mensah',12),(4,'2014-12-20','General Checkup','Tema General Hospital','Tema General Hospital','Evening','esi.bannerman',12),(5,'2014-12-12','General Checkup','Lister Hospital','Lister Hospital','Afternoon','jemila.baiden',12),(6,'2014-12-25','General Checkup','Lister Hospital','Lister Hospital','Afternoon','ama.baah',12),(7,'2014-01-30','Stomach Ache Follow Up','Komfo Anokye Teaching Hospital','Komfo Anokye Teaching Hospital','Afternoon','araba.wilson',1),(8,'2014-02-20','Dental Appointment','Ridge Hospital','Ridge Hospital','Evening','araba.wilson',2),(9,'2014-04-25','ENT Check Up','Nyaho Clinic','Nyaho Clinic','Afternoon','araba.wilson',4),(10,'2014-10-20','Leg X-Ray Scan','Korle-Bu','Dr. Armah','Afternoon','araba.wilson',10),(11,'2014-11-18','Ear Nose and Throat Checkup','Ashesi Community Clinic','Ashesi Community Clinic','Afternoon','adjoa.mensah',10),(12,'2014-06-08','ENT Checkup','Ashesi Community Clinic','Dr. Abena Amponsah','Evening','araba.wilson',6),(13,'2014-12-19','Check-up','Tema General Hospital','Dr. Antwi','Afternoon','maame.botchway',12),(14,'2014-02-14','ENT Checkup','Lister','Dr. Yaw','Evening','araba.wilson',2),(15,'2014-12-27','Check Up','Korle Bu','Dr. Baah','Morning','dorothy.amoako',12),(46,'2015-10-22','Delivery','Korle-Bu','Dr. Asare','Morning','afua.nyarko',10);
/*!40000 ALTER TABLE `Appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Diary`
--

DROP TABLE IF EXISTS `Diary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Diary` (
  `date` date NOT NULL,
  `weight` double DEFAULT NULL,
  `height` double DEFAULT NULL,
  `bmi` double DEFAULT NULL,
  `bmiExplanation` varchar(45) DEFAULT 'null',
  `babyBump` double DEFAULT NULL,
  `bloodPressure` varchar(45) DEFAULT 'null',
  `generalFeeling` varchar(450) DEFAULT 'null',
  `mother` varchar(130) NOT NULL,
  PRIMARY KEY (`mother`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Diary`
--

LOCK TABLES `Diary` WRITE;
/*!40000 ALTER TABLE `Diary` DISABLE KEYS */;
INSERT INTO `Diary` VALUES ('2014-12-13',67,1.2,46.52777777777778,'Obese',43.45,'23','Fatigued.','afua.nyarko'),('2014-12-11',67.3,1.75,21.975510204081633,'Normal',23.6,'23','I\'m feeling quite well. I felt the baby kick in the afternoon. So excited. Whoop!','ama.baah'),('2014-12-12',23.5,12.3,0.15533082160089892,'Underweight',23,'23','Great. But  a bit nervous about today\'s presentation','araba.wilson'),('2014-12-18',68,1.89,19.03642115282327,'Normal',14.3,'24','Great, slept really well!','araba.wilson'),('2014-12-19',180,2.1,40.816326530612244,'Obese',34.5,'12','Okay','araba.wilson'),('2014-12-11',65,1.78,20.515086478979924,'Normal',23,'24','I\'m feeling a bit heavy today. I think I felt him kick twice in the morning.','esi.bannerman'),('2014-12-04',67.3,1.56,27.654503616042074,'Overweight',23.4,'4','I\'m actually feeling good today. Boo sent me a good morning text. :)','jemila.baiden'),('2014-12-19',23,1.3,13.609467455621301,'Underweight',23.5,'4','Okay. Had a headache in the morning.','maame.botchway');
/*!40000 ALTER TABLE `Diary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Mothers`
--

DROP TABLE IF EXISTS `Mothers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Mothers` (
  `firstName` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `hospital` varchar(45) DEFAULT 'null',
  `doctor` varchar(45) DEFAULT 'null',
  `conceptionDate` date DEFAULT NULL,
  `bloodGroup` varchar(15) DEFAULT 'null',
  `hasHiv` tinyint(1) DEFAULT NULL,
  `hasAsthma` tinyint(1) DEFAULT NULL,
  `gender` char(1) NOT NULL DEFAULT 'F',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Mothers`
--

LOCK TABLES `Mothers` WRITE;
/*!40000 ALTER TABLE `Mothers` DISABLE KEYS */;
INSERT INTO `Mothers` VALUES ('Abena','Okine','1979-02-18','abena.okine','1f2e0146afb6c65f28298cdc8918784c','Tema General Hospital',NULL,NULL,NULL,0,0,'F'),('Adjoa','Mensah','1990-10-14','adjoa.mensah','1f2e0146afb6c65f28298cdc8918784c','Accra Polyclinic','Dr. Maku','2014-06-13','AB',0,1,'F'),('Afua','Nyarko','1984-07-27','afua.nyarko','1f2e0146afb6c65f28298cdc8918784c','Dansoman Polyclinic','Dr. Adjei','2014-12-06','AB',0,1,'F'),('Akosua','Adams','1985-07-19','akosua.adams','1f2e0146afb6c65f28298cdc8918784c','Ho Polyclinic',NULL,NULL,NULL,0,0,'F'),('Ama','Baah','2014-12-18','ama.baah','1f2e0146afb6c65f28298cdc8918784c','Lister Hospital','Dr. Fred Afriyie','2014-12-01','AB',0,0,'F'),('Ama','Boamah','1990-12-22','ama.boamah','1f2e0146afb6c65f28298cdc8918784c','Korle-Bu',NULL,NULL,NULL,0,0,'F'),('Ama','Fowaa','1993-12-16','ama.fowaa','1f2e0146afb6c65f28298cdc8918784c','KATH',NULL,NULL,NULL,0,0,'F'),('Araba','Abayie','1977-12-07','araba.abayie','1f2e0146afb6c65f28298cdc8918784c','KATH',NULL,NULL,NULL,0,0,'F'),('Araba','Wilson','1989-12-15','araba.wilson','1f2e0146afb6c65f28298cdc8918784c','Lister Hospital','Dr. Jemima Mills','2014-05-21','AA',0,0,'F'),('Dorothy','Amoako','1979-12-18','dorothy.amoako','1f2e0146afb6c65f28298cdc8918784c','Tema General Hospital',NULL,NULL,NULL,0,0,'F'),('Dorothy','Jones','1970-08-09','dorothy.jones','1f2e0146afb6c65f28298cdc8918784c','Korle-Bu','Dr. Ampong','2014-12-29','BB',1,1,'F'),('Esi','Bannerman','1993-07-13','esi.bannerman','1f2e0146afb6c65f28298cdc8918784c','Tema General Hospital',NULL,NULL,NULL,0,0,'F'),('Ewuraesi','Ampofo','1991-12-17','ewuraesi.ampofo','1f2e0146afb6c65f28298cdc8918784c','Lister Hospital',NULL,NULL,NULL,0,0,'F'),('Georgina','Bruce','1990-12-21','georgina.bruce','1f2e0146afb6c65f28298cdc8918784c','KATH',NULL,NULL,NULL,0,0,'F'),('Jasmine','Donkor','1995-08-23','jasmine.donkor','1f2e0146afb6c65f28298cdc8918784c','Dansoman Clinic',NULL,NULL,NULL,0,0,'F'),('Jemila','Baiden','1976-12-22','jemila.baiden','1f2e0146afb6c65f28298cdc8918784c','Lister Hospital','Dr. Abdulai','2014-12-01','AB',0,1,'F'),('Jennifer','Bingo','1977-12-14','jennifer.bingo','1f2e0146afb6c65f28298cdc8918784c','Korle-Bu',NULL,NULL,NULL,0,0,'F'),('Lydia','Sarpong','1987-12-14','lydia.sarpong','1f2e0146afb6c65f28298cdc8918784c','Korle Bu',NULL,NULL,NULL,0,0,'F'),('Maame','Botchway','1989-12-13','maame.botchway','1f2e0146afb6c65f28298cdc8918784c','Korle-Bu','Dr. Antwi','2014-03-27','AB',0,0,'F'),('Nura','Alhassan','1970-12-16','nura.alhassan','1f2e0146afb6c65f28298cdc8918784c','Korle-Bu',NULL,NULL,NULL,0,0,'F');
/*!40000 ALTER TABLE `Mothers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-13 20:12:31
