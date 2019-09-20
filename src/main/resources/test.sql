/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : 127.0.0.1:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 20/09/2019 22:14:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` int(5) NOT NULL,
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isbn` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'Java编程思想', 10800, '(美)Bruce Eckel', '9787111213826');
INSERT INTO `book` VALUES (2, 'Java EE互联网轻量级框架整合开发--SSM框架', 11900, '杨开振等', '9787121318474');
INSERT INTO `book` VALUES (3, '阿里巴巴Java开发手册', 3500, '杨冠宝', '9787121332319');
INSERT INTO `book` VALUES (4, '算法导论', 12800, '(美)科尔曼', '9787111407010');
INSERT INTO `book` VALUES (5, '疯狂Java讲义', 13900, '李刚', '9787121361586');
INSERT INTO `book` VALUES (6, '鸟哥的Linux私房菜 基础学习篇', 8800, '鸟哥', '9787115226266');
INSERT INTO `book` VALUES (7, '深入浅出MyBatis技术原理与实战', 6900, '杨开振', '9787121295942');
INSERT INTO `book` VALUES (8, '挑战程序设计竞赛2 算法和数据结构', 7900, '渡部有隆', '9787115431615');
INSERT INTO `book` VALUES (9, 'Java核心技术 卷I：基础知识', 11900, '（美）Horstmann', '9787111547426');
INSERT INTO `book` VALUES (10, 'Java核心技术 卷II：高级特性', 13900, '（美）Horstmann', '9787111573319');
INSERT INTO `book` VALUES (11, 'MySQL技术内幕：InnoDB存储引擎', 7900, '姜承尧', '9787111422068');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username_uk`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'lsh', '123456');
INSERT INTO `user` VALUES (2, 'admin', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
