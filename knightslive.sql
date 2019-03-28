-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: knightslivedb
-- Source Schemata: knightslivedb
-- Created: Sun Feb 10 18:59:48 2019
-- Workbench Version: 8.0.12
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema knightslivedb
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `knightslivedb` ;
CREATE SCHEMA IF NOT EXISTS `knightslivedb` ;

-- ----------------------------------------------------------------------------
-- Table knightslivedb.archive
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `knightslivedb`.`archive` (
  `archive_id` MEDIUMINT(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `video_id` SMALLINT(5) UNSIGNED NOT NULL,
  `host_title` VARCHAR(25) NOT NULL,
  `last_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `host_first_name` VARCHAR(45) NOT NULL,
  `host_last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  `active` TINYINT(1) NOT NULL DEFAULT '1',
  `username` VARCHAR(16) NOT NULL,
  `password` VARCHAR(40) CHARACTER SET 'utf8mb4' NULL DEFAULT NULL
CURRENT_TIMESTAMP,
  PRIMARY KEY (`archive_id`), 
  CONSTRAINT `fk_archive_video`
    FOREIGN KEY (`video_id`)
    REFERENCES `knightslivedb`.`video` (`video_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table knightslivedb.video
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `knightslivedb`.`video` (
  `video_id` SMALLINT(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `event_id` VARCHAR(255) NOT NULL,
  `create_date` DATETIME NOT NULL,
  `event_type` VARCHAR(25) NOT NULL,
  `website_link` VARCHAR(13383) NOT NULL,
  `picture` BLOB NULL DEFAULT NULL,
  `title` VARCHAR(255) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `status` TEXT NULL DEFAULT NULL,
  `release_year` YEAR(4) NULL DEFAULT NULL,
  `duration` TINYINT(3) UNSIGNED NOT NULL DEFAULT '3',
  `length` SMALLINT(5) UNSIGNED NULL DEFAULT NULL,
  `rating` ENUM('*', '**', '***', '****', '*****') NULL DEFAULT NULL,
  `last_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `video_info` INT(11) NULL DEFAULT NULL)
  PRIMARY KEY (`video_id`),
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



INSERT INTO `knightslivedb`.`archive` (`host_title`) VALUES ('President');
INSERT INTO `knightslivedb`.`archive` (`host_first_name`) VALUES ('Brad');
INSERT INTO `knightslivedb`.`archive` (`host_last_name`) VALUES ('Pitt');
INSERT INTO `knightslivedb`.`archive` (`email`) VALUES ('bpitt@knights.ucf.edu');
INSERT INTO `knightslivedb`.`archive` (`active`) VALUES ('1');
INSERT INTO `knightslivedb`.`archive` (`username`) VALUES ('bpitt');
INSERT INTO `knightslivedb`.`archive` (`password`) VALUES ('password2');

INSERT INTO `knightslivedb`.`video` (`website_link`) VALUES ('https://www.youtube.com/watch?v=4F6mTzoKEkY');
INSERT INTO `knightslivedb`.`video` (`create_date`) VALUES ('2019-02-11');
INSERT INTO `knightslivedb`.`video` (`event_type`) VALUES ('Football Game');
INSERT INTO `knightslivedb`.`video` (`picture`) VALUES ('');
INSERT INTO `knightslivedb`.`video` (`title`) VALUES ('UCF Knights Football Game');
INSERT INTO `knightslivedb`.`video` (`description`) VALUES (' UCF Knights Football Game Knights vs Bulls');
INSERT INTO `knightslivedb`.`video` (`release_year`) VALUES ('2019');
INSERT INTO `knightslivedb`.`video` (`duration`) VALUES ('1');
INSERT INTO `knightslivedb`.`video` (`length`) VALUES ('1');
INSERT INTO `knightslivedb`.`video` (`rating`) VALUES ('*****');
INSERT INTO `knightslivedb`.`video` (`status`) VALUES ('live');
INSERT INTO `knightslivedb`.`video` (`private`) VALUES ('yes');
-------------------
INSERT INTO `knightslivedb`.`archive` (`host_title`) VALUES ('Director of IT');
INSERT INTO `knightslivedb`.`archive` (`host_first_name`) VALUES ('Jane');
INSERT INTO `knightslivedb`.`archive` (`host_last_name`) VALUES ('Seymour');
INSERT INTO `knightslivedb`.`archive` (`email`) VALUES ('jSeymour@knights.ucf.edu');
INSERT INTO `knightslivedb`.`archive` (`active`) VALUES ('1');
INSERT INTO `knightslivedb`.`archive` (`username`) VALUES ('jseymour');
INSERT INTO `knightslivedb`.`archive` (`password`) VALUES ('password1');

INSERT INTO `knightslivedb`.`video` (`website_link`) VALUES ('https://www.youtube.com/watch?v=4F6mTzoKEkY');
INSERT INTO `knightslivedb`.`video` (`create_date`) VALUES ('2019-02-10');
INSERT INTO `knightslivedb`.`video` (`event_type`) VALUES ('Football Rally');
INSERT INTO `knightslivedb`.`video` (`picture`) VALUES ('');
INSERT INTO `knightslivedb`.`video` (`title`) VALUES ('UCF Knights Football Rally');
INSERT INTO `knightslivedb`.`video` (`description`) VALUES (' UCF Knights Football Rally before the Knights vs Bulls');
INSERT INTO `knightslivedb`.`video` (`release_year`) VALUES ('2019');
INSERT INTO `knightslivedb`.`video` (`duration`) VALUES ('1');
INSERT INTO `knightslivedb`.`video` (`length`) VALUES ('1');
INSERT INTO `knightslivedb`.`video` (`rating`) VALUES ('*****');
INSERT INTO `knightslivedb`.`video` (`status`) VALUES ('archive');
INSERT INTO `knightslivedb`.`video` (`private`) VALUES ('no');





