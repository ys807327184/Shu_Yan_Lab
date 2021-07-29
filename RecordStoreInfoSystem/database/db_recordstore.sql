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
    `nationality` varchar(30) NOT NULL,
    `dateOfBirth` date NOT NULL,
    PRIMARY KEY (`musicianId`)
);

-- ---------------------------
-- Table structure for `genre`
-- ---------------------------
DROP TABLE IF EXISTS `genre`;
CREATE TABLE `genre` (
	`genreId` int(5) NOT NULL AUTO_INCREMENT,
    `description` varchar(30) NOT NULL,
    PRIMARY KEY (`genreId`)
);

-- ------------------------------
-- Table structure for `language`
-- ------------------------------
DROP TABLE IF EXISTS `language`;
CREATE TABLE `language` (
	`languageId` int(5) NOT NULL AUTO_INCREMENT,
    `title` varchar(30) NOT NULL,
    PRIMARY KEY (`languageId`)
);

-- ---------------------------
-- Table structure for `album`
-- ---------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
	`albumId` int(5) NOT NULL AUTO_INCREMENT,
    `title` varchar(30) NOT NULL,
    `releaseDate` date NOT NULL,
    `length` time NOT NULL,
    `price` decimal(5, 2) NOT NULL,
    `inStock` int(4) NOT NULL,
    `sold` int(4) NOT NULL,
    PRIMARY KEY (`albumId`),
    CONSTRAINT FK_AlbumType FOREIGN KEY (albumTypeId) REFERENCES albumtype(albumTypeId),
    CONSTRAINT FK_AlbumGenre FOREIGN KEY (genreId) REFERENCES genre(genreId)
);

-- ---------------------------
-- Table structure for `track`
-- ---------------------------
DROP TABLE IF EXISTS `track`;
CREATE TABLE `track` (
	`trackId` int(5) NOT NULL AUTO_INCREMENT,
    `title` varchar(30) NOT NULL,
    `length` time NOT NULL,
    PRIMARY KEY (`trackId`),
    CONSTRAINT FK_TrackAlbum FOREIGN KEY (albumId) REFERENCES album(albumId)
);