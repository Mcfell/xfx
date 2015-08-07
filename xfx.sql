/*
SQLyog v10.2 
MySQL - 5.6.21-log : Database - xfx
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xfx` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `xfx`;

/*Table structure for table `complain` */

DROP TABLE IF EXISTS `complain`;

CREATE TABLE `complain` (
  `SID` varchar(32) DEFAULT NULL,
  `TID` varchar(32) DEFAULT NULL,
  `CID` varchar(32) DEFAULT NULL,
  `COM_CONTENT` text,
  `COM_TIME` datetime DEFAULT NULL,
  `ANS_CONTENT` text,
  `ANS_NAME` varchar(32) DEFAULT NULL,
  `ANS_TIME` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `complain` */

/*Table structure for table `curriculums` */

DROP TABLE IF EXISTS `curriculums`;

CREATE TABLE `curriculums` (
  `CID` varchar(32) DEFAULT NULL,
  `GRADE` varchar(32) DEFAULT NULL,
  `COURSE` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `curriculums` */

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `O_NUMBER` varchar(32) NOT NULL,
  `OID` varchar(32) DEFAULT NULL,
  `AMOUNT` float DEFAULT NULL,
  `STATE` varchar(32) DEFAULT NULL,
  `OPER_TIME` datetime DEFAULT NULL,
  `START_TIME` datetime DEFAULT NULL,
  `OVER_TIME` datetime DEFAULT NULL,
  `NOW_NUMS` int(11) DEFAULT NULL,
  `ALL_NUMS` int(11) DEFAULT NULL,
  `BEST_NUMS` int(11) DEFAULT NULL,
  `BETTER_NUMS` int(11) DEFAULT NULL,
  `NORMAL_NUMS` int(11) DEFAULT NULL,
  `BAD_NUMS` int(11) DEFAULT NULL,
  PRIMARY KEY (`O_NUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

/*Table structure for table `postgraduate_culums` */

DROP TABLE IF EXISTS `postgraduate_culums`;

CREATE TABLE `postgraduate_culums` (
  `PARENTID` varchar(32) DEFAULT NULL,
  `SELFID` varchar(32) DEFAULT NULL,
  `CONTENT` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `postgraduate_culums` */

/*Table structure for table `stco` */

DROP TABLE IF EXISTS `stco`;

CREATE TABLE `stco` (
  `O_NUMBER` varchar(32) DEFAULT NULL,
  `SID` varchar(32) DEFAULT NULL,
  `TID` varchar(32) DEFAULT NULL,
  `CID` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stco` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `SID` varchar(32) NOT NULL,
  `USERNAME` varchar(64) DEFAULT NULL,
  `PASSWORD` varchar(32) DEFAULT NULL,
  `EMAIL` varchar(64) DEFAULT NULL,
  `TELEPHONE` varchar(20) DEFAULT NULL,
  `PROVINCE` varchar(32) DEFAULT NULL,
  `CITY` varchar(32) DEFAULT NULL,
  `ADDRESS` varchar(128) DEFAULT NULL,
  `GRADE` varchar(32) DEFAULT NULL,
  `PHOTO` varchar(255) DEFAULT NULL,
  `STATE` tinyint(4) DEFAULT NULL,
  `REG_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `TID` varchar(32) NOT NULL,
  `REALNAME` varchar(32) DEFAULT NULL,
  `PASSWORD` varchar(32) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  `TELEPHONE` varchar(20) DEFAULT NULL,
  `PROVINCE` varchar(32) DEFAULT NULL,
  `CITY` varchar(32) DEFAULT NULL,
  `ADDRESS` varchar(64) DEFAULT NULL,
  `STATUS` varchar(32) DEFAULT NULL,
  `LEVEL` tinyint(4) DEFAULT NULL,
  `PROFESSION` varchar(32) DEFAULT NULL,
  `PHOTO1` varchar(64) DEFAULT NULL,
  `PHOTO2` varchar(64) DEFAULT NULL,
  `INTRODUCTION` varchar(255) DEFAULT NULL,
  `DETAILS` text,
  `BEST_NUMS` int(11) DEFAULT NULL,
  `NORMAL_NUMS` int(11) DEFAULT NULL,
  `BAD_NUMS` int(11) DEFAULT NULL,
  `ALL_NUMS` int(11) DEFAULT NULL,
  `BANKACCOUTNT` varchar(64) DEFAULT NULL,
  `DES_BANK` varchar(32) DEFAULT NULL,
  `STATE` tinyint(4) DEFAULT NULL,
  `REG_TIME` datetime DEFAULT NULL,
  `SCHOOL` varchar(32) DEFAULT NULL,
  `THRU_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`TID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`TID`,`REALNAME`,`PASSWORD`,`EMAIL`,`TELEPHONE`,`PROVINCE`,`CITY`,`ADDRESS`,`STATUS`,`LEVEL`,`PROFESSION`,`PHOTO1`,`PHOTO2`,`INTRODUCTION`,`DETAILS`,`BEST_NUMS`,`NORMAL_NUMS`,`BAD_NUMS`,`ALL_NUMS`,`BANKACCOUTNT`,`DES_BANK`,`STATE`,`REG_TIME`,`SCHOOL`,`THRU_TIME`) values ('te-796e7360:14e38f0343d:-8000','admin','admin1','448194192@qq.com','15201316032','北京','北京','北京交通大学学院4号楼',NULL,NULL,'软件工程','http://localhost:8080/xfx/template/images/good/ID2/2.jpg',NULL,'学习改变命运，努力成就人生。由浅入深，循序渐进，言简意赅，快乐教学。','三十多年的实践，构筑了个性化知识体系。广泛的兴趣爱好和个人魅力，形成了独特的教学风格，高中物理已经被我破解成点点滴滴的碎片,给你一根线,就能串连成当空舞的彩练, 跟我学，不会错。助你成功!\r\n',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'北京交通大学',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
