/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.47 : Database - book
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `book`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `book_category_id` int(11) NOT NULL COMMENT '图书类别编号',
  `book_name` varchar(100) NOT NULL COMMENT '图书名称',
  `book_synopsis` varchar(300) NOT NULL COMMENT '图书简介',
  `book_picture` varchar(300) NOT NULL COMMENT '图书图片',
  `book_price` double(7,2) NOT NULL COMMENT '图书价格',
  `is_usable` tinyint(1) unsigned NOT NULL COMMENT '是否可用 0-否 1-是',
  `cst_create` datetime NOT NULL COMMENT '数据的创建时间',
  `cst_modify` datetime NOT NULL COMMENT '数据的修改时间',
  PRIMARY KEY (`id`),
  KEY `FK_book_user_id` (`user_id`),
  KEY `FK_book_book_category_id` (`book_category_id`),
  CONSTRAINT `FK_book_book_category_id` FOREIGN KEY (`book_category_id`) REFERENCES `book_category` (`id`),
  CONSTRAINT `FK_book_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`user_id`,`book_category_id`,`book_name`,`book_synopsis`,`book_picture`,`book_price`,`is_usable`,`cst_create`,`cst_modify`)
values (1,1,38,'小王子手绘本','图书质量很不错，八成新，很适合小朋友看','1f166afa-32b1-4eb8-93ed-0766e5f9625d.PNG#a9c26b98-a68f-4109-b047-eafbd816ddcc.PNG#20870d97-ac99-42c7-8e6b-8f5cac93a827.PNG#61e2de53-1aca-4d6b-9ab3-1ff91faa38e0.PNG',20.30,1,'2019-04-15 12:07:16','2019-04-15 12:07:42'),(2,1,31,'java编程思想第四版','内容很实用，适合想要深入学习java的人使用，书本七成新','cde61e67-75d4-403d-8c85-42889dcee1eb.PNG#7eb46333-63b0-4612-bb62-11664f683dcf.PNG#17b72c4a-a6df-4b9c-9c98-4bd88862d4d1.PNG',50.88,1,'2019-04-15 12:13:17','2019-04-15 12:22:06'),(3,1,1,'中公国家教师资格证考试用书2019','九成新，不准备考了，试卷基本没做','52277f97-2a78-4138-b446-e00f3287ad32.PNG#a739d50e-2c49-45d7-8304-513968b8665d.PNG',60.32,1,'2019-04-15 12:25:03','2019-04-15 12:25:24'),(4,1,12,'概率论与数理统计教程书','书名:概率论与数理统计教程\n\n作者:茆诗松 等编著\n\n出版社：高等教育出版社\n\n出版日期：2004-07-01\n\nISBN：9787040143652\n\n字数：550000\n\n页码：459\n\n版次：1\n\n装帧：平装','24732f5f-3e6f-4547-b285-577de093c53b.jpg',30.40,1,'2019-04-16 13:37:19','2019-04-16 13:37:19'),(5,1,1,'中公2018教师资格证考试中学','正版书籍八成新笔记不多','7ed37c00-1b6d-4e1d-987a-d58ae2d9be68.jpg#b63b2f65-2523-4732-aa7b-04901be39428.jpg#231d781c-3def-43ec-81e3-c9ab9d2280b9.png',30.40,1,'2019-04-16 14:25:38','2019-04-16 14:25:58');

/*Table structure for table `book_category` */

DROP TABLE IF EXISTS `book_category`;

CREATE TABLE `book_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书类别编号',
  `book_category_name` varchar(50) NOT NULL COMMENT '图书类别名',
  `book_category_father_id` int(11) NOT NULL DEFAULT '0' COMMENT '图书类别父类编号',
  `book_category_level` int(2) NOT NULL DEFAULT '0' COMMENT '图书类别级别',
  `is_usable` tinyint(1) unsigned NOT NULL COMMENT '是否可用 0-否 1-是',
  `cst_create` datetime NOT NULL COMMENT '数据的创建时间',
  `cst_modify` datetime NOT NULL COMMENT '数据的修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `book_category` */

insert  into `book_category`(`id`,`book_category_name`,`book_category_father_id`,`book_category_level`,`is_usable`,`cst_create`,`cst_modify`) values (1,'考试教育',0,0,1,'2019-04-08 21:40:52','2019-04-08 21:40:52'),(2,'经济管理',0,0,1,'2019-04-08 21:40:52','2019-04-08 21:40:52'),(3,'文学艺术',0,0,1,'2019-04-08 21:40:52','2019-04-08 21:40:52'),(4,'人文社科',0,0,1,'2019-04-08 21:40:52','2019-04-08 21:40:52'),(5,'科学技术',0,0,1,'2019-04-08 21:40:52','2019-04-08 21:40:52'),(6,'生活休闲',0,0,1,'2019-04-08 21:40:52','2019-04-08 21:40:52'),(7,'公务员考试',1,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(8,'英语考试',1,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(9,'考研',1,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(10,'其他考试',1,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(11,'职称考试',1,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(12,'教辅书',1,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(13,'工具书',1,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(14,'成功励志',2,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(15,'管理',2,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(16,'经济经融',2,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(17,'收藏鉴赏',3,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(18,'艺术',3,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(19,'文学小说',3,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(20,'文化历史',3,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(21,'新闻传播',4,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(22,'心理',4,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(23,'法律',4,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(24,'自然科学',4,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(25,'社会科学',4,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(26,'政治军事',4,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(27,'宗教哲学',4,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(28,'语言学习',4,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(29,'汽车与交通运输',5,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(30,'医学卫生',5,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(31,'计算机与网络',5,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(32,'科技工程',5,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(33,'建筑',5,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(34,'生活时尚',6,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(35,'家庭育儿',6,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(36,'旅游地理',6,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(37,'体育保健',6,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48'),(38,'少儿',6,1,1,'2019-04-08 21:59:48','2019-04-08 21:59:48');

/*Table structure for table `collection` */

DROP TABLE IF EXISTS `collection`;

CREATE TABLE `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏编号',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `book_id` int(11) NOT NULL COMMENT '图书编号',
  `is_usable` tinyint(1) unsigned NOT NULL COMMENT '是否可用 0-否 1-是',
  `cst_create` datetime NOT NULL COMMENT '数据的创建时间',
  `cst_modify` datetime NOT NULL COMMENT '数据的修改时间',
  PRIMARY KEY (`id`),
  KEY `FK_collection_user_id` (`user_id`),
  KEY `FK_collection_book_id` (`book_id`),
  CONSTRAINT `FK_collection_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FK_collection_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `collection` */

/*Table structure for table `leave_word` */

DROP TABLE IF EXISTS `leave_word`;

CREATE TABLE `leave_word` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '留言编号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户编号',
  `book_id` int(11) DEFAULT NULL COMMENT '图书编号',
  `leave_content` varchar(300) DEFAULT NULL COMMENT '留言内容',
  `leave_father_id` int(11) DEFAULT '0' COMMENT '回复留言编号 -0 直接针对图书评论',
  `is_usable` tinyint(1) unsigned NOT NULL COMMENT '是否可用 0-否 1-是',
  `cst_create` datetime NOT NULL COMMENT '数据的创建时间',
  `cst_modify` datetime NOT NULL COMMENT '数据的修改时间',
  PRIMARY KEY (`id`),
  KEY `FK_leave_word_user_id` (`user_id`),
  KEY `FK_leave_word_book_id` (`book_id`),
  CONSTRAINT `FK_leave_word_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FK_leave_word_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `leave_word` */

/*Table structure for table `order_form` */

DROP TABLE IF EXISTS `order_form`;

CREATE TABLE `order_form` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `book_id` int(11) NOT NULL COMMENT '图书编号',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `receiver_id` int(11) NOT NULL COMMENT '收货地址编号',
  `order_state` int(2) NOT NULL COMMENT '订单状态 -0 发货中 -1 已收货 -2 已取消',
  `order_remark` varchar(300) NOT NULL COMMENT '备注',
  `is_usable` tinyint(1) unsigned NOT NULL COMMENT '是否可用 0-否 1-是',
  `cst_create` datetime NOT NULL COMMENT '数据的创建时间',
  `cst_modify` datetime NOT NULL COMMENT '数据的修改时间',
  PRIMARY KEY (`id`),
  KEY `FK_order_form_user_id` (`user_id`),
  KEY `FK_order_form_book_id` (`book_id`),
  KEY `FK_order_form_receiving_address_id` (`receiver_id`),
  CONSTRAINT `FK_order_form_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  CONSTRAINT `FK_order_form_receiving_address_id` FOREIGN KEY (`receiver_id`) REFERENCES `receiving_address` (`id`),
  CONSTRAINT `FK_order_form_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_form` */

/*Table structure for table `place_transaction` */

DROP TABLE IF EXISTS `place_transaction`;

CREATE TABLE `place_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易地点编号',
  `place_name` varchar(50) NOT NULL COMMENT '交易地点名',
  `place_father_id` int(11) NOT NULL DEFAULT '0' COMMENT '地点父类编号',
  `place_level` int(2) NOT NULL DEFAULT '1' COMMENT '地点级别 -1 园区 -2 楼栋',
  `is_usable` tinyint(1) unsigned NOT NULL COMMENT '是否可用 0-否 1-是',
  `cst_create` datetime NOT NULL COMMENT '数据的创建时间',
  `cst_modify` datetime NOT NULL COMMENT '数据的修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `place_transaction` */

insert  into `place_transaction`(`id`,`place_name`,`place_father_id`,`place_level`,`is_usable`,`cst_create`,`cst_modify`) values (1,'桃园',0,0,1,'2019-04-08 22:14:55','2019-04-08 22:14:55'),(2,'荷园',0,0,1,'2019-04-08 22:14:55','2019-04-08 22:14:55'),(3,'松原',0,0,1,'2019-04-08 22:14:55','2019-04-08 22:14:55'),(4,'明德楼',0,0,1,'2019-04-08 22:14:55','2019-04-08 22:14:55'),(5,'博雅楼',0,0,1,'2019-04-08 22:14:55','2019-04-08 22:14:55'),(6,'弘毅楼',0,0,1,'2019-04-08 22:14:55','2019-04-08 22:14:55'),(7,'综合楼',0,0,1,'2019-04-08 22:14:55','2019-04-08 22:14:55'),(8,'逸夫楼',0,0,1,'2019-04-08 22:14:55','2019-04-08 22:14:55'),(9,'尚美楼',0,0,1,'2019-04-08 22:14:55','2019-04-08 22:14:55'),(10,'体院馆',0,0,1,'2019-04-08 22:14:55','2019-04-08 22:14:55'),(11,'训练馆',0,0,1,'2019-04-08 22:14:55','2019-04-08 22:14:55'),(12,'美术楼',0,0,1,'2019-04-08 22:14:55','2019-04-08 22:14:55'),(13,'桃园一栋',1,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(14,'桃园二栋',1,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(15,'桃园三栋',1,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(16,'桃园四栋',1,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(17,'桃园五栋',1,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(18,'桃园六栋',1,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(19,'桃园七栋',1,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(20,'桃园食堂',1,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(21,'荷园一栋',2,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(22,'荷园二栋',2,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(23,'荷园三栋',2,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(24,'荷园四栋',2,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(25,'荷园五栋',2,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(26,'荷园食堂',2,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(27,'松原一栋',3,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(28,'松原二栋',3,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(29,'松原三栋',3,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(30,'松原四栋',3,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(31,'松原五栋',3,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(32,'松原食堂',3,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(33,'致远楼',7,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(34,'立信楼',7,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(35,'明理楼',7,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(36,'日新楼',7,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31'),(37,'知行楼',7,1,1,'2019-04-08 22:21:31','2019-04-08 22:21:31');

/*Table structure for table `receiving_address` */

DROP TABLE IF EXISTS `receiving_address`;

CREATE TABLE `receiving_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收货地址编号',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `receiver_name` varchar(30) NOT NULL COMMENT '收货人姓名',
  `receiver_tel` varchar(30) NOT NULL COMMENT '手机号码',
  `place_name` varchar(50) NOT NULL COMMENT '交易地点',
  `is_usable` tinyint(1) unsigned NOT NULL COMMENT '是否可用 0-否 1-是',
  `cst_create` datetime NOT NULL COMMENT '数据的创建时间',
  `cst_modify` datetime NOT NULL COMMENT '数据的修改时间',
  PRIMARY KEY (`id`),
  KEY `FK_receiving_address_user_id` (`user_id`),
  CONSTRAINT `FK_receiving_address_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `receiving_address` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(30) NOT NULL COMMENT '用户名',
  `user_stuId` varchar(13) DEFAULT NULL COMMENT '用户学号',
  `user_real_name` varchar(30) DEFAULT NULL COMMENT '用户真实姓名',
  `user_sex` char(2) DEFAULT NULL COMMENT '用户性别',
  `user_birthday` date DEFAULT NULL COMMENT '出生年月',
  `user_pwd` varchar(50) DEFAULT NULL COMMENT '密码',
  `user_tel` varchar(50) NOT NULL COMMENT '电话',
  `user_email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `user_pic` varchar(300) DEFAULT NULL COMMENT '头像',
  `user_role` int(2) DEFAULT '0' COMMENT '用户角色  -0 普通用户 -1 管理员 -2 超级管理员',
  `is_usable` tinyint(1) unsigned NOT NULL COMMENT '是否可用 0-否 1-是',
  `cst_create` datetime NOT NULL COMMENT '数据的创建时间',
  `cst_modify` datetime NOT NULL COMMENT '数据的修改时间',
  `user_stu_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`user_name`,`user_stuId`,`user_real_name`,`user_sex`,`user_birthday`,`user_pwd`,`user_tel`,`user_email`,`user_pic`,`user_role`,`is_usable`,`cst_create`,`cst_modify`,`user_stu_id`) values (1,'张三','201504020101','李四','男','1996-06-11','123456','13745682594','123456789@qq.com','da4befcf-990b-42a8-a4e1-29c8956456f1.jpg',0,1,'2019-04-08 20:30:57','2019-04-08 20:30:57',NULL),(2,'李四',NULL,NULL,'男',NULL,'123456','14567895257','1562543587@qq.com','default.jpg',0,1,'2019-04-08 20:33:57','2019-04-08 20:33:57',NULL),(3,'王五',NULL,NULL,'男',NULL,'123456','12345678925','4544578878@qq.com','default.jpg',0,1,'2019-04-08 20:33:57','2019-04-08 20:33:57',NULL),(4,'柳柳',NULL,NULL,'女',NULL,'123456','18547569875','123542584@qq.com','default.jpg',0,1,'2019-04-08 20:33:57','2019-04-08 20:33:57',NULL),(5,'test',NULL,NULL,'女',NULL,'test','13745682594','123456789@qq.com','default.jpg',0,1,'2019-04-08 20:35:24','2019-04-08 20:35:24',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
