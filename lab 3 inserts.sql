-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Slyvka
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Slyvka
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Slyvka` DEFAULT CHARACTER SET utf8 ;
USE `Slyvka` ;

-- -----------------------------------------------------
-- Table `Slyvka`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Slyvka`.`city` ;

CREATE TABLE IF NOT EXISTS `Slyvka`.`city` (
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `idcity_UNIQUE` ON `Slyvka`.`city` (`name` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `Slyvka`.`country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Slyvka`.`country` ;

CREATE TABLE IF NOT EXISTS `Slyvka`.`country` (
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `idcountry_UNIQUE` ON `Slyvka`.`country` (`name` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `Slyvka`.`landlord`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Slyvka`.`landlord` ;

CREATE TABLE IF NOT EXISTS `Slyvka`.`landlord` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `money_balance` DECIMAL(9,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `Slyvka`.`street`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Slyvka`.`street` ;

CREATE TABLE IF NOT EXISTS `Slyvka`.`street` (
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE UNIQUE INDEX `idstreet_UNIQUE` ON `Slyvka`.`street` (`name` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `Slyvka`.`apartment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Slyvka`.`apartment` ;

CREATE TABLE IF NOT EXISTS `Slyvka`.`apartment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `area` INT(11) NOT NULL,
  `number_of_room` INT(11) NOT NULL,
  `feedback` VARCHAR(500) NULL DEFAULT NULL,
  `rating` DECIMAL(2,1) NULL DEFAULT NULL,
  `landlord_id` INT(11) NOT NULL,
  `city_name` VARCHAR(30) NOT NULL,
  `country_name` VARCHAR(30) NOT NULL,
  `street_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`, `landlord_id`, `city_name`, `country_name`, `street_name`),
  CONSTRAINT `fk_apartment_city1`
    FOREIGN KEY (`city_name`)
    REFERENCES `Slyvka`.`city` (`name`),
  CONSTRAINT `fk_apartment_country1`
    FOREIGN KEY (`country_name`)
    REFERENCES `Slyvka`.`country` (`name`),
  CONSTRAINT `fk_apartment_landlord1`
    FOREIGN KEY (`landlord_id`)
    REFERENCES `Slyvka`.`landlord` (`id`),
  CONSTRAINT `fk_apartment_street1`
    FOREIGN KEY (`street_name`)
    REFERENCES `Slyvka`.`street` (`name`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_apartment_landlord1_idx` ON `Slyvka`.`apartment` (`landlord_id` ASC) VISIBLE;

CREATE INDEX `fk_apartment_city1_idx` ON `Slyvka`.`apartment` (`city_name` ASC) VISIBLE;

CREATE INDEX `fk_apartment_country1_idx` ON `Slyvka`.`apartment` (`country_name` ASC) VISIBLE;

CREATE INDEX `fk_apartment_street1_idx` ON `Slyvka`.`apartment` (`street_name` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `Slyvka`.`tenant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Slyvka`.`tenant` ;

CREATE TABLE IF NOT EXISTS `Slyvka`.`tenant` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `money_balance` DECIMAL(9,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `Slyvka`.`money_transfer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Slyvka`.`money_transfer` ;

CREATE TABLE IF NOT EXISTS `Slyvka`.`money_transfer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `time` DATETIME NOT NULL,
  `money` DECIMAL(9,2) NOT NULL,
  `is_sent` TINYINT(1) NULL DEFAULT NULL,
  `may_be_recieved` TINYINT(1) NULL DEFAULT NULL,
  `is_recieved` TINYINT(1) NULL DEFAULT NULL,
  `landlord_id` INT(11) NOT NULL,
  `tenant_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `landlord_id`, `tenant_id`),
  CONSTRAINT `fk_money_transfer_landlord1`
    FOREIGN KEY (`landlord_id`)
    REFERENCES `Slyvka`.`landlord` (`id`),
  CONSTRAINT `fk_money_transfer_tenant1`
    FOREIGN KEY (`tenant_id`)
    REFERENCES `Slyvka`.`tenant` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_money_transfer_landlord1_idx` ON `Slyvka`.`money_transfer` (`landlord_id` ASC) VISIBLE;

CREATE INDEX `fk_money_transfer_tenant1_idx` ON `Slyvka`.`money_transfer` (`tenant_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `Slyvka`.`photo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Slyvka`.`photo` ;

CREATE TABLE IF NOT EXISTS `Slyvka`.`photo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `link` VARCHAR(50) NULL DEFAULT NULL,
  `apartment_id` INT(11) NOT NULL,
  `apartment_landlord_id` INT(11) NOT NULL,
  `apartment_city_name` VARCHAR(30) NOT NULL,
  `apartment_country_name` VARCHAR(30) NOT NULL,
  `apartment_street_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_photo_apartment1`
    FOREIGN KEY (`apartment_id` , `apartment_landlord_id` , `apartment_city_name` , `apartment_country_name` , `apartment_street_name`)
    REFERENCES `Slyvka`.`apartment` (`id` , `landlord_id` , `city_name` , `country_name` , `street_name`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_photo_apartment1_idx` ON `Slyvka`.`photo` (`apartment_id` ASC, `apartment_landlord_id` ASC, `apartment_city_name` ASC, `apartment_country_name` ASC, `apartment_street_name` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `Slyvka`.`reservation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Slyvka`.`reservation` ;

CREATE TABLE IF NOT EXISTS `Slyvka`.`reservation` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `beginning_date` DATE NULL DEFAULT NULL,
  `ending_date` DATE NULL DEFAULT NULL,
  `is_arranged` TINYINT(1) NULL DEFAULT NULL,
  `tenant_id` INT(11) NOT NULL,
  `apartment_id` INT(11) NOT NULL,
  `apartment_landlord_id` INT(11) NOT NULL,
  `apartment_city_name` VARCHAR(30) NOT NULL,
  `apartment_country_name` VARCHAR(30) NOT NULL,
  `apartment_street_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`, `tenant_id`, `apartment_id`, `apartment_landlord_id`, `apartment_city_name`, `apartment_country_name`, `apartment_street_name`),
  CONSTRAINT `fk_reservation_apartment1`
    FOREIGN KEY (`apartment_id` , `apartment_landlord_id` , `apartment_city_name` , `apartment_country_name` , `apartment_street_name`)
    REFERENCES `Slyvka`.`apartment` (`id` , `landlord_id` , `city_name` , `country_name` , `street_name`),
  CONSTRAINT `fk_reservation_tenant1`
    FOREIGN KEY (`tenant_id`)
    REFERENCES `Slyvka`.`tenant` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- MY INDEXES
CREATE INDEX by_tenant_id ON Slyvka.reservation (`tenant_id`);
CREATE INDEX by_apartment_landlord_city_country_street ON Slyvka.reservation (apartment_id, apartment_landlord_id, apartment_city_name, apartment_country_name, apartment_street_name);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `Slyvka`.`country` (`name`) VALUES ('Australia');
INSERT INTO `Slyvka`.`country` (`name`) VALUES ('Austria');
INSERT INTO `Slyvka`.`country` (`name`) VALUES ('Germany');
INSERT INTO `Slyvka`.`country` (`name`) VALUES ('Luxemberg');
INSERT INTO `Slyvka`.`country` (`name`) VALUES ('Montenegro');
INSERT INTO `Slyvka`.`country` (`name`) VALUES ('Poland');
INSERT INTO `Slyvka`.`country` (`name`) VALUES ('Romania');
INSERT INTO `Slyvka`.`country` (`name`) VALUES ('Swiss');
INSERT INTO `Slyvka`.`country` (`name`) VALUES ('Ukraine');
INSERT INTO `Slyvka`.`country` (`name`) VALUES ('USA');

INSERT INTO `Slyvka`.`city` (`name`) VALUES ('Adis-Abeba');
INSERT INTO `Slyvka`.`city` (`name`) VALUES ('Budva');
INSERT INTO `Slyvka`.`city` (`name`) VALUES ('Chernivtsi');
INSERT INTO `Slyvka`.`city` (`name`) VALUES ('Kharkiv');
INSERT INTO `Slyvka`.`city` (`name`) VALUES ('Kyiv');
INSERT INTO `Slyvka`.`city` (`name`) VALUES ('London');
INSERT INTO `Slyvka`.`city` (`name`) VALUES ('Lviv');
INSERT INTO `Slyvka`.`city` (`name`) VALUES ('New York');
INSERT INTO `Slyvka`.`city` (`name`) VALUES ('Paris');
INSERT INTO `Slyvka`.`city` (`name`) VALUES ('Poltava');
INSERT INTO `Slyvka`.`city` (`name`) VALUES ('Tashkent');
INSERT INTO `Slyvka`.`city` (`name`) VALUES ('Tokyo');

INSERT INTO `Slyvka`.`street` (`name`) VALUES ('Gerojiv UPA');
INSERT INTO `Slyvka`.`street` (`name`) VALUES ('Golovna');
INSERT INTO `Slyvka`.`street` (`name`) VALUES ('Gorodotska');
INSERT INTO `Slyvka`.`street` (`name`) VALUES ('Naukova');
INSERT INTO `Slyvka`.`street` (`name`) VALUES ('Poletajeva');
INSERT INTO `Slyvka`.`street` (`name`) VALUES ('Prospekt Chervonpji Kalyny');
INSERT INTO `Slyvka`.`street` (`name`) VALUES ('Shevchenka');
INSERT INTO `Slyvka`.`street` (`name`) VALUES ('Stepana Bandery');
INSERT INTO `Slyvka`.`street` (`name`) VALUES ('Universytetska');
INSERT INTO `Slyvka`.`street` (`name`) VALUES ('Zaliznychna');
INSERT INTO `Slyvka`.`street` (`name`) VALUES ('Zavodska');

INSERT INTO `Slyvka`.`landlord` (`id`, `name`, `surname`, `money_balance`) VALUES ('18', 'Garik', 'Morozov', '53000.00');
INSERT INTO `Slyvka`.`landlord` (`id`, `name`, `surname`, `money_balance`) VALUES ('19', 'Yaroslav', 'Yurijchuck', '136050.45');
INSERT INTO `Slyvka`.`landlord` (`id`, `name`, `surname`, `money_balance`) VALUES ('20', 'Sergio', 'Feduchini', '23000.00');
INSERT INTO `Slyvka`.`landlord` (`id`, `name`, `surname`, `money_balance`) VALUES ('21', 'Pavlo', 'Slyvka', '78000.00');
INSERT INTO `Slyvka`.`landlord` (`id`, `name`, `surname`, `money_balance`) VALUES ('22', 'Taras', 'Dobryj', '12000.00');
INSERT INTO `Slyvka`.`landlord` (`id`, `name`, `surname`, `money_balance`) VALUES ('23', 'Dima', 'Unstoppable', '450000.13');
INSERT INTO `Slyvka`.`landlord` (`id`, `name`, `surname`, `money_balance`) VALUES ('24', 'Kat', 'Kruger', '42000.00');
INSERT INTO `Slyvka`.`landlord` (`id`, `name`, `surname`, `money_balance`) VALUES ('25', 'Oleksandr', 'Victorious', '300.00');
INSERT INTO `Slyvka`.`landlord` (`id`, `name`, `surname`, `money_balance`) VALUES ('26', 'Denys', 'Nakonechnyj', '560.00');
INSERT INTO `Slyvka`.`landlord` (`id`, `name`, `surname`, `money_balance`) VALUES ('27', 'Garfild', 'Cat', '670450.00');

INSERT INTO `Slyvka`.`tenant` (`id`, `name`, `surname`, `money_balance`) VALUES ('1', 'Bill', 'Gates', '3000.00');
INSERT INTO `Slyvka`.`tenant` (`id`, `name`, `surname`, `money_balance`) VALUES ('2', 'Leonardo', 'DiCaprio', '57000.00');
INSERT INTO `Slyvka`.`tenant` (`id`, `name`, `surname`, `money_balance`) VALUES ('3', 'Arnold', 'Schwarzeneger', '78090.50');
INSERT INTO `Slyvka`.`tenant` (`id`, `name`, `surname`, `money_balance`) VALUES ('4', 'Christofor', 'Columb', '456000.00');
INSERT INTO `Slyvka`.`tenant` (`id`, `name`, `surname`, `money_balance`) VALUES ('5', 'Daniel', 'Radcliffe', '101000.00');
INSERT INTO `Slyvka`.`tenant` (`id`, `name`, `surname`, `money_balance`) VALUES ('6', 'Stirlitz', 'Stirlitz', '2000.00');
INSERT INTO `Slyvka`.`tenant` (`id`, `name`, `surname`, `money_balance`) VALUES ('7', 'James', 'Bond', '5000000.00');
INSERT INTO `Slyvka`.`tenant` (`id`, `name`, `surname`, `money_balance`) VALUES ('8', 'Christopher', 'Nolan', '340000.00');
INSERT INTO `Slyvka`.`tenant` (`id`, `name`, `surname`, `money_balance`) VALUES ('9', 'Rayan', 'Reynolds', '500100.00');
INSERT INTO `Slyvka`.`tenant` (`id`, `name`, `surname`, `money_balance`) VALUES ('10', 'Jonny', 'Depp', '40000.00');

INSERT INTO `Slyvka`.`apartment` (`area`, `number_of_room`, `feedback`, `rating`, `landlord_id`, `city_name`, `country_name`, `street_name`) 
VALUES ('47', '2', 'Wonderful!', '4.7', '18', 'Chernivtsi', 'Ukraine', 'Golovna');
INSERT INTO `Slyvka`.`apartment` (`area`, `number_of_room`, `feedback`, `rating`, `landlord_id`, `city_name`, `country_name`, `street_name`) 
VALUES ('47', '2', 'graet!', '4.7', '18', 'Chernivtsi', 'Ukraine', 'Poletajeva');
INSERT INTO `Slyvka`.`apartment` (`area`, `number_of_room`, `feedback`, `rating`, `landlord_id`, `city_name`, `country_name`, `street_name`) 
VALUES ('407', '20', 'cool!', '3.7', '19', 'Poltava', 'Ukraine', 'Golovna');
INSERT INTO `Slyvka`.`apartment` (`area`, `number_of_room`, `feedback`, `rating`, `landlord_id`, `city_name`, `country_name`, `street_name`) 
VALUES ('120', '4', 'awesome!', '4.7', '27', 'Kharkiv', 'Ukraine', 'Poletajeva');
INSERT INTO `Slyvka`.`apartment` (`area`, `number_of_room`, `feedback`, `rating`, `landlord_id`, `city_name`, `country_name`, `street_name`) 
VALUES ('47', '2', 'Wonderful!', '4.7', '18', 'Budva', 'Montenegro', 'Gorodotska');
INSERT INTO `Slyvka`.`apartment` (`area`, `number_of_room`, `feedback`, `rating`, `landlord_id`, `city_name`, `country_name`, `street_name`) 
VALUES ('67', '3', 'nice!', '4.5', '22', 'Chernivtsi', 'Ukraine', 'Golovna');
INSERT INTO `Slyvka`.`apartment` (`area`, `number_of_room`, `feedback`, `rating`, `landlord_id`, `city_name`, `country_name`, `street_name`) 
VALUES ('47', '2', 'Wonderful!', '4.7', '18', 'Poltava', 'Ukraine', 'Gerojiv UPA');
INSERT INTO `Slyvka`.`apartment` (`area`, `number_of_room`, `feedback`, `rating`, `landlord_id`, `city_name`, `country_name`, `street_name`) 
VALUES ('47', '2', 'graet!', '4.7', '18', 'Kyiv', 'Ukraine', 'Poletajeva');
INSERT INTO `Slyvka`.`apartment` (`area`, `number_of_room`, `feedback`, `rating`, `landlord_id`, `city_name`, `country_name`, `street_name`) 
VALUES ('47', '2', 'Wonderful!', '4.7', '18', 'Chernivtsi', 'Ukraine', 'Golovna');
INSERT INTO `Slyvka`.`apartment` (`area`, `number_of_room`, `feedback`, `rating`, `landlord_id`, `city_name`, `country_name`, `street_name`) 
VALUES ('33', '1', 'just a dream!', '5.0', '25', 'Lviv', 'Ukraine', 'Zaliznychna');

INSERT INTO `Slyvka`.`reservation` (`beginning_date`, `ending_date`, `is_arranged`, `tenant_id`, `apartment_id`, `apartment_landlord_id`, `apartment_city_name`, `apartment_country_name`, `apartment_street_name`) 
VALUES ('1900-01-01 00:00:00', '1900-01-01', '1', '10', '4', '18', 'Chernivtsi', 'Ukraine', 'Golovna');
INSERT INTO `Slyvka`.`reservation` (`beginning_date`, `ending_date`, `is_arranged`, `tenant_id`, `apartment_id`, `apartment_landlord_id`, `apartment_city_name`, `apartment_country_name`, `apartment_street_name`) 
VALUES ('2021-10-12', '2021-10-13', '1', '10', '5', '18', 'Chernivtsi', 'Ukraine', 'Poletajeva');
INSERT INTO `Slyvka`.`reservation` (`beginning_date`, `ending_date`, `is_arranged`, `tenant_id`, `apartment_id`, `apartment_landlord_id`, `apartment_city_name`, `apartment_country_name`, `apartment_street_name`) 
VALUES ('2021-08-03 00:00:00', '2021-09-01', '1', '9', '6', '19', 'Poltava', 'Ukraine', 'Golovna');
INSERT INTO `Slyvka`.`reservation` (`beginning_date`, `ending_date`, `is_arranged`, `tenant_id`, `apartment_id`, `apartment_landlord_id`, `apartment_city_name`, `apartment_country_name`, `apartment_street_name`) 
VALUES ('1900-01-01 00:00:00', '1900-01-01', '1', '5', '7', '27', 'Kharkiv', 'Ukraine', 'Poletajeva');
INSERT INTO `Slyvka`.`reservation` (`beginning_date`, `ending_date`, `is_arranged`, `tenant_id`, `apartment_id`, `apartment_landlord_id`, `apartment_city_name`, `apartment_country_name`, `apartment_street_name`)
 VALUES ('2021-10-12', '2021-10-13', '1', '10', '8', '18', 'Budva', 'Montenegro', 'Gorodotska');
INSERT INTO `Slyvka`.`reservation` (`beginning_date`, `ending_date`, `is_arranged`, `tenant_id`, `apartment_id`, `apartment_landlord_id`, `apartment_city_name`, `apartment_country_name`, `apartment_street_name`) 
VALUES ('2021-08-03 00:00:00', '2021-09-01', '1', '9', '9', '22', 'Chernivtsi', 'Ukraine', 'Golovna');

INSERT INTO `Slyvka`.`money_transfer` (`time`, `money`, `is_sent`, `may_be_recieved`, `is_recieved`, `landlord_id`, `tenant_id`) VALUES ('2021-10-10 20:20:15', '500', '1', '1', '1', '18', '1');
INSERT INTO `Slyvka`.`money_transfer` (`time`, `money`, `is_sent`, `may_be_recieved`, `is_recieved`, `landlord_id`, `tenant_id`) 
VALUES ('2021-11-15 20:21:20', '700', '1', '1', '0', '20', '3');
INSERT INTO `Slyvka`.`money_transfer` (`time`, `money`, `is_sent`, `may_be_recieved`, `is_recieved`, `landlord_id`, `tenant_id`) 
VALUES ('2021-10-11 20:08:10', '230', '1', '0', '0', '19', '2');
INSERT INTO `Slyvka`.`money_transfer` (`time`, `money`, `is_sent`, `may_be_recieved`, `is_recieved`, `landlord_id`, `tenant_id`) 
VALUES ('2021-10-11 10:48:13', '360', '0', '0', '0', '21', '4');
INSERT INTO `Slyvka`.`money_transfer` (`time`, `money`, `is_sent`, `may_be_recieved`, `is_recieved`, `landlord_id`, `tenant_id`) 
VALUES ('2021-09-11 23:59:59', '3000', '1', '1', '0', '19', '5');
INSERT INTO `Slyvka`.`money_transfer` (`time`, `money`, `is_sent`, `may_be_recieved`, `is_recieved`, `landlord_id`, `tenant_id`) 
VALUES ('2021-10-11 20:08:10', '230', '1', '0', '0', '27', '10');
INSERT INTO `Slyvka`.`money_transfer` (`time`, `money`, `is_sent`, `may_be_recieved`, `is_recieved`, `landlord_id`, `tenant_id`) 
VALUES ('2021-10-11 20:08:10', '680', '1', '0', '0', '23', '6');
INSERT INTO `Slyvka`.`money_transfer` (`time`, `money`, `is_sent`, `may_be_recieved`, `is_recieved`, `landlord_id`, `tenant_id`) 
VALUES ('2021-12-11 20:54:10', '230', '1', '0', '0', '21', '8');
INSERT INTO `Slyvka`.`money_transfer` (`time`, `money`, `is_sent`, `may_be_recieved`, `is_recieved`, `landlord_id`, `tenant_id`) 
VALUES ('2020-06-11 20:08:10', '500000', '1', '0', '0', '25', '7');

INSERT INTO `Slyvka`.`photo` (`link`, `apartment_id`, `apartment_landlord_id`, `apartment_city_name`, `apartment_country_name`, `apartment_street_name`) VALUES ('https//kek.com/3434r5rgtrr', '5', '18', 'Chernivtsi', 'Ukraine', 'Poletajeva');
INSERT INTO `Slyvka`.`photo` (`link`, `apartment_id`, `apartment_landlord_id`, `apartment_city_name`, `apartment_country_name`, `apartment_street_name`) 
VALUES ('https//kek.com/34049bg8b0f5rgtrr', '4', '18', 'Chernivtsi', 'Ukraine', 'Golovna');
INSERT INTO `Slyvka`.`photo` (`link`, `apartment_id`, `apartment_landlord_id`, `apartment_city_name`, `apartment_country_name`, `apartment_street_name`) 
VALUES ('https//kek.com/4rejktj54fj45k', '6', '19', 'Poltava', 'Ukraine', 'Golovna');
INSERT INTO `Slyvka`.`photo` (`link`, `apartment_id`, `apartment_landlord_id`, `apartment_city_name`, `apartment_country_name`, `apartment_street_name`) 
VALUES ('https//kek.com/gfklfdvfo856968', '7', '27', 'Kharkiv', 'Ukraine', 'Poletajeva');
INSERT INTO `Slyvka`.`photo` (`link`, `apartment_id`, `apartment_landlord_id`, `apartment_city_name`, `apartment_country_name`, `apartment_street_name`) 
VALUES ('https//kek.com/fjdfo658659', '8', '18', 'Budva', 'Montenegro', 'Gorodotska');
