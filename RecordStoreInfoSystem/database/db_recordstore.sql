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
DROP TABLE IF EXISTS `positions`;
CREATE TABLE `positions` (
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

-- ------------------------------------------
-- Table structure for `allocateCompanyAlbum`
-- ------------------------------------------
DROP TABLE IF EXISTS `allocateCompanyAlbum`;
CREATE TABLE `allocateCompanyAlbum` (
	`companyAlbumId` int(5) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`companyAlbumId`),
    CONSTRAINT FK_CompanyAlbum FOREIGN KEY (albumId) REFERENCES album(albumId),
    CONSTRAINT FK_AlbumCompany FOREIGN KEY (companyId) REFERENCES company(companyId)
);

-- ----------------------------------------------
-- Table structure for `allocatePositionMusician`
-- ----------------------------------------------
DROP TABLE IF EXISTS `allocatePositionMusician`;
CREATE TABLE `allocatePositionMusician` (
	`positionMusicianId` int(5) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`positionMusicianId`),
    CONSTRAINT FK_PositionMusician FOREIGN KEY (musicianId) REFERENCES musician(musicianId),
    CONSTRAINT FK_MusicianPosition FOREIGN KEY (positionId) REFERENCES positions(positionId)
);

-- ---------------------------
-- Table struture for `singer`
-- ---------------------------
DROP TABLE IF EXISTS `singer`;
CREATE TABLE `singer` (
	`singerId` int(5) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`singerId`),
    CONSTRAINT FK_SingerMusician FOREIGN KEY (musicianId) REFERENCES musician(musicianId),
    CONSTRAINT FK_SingerTrack FOREIGN KEY (trackId) REFERENCES track(trackId)
);

-- ---------------------------
-- Table struture for `featured`
-- ---------------------------
DROP TABLE IF EXISTS `featured`;
CREATE TABLE `featured` (
	`featuredId` int(5) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`featuredId`),
    CONSTRAINT FK_FeaturedMusician FOREIGN KEY (musicianId) REFERENCES musician(musicianId),
    CONSTRAINT FK_FeaturedTrack FOREIGN KEY (trackId) REFERENCES track(trackId)
);

-- ---------------------------
-- Table struture for `lyric`
-- ---------------------------
DROP TABLE IF EXISTS `lyric`;
CREATE TABLE `lyric` (
	`lyricId` int(5) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`lyricId`),
    CONSTRAINT FK_LyricMusician FOREIGN KEY (musicianId) REFERENCES musician(musicianId),
    CONSTRAINT FK_LyricTrack FOREIGN KEY (trackId) REFERENCES track(trackId)
);

-- ---------------------------
-- Table struture for `composer`
-- ---------------------------
DROP TABLE IF EXISTS `composer`;
CREATE TABLE `composer` (
	`composerId` int(5) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`composerId`),
    CONSTRAINT FK_ComposerMusician FOREIGN KEY (musicianId) REFERENCES musician(musicianId),
    CONSTRAINT FK_ComposerTrack FOREIGN KEY (trackId) REFERENCES track(trackId)
);

-- ---------------------------
-- Table struture for `producer`
-- ---------------------------
DROP TABLE IF EXISTS `producer`;
CREATE TABLE `producer` (
	`producerId` int(5) NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`producerId`),
    CONSTRAINT FK_ProducerMusician FOREIGN KEY (musicianId) REFERENCES musician(musicianId),
    CONSTRAINT FK_ProducerAlbum FOREIGN KEY (albumId) REFERENCES album(albumId)
);

-- -----------------------------
-- Table Structure for `account`
-- -----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
	`accountId` int(5) NOT NULL AUTO_INCREMENT,
    `username` varchar(30) NOT NULL,
    `password` varchar(30) NOT NULL,
    PRIMARY KEY (`accountId`)
);

-- -----------------------------
-- Table Structure for `invoice`
-- -----------------------------
DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
	`invoiceId` int(5) NOT NULL AUTO_INCREMENT,
    `date` date NOT NULL,
    PRIMARY KEY (`invoiceId`),
    CONSTRAINT FK_InvoiceAccount FOREIGN KEY (accountId) REFERENCES accounts(accountId)
);

-- ---------------------------
-- Table struture for `sell`
-- ---------------------------
DROP TABLE IF EXISTS `sell`;
CREATE TABLE `sell` (
	`sellId` int(5) NOT NULL AUTO_INCREMENT,
    `number` int(5) NOT NULL,
    PRIMARY KEY (`sellId`),
    CONSTRAINT FK_SellInvoice FOREIGN KEY (invoiceId) REFERENCES invoice(invoiceId),
    CONSTRAINT FK_SellAlbum FOREIGN KEY (albumId) REFERENCES album(albumId)
);