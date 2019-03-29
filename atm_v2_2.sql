/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 100138
Source Host           : localhost:3306
Source Database       : atm_v2_2

Target Server Type    : MYSQL
Target Server Version : 100138
File Encoding         : 65001

Date: 2019-03-29 10:11:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `phone` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户手机号',
  `passwd` varchar(255) NOT NULL COMMENT '登陆密码',
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=13556509411 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('13556509406', 'zhuce');
INSERT INTO `account` VALUES ('13556509407', 'cheshi');
INSERT INTO `account` VALUES ('13556509408', 'cheshi2');
INSERT INTO `account` VALUES ('13556509409', 'cheshi3');
INSERT INTO `account` VALUES ('13556509410', 'test4');

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `billId` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易单号',
  `time` datetime DEFAULT NULL COMMENT '交易时间',
  `type` tinyint(4) NOT NULL COMMENT '交易类型  0：存款 1：取款  2：转账',
  `cardId` bigint(20) NOT NULL COMMENT '用户账号',
  `change` decimal(10,2) NOT NULL COMMENT '交易金额',
  `balanceChange` decimal(10,2) NOT NULL COMMENT '账户余额',
  `transferCardId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`billId`) USING BTREE,
  KEY `u_account` (`cardId`) USING BTREE,
  CONSTRAINT `fk_card` FOREIGN KEY (`cardId`) REFERENCES `card` (`cardId`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bill
-- ----------------------------

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `cardId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '银行卡号',
  `pin` int(9) NOT NULL COMMENT '支付密码',
  `balance` decimal(8,2) NOT NULL COMMENT '账户余额',
  `belong` bigint(20) NOT NULL,
  `isFrozen` tinyint(4) DEFAULT NULL COMMENT '是否被冻结 0：否 1：是',
  `isLoss` tinyint(4) DEFAULT NULL COMMENT '是否挂失  0：否 1：是',
  PRIMARY KEY (`cardId`) USING BTREE,
  KEY `BankCard` (`cardId`) USING BTREE,
  KEY `BankCard_2` (`cardId`) USING BTREE,
  KEY `bankCard_3` (`cardId`) USING BTREE,
  KEY `fk_account` (`belong`) USING BTREE,
  CONSTRAINT `fk_account` FOREIGN KEY (`belong`) REFERENCES `account` (`phone`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1112 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('1024', '1024', '600.00', '13556509406', null, null);
INSERT INTO `card` VALUES ('1111', '1111', '800.00', '13556509406', null, null);
