CREATE DATABASE db_RecordStore;
USE db_RecordStore;

-- -----------------------------
-- Table structure for `company`
-- -----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
	`companyId` int(5) NOT NULL AUTO_INCREMENT,
    `name` varchar(30) NOT NULL,
    `emailAddress` varchar(30) DEFAULT NULL,
    `phoneNumber` varchar(30) DEFAULT NULL,
    PRIMARY KEY (`companyId`)
);

-- -------------------------------
-- Table structure for `albumtype`
-- -------------------------------
DROP TABLE IF EXISTS `albumtype`;
CREATE TABLE `albumtype` (
	`albumTypeId` int(5) NOT NULL AUTO_INCREMENT,
    `description` varchar(30) NOT NULL,
    PRIMARY KEY (`albumTypeId`)
);

-- ----------------------------
-- Table structure for `vendor`
-- ----------------------------
DROP TABLE IF EXISTS `vendor`;
CREATE TABLE `vendor` (
	`vendorId` int(5) NOT NULL AUTO_INCREMENT,
    `name` varchar(30) NOT NULL,
    `emailAddress` varchar(30) DEFAULT NULL,
    `phoneNumber` varchar(30) DEFAULT NULL,
    PRIMARY KEY (`vendorId`)
);

-- ------------------------------
-- Table structure for `position`
-- ------------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
	`positionId` int(5) NOT NULL AUTO_INCREMENT,
    `title` varchar(30) NOT NULL,
    PRIMARY KEY (`positionId`)
);

-- ------------------------------
-- Table structure for `musician`
-- ------------------------------
DROP TABLE IF EXISTS `musician`;
CREATE TABLE `misician` (
	`musicianId` int(5) NOT NULL AUTO_INCREMENT,
    `name` varchar(30) NOT NULL,
    PRIMARY KEY (`musicianId`)
);