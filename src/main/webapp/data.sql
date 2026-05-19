-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: ighostel
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `amsamkattam`
--

DROP TABLE IF EXISTS `amsamkattam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `amsamkattam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `a1` varchar(255) DEFAULT NULL,
  `a10` varchar(255) DEFAULT NULL,
  `a11` varchar(255) DEFAULT NULL,
  `a12` varchar(255) DEFAULT NULL,
  `a2` varchar(255) DEFAULT NULL,
  `a3` varchar(255) DEFAULT NULL,
  `a4` varchar(255) DEFAULT NULL,
  `a5` varchar(255) DEFAULT NULL,
  `a6` varchar(255) DEFAULT NULL,
  `a7` varchar(255) DEFAULT NULL,
  `a8` varchar(255) DEFAULT NULL,
  `a9` varchar(255) DEFAULT NULL,
  `personal_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amsamkattam`
--

LOCK TABLES `amsamkattam` WRITE;
/*!40000 ALTER TABLE `amsamkattam` DISABLE KEYS */;
INSERT INTO `amsamkattam` VALUES (1,NULL,NULL,NULL,NULL,'sev',NULL,NULL,NULL,NULL,NULL,NULL,NULL,2),(2,'SEV',NULL,NULL,NULL,NULL,NULL,'LAC',NULL,NULL,NULL,NULL,NULL,3),(3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'SUN',NULL,NULL,'LAC',NULL,4),(4,NULL,NULL,'LAC',NULL,NULL,NULL,NULL,'VIJ',NULL,NULL,NULL,NULL,5),(5,NULL,NULL,NULL,NULL,NULL,'RAGU',NULL,'LAC','CHK',NULL,NULL,NULL,6);
/*!40000 ALTER TABLE `amsamkattam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assigned_plan`
--

DROP TABLE IF EXISTS `assigned_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assigned_plan` (
  `idassigned_plan` int(11) NOT NULL AUTO_INCREMENT,
  `personalid` int(11) DEFAULT NULL,
  `membership_plan_id` int(11) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  `subscripeddate` datetime DEFAULT NULL,
  `updatecount` int(11) DEFAULT NULL,
  PRIMARY KEY (`idassigned_plan`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assigned_plan`
--

LOCK TABLES `assigned_plan` WRITE;
/*!40000 ALTER TABLE `assigned_plan` DISABLE KEYS */;
INSERT INTO `assigned_plan` VALUES (3,3,3,'A','2018-01-25 09:16:11',48);
/*!40000 ALTER TABLE `assigned_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bankdetails`
--

DROP TABLE IF EXISTS `bankdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bankdetails` (
  `bankdetailsid` int(11) NOT NULL AUTO_INCREMENT,
  `accountnumber` varchar(45) DEFAULT NULL,
  `holdername` varchar(45) DEFAULT NULL,
  `branchname` varchar(45) DEFAULT NULL,
  `branchcode` varchar(45) DEFAULT NULL,
  `ifsccode` varchar(45) DEFAULT NULL,
  `status` varchar(5) DEFAULT NULL,
  `bankname` varchar(300) DEFAULT NULL,
  `imagepath` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`bankdetailsid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankdetails`
--

LOCK TABLES `bankdetails` WRITE;
/*!40000 ALTER TABLE `bankdetails` DISABLE KEYS */;
INSERT INTO `bankdetails` VALUES (3,'9797987','Sathees','Madurai','HDFC0909','Hdfc00123','A',NULL,'bank/1516850958802.jpg'),(4,'9879889','Priya','SUR','SBI8908','SBI90789','A',NULL,'bank/1516851156024.png');
/*!40000 ALTER TABLE `bankdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caste`
--

DROP TABLE IF EXISTS `caste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caste` (
  `casteid` int(11) NOT NULL,
  `castename` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`casteid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caste`
--

LOCK TABLES `caste` WRITE;
/*!40000 ALTER TABLE `caste` DISABLE KEYS */;
INSERT INTO `caste` VALUES (1,'Reddiyar','A');
/*!40000 ALTER TABLE `caste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactdetails`
--

DROP TABLE IF EXISTS `contactdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contactdetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addressone` varchar(255) DEFAULT NULL,
  `addresstwo` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `contactno` varchar(255) DEFAULT NULL,
  `mobileno` varchar(255) DEFAULT NULL,
  `personal_id` int(11) NOT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactdetails`
--

LOCK TABLES `contactdetails` WRITE;
/*!40000 ALTER TABLE `contactdetails` DISABLE KEYS */;
INSERT INTO `contactdetails` VALUES (1,'5/102,kalkurichi','Kalkurichi','Madurai','9944953584','9944953584',2,'A'),(2,'Madurai','Madurai','Coimbatore','9944953584','9944953584',3,'A'),(3,'5/102 kalkurichi',NULL,'Madurai','9944953584','9944953584',4,'A'),(4,'83,C-2,S M ILLAM ,A J NAGAR,PALLAPATTI ROAD,THIRUTHANGAL,','83,C-2,S M ILLAM ,A J NAGAR,PALLAPATTI ROAD,THIRUTHANGAL,','VIRUTHUNAGAR','9944953584','4566280424',5,'A'),(5,'Kalkurichi','Kovai','VIRUTHUNAGAR','4566280424','9944953584',6,'A');
/*!40000 ALTER TABLE `contactdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `district`
--

DROP TABLE IF EXISTS `district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `district` (
  `districtid` int(11) NOT NULL AUTO_INCREMENT,
  `districtname` varchar(45) DEFAULT NULL,
  `status` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`districtid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `district`
--

LOCK TABLES `district` WRITE;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
INSERT INTO `district` VALUES (1,NULL,'D'),(2,'Madurai','A');
/*!40000 ALTER TABLE `district` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expetation`
--

DROP TABLE IF EXISTS `expetation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expetation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emailid` varchar(255) DEFAULT NULL,
  `expectation` varchar(255) DEFAULT NULL,
  `personal_id` int(11) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `registeredby` varchar(255) DEFAULT NULL,
  `specialcase` varchar(255) DEFAULT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expetation`
--

LOCK TABLES `expetation` WRITE;
/*!40000 ALTER TABLE `expetation` DISABLE KEYS */;
INSERT INTO `expetation` VALUES (1,'rajamca86@gmail.com','good look',2,'documents/1507740378177.png','Myself','no','A'),(2,'rajamca86@gmail.com','nothing',3,'documents/1509161011584.jpg','Myself','null','A'),(3,'rajamca86@gmail.com','good',4,'documents/1511678335987.jpg','Myself',NULL,'A'),(4,'ramrajaram.sdr@gmail.com','Nalla alagan ponne',5,'documents/1513494889221.jpg','Myself','no','A'),(5,'ramrajaram.sdr@gmail.com','Nothing',6,'documents/1517729752134.JPG','Myself','no','A');
/*!40000 ALTER TABLE `expetation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `familydetails`
--

DROP TABLE IF EXISTS `familydetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `familydetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `assets` varchar(255) DEFAULT NULL,
  `brother` int(11) NOT NULL,
  `fathername` varchar(255) DEFAULT NULL,
  `fatheroccupation` varchar(255) DEFAULT NULL,
  `kulatheivam` varchar(255) DEFAULT NULL,
  `marriedbrothers` int(11) NOT NULL,
  `marriedsister` int(11) NOT NULL,
  `mothername` varchar(255) DEFAULT NULL,
  `motheroccupation` varchar(255) DEFAULT NULL,
  `nativeplace` varchar(255) DEFAULT NULL,
  `personal_id` int(11) NOT NULL,
  `sister` int(11) NOT NULL,
  `status` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familydetails`
--

LOCK TABLES `familydetails` WRITE;
/*!40000 ALTER TABLE `familydetails` DISABLE KEYS */;
INSERT INTO `familydetails` VALUES (1,'5 lakh',2,'Raja','Former','Muni',1,1,'Valli','Former','Kalkurichi',2,2,'A'),(2,'5 lakh',1,'Rama','Former','Muni',1,1,'Sundravalli','Former','Madurai',3,1,'A'),(3,'da',1,'Ramachandran','Former','karuppasamy',1,1,'ad','ad','Kalkurichi',4,1,'A'),(4,'2 acer',1,'Ramachandran','Former','Muniyandi',1,1,'sundravalii','former','VIRUTHUNAGAR',5,1,'A'),(5,'1 acer',1,'Ramachandran','Former','Alagar',1,1,'Sundravalli','Former','VIRUTHUNAGAR',6,1,'A');
/*!40000 ALTER TABLE `familydetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gallery`
--

DROP TABLE IF EXISTS `gallery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gallery` (
  `galleryid` int(11) NOT NULL AUTO_INCREMENT,
  `imagename` varchar(1000) DEFAULT NULL,
  `imagepath` varchar(1000) DEFAULT NULL,
  `personalid` int(11) DEFAULT NULL,
  `status` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`galleryid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gallery`
--

LOCK TABLES `gallery` WRITE;
/*!40000 ALTER TABLE `gallery` DISABLE KEYS */;
INSERT INTO `gallery` VALUES (6,'savetree.png','gallery/1517032800391.png',2,'A');
/*!40000 ALTER TABLE `gallery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horoscopedetails`
--

DROP TABLE IF EXISTS `horoscopedetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horoscopedetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dhishaiiruphu` varchar(255) DEFAULT NULL,
  `document` varchar(255) DEFAULT NULL,
  `lagnam` varchar(255) DEFAULT NULL,
  `personal_id` int(11) NOT NULL,
  `rasi` varchar(255) DEFAULT NULL,
  `star` varchar(255) DEFAULT NULL,
  `year_month_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horoscopedetails`
--

LOCK TABLES `horoscopedetails` WRITE;
/*!40000 ALTER TABLE `horoscopedetails` DISABLE KEYS */;
INSERT INTO `horoscopedetails` VALUES (1,'குரு',NULL,'மேஷம்',2,'விருச்சிகம்','பூசம்','2/3/2'),(2,'குரு',NULL,'மேஷம்',3,'மேஷம்','பரணி','4/8/8'),(3,'குரு',NULL,'மேஷம்',4,'மிதுனம்','அசுவதி','19/5/6'),(4,'குரு',NULL,'மேஷம்',5,'விருச்சிகம்','அசுவதி','2/1/1'),(5,'சுக்கிரன்',NULL,'விருச்சிகம்',6,'விருச்சிகம்','சித்திரை','90/2/23');
/*!40000 ALTER TABLE `horoscopedetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createddate` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `personal_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` char(1) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,NULL,'admin',1,'admin','A','admin'),(2,'2017-10-11 22:16:23','raja123',2,'user','A','raja'),(3,'2017-10-28 08:54:10','admin1',3,'user','A','admin1'),(4,'2017-11-26 12:08:58','raja1',4,'user','A','raja1'),(5,'2017-12-17 12:45:05','ram',5,'user','A','ram'),(6,'2018-02-04 13:05:55','ram123',6,'user','A','ram');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membership_plan`
--

DROP TABLE IF EXISTS `membership_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membership_plan` (
  `planid` int(11) NOT NULL AUTO_INCREMENT,
  `planname` varchar(45) DEFAULT NULL,
  `contacts` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `status` varchar(5) DEFAULT NULL,
  `validitydays` int(11) DEFAULT NULL,
  PRIMARY KEY (`planid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membership_plan`
--

LOCK TABLES `membership_plan` WRITE;
/*!40000 ALTER TABLE `membership_plan` DISABLE KEYS */;
INSERT INTO `membership_plan` VALUES (1,'Gold',30,1500,'D',NULL),(2,'Silver',20,500,'A',NULL),(3,'Gold',50,1000,'A',NULL),(4,'Diamond',85,1500,'A',NULL),(5,'Platinum',100,2000,'A',NULL);
/*!40000 ALTER TABLE `membership_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `complexion` varchar(255) DEFAULT NULL,
  `dateofbirth` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `education_id` int(11) DEFAULT NULL,
  `educationlevel` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `heightcm` varchar(255) DEFAULT NULL,
  `heightft` varchar(255) DEFAULT NULL,
  `marriedstatus` varchar(255) DEFAULT NULL,
  `monthlyincome` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  `registerid` varchar(255) DEFAULT NULL,
  `registerno` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `subcaste_id` int(11) DEFAULT NULL,
  `workingplace` varchar(255) DEFAULT NULL,
  `religion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Raja',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'சிவப்பு','10/03/2017','B.E',2,NULL,'ஆண்','142cm','4ft.8in','திருமணமாகதவர்','25000','Raja','Engineer','MONIC_M2','undefined','D',1,'Madurai','Hindhu'),(3,'சிவப்பு','06/1/2009','B.E',2,'2','ஆண்','152cm','5ft','திருமணமாகதவர்','1000000','Raja','Engineer','MONIC_M3','MO122','A',2,'Madurai','Hindhu'),(4,'கருப்பு','06/05/1986','ME',3,NULL,'ஆண்','165cm','5ft.5in','திருமணமாகதவர்','1000000','Raja','Software','MONIC_M4','MO121','A',1,'Madurai','Hindhu'),(5,'சிவப்பு','02/02/2010','ME',2,NULL,'ஆண்','137cm','4ft.6in','திருமணமாகதவர்','100000','Ramasamy','Software','MONIC_M5','MO123','D',1,'83,C-2,S M ILLAM ,A J NAGAR,PALLAPATTI ROAD,T','Hindhu'),(6,'சிவப்பு','04/05/1990','ME',2,NULL,'ஆண்','185cm','6ft.1in','திருமணமாகதவர்','200000','Ramasamy','Teacher','MONIC_M6','MO125','A',1,'Aruppukottai','Hindhu');
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rkattam`
--

DROP TABLE IF EXISTS `rkattam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rkattam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `personal_id` int(11) NOT NULL,
  `r1` varchar(255) DEFAULT NULL,
  `r10` varchar(255) DEFAULT NULL,
  `r11` varchar(255) DEFAULT NULL,
  `r12` varchar(255) DEFAULT NULL,
  `r2` varchar(255) DEFAULT NULL,
  `r3` varchar(255) DEFAULT NULL,
  `r4` varchar(255) DEFAULT NULL,
  `r5` varchar(255) DEFAULT NULL,
  `r6` varchar(255) DEFAULT NULL,
  `r7` varchar(255) DEFAULT NULL,
  `r8` varchar(255) DEFAULT NULL,
  `r9` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rkattam`
--

LOCK TABLES `rkattam` WRITE;
/*!40000 ALTER TABLE `rkattam` DISABLE KEYS */;
INSERT INTO `rkattam` VALUES (1,2,NULL,NULL,NULL,NULL,'pu',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,3,NULL,NULL,NULL,NULL,'SAT',NULL,NULL,NULL,'KEE',NULL,NULL,NULL),(3,4,NULL,NULL,NULL,NULL,'SU',NULL,NULL,NULL,NULL,'SAT',NULL,NULL),(4,5,NULL,NULL,'KEE',NULL,NULL,'PU',NULL,NULL,NULL,NULL,NULL,NULL),(5,6,NULL,NULL,NULL,NULL,'RAGU',NULL,NULL,'SAT',NULL,NULL,'KEE',NULL);
/*!40000 ALTER TABLE `rkattam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcaste`
--

DROP TABLE IF EXISTS `subcaste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcaste` (
  `subcasteid` int(11) NOT NULL AUTO_INCREMENT,
  `subcastename` varchar(45) DEFAULT NULL,
  `casteid` int(11) DEFAULT NULL,
  `status` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`subcasteid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcaste`
--

LOCK TABLES `subcaste` WRITE;
/*!40000 ALTER TABLE `subcaste` DISABLE KEYS */;
INSERT INTO `subcaste` VALUES (1,'Kanjam',1,'A'),(2,'reddy',1,'A');
/*!40000 ALTER TABLE `subcaste` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viewedhistory`
--

DROP TABLE IF EXISTS `viewedhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viewedhistory` (
  `viewedhistoryid` int(11) NOT NULL AUTO_INCREMENT,
  `viewedmemberid` int(11) DEFAULT NULL,
  `vieweddate` datetime DEFAULT NULL,
  `viewedby` int(11) DEFAULT NULL,
  `status` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`viewedhistoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viewedhistory`
--

LOCK TABLES `viewedhistory` WRITE;
/*!40000 ALTER TABLE `viewedhistory` DISABLE KEYS */;
INSERT INTO `viewedhistory` VALUES (5,3,'2018-02-04 12:52:18',3,'A');
/*!40000 ALTER TABLE `viewedhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ighostel'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-05  9:12:06
