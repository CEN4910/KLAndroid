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


