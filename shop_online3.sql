-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema shop_online
--

CREATE DATABASE IF NOT EXISTS shop_online;
USE shop_online;

--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cat_id` int(10) unsigned NOT NULL auto_increment,
  `cat_name` varchar(45) NOT NULL,
  `cat_desc` varchar(200) NOT NULL,
  PRIMARY KEY  (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`cat_id`,`cat_name`,`cat_desc`) VALUES 
 (1,'Mobile','Android Mobile'),
 (2,'Laptop','Hp');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `delivary_cost`
--

DROP TABLE IF EXISTS `delivary_cost`;
CREATE TABLE `delivary_cost` (
  `delivary_id` int(10) unsigned NOT NULL auto_increment,
  `zone_name` varchar(45) NOT NULL,
  `delivary_cost` double NOT NULL,
  PRIMARY KEY  USING BTREE (`delivary_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `delivary_cost`
--

/*!40000 ALTER TABLE `delivary_cost` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivary_cost` ENABLE KEYS */;


--
-- Definition of table `pro_order`
--

DROP TABLE IF EXISTS `pro_order`;
CREATE TABLE `pro_order` (
  `order_id` int(10) unsigned NOT NULL auto_increment,
  `pro_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `order_date` date NOT NULL,
  `order_qty` int(10) unsigned NOT NULL,
  `total_price` double NOT NULL,
  `order_status` varchar(45) NOT NULL default '"N"',
  `delivary_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`order_id`),
  KEY `FK_pro_order_user_id` (`user_id`),
  KEY `FK_pro_order_del_id` (`delivary_id`),
  CONSTRAINT `FK_pro_order_del_id` FOREIGN KEY (`delivary_id`) REFERENCES `delivary_cost` (`delivary_id`),
  CONSTRAINT `FK_pro_order_user_id` FOREIGN KEY (`user_id`) REFERENCES `shop_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pro_order`
--

/*!40000 ALTER TABLE `pro_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `pro_order` ENABLE KEYS */;


--
-- Definition of table `pro_order_details`
--

DROP TABLE IF EXISTS `pro_order_details`;
CREATE TABLE `pro_order_details` (
  `order_details` int(10) unsigned NOT NULL auto_increment,
  `order_id` int(10) unsigned NOT NULL,
  `pro_id` int(10) unsigned NOT NULL,
  `pro_qty` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`order_details`),
  KEY `FK_pro_order_details_order_id` (`order_id`),
  KEY `FK_pro_order_details_pro_id` (`pro_id`),
  CONSTRAINT `FK_pro_order_details_order_id` FOREIGN KEY (`order_id`) REFERENCES `pro_order` (`order_id`),
  CONSTRAINT `FK_pro_order_details_pro_id` FOREIGN KEY (`pro_id`) REFERENCES `product` (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pro_order_details`
--

/*!40000 ALTER TABLE `pro_order_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `pro_order_details` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pro_id` int(10) unsigned NOT NULL auto_increment,
  `sub_cat_id` int(10) unsigned NOT NULL,
  `pro_name` varchar(45) NOT NULL,
  `pro_qty` int(10) unsigned NOT NULL,
  `pro_price` double NOT NULL,
  `pro_url` varchar(45) NOT NULL,
  `pro_desc` varchar(200) NOT NULL,
  PRIMARY KEY  (`pro_id`),
  KEY `FK_product_sub_cat_id` (`sub_cat_id`),
  CONSTRAINT `FK_product_sub_cat_id` FOREIGN KEY (`sub_cat_id`) REFERENCES `sub_category` (`sub_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`pro_id`,`sub_cat_id`,`pro_name`,`pro_qty`,`pro_price`,`pro_url`,`pro_desc`) VALUES 
 (1,1,'j5',1,500,'ahsan.jpg','good'),
 (2,1,'Galaxy Note 7',1,500,'imeges3.png','good'),
 (3,1,'Galaxy Note6',1,550,'Galaxy-S6.png','good'),
 (4,1,'Galaxy S6-2',1,333,'galaxyS6.png','good'),
 (5,3,'pavilon',1,333,'laptopi3.png','good'),
 (6,3,'pavilon',1,333,'laptopi3.png','good');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `shop_user`
--

DROP TABLE IF EXISTS `shop_user`;
CREATE TABLE `shop_user` (
  `user_id` int(10) unsigned NOT NULL auto_increment,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `req_date` date NOT NULL,
  `contact_no` varchar(11) NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`user_id`),
  KEY `FK_shop_use_role_id` (`role_id`),
  CONSTRAINT `FK_shop_use_role_id` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shop_user`
--

/*!40000 ALTER TABLE `shop_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop_user` ENABLE KEYS */;


--
-- Definition of table `sub_category`
--

DROP TABLE IF EXISTS `sub_category`;
CREATE TABLE `sub_category` (
  `sub_cat_id` int(10) unsigned NOT NULL auto_increment,
  `cat_id` int(10) unsigned NOT NULL,
  `sub_cat_name` varchar(45) NOT NULL,
  `sub_cat_desc` varchar(200) NOT NULL,
  PRIMARY KEY  (`sub_cat_id`),
  KEY `FK_sub_category_1` (`cat_id`),
  CONSTRAINT `FK_sub_category_1` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_category`
--

/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;
INSERT INTO `sub_category` (`sub_cat_id`,`cat_id`,`sub_cat_name`,`sub_cat_desc`) VALUES 
 (1,1,'Samsung','A7'),
 (2,1,'Nokia','n5'),
 (3,2,'HP','core I5');
/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `role_id` int(10) unsigned NOT NULL auto_increment,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
