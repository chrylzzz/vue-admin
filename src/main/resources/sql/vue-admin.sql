/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : vue-admin

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 04/01/2020 16:02:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date` date DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `is_pass` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'abc333', '123789', '2020-01-15', 12, NULL);
INSERT INTO `user` VALUES (2, 'abc4a', '1237891', '2020-01-17', NULL, NULL);
INSERT INTO `user` VALUES (3, '452', 'sksa', '2020-01-20', NULL, NULL);
INSERT INTO `user` VALUES (4, '444', '4445221', '2020-01-22', NULL, NULL);
INSERT INTO `user` VALUES (5, '999', '99962', '2020-01-30', NULL, NULL);
INSERT INTO `user` VALUES (6, '112', '1213123', '2020-01-20', NULL, NULL);
INSERT INTO `user` VALUES (7, '111', '111', '2020-01-21', NULL, NULL);
INSERT INTO `user` VALUES (8, '1123', '123123', '2020-01-27', NULL, NULL);
INSERT INTO `user` VALUES (9, '555', '552', '2020-01-22', NULL, NULL);
INSERT INTO `user` VALUES (10, '555', '5555', '2020-01-15', NULL, NULL);
INSERT INTO `user` VALUES (11, '666', '666', '2020-01-20', NULL, NULL);
INSERT INTO `user` VALUES (12, '000', '112', '2020-01-21', NULL, NULL);
INSERT INTO `user` VALUES (13, '555', '112', '2019-12-31', NULL, NULL);
INSERT INTO `user` VALUES (14, '567890', '12345da', '2019-12-31', NULL, NULL);
INSERT INTO `user` VALUES (15, '111', '111', '2020-01-19', NULL, NULL);
INSERT INTO `user` VALUES (16, '', '', NULL, NULL, NULL);
INSERT INTO `user` VALUES (17, '', '', NULL, NULL, NULL);
INSERT INTO `user` VALUES (18, '', '', NULL, NULL, NULL);
INSERT INTO `user` VALUES (19, '', '', NULL, NULL, NULL);
INSERT INTO `user` VALUES (20, '', '', NULL, NULL, NULL);
INSERT INTO `user` VALUES (21, '1231231', '12313', '2020-01-06', NULL, NULL);
INSERT INTO `user` VALUES (22, '2313111', '322323', '2020-01-13', NULL, NULL);
INSERT INTO `user` VALUES (23, '2313111', '322323', '2020-01-13', NULL, NULL);
INSERT INTO `user` VALUES (24, '2313111', '322323', '2020-01-13', NULL, NULL);
INSERT INTO `user` VALUES (25, '333333', '3333333', '2020-01-07', NULL, NULL);
INSERT INTO `user` VALUES (26, 'admin', '111111', '2020-01-29', 18, 0);
INSERT INTO `user` VALUES (27, '444444', '444444', '2020-01-20', 44, 1);
INSERT INTO `user` VALUES (29, '213132', '233233', '2020-01-27', 23, NULL);
INSERT INTO `user` VALUES (30, '222222', '222222', '2020-01-21', 22, NULL);
INSERT INTO `user` VALUES (31, '444444', '444444', '2020-01-27', 44, NULL);
INSERT INTO `user` VALUES (32, '', '', NULL, NULL, NULL);
INSERT INTO `user` VALUES (33, '123121', '123232', '2020-01-21', 11, NULL);
COMMIT;

-- ----------------------------
-- Table structure for v_permissions
-- ----------------------------
DROP TABLE IF EXISTS `v_permissions`;
CREATE TABLE `v_permissions` (
  `permissions_id` int(5) NOT NULL AUTO_INCREMENT,
  `permissions_code` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `permissions_desc` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`permissions_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of v_permissions
-- ----------------------------
BEGIN;
INSERT INTO `v_permissions` VALUES (1, 'admin', '超级管理权限');
INSERT INTO `v_permissions` VALUES (2, 'ordinary', '普通用户权限');
INSERT INTO `v_permissions` VALUES (3, 'editor', '编辑');
COMMIT;

-- ----------------------------
-- Table structure for v_role
-- ----------------------------
DROP TABLE IF EXISTS `v_role`;
CREATE TABLE `v_role` (
  `role_id` int(5) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `role_desc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of v_role
-- ----------------------------
BEGIN;
INSERT INTO `v_role` VALUES (1, 'admin', 'admin', '超级管理员');
INSERT INTO `v_role` VALUES (2, 'ordinary', 'ordinary', '普通用户');
COMMIT;

-- ----------------------------
-- Table structure for v_role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `v_role_permissions`;
CREATE TABLE `v_role_permissions` (
  `g_role_id` int(11) DEFAULT NULL,
  `g_permissions_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of v_role_permissions
-- ----------------------------
BEGIN;
INSERT INTO `v_role_permissions` VALUES (1, 1);
INSERT INTO `v_role_permissions` VALUES (2, 2);
INSERT INTO `v_role_permissions` VALUES (1, 3);
COMMIT;

-- ----------------------------
-- Table structure for v_user
-- ----------------------------
DROP TABLE IF EXISTS `v_user`;
CREATE TABLE `v_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `is_pass` int(5) DEFAULT NULL COMMENT '是否通过',
  `g_role_id` int(5) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of v_user
-- ----------------------------
BEGIN;
INSERT INTO `v_user` VALUES (1, 'admin', '111111', 18, '2018-10-18', 0, 1);
INSERT INTO `v_user` VALUES (2, 'nancy1', '111111', 17, '2020-01-05', 1, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
