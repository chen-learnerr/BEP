/*
 Navicat Premium Data Transfer

 Source Server         : 49.234.88.203_3306
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 49.234.88.203:3306
 Source Schema         : siemis

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 20/12/2020 18:32:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_log
-- ----------------------------
DROP TABLE IF EXISTS `admin_log`;
CREATE TABLE `admin_log`  (
  `admin_acct` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员账号',
  `admin_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`admin_acct`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for file_info
-- ----------------------------
DROP TABLE IF EXISTS `file_info`;
CREATE TABLE `file_info`  (
  `file_save_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件保存的名字',
  `file_disp_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件显示的名字',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件保存的路径',
  PRIMARY KEY (`file_save_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for ie_prog
-- ----------------------------
DROP TABLE IF EXISTS `ie_prog`;
CREATE TABLE `ie_prog`  (
  `proj_no` int NOT NULL AUTO_INCREMENT COMMENT '项目编号',
  `proj_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `proj_sch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '开设学校',
  `proj_apply_ddl` date NOT NULL COMMENT '申请截止日期',
  `proj_start_time` date NOT NULL COMMENT '项目开始时间',
  `proj_lang` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目语种',
  `proj_country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目国家',
  `proj_pub_acct` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目发布人员',
  `proj_credict` int NOT NULL COMMENT '项目学分',
  `proj_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学习时间',
  `proj_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细信息',
  `proj_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目文件',
  PRIMARY KEY (`proj_no`) USING BTREE,
  INDEX `proj_pub_acct:admin_acct`(`proj_pub_acct`) USING BTREE,
  INDEX `proj_lang`(`proj_lang`) USING BTREE,
  CONSTRAINT `proj_pub_acct:admin_acct` FOREIGN KEY (`proj_pub_acct`) REFERENCES `admin_log` (`admin_acct`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = sjis COLLATE = sjis_japanese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for mod_proj_notify
-- ----------------------------
DROP TABLE IF EXISTS `mod_proj_notify`;
CREATE TABLE `mod_proj_notify`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '信息ID',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '信息内容',
  `expiry_date` date NOT NULL COMMENT '消息过期时间',
  `proj_id` int NOT NULL COMMENT '对应的项目id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `proj_id`(`proj_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for new_proj_notify
-- ----------------------------
DROP TABLE IF EXISTS `new_proj_notify`;
CREATE TABLE `new_proj_notify`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '信息ID',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '信息内容',
  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '国家',
  `school` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学校',
  `expiry_date` date NOT NULL COMMENT '消息过期时间',
  `proj_id` int NOT NULL COMMENT '对应的项目id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `proj_id`(`proj_id`) USING BTREE,
  CONSTRAINT `new_proj_notify_ibfk_1` FOREIGN KEY (`proj_id`) REFERENCES `ie_prog` (`proj_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for rev_change_notify
-- ----------------------------
DROP TABLE IF EXISTS `rev_change_notify`;
CREATE TABLE `rev_change_notify`  (
  `stu_num` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生学号',
  `proj_no` int NOT NULL COMMENT '项目编号',
  `review_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '审查信息',
  `expiry_date` date NOT NULL COMMENT '信息过期时间',
  PRIMARY KEY (`stu_num`, `proj_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for stu_apply
-- ----------------------------
DROP TABLE IF EXISTS `stu_apply`;
CREATE TABLE `stu_apply`  (
  `stu_num` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `proj_no` int NOT NULL COMMENT '项目编号',
  `apply_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请状态',
  `aprv_admin` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审批员工号',
  `apply_att_name` varchar(255) CHARACTER SET sjis COLLATE sjis_japanese_ci NOT NULL COMMENT '附件名称',
  PRIMARY KEY (`stu_num`, `proj_no`) USING BTREE,
  INDEX `stu_num:stu_num`(`stu_num`) USING BTREE,
  INDEX `aprv_admin:job_num`(`aprv_admin`) USING BTREE,
  INDEX `proj_no:proj_no`(`proj_no`) USING BTREE,
  CONSTRAINT `aprv_admin:job_num` FOREIGN KEY (`aprv_admin`) REFERENCES `admin_log` (`admin_acct`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stu_num:stu_num` FOREIGN KEY (`stu_num`) REFERENCES `stu_info` (`stu_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = sjis COLLATE = sjis_japanese_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for stu_info
-- ----------------------------
DROP TABLE IF EXISTS `stu_info`;
CREATE TABLE `stu_info`  (
  `stu_num` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `stu_acct` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生账户',
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `stu_id_num` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `stu_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生性别',
  `stu_political_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '政治面貌',
  `stu_major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业',
  `stu_mob_no` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `stu_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `stu_nation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '民族',
  `stu_grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生年级',
  `stu_birthday` date NOT NULL COMMENT '出生日期',
  `stu_dates` int NOT NULL COMMENT '入学年份',
  PRIMARY KEY (`stu_num`) USING BTREE,
  INDEX `stu_acct:stu_acct`(`stu_acct`) USING BTREE,
  CONSTRAINT `stu_acct:stu_acct` FOREIGN KEY (`stu_acct`) REFERENCES `stu_log` (`stu_acct`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for stu_log
-- ----------------------------
DROP TABLE IF EXISTS `stu_log`;
CREATE TABLE `stu_log`  (
  `stu_acct` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生账号',
  `stu_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生密码',
  PRIMARY KEY (`stu_acct`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for stu_pref
-- ----------------------------
DROP TABLE IF EXISTS `stu_pref`;
CREATE TABLE `stu_pref`  (
  `pref_id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '编号',
  `stu_numb` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `pref_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '偏好字段的类型\r\n',
  `pref_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '偏好学校或者地区的名称',
  PRIMARY KEY (`pref_id`) USING BTREE,
  INDEX `stu_numb:stu_num`(`stu_numb`) USING BTREE,
  CONSTRAINT `stu_numb:stu_num` FOREIGN KEY (`stu_numb`) REFERENCES `stu_info` (`stu_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
