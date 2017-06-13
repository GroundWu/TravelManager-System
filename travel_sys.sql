/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : travel_sys

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-06-13 13:25:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cars`
-- ----------------------------
DROP TABLE IF EXISTS `cars`;
CREATE TABLE `cars` (
  `location` varchar(255) CHARACTER SET utf8 NOT NULL,
  `price` int(11) NOT NULL,
  `numCars` int(11) NOT NULL,
  `numAvail` int(11) NOT NULL,
  PRIMARY KEY (`location`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cars
-- ----------------------------
INSERT INTO `cars` VALUES ('aa', '13', '12', '10');

-- ----------------------------
-- Table structure for `customers`
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `custName` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`custName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES ('');
INSERT INTO `customers` VALUES ('a');
INSERT INTO `customers` VALUES ('aaa');
INSERT INTO `customers` VALUES ('aaad');
INSERT INTO `customers` VALUES ('dfs');
INSERT INTO `customers` VALUES ('qwe');

-- ----------------------------
-- Table structure for `flights`
-- ----------------------------
DROP TABLE IF EXISTS `flights`;
CREATE TABLE `flights` (
  `flightNum` varchar(256) NOT NULL COMMENT '航班',
  `price` int(10) NOT NULL,
  `numSeats` int(255) NOT NULL,
  `numAvail` int(100) NOT NULL,
  `FromCity` varchar(256) NOT NULL,
  `AvrivCity` varchar(256) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`flightNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of flights
-- ----------------------------
INSERT INTO `flights` VALUES ('001', '22', '7', '3', '4a', '9f');
INSERT INTO `flights` VALUES ('002', '2', '2', '2', '2f', '1a');
INSERT INTO `flights` VALUES ('003', '300', '200', '199', '3f', '4a');
INSERT INTO `flights` VALUES ('A', '12', '123', '119', 'frome', 'arr');
INSERT INTO `flights` VALUES ('as', '12', '123', '123', '12f', '12a');
INSERT INTO `flights` VALUES ('sdfas', '123', '123', '123', '432f', '123a');

-- ----------------------------
-- Table structure for `hotels`
-- ----------------------------
DROP TABLE IF EXISTS `hotels`;
CREATE TABLE `hotels` (
  `location` varchar(255) CHARACTER SET utf8 NOT NULL,
  `price` int(11) NOT NULL,
  `numRooms` int(11) NOT NULL,
  `numAvail` int(11) NOT NULL COMMENT '宾馆房间',
  PRIMARY KEY (`location`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hotels
-- ----------------------------
INSERT INTO `hotels` VALUES ('a', '123', '12', '7');

-- ----------------------------
-- Table structure for `reservations`
-- ----------------------------
DROP TABLE IF EXISTS `reservations`;
CREATE TABLE `reservations` (
  `custName` varchar(255) CHARACTER SET utf8 NOT NULL,
  `resvType` int(11) NOT NULL,
  `resvKey` int(11) NOT NULL AUTO_INCREMENT,
  `detail` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`resvKey`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of reservations
-- ----------------------------
INSERT INTO `reservations` VALUES ('a', '1', '3', '001');
INSERT INTO `reservations` VALUES ('a', '1', '4', '002');
INSERT INTO `reservations` VALUES ('b', '2', '5', 'a');
INSERT INTO `reservations` VALUES ('b', '3', '6', 'aa');
INSERT INTO `reservations` VALUES ('a', '1', '7', '003');
INSERT INTO `reservations` VALUES ('b', '1', '8', '001');
INSERT INTO `reservations` VALUES ('aaad', '1', '9', '001');
INSERT INTO `reservations` VALUES ('qwe', '3', '10', 'aa');
INSERT INTO `reservations` VALUES ('aaad', '2', '11', 'a');
INSERT INTO `reservations` VALUES ('a', '1', '12', 'A');
INSERT INTO `reservations` VALUES ('a', '1', '13', 'A');
INSERT INTO `reservations` VALUES ('a', '1', '14', 'A');
INSERT INTO `reservations` VALUES ('a', '1', '15', 'A');
INSERT INTO `reservations` VALUES ('a', '2', '16', 'a');
INSERT INTO `reservations` VALUES ('a', '1', '17', '001');
INSERT INTO `reservations` VALUES ('a', '1', '18', '001');
INSERT INTO `reservations` VALUES ('a', '1', '19', '001');
