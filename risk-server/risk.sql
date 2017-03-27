/*
Navicat MySQL Data Transfer

Source Server         : risk
Source Server Version : 50616
Source Host           : 192.168.1.220:3306
Source Database       : risk

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2016-08-19 11:00:27
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `r_adminuser`
-- ----------------------------
DROP TABLE IF EXISTS `r_adminuser`;
CREATE TABLE `r_adminuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `realName` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮件',
  `status` int(11) DEFAULT NULL COMMENT '状态: 1正常 2冻结',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_adminuser
-- ----------------------------

-- ----------------------------
-- Table structure for `r_company`
-- ----------------------------
DROP TABLE IF EXISTS `r_company`;
CREATE TABLE `r_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `status` smallint(6) DEFAULT NULL COMMENT '公司是否有业务往来 1 正常 2.已禁用',
  `operName` varchar(50) DEFAULT NULL COMMENT '操作人名称',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_company
-- ----------------------------

-- ----------------------------
-- Table structure for `r_consumer`
-- ----------------------------
DROP TABLE IF EXISTS `r_consumer`;
CREATE TABLE `r_consumer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) DEFAULT NULL COMMENT '公司ID',
  `loginName` varchar(50) DEFAULT NULL COMMENT '用户名',
  `name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(50) DEFAULT NULL COMMENT '客户密码',
  `rankLevel` varchar(50) DEFAULT NULL COMMENT '职位级别',
  `status` smallint(6) DEFAULT NULL COMMENT '客户状态: 1 正常 2.已禁用',
  `cardId` int(11) DEFAULT NULL COMMENT '身份证号',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `phone` int(11) DEFAULT NULL COMMENT '手机号',
  `mail` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `operName` varchar(50) DEFAULT NULL COMMENT '操作人名称',
  `updateTime` datetime NOT NULL COMMENT '创建时间',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `index_consumer_loginname` (`companyId`, `loginName`) USING BTREE 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_consumer
-- ----------------------------

-- ----------------------------
-- Table structure for `r_consumertemplatedetail`
-- ----------------------------
DROP TABLE IF EXISTS `r_consumertemplatedetail`;
CREATE TABLE `r_consumertemplatedetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `consumerId` int(11) DEFAULT NULL COMMENT '客户ID',
  `consumerName` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `companyId` int(11) DEFAULT NULL COMMENT '公司ID',
  `templateId` int(11) DEFAULT NULL COMMENT '模板ID',
  `params` varchar(2000) DEFAULT NULL COMMENT '查询参数',
  `orderId` varchar(50) DEFAULT NULL COMMENT '查询订单编号',
  `personName` varchar(50) DEFAULT NULL COMMENT '被查人姓名',
  `cardId` varchar(50) DEFAULT NULL COMMENT '被查人身份证号',
  `returnData` varchar(15000) DEFAULT NULL COMMENT '查询返回数据',
  `totalPrice` decimal(10,2) DEFAULT NULL COMMENT '总价',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_consumertemplatedetail
-- ----------------------------

-- ----------------------------
-- Table structure for `r_interparam`
-- ----------------------------
DROP TABLE IF EXISTS `r_interparam`;
CREATE TABLE `r_interparam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `interId` varchar(50) DEFAULT NULL COMMENT '服务商接口id',
  `interCode` varchar(50) DEFAULT NULL COMMENT '服务商接口code(uri)',
  `name` varchar(50) DEFAULT NULL COMMENT '服务商接口参数名称',
  `paramType` varchar(50) DEFAULT NULL COMMENT '接口参数数据类型',
  `isMust` smallint(6) DEFAULT NULL COMMENT '是否必填',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `updateTime` datetime NOT NULL COMMENT '创建时间',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_interparam
-- ----------------------------

-- ----------------------------
-- Table structure for `r_product`
-- ----------------------------
DROP TABLE IF EXISTS `r_product`;
CREATE TABLE `r_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `providerCode` int(11) DEFAULT NULL COMMENT '服务商ID',
  `providerInterCode` int(11) DEFAULT NULL COMMENT '服务商接口ID',
  `name` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `marketPrice` decimal(10,2) DEFAULT NULL COMMENT '市场价',
  `specialPrice` decimal(10,2) DEFAULT NULL COMMENT '特价',
  `costPrice` decimal(10,2) DEFAULT NULL COMMENT '成本价',
  `status` smallint(6) DEFAULT NULL COMMENT '产品状态:1 正常 2停用',
  `feeType` smallint(6) DEFAULT NULL COMMENT '费用类型:1.查询 2.查得',
  `infoType` varchar(50) DEFAULT NULL COMMENT '产品信息类别',
  `description` varchar(500) comment '产品描述',
  `operName` varchar(50) DEFAULT NULL COMMENT '操作人名称',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_product
-- ----------------------------

-- ----------------------------
-- Table structure for `r_productcalldetail`
-- ----------------------------
DROP TABLE IF EXISTS `r_productcalldetail`;
CREATE TABLE `r_productcalldetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) DEFAULT NULL COMMENT '产品ID',
  `companyId` int(11) DEFAULT NULL COMMENT '公司ID',
  `consumerId` int(11) DEFAULT NULL COMMENT '客户ID',
  `productName` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '产品价格',
  `returncode` varchar(50) DEFAULT NULL COMMENT '返回码',
  `returnData` varchar(10000) DEFAULT NULL COMMENT '返回数据',
  `status` smallint(6) DEFAULT NULL COMMENT '调用状态:1成功 2失败',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_productcalldetail
-- ----------------------------

-- ----------------------------
-- Table structure for `r_providerinter`
-- ----------------------------
DROP TABLE IF EXISTS `r_providerinter`;
CREATE TABLE `r_providerinter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) DEFAULT NULL COMMENT '产品ID',
  `name` varchar(50) DEFAULT NULL COMMENT '服务商名称',
  `providerCode` int(11) DEFAULT NULL COMMENT '服务商机构号',
  `interCode` int(30) DEFAULT NULL COMMENT '服务商接口rest code',
  `price` decimal(10,2) DEFAULT NULL COMMENT '服务商接口价格',
  `feeType` smallint(6) DEFAULT NULL COMMENT '价格类型:1查询 2查得 3查得按累别 4查得按篇 5查询按条',
  `status` smallint(6) DEFAULT NULL COMMENT '服务商接口状态:1 正常 2停用',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_providerinter
-- ----------------------------

-- ----------------------------
-- Table structure for `r_providerinterdetail`
-- ----------------------------
DROP TABLE IF EXISTS `r_providerinterdetail`;
CREATE TABLE `r_providerinterdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `providerInterId` int(11) DEFAULT NULL COMMENT '服务商ID',
  `providerCode` int(11) DEFAULT NULL COMMENT '服务商机构号',
  `providerInterCode` int(11) DEFAULT NULL COMMENT '服务商接口rest code例5001',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `status` smallint(6) DEFAULT NULL COMMENT '服务商接口调用状态: 1成功 2失败',
  `params` varchar(50) DEFAULT NULL COMMENT '服务商接口调用参数',
  `returnCode` varchar(50) DEFAULT NULL COMMENT '服务商接口返回码',
  `returnData` varchar(5000) DEFAULT NULL COMMENT '服务商接口返回结果  json格式',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_providerinterdetail
-- ----------------------------

-- ----------------------------
-- Table structure for `r_template`
-- ----------------------------
DROP TABLE IF EXISTS `r_template`;
CREATE TABLE `r_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) DEFAULT NULL COMMENT '公司ID',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `tempName` int(11) DEFAULT NULL COMMENT '模板名称',
  `totalPrice` decimal(10,2) DEFAULT NULL COMMENT '报告价格',
  `status` smallint(6) DEFAULT NULL COMMENT '模板状态:1正常 2停用',
  `orderIndex` int(11) DEFAULT NULL COMMENT '排序序号',
  `operName` varchar(50) DEFAULT NULL COMMENT '操作人名称',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_template
-- ----------------------------

-- ----------------------------
-- Table structure for `r_templateinter`
-- ----------------------------
DROP TABLE IF EXISTS `r_templateinter`;
CREATE TABLE `r_templateinter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `templateId` int(11) DEFAULT NULL COMMENT '模板ID',
  `productId` int(11) DEFAULT NULL COMMENT '产品ID',
  `infoType` varchar(50) DEFAULT NULL COMMENT '产品类别',
  `orderIndex` int(11) DEFAULT NULL COMMENT '接口报告排序',
  `operName` varchar(50) DEFAULT NULL COMMENT '操作人名称',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_templateinter
-- ----------------------------
