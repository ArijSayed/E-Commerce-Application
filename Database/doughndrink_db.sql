CREATE DATABASE  IF NOT EXISTS `doughndrink` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `doughndrink`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: doughndrink
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `category_id_UNIQUE` (`category_id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `UK46ccwnsi9409t36lurvtyljak` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (2,'drinks'),(1,'food');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_contains_product`
--

DROP TABLE IF EXISTS `order_contains_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_contains_product` (
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quntity` int NOT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `order_contains_product_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `order_contains_product_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_contains_product`
--

LOCK TABLES `order_contains_product` WRITE;
/*!40000 ALTER TABLE `order_contains_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_contains_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `payment_type` varchar(10) DEFAULT NULL,
  `shipping_date` datetime NOT NULL,
  `order_date` datetime NOT NULL,
  `user_id` int DEFAULT NULL,
  `total_price` double NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FKel9kyl84ego2otj2accfd8mr7` (`user_id`),
  CONSTRAINT `FKel9kyl84ego2otj2accfd8mr7` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'cash','2022-05-12 00:00:00','2022-05-12 00:00:00',2,33.95),(2,'visa','2023-02-22 00:00:00','2023-02-22 00:00:00',NULL,20.65),(3,'visa','2023-02-22 00:00:00','2023-02-22 00:00:00',NULL,0),(4,'visa','2023-02-22 00:00:00','2023-02-22 00:00:00',NULL,0),(5,'visa','2023-02-22 00:00:00','2023-02-22 00:00:00',NULL,50.65),(6,'visa','2023-02-22 00:00:00','2023-02-22 00:00:00',NULL,20.65),(7,'visa','2023-02-22 00:00:00','2023-02-22 00:00:00',NULL,50.65),(8,'cash','2023-02-22 00:00:00','2023-02-11 00:00:00',2,45.2),(9,'visa','2023-02-22 00:00:00','2023-02-22 00:00:00',NULL,750.65),(10,'visa','2023-02-22 00:00:00','2023-02-22 00:00:00',NULL,750.65);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `size` varchar(1) NOT NULL,
  `price` float NOT NULL,
  `stock` varchar(15) NOT NULL,
  `description` varchar(500) NOT NULL,
  `image` varchar(250) DEFAULT NULL,
  `sub_category_id` int DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `product_id_UNIQUE` (`product_id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `UKjmivyxk9rmgysrmsqw15lqr5b` (`name`),
  KEY `sub_category_id` (`sub_category_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`sub_category_id`) REFERENCES `sub_category` (`sub_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'pepperoni pizza','M',122,'in','pepperoni pizza','https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F43%2F2023%2F02%2F10%2F240376-homemade-pepperoni-pizza-Beauty-3x4-1.jpg&q=60&c=sc&orient=true&poi=auto&h=512',1),(2,'donut','l',70,'in','donut','https://www.shugarysweets.com/wp-content/uploads/2020/01/baked-chocolate-donuts-recipe.jpg',2),(3,'tea','m',20,'in','tea','https://2u.pw/kJZOlO',3),(4,'coca','l',25,'in','coca','https://media.istockphoto.com/id/499208007/photo/coca-cola-classic-in-a-glass-bottle.jpg?s=612x612&w=0&k=20&c=hQ2ub4bQdSRjPkreJBMHT5lwZdXyyRd4dtf8w0NWVUg=',3),(5,'Chicke Ranch Pizza','m',95,'in','chicken ranch pizza ','https://2u.pw/DCHbcU',1),(6,'cookies','m',10,'in','This is a medium cookie','https://www.justataste.com/wp-content/uploads/2009/09/monster-cookies-recipe.jpg',2),(7,'Hot Chocolate','m',35,'in','Hot Chocolate','https://www.girlgonegourmet.com/wp-content/uploads/2022/09/Hot-Chocolate-12.jpg',3),(8,'Pizza Margherita','m',75,'in','Pizza Margherita','https://2u.pw/tOkBfw',1),(9,'Molten Cake','m',40,'in','Molten Cake','https://cdn.shopify.com/s/files/1/0660/0575/products/E6431E69-0203-4072-957E-55ECC9065F76_1200x1200.jpg?v=1665177739',2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_id_UNIQUE` (`role_id`),
  UNIQUE KEY `UK716hgxp60ym1lifrdgp67xt5k` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_category`
--

DROP TABLE IF EXISTS `sub_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_category` (
  `sub_category_id` int NOT NULL AUTO_INCREMENT,
  `sub_ctg_name` varchar(45) NOT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`sub_category_id`),
  UNIQUE KEY `sub_category_id_UNIQUE` (`sub_category_id`),
  UNIQUE KEY `sub_ctg_name_UNIQUE` (`sub_ctg_name`),
  UNIQUE KEY `UKp0dc8l7ul0mxiik3c3rmwnc8` (`sub_ctg_name`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `sub_category_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_category`
--

LOCK TABLES `sub_category` WRITE;
/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;
INSERT INTO `sub_category` VALUES (1,'main_food',1),(2,'snack',1),(3,'drink',2),(4,'cold_drink',2),(5,'dessert',NULL);
/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(30) NOT NULL,
  `lname` varchar(30) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` varchar(300) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK589idila9li6a4arw1t8ht1gx` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'mina','yousry','minayousry597@gmail.com','012494','ksdfkk','123456',NULL),(2,'sohaila','barakat','sohaila@gmail.com','0222335','dsfkldsjlj','',NULL),(3,'Sohaila','Barakat','sohailaaaaa@gmail.com','928376287','cairo','$2a$10$IZL0jBRlhwIgrzN9vSEL/ulB2ExOk5DFra6CBLndkpyeIS20lUg2q','ROLE_USER'),(4,'Sohaila','Barakat','sohaila23@gmail.com','298439','cairo','$2a$10$IZL0jBRlhwIgrzN9vSEL/ulB2ExOk5DFra6CBLndkpyeIS20lUg2q','ROLE_ADMIN'),(5,'mi','df','mina@yahoo.com','122112','dsd','123456',NULL),(6,'mina','yousry','yousry@yahoo.com','011222111113','mkmkmkmkkm','$2a$10$rH9J9/SmLPabp4V40p6xl.Uh3A92YL1KqST2eHiOLRSg/9XTzupqi','ROLE_USER'),(7,'mins','gggg','magic@yahoo.com','011222122111',',fl,vf,lgb,l','$2a$10$arlCHK3h7/wFq/gBS7FuoOnkd0XiXOU5iW.wD0Eyy/1qNs1r69m2G','ROLE_USER'),(8,'mkmkm','kkkl','youuu@yahoo.com','01111222333','sdfsdfdsfdfs','123456789',NULL),(9,'mni','dfk','miina@yahoo.com','1122112','dkksd','$2a$10$OpJyIaz0AQffk6EQtyrE/uQYop7zvX9cG3PShArKBOhtGSuLSYPDK','ROLE_USER'),(10,'mni','dfk','minaaa@yahoo.com','112212','dkksd','$2a$10$LkQ6qkYEXGfYOfihX2PpJ.F8.8eNzwhaMpqtEMd9fA8hgx.o1i2yC','ROLE_USER'),(11,'dssd','sde','nnnnn@yahoo.com','02184551515','sdf;s;mf;m','123456',NULL),(12,'minaaaa','yousryyy','mmina@yahoo.com','021845551515','sdf;s;mfdm','123456',NULL),(13,'miaaa','youssss','drinkk@yahoo.com','02121345656','fdpsvmfmfdm','$2a$10$FSzGpHGYEwjbvW9.M8XQq.XH6YIf3q/GE1DF0EynxbQcnfznznlfy','ROLE_USER'),(14,'ewrwer','ewrerw','ewrewr@yahoo.com','12548978995','sdfsgsfgger','$2a$10$iYHL7yTnFHAeNNUIuvWg0OuDhmaMP.DvC9lJf/k4Nf6dsUgrjtMTu','ROLE_USER'),(15,'mni','dfk','minaa1@yahoo.com','1122512','dkksd','$2a$10$UE4VLwsT23Ma7PStwwdgvO2Ln7Dd7grfP9zCisYo1oYUoeFnUGDH6','ROLE_USER'),(16,'mni','dfk','minaa21@yahoo.com','11225812','dkksd','$2a$10$aESaIMn5oPptdWRQL7or5OCNSo6kUsEAxRxig8sR63N9J6z8TelKu','ROLE_USER'),(17,'mina','yoooy','minaaaaa@yahoo.com','01225486554','mksfvdmvmfo','$2a$10$xpdKsCAdn4yxN3IHnqoUuOCEkcKHU8A5m3CncV1AnuX35PYYLPxW6','ROLE_USER'),(18,'sdfssd','sdfdsf','dafsssdf@yahoo.com','012234458556','dsoondsnni','$2a$10$PliIQjkNVW1sppHyL4iXIeg5DyDdRl6RtV6xi1CdXYXar66uFlgAe','ROLE_USER'),(19,'sohaila','dfk','sohaila239@gmail.com','11225812876','dkksdcnbdk','$2a$10$KM7uz/Bl.LMM3nxY4gL1x.pA5Hbsnw6P6R/F8FxADmlEvZjHdvq8e','ROLE_ADMIN'),(20,'sohaila','barakat','sohaila2391@gmail.com','938246374683746','834747834778','$10$KM7uz/Bl.LMM3nxY4gL1x.pA5Hbsnw6P6R/F8FxADmlEvZjHdvq8e','ROLE_ADMIN'),(21,'mina','yousry','miiiina@gmail.com','1122255812876','dkksdcnbdk','$2a$10$eWVl24AxiVDNB9aANeOyzOaD/Tn/p.z2/PwN/ZpY8T5ngQMOsOOjW','ROLE_USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_buy_product`
--

DROP TABLE IF EXISTS `user_buy_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_buy_product` (
  `user_id` int NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`product_id`),
  KEY `FKl000hxc66hjy6g7q3j7ab2lpw` (`product_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_buy_product`
--

LOCK TABLES `user_buy_product` WRITE;
/*!40000 ALTER TABLE `user_buy_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_buy_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_controls_product`
--

DROP TABLE IF EXISTS `user_controls_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_controls_product` (
  `user_id` int NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `user_controls_product_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_controls_product_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_controls_product`
--

LOCK TABLES `user_controls_product` WRITE;
/*!40000 ALTER TABLE `user_controls_product` DISABLE KEYS */;
INSERT INTO `user_controls_product` VALUES (2,1),(1,2),(2,3),(1,4);
/*!40000 ALTER TABLE `user_controls_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_has_role`
--

DROP TABLE IF EXISTS `user_has_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_has_role` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_has_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_has_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_has_role`
--

LOCK TABLES `user_has_role` WRITE;
/*!40000 ALTER TABLE `user_has_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_has_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-17 16:49:38
