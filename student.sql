/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : fresh

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-11-02 11:50:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '专业',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '朱云', '江西', '2020-11-20', '计算机');
INSERT INTO `category` VALUES ('2', '彭小莲', '云南', '2020-11-20', '会计');
INSERT INTO `category` VALUES ('3', '花生米', '海南', '2020-11-24', '计算机');
INSERT INTO `category` VALUES ('4', '向小北', '向北', '2020-11-26', '商务');
INSERT INTO `category` VALUES ('5', '吴迪', '云南', '2020-11-11', '电竞');
INSERT INTO `category` VALUES ('6', '江波', '大理', '2020-11-26', '会计');
INSERT INTO `category` VALUES ('7', '徐天', '湖南', '2020-11-26', '商务');
INSERT INTO `category` VALUES ('8', '张浩', '北京', '2020-10-26', '旅游');
INSERT INTO `category` VALUES ('9', '黄诗佳', '上海', '2020-09-26', '计算机');
INSERT INTO `category` VALUES ('10', '马洪', '杭州', '2020-08-26', '计算机');
INSERT INTO `category` VALUES ('11', '谭琳', '南京', '2020-10-26', '旅游');
INSERT INTO `category` VALUES ('12', '胡红梅', '宜春', '2020-04-26', '商务');
INSERT INTO `category` VALUES ('13', '饶亮', '萍乡', '2020-11-26', '会计');
INSERT INTO `category` VALUES ('14', '悟空', '南昌', '2020-10-26', '信息管理');
INSERT INTO `category` VALUES ('15', '马赫', '黄冈', '2020-11-26', '电子');
INSERT INTO `category` VALUES ('16', '黄睿', '北京', '2020-06-24', '环境科学');
INSERT INTO `category` VALUES ('17', '霞霞', '上海', '2020-07-15', '数学');
INSERT INTO `category` VALUES ('18', '黄胜米', '杭州', '2020-07-15', '电子');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  ` id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `emails` varchar(255) DEFAULT NULL,
  PRIMARY KEY (` id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', 'qq@qqq.com');
INSERT INTO `user` VALUES ('2', 'koko', '123456', '1597444@qq.com');
