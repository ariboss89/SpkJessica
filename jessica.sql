﻿# Host: localhost  (Version: 5.5.5-10.4.17-MariaDB)
# Date: 2021-05-07 21:05:59
# Generator: MySQL-Front 5.3  (Build 4.81)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "tb_admin"
#

DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `username` varchar(55) NOT NULL DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "tb_admin"
#

/*!40000 ALTER TABLE `tb_admin` DISABLE KEYS */;
INSERT INTO `tb_admin` VALUES ('ariboss89','123456');
/*!40000 ALTER TABLE `tb_admin` ENABLE KEYS */;

#
# Structure for table "tb_alternatif"
#

DROP TABLE IF EXISTS `tb_alternatif`;
CREATE TABLE `tb_alternatif` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `kontak` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

#
# Data for table "tb_alternatif"
#

/*!40000 ALTER TABLE `tb_alternatif` DISABLE KEYS */;
INSERT INTO `tb_alternatif` VALUES (1,'Ari Ramadhan','Jl. Gudang Minyak No.28','081268643631'),(2,'Brian Montegno','Ganet','0816564321'),(3,'Clarissa Marissa','Batu 10','087876543322'),(5,'M. Fathur Wijayakusumo','Jl. Peralatan Km.7','0852444555'),(7,'Jessica','Pramuka no 23','089765432211');
/*!40000 ALTER TABLE `tb_alternatif` ENABLE KEYS */;

#
# Structure for table "tb_kriteria"
#

DROP TABLE IF EXISTS `tb_kriteria`;
CREATE TABLE `tb_kriteria` (
  `id_kriteria` varchar(11) NOT NULL DEFAULT '',
  `nama_kriteria` varchar(255) DEFAULT NULL,
  `nilai_kriteria` double(3,2) DEFAULT NULL,
  PRIMARY KEY (`id_kriteria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tb_kriteria"
#

INSERT INTO `tb_kriteria` VALUES ('C1','SMART Selling',0.20),('C2','Kinerja Bisnis',0.20),('C3','Pelayanan',0.20),('C4','Penampilan',0.15),('C5','Kepribadian',0.25);

#
# Structure for table "tb_perankingan"
#

DROP TABLE IF EXISTS `tb_perankingan`;
CREATE TABLE `tb_perankingan` (
  `Id` varchar(11) NOT NULL DEFAULT '',
  `alternatif` varchar(255) DEFAULT NULL,
  `c1` double(6,4) DEFAULT NULL,
  `c2` double(6,4) DEFAULT NULL,
  `c3` double(6,4) DEFAULT NULL,
  `c4` double(6,4) DEFAULT NULL,
  `c5` double(6,4) DEFAULT NULL,
  `s` double(6,4) DEFAULT NULL,
  `k` double(6,4) DEFAULT NULL,
  `ket` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "tb_perankingan"
#

/*!40000 ALTER TABLE `tb_perankingan` DISABLE KEYS */;
INSERT INTO `tb_perankingan` VALUES ('R003','Clarissa Marissa',1.0000,1.0000,70.0000,6.0000,81.0000,0.2100,0.7692,'Ranking 4'),('R005','Jessica',1.0000,2.0000,85.0000,7.0000,82.0000,0.2662,0.9751,'Ranking 2'),('R006','Ari Ramadhan',3.0000,1.0000,78.0000,6.0000,82.0000,0.2730,1.0000,'Ranking 1'),('R007','M. Fathur Wijayakusumo',2.0000,1.0000,80.0000,7.0000,81.0000,0.2507,0.9183,'Ranking 3');
/*!40000 ALTER TABLE `tb_perankingan` ENABLE KEYS */;

#
# Structure for table "tb_riwayat"
#

DROP TABLE IF EXISTS `tb_riwayat`;
CREATE TABLE `tb_riwayat` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal` varchar(255) DEFAULT NULL,
  `alternatif` varchar(255) DEFAULT NULL,
  `c1` varchar(255) DEFAULT NULL,
  `c2` varchar(255) DEFAULT NULL,
  `c3` varchar(255) DEFAULT NULL,
  `c4` varchar(255) DEFAULT NULL,
  `c5` varchar(255) DEFAULT NULL,
  `s` varchar(255) DEFAULT NULL,
  `k` varchar(255) DEFAULT NULL,
  `ket` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_riwayat"
#

INSERT INTO `tb_riwayat` VALUES (5,'May-2021','Ari Ramadhan','3.0000','1.0000','78.0000','6.0000','82.0000','0.2730','1.0000','Ranking 1'),(6,'May-2021','Jessica','1.0000','2.0000','85.0000','7.0000','82.0000','0.2662','0.9751','Ranking 2'),(7,'May-2021','M. Fathur Wijayakusumo','2.0000','1.0000','80.0000','7.0000','81.0000','0.2507','0.9183','Ranking 3'),(8,'May-2021','Clarissa Marissa','1.0000','1.0000','70.0000','6.0000','81.0000','0.2100','0.7692','Ranking 4');
