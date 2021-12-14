-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Slyvka_db_lab7_variant66
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Slyvka_db_lab7_variant66
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Slyvka_db_lab7_variant66` DEFAULT CHARACTER SET utf8 ;
USE `Slyvka_db_lab7_variant66` ;

-- -----------------------------------------------------
-- Table `Slyvka_db_lab7_variant66`.`Position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka_db_lab7_variant66`.`Position` (
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Slyvka_db_lab7_variant66`.`Street`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka_db_lab7_variant66`.`Street` (
  `name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Slyvka_db_lab7_variant66`.`Drugstore`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka_db_lab7_variant66`.`Drugstore` (
  `name` VARCHAR(20) NOT NULL,
  `building_nomber` INT NOT NULL,
  `web_url` VARCHAR(45) NOT NULL,
  `open_time` TIME NOT NULL,
  `close_time` TIME NOT NULL,
  `working_on_saturday` TINYINT NULL,
  `working_on_sunday` TINYINT NULL,
  `Street_name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`name`, `Street_name`),
  INDEX `fk_Drugstore_Street1_idx` (`Street_name` ASC) VISIBLE,
  CONSTRAINT `fk_Drugstore_Street1`
    FOREIGN KEY (`Street_name`)
    REFERENCES `Slyvka_db_lab7_variant66`.`Street` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Slyvka_db_lab7_variant66`.`Worker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka_db_lab7_variant66`.`Worker` (
  `name` VARCHAR(20) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `id_number` BIGINT NOT NULL,
  `passport` VARCHAR(20) NOT NULL,
  `seniority` INT NULL,
  `birth_date` DATE NOT NULL,
  `Position_name` VARCHAR(20) NOT NULL,
  `Drugstore_name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_number`, `Position_name`, `Drugstore_name`),
  UNIQUE INDEX `passport_UNIQUE` (`passport` ASC) VISIBLE,
  INDEX `fk_Worker_Position_idx` (`Position_name` ASC) VISIBLE,
  INDEX `fk_Worker_Drugstore1_idx` (`Drugstore_name` ASC) VISIBLE,
  CONSTRAINT `fk_Worker_Position`
    FOREIGN KEY (`Position_name`)
    REFERENCES `Slyvka_db_lab7_variant66`.`Position` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Worker_Drugstore1`
    FOREIGN KEY (`Drugstore_name`)
    REFERENCES `Slyvka_db_lab7_variant66`.`Drugstore` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Slyvka_db_lab7_variant66`.`Drug`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka_db_lab7_variant66`.`Drug` (
  `name` VARCHAR(30) NOT NULL,
  `ministry_code` INT NULL,
  `only_be_recipt` TINYINT NULL,
  `narcotic` TINYINT NULL,
  `psychotropic` TINYINT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Slyvka_db_lab7_variant66`.`Drugstore_has_Drug`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka_db_lab7_variant66`.`Drugstore_has_Drug` (
  `Drugstore_name` VARCHAR(20) NOT NULL,
  `Drug_name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`Drugstore_name`, `Drug_name`),
  INDEX `fk_Drugstore_has_Drug_Drug1_idx` (`Drug_name` ASC) VISIBLE,
  INDEX `fk_Drugstore_has_Drug_Drugstore1_idx` (`Drugstore_name` ASC) VISIBLE,
  CONSTRAINT `fk_Drugstore_has_Drug_Drugstore1`
    FOREIGN KEY (`Drugstore_name`)
    REFERENCES `Slyvka_db_lab7_variant66`.`Drugstore` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Drugstore_has_Drug_Drug1`
    FOREIGN KEY (`Drug_name`)
    REFERENCES `Slyvka_db_lab7_variant66`.`Drug` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Slyvka_db_lab7_variant66`.`Heal_target`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka_db_lab7_variant66`.`Heal_target` (
  `name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Slyvka_db_lab7_variant66`.`Drug_has_Heal_target`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka_db_lab7_variant66`.`Drug_has_Heal_target` (
  `Drug_name` VARCHAR(30) NOT NULL,
  `Heal_target_name` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`Drug_name`, `Heal_target_name`),
  INDEX `fk_Drug_has_Heal_target_Heal_target1_idx` (`Heal_target_name` ASC) VISIBLE,
  INDEX `fk_Drug_has_Heal_target_Drug1_idx` (`Drug_name` ASC) VISIBLE,
  CONSTRAINT `fk_Drug_has_Heal_target_Drug1`
    FOREIGN KEY (`Drug_name`)
    REFERENCES `Slyvka_db_lab7_variant66`.`Drug` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Drug_has_Heal_target_Heal_target1`
    FOREIGN KEY (`Heal_target_name`)
    REFERENCES `Slyvka_db_lab7_variant66`.`Heal_target` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
