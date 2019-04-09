/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 100138
Source Host           : localhost:3306
Source Database       : atm_v2_2

Target Server Type    : MYSQL
Target Server Version : 100138
File Encoding         : 65001

Date: 2019-04-08 13:37:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `phone` bigint(20) NOT NULL COMMENT '手机号',
  `passwd` varchar(255) NOT NULL COMMENT '登陆密码',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `identity` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `frozen` tinyint(4) NOT NULL DEFAULT '0' COMMENT '冻结计数',
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('13730769211', 'bMeoK5U6', '吴颜祖', '982935199776836303', '0');
INSERT INTO `account` VALUES ('15480158803', 'CUcl__jC/', '刘得华', '628712485428259357', '0');

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `billId` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易单号',
  `selfId` int(11) DEFAULT NULL,
  `cardId` varchar(255) NOT NULL COMMENT '用户账号',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '交易时间',
  `type` tinyint(4) NOT NULL COMMENT '交易类型  0：存款 1：取款  2：转账',
  `changee` decimal(10,2) NOT NULL COMMENT '交易金额',
  `balanceChange` decimal(10,2) NOT NULL COMMENT '账户余额',
  PRIMARY KEY (`billId`) USING BTREE,
  KEY `u_account` (`cardId`) USING BTREE,
  KEY `fk_self` (`selfId`),
  CONSTRAINT `fk_card` FOREIGN KEY (`cardId`) REFERENCES `card` (`cardId`) ON UPDATE CASCADE,
  CONSTRAINT `fk_self` FOREIGN KEY (`selfId`) REFERENCES `bill` (`billId`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('30', null, '1126576788867670', '2019-04-08 13:32:17', '0', '100.00', '100.60');
INSERT INTO `bill` VALUES ('31', null, '1126576788867670', '2019-04-08 13:32:34', '1', '50.30', '50.30');
INSERT INTO `bill` VALUES ('32', null, '1126576788867670', '2019-04-08 13:34:20', '10', '30.00', '20.30');
INSERT INTO `bill` VALUES ('33', '32', '4301374871239444', '2019-04-08 13:34:20', '11', '30.00', '31.00');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `cardId` varchar(255) NOT NULL COMMENT '银行卡号',
  `balance` decimal(8,2) DEFAULT NULL COMMENT '账户余额',
  `pin` int(11) DEFAULT NULL,
  `belong` bigint(20) DEFAULT NULL,
  `loss` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`cardId`) USING BTREE,
  KEY `BankCard` (`cardId`) USING BTREE,
  KEY `BankCard_2` (`cardId`) USING BTREE,
  KEY `bankCard_3` (`cardId`) USING BTREE,
  KEY `fk_account` (`belong`) USING BTREE,
  CONSTRAINT `fk_account` FOREIGN KEY (`belong`) REFERENCES `account` (`phone`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('1126576788867670', '20.30', '725098', '13730769211', '0');
INSERT INTO `card` VALUES ('4301374871239444', '31.00', '633679', '15480158803', '0');
