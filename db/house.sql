/*
Navicat MySQL Data Transfer

Source Server         : jeesite
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : housing

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2015-03-13 03:56:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `id` int(64) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `type` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES ('15', 'test house8', 'generic');
INSERT INTO `house` VALUES ('16', 'test house8', 'generic');
INSERT INTO `house` VALUES ('17', 'test house8', 'generic');
INSERT INTO `house` VALUES ('18', 'test house9', 'generic');
INSERT INTO `house` VALUES ('19', '79798', '808087');
INSERT INTO `house` VALUES ('20', 'werew', 'rewr');
INSERT INTO `house` VALUES ('21', 'testhouse6', 'general apartment');
INSERT INTO `house` VALUES ('22', 'test4', 'family');
