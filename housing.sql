/*
Navicat MySQL Data Transfer

Source Server         : jeesite
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : housing

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2015-03-08 16:59:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for family_apartment
-- ----------------------------
DROP TABLE IF EXISTS `family_apartment`;
CREATE TABLE `family_apartment` (
  `id` varchar(64) NOT NULL,
  `name` varchar(255) default NULL,
  `addr` varchar(255) default NULL,
  `tel` varchar(20) default NULL,
  `room_count` int(11) default NULL,
  `bath_count` int(11) default NULL,
  `month_rate` float default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for family_member
-- ----------------------------
DROP TABLE IF EXISTS `family_member`;
CREATE TABLE `family_member` (
  `id` varchar(64) NOT NULL,
  `student_id` varchar(64) default NULL,
  `birth_date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for general_apartment
-- ----------------------------
DROP TABLE IF EXISTS `general_apartment`;
CREATE TABLE `general_apartment` (
  `id` varchar(64) NOT NULL,
  `name` varchar(255) default NULL,
  `addr` varchar(255) default NULL,
  `tel` varchar(255) default NULL,
  `room_count` int(11) default NULL,
  `bath_count` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for invoice
-- ----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
  `id` varchar(64) NOT NULL,
  `lease_id` varchar(64) default NULL,
  `pay_date` datetime default NULL,
  `pay_method` varchar(50) default NULL,
  `status` varchar(20) default NULL,
  `penalty` float default NULL,
  `damage_charge` float default NULL,
  `late_fee` float default NULL,
  `total` float(255,0) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for kin_info
-- ----------------------------
DROP TABLE IF EXISTS `kin_info`;
CREATE TABLE `kin_info` (
  `id` varchar(64) NOT NULL,
  `student_id` varchar(64) default NULL,
  `name` varchar(255) default NULL,
  `relationship` varchar(255) default NULL,
  `addr` text,
  `city` varchar(50) default NULL,
  `post_code` varchar(10) default NULL,
  `tel` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for lease
-- ----------------------------
DROP TABLE IF EXISTS `lease`;
CREATE TABLE `lease` (
  `id` varchar(64) NOT NULL,
  `student_id` varchar(64) default NULL,
  `house_id` varchar(64) default NULL,
  `room_id` varchar(64) default NULL,
  `room_num` varchar(50) default NULL,
  `duration` varchar(50) default NULL,
  `enter_date` datetime default NULL,
  `leave_date` datetime default NULL,
  `deposit` varchar(255) default NULL,
  `payment` varchar(50) default NULL,
  `penalty` varchar(50) default NULL,
  `inspect_date` datetime default NULL,
  `parking_id` varchar(64) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for lease_request
-- ----------------------------
DROP TABLE IF EXISTS `lease_request`;
CREATE TABLE `lease_request` (
  `id` varchar(64) NOT NULL,
  `student_id` varchar(64) default NULL,
  `preference1` varchar(50) default NULL,
  `preference2` varchar(50) default NULL,
  `preference3` varchar(50) default NULL,
  `status` varchar(40) default NULL,
  `start_date` datetime default NULL,
  `end_date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for nearby
-- ----------------------------
DROP TABLE IF EXISTS `nearby`;
CREATE TABLE `nearby` (
  `id` varchar(64) NOT NULL,
  `lot_id` varchar(64) NOT NULL,
  `house_id` varchar(64) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for parking_lot
-- ----------------------------
DROP TABLE IF EXISTS `parking_lot`;
CREATE TABLE `parking_lot` (
  `id` varchar(64) NOT NULL,
  `num_parking_spot` int(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for parking_lot
-- ----------------------------
DROP TABLE IF EXISTS `parking_spot`;
CREATE TABLE `parking_spot` (
  `id` varchar(64) NOT NULL,
  `lot_id` varchar(64) NOT NULL,
  `class` varchar(64) ,
  `fee` float default NULL,
  `availablity` varchar(64)  default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for residence_hall
-- ----------------------------
DROP TABLE IF EXISTS `residence_hall`;
CREATE TABLE `residence_hall` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) default NULL,
  `addr` text,
  `tel` varchar(20) default NULL,
  `manager_id` varchar(64) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` varchar(64) NOT NULL,
  `room_number` varchar(50) default NULL,
  `month_rate` float default NULL,
  `house_id` varchar(64) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` varchar(64) NOT NULL,
  `fname` varchar(20) default NULL,
  `lname` varchar(20) default NULL,
  `addr` text,
  `city` varchar(50) default NULL,
  `post_code` varchar(10) default NULL,
  `birth_date` datetime default NULL,
  `gender` varchar(10) default NULL,
  `position` varchar(255) default NULL,
  `work_at` varchar(255) default NULL COMMENT 'housing office or hall',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(64) NOT NULL,
  `fname` varchar(50) default NULL,
  `lname` varchar(50) default NULL,
  `type` varchar(255) default NULL COMMENT 'student type',
  `gender` varchar(10) default NULL,
  `tel` varchar(20) default NULL,
  `alter_tel` varchar(20) default NULL,
  `addr` text,
  `city` varchar(255) default NULL,
  `post_code` varchar(10) default NULL,
  `birth_date` datetime default NULL,
  `category` varchar(255) default NULL,
  `nation` varchar(40) default NULL,
  `smoker` varchar(40) default NULL,
  `need` text COMMENT 'special need',
  `comment` text,
  `status` varchar(10) default NULL,
  `courses` text,
  `approval_id` varchar(64) default NULL,
  `kin_id` varchar(64) default NULL COMMENT 'emergency contact',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for terminate_request
-- ----------------------------
DROP TABLE IF EXISTS `terminate_request`;
CREATE TABLE `terminate_request` (
  `id` varchar(64) NOT NULL,
  `lease_id` varchar(64) default NULL,
  `reason` text,
  `date` datetime default NULL,
  `status` varchar(40) default NULL,
  `inspection_date` datetime default NULL,
  `extra_fee` float(255,0) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` varchar(64) NOT NULL,
  `type` varchar(20) default NULL COMMENT 'serverity',
  `student_id` varchar(64) default NULL,
  `date` datetime default NULL,
  `location` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
