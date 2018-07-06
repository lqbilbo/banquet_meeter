CREATE SCHEMA `easykotlin` DEFAULT CHARACTER SET utf8 ;

/*
 Navicat Premium Data Transfer

 Source Server         : local-db
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost
 Source Database       : easykotlin

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : utf-8

 Date: 07/04/2018 14:02:16 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码的md5串',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `last_login_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次登录时间',
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `place_id` int(11) DEFAULT NULL COMMENT '地点id',
  `sponsor_id` int(11) DEFAULT NULL COMMENT '发起人id',
  `activity_status` int(2) DEFAULT NULL COMMENT '发布状态',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `utime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `activity_person_mapping`
-- ----------------------------
DROP TABLE IF EXISTS `activity_person_mapping`;
CREATE TABLE `activity_person_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_id` bigint(20) DEFAULT NULL COMMENT '活动id',
  `person_id` bigint(20) DEFAULT NULL COMMENT '报名人id',
  `ctime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `hibernate_sequence`
-- ----------------------------
BEGIN;
INSERT INTO `hibernate_sequence` VALUES ('27');
COMMIT;

-- ----------------------------
--  Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `activity_id` int(11) DEFAULT NULL COMMENT '活动id',
  `attender_id` int(11) DEFAULT NULL COMMENT '参与人id',
  `order_status` int(2) DEFAULT NULL COMMENT '订单状态 0 已接单 1 已完成',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  `utime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `label` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标签',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '头像url',
  `certificate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '证件url加密串',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `person`
-- ----------------------------
BEGIN;
INSERT INTO `person` VALUES ('22', '28', 'Jason', 'Male', '2018-06-22 05:15:36', '2018-06-22 05:15:36', 'Chen', 'Top 5 Cities to Visit in Tamil Nadu', 'places/india_thanjavur_market.png', null), ('23', '32', 'Bluce', 'Male', '2018-06-22 05:15:36', '2018-06-22 05:15:36', 'Li', null, null, null), ('24', '20', 'Corey', 'Female', '2018-06-22 05:15:36', '2018-06-22 05:15:36', 'Chen', 'Artisans of Southern India', 'places/india_chettinad_silk_maker.png', null), ('26', '19', 'Benjemin', 'Male', '2018-06-27 06:08:53', '2018-06-27 06:08:53', 'Frank', 'test', 'test2', null), ('27', '21', 'Miacle', 'Male', '2018-07-02 14:13:36', '2018-07-02 14:13:39', 'Chen', 'Batad rice terraces', 'places/india_pondicherry_beach.png', null), ('28', '53', 'Lily', 'Female', '2018-07-02 14:14:48', '2018-07-02 14:14:50', 'Chen', 'Ceresole Reale', 'places/india_chennai_highway.png', null), ('29', '29', 'Lucy', 'Female', '2018-07-02 14:15:19', '2018-07-02 14:15:21', 'Chen', 'Beautiful mountains', 'places/india_tanjore_thanjavur_temple_carvings.png', null), ('30', '33', 'Mike', 'Male', '2018-07-02 14:16:10', '2018-07-02 14:16:12', 'Chen', 'Beautiful hills', 'places/india_tanjore_market_technology.png', null);
COMMIT;

-- ----------------------------
--  Table structure for `place`
-- ----------------------------
DROP TABLE IF EXISTS `place`;
CREATE TABLE `place` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `poi_id` int(11) NOT NULL COMMENT '地点id',
  `poi_name` varchar(255) DEFAULT NULL COMMENT '地点名',
  `average_price` decimal(10,0) NOT NULL COMMENT '人均消费',
  `latitude` double(10,0) NOT NULL COMMENT '纬度',
  `longitude` double(10,0) NOT NULL COMMENT '经度',
  `ctime` datetime DEFAULT NULL COMMENT '创建时间',
  `utime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `user_behavior_log`
-- ----------------------------
DROP TABLE IF EXISTS `user_behavior_log`;
CREATE TABLE `user_behavior_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `place_id` int(11) DEFAULT NULL COMMENT '地点id',
  `activity_id` bigint(20) DEFAULT NULL COMMENT '活动id',
  `activity_time` datetime DEFAULT NULL COMMENT '活动时间',
  `ctime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
