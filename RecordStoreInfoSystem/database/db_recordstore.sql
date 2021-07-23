CREATE DATABASE db_RecordStore;
USE db_RecordStore;

-- -----------------------------
-- Table structure for 'company'
-- -----------------------------
DROP TABLE IF EXISTS `db_recordstore`.`company`;
CREATE TABLE `db_recordstore`.`company` (
	`companyId` int(5) NOT NULL AUTO_INCREMENT,
    `name` varchar(30) NOT NULL,
    `emailAddress` varchar(30) DEFAULT NULL,
    `phoneNumber` varchar(30) DEFAULT NULL,
    PRIMARY KEY (`companyId`)
);

-- -------------------------------
-- Table structure for 'albumtype'
-- -------------------------------
DROP TABLE IF EXISTS `db_recordstore`.`albumtype`;
