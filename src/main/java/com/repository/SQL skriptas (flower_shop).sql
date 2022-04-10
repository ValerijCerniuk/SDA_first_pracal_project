-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema flower_shop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema flower_shop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `flower_shop` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `flower_shop` ;

-- -----------------------------------------------------
-- Table `flower_shop`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flower_shop`.`customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `billing_address` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `full_name` VARCHAR(255) NULL DEFAULT NULL,
  `phone_number` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `flower_shop`.`flowers_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flower_shop`.`flowers_order` (
  `flower_order_id` INT NOT NULL AUTO_INCREMENT,
  `order_date` VARCHAR(255) NULL DEFAULT NULL,
  `order_deadline_date` VARCHAR(255) NULL DEFAULT NULL,
  `customer_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`flower_order_id`),
  INDEX `FK8ci6vlbhil9yedq1mgyelp8a` (`customer_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `flower_shop`.`flower`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flower_shop`.`flower` (
  `flower_id` INT NOT NULL AUTO_INCREMENT,
  `flower_price` INT NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `flower_order_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`flower_id`),
  INDEX `FKl59jidfxbvl2d4049uiet10aa` (`flower_order_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
