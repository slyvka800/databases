-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`tenant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tenant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `money_balance` DECIMAL(9,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`landlord`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`landlord` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `money_balance` DECIMAL(9,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`apartment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`apartment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `area` INT NOT NULL,
  `number_of_room` INT NOT NULL,
  `feedback` VARCHAR(500) NULL,
  `rating` DECIMAL(1,1) NULL,
  `Landlord_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Landlord_id`),
  INDEX `fk_Apartment_Landlord1_idx` (`Landlord_id` ASC) VISIBLE,
  CONSTRAINT `fk_Apartment_Landlord1`
    FOREIGN KEY (`Landlord_id`)
    REFERENCES `mydb`.`landlord` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`photo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`photo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Apartment_id` VARCHAR(45) NOT NULL,
  `link` VARCHAR(50) NULL,
  INDEX `fk_Photo_Apartment_idx` (`Apartment_id` ASC) VISIBLE,
  PRIMARY KEY (`id`, `Apartment_id`),
  CONSTRAINT `fk_Photo_Apartment`
    FOREIGN KEY (`Apartment_id`)
    REFERENCES `mydb`.`apartment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`reservation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `beginning_date` DATE NULL,
  `ending_date` DATE NULL,
  `Tenant_id` INT NOT NULL,
  `Apartment_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `Tenant_id`, `Apartment_id`),
  INDEX `fk_Reservation_Tenant1_idx` (`Tenant_id` ASC) VISIBLE,
  INDEX `fk_Reservation_Apartment1_idx` (`Apartment_id` ASC) VISIBLE,
  CONSTRAINT `fk_Reservation_Tenant1`
    FOREIGN KEY (`Tenant_id`)
    REFERENCES `mydb`.`tenant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservation_Apartment1`
    FOREIGN KEY (`Apartment_id`)
    REFERENCES `mydb`.`apartment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`money_transfer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`money_transfer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tenant_id` INT NOT NULL,
  `landlord_id` INT NOT NULL,
  `time` DATETIME NOT NULL,
  `money` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`id`, `tenant_id`, `landlord_id`),
  INDEX `fk_tenant_has_landlord_landlord1_idx` (`landlord_id` ASC) VISIBLE,
  INDEX `fk_tenant_has_landlord_tenant1_idx` (`tenant_id` ASC) VISIBLE,
  CONSTRAINT `fk_tenant_has_landlord_tenant1`
    FOREIGN KEY (`tenant_id`)
    REFERENCES `mydb`.`tenant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tenant_has_landlord_landlord1`
    FOREIGN KEY (`landlord_id`)
    REFERENCES `mydb`.`landlord` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
