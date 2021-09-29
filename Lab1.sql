-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Slyvka
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Slyvka
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Slyvka` DEFAULT CHARACTER SET utf8 ;
USE `Slyvka` ;

-- -----------------------------------------------------
-- Table `Slyvka`.`tenant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka`.`tenant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `money_balance` DECIMAL(9,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Slyvka`.`landlord`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka`.`landlord` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `money_balance` DECIMAL(9,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Slyvka`.`apartment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka`.`apartment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `area` INT NOT NULL,
  `number_of_room` INT NOT NULL,
  `feedback` VARCHAR(500) NULL,
  `rating` DECIMAL(1,1) NULL,
  `landlord_id` INT NOT NULL,
  PRIMARY KEY (`id`, `landlord_id`),
  INDEX `fk_apartment_landlord1_idx` (`landlord_id` ASC) VISIBLE,
  CONSTRAINT `fk_apartment_landlord1`
    FOREIGN KEY (`landlord_id`)
    REFERENCES `Slyvka`.`landlord` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Slyvka`.`photo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka`.`photo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `link` VARCHAR(50) NULL,
  `apartment_id` INT NOT NULL,
  `apartment_landlord_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_photo_apartment1_idx` (`apartment_id` ASC, `apartment_landlord_id` ASC) VISIBLE,
  CONSTRAINT `fk_photo_apartment1`
    FOREIGN KEY (`apartment_id` , `apartment_landlord_id`)
    REFERENCES `Slyvka`.`apartment` (`id` , `landlord_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Slyvka`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka`.`reservation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `beginning_date` DATE NULL,
  `ending_date` DATE NULL,
  `is_arranged` TINYINT(1) NULL,
  `apartment_id` INT NOT NULL,
  `tenant_id` INT NOT NULL,
  PRIMARY KEY (`id`, `apartment_id`, `tenant_id`),
  INDEX `fk_reservation_apartment1_idx` (`apartment_id` ASC) VISIBLE,
  INDEX `fk_reservation_tenant1_idx` (`tenant_id` ASC) VISIBLE,
  CONSTRAINT `fk_reservation_apartment1`
    FOREIGN KEY (`apartment_id`)
    REFERENCES `Slyvka`.`apartment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservation_tenant1`
    FOREIGN KEY (`tenant_id`)
    REFERENCES `Slyvka`.`tenant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Slyvka`.`money_transfer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka`.`money_transfer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time` DATETIME NOT NULL,
  `money` DECIMAL(9,2) NOT NULL,
  `is_sent` TINYINT(1) NULL,
  `may_be_recieved` TINYINT(1) NULL,
  `is_recieved` TINYINT(1) NULL,
  `landlord_id` INT NOT NULL,
  `tenant_id` INT NOT NULL,
  PRIMARY KEY (`id`, `landlord_id`, `tenant_id`),
  INDEX `fk_money_transfer_landlord1_idx` (`landlord_id` ASC) VISIBLE,
  INDEX `fk_money_transfer_tenant1_idx` (`tenant_id` ASC) VISIBLE,
  CONSTRAINT `fk_money_transfer_landlord1`
    FOREIGN KEY (`landlord_id`)
    REFERENCES `Slyvka`.`landlord` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_money_transfer_tenant1`
    FOREIGN KEY (`tenant_id`)
    REFERENCES `Slyvka`.`tenant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Slyvka`.`money_transfer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Slyvka`.`money_transfer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time` DATETIME NOT NULL,
  `money` DECIMAL(9,2) NOT NULL,
  `is_sent` TINYINT(1) NULL,
  `may_be_recieved` TINYINT(1) NULL,
  `is_recieved` TINYINT(1) NULL,
  `landlord_id` INT NOT NULL,
  `tenant_id` INT NOT NULL,
  PRIMARY KEY (`id`, `landlord_id`, `tenant_id`),
  INDEX `fk_money_transfer_landlord1_idx` (`landlord_id` ASC) VISIBLE,
  INDEX `fk_money_transfer_tenant1_idx` (`tenant_id` ASC) VISIBLE,
  CONSTRAINT `fk_money_transfer_landlord1`
    FOREIGN KEY (`landlord_id`)
    REFERENCES `Slyvka`.`landlord` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_money_transfer_tenant1`
    FOREIGN KEY (`tenant_id`)
    REFERENCES `Slyvka`.`tenant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
