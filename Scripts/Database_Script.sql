
-- -----------------------------------------------------
-- Schema w4smvp3
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema w4smvp3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `w4smvp3` DEFAULT CHARACTER SET utf8 ;
USE `w4smvp3` ;

-- -----------------------------------------------------
-- Table `w4smvp3`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `w4smvp3`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(255) NOT NULL COMMENT 'This table save user information',
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `w4smvp3`.`car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `w4smvp3`.`car` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(255) NOT NULL,
  `model` VARCHAR(255) NULL,
  `year` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `w4smvp3`.`university`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `w4smvp3`.`university` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `w4smvp3`.`service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `w4smvp3`.`service` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `car_id` INT NOT NULL,
  `university_id` INT NOT NULL,
  `address` VARCHAR(255) NULL,
  `departure_time` TIMESTAMP NULL,
  `payment_type` VARCHAR(255) NULL,
  `space_available` INT(2) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_service_car_idx` (`car_id` ASC),
  INDEX `fk_service_university1_idx` (`university_id` ASC),
  CONSTRAINT `fk_service_car`
    FOREIGN KEY (`car_id`)
    REFERENCES `w4smvp3`.`car` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_university1`
    FOREIGN KEY (`university_id`)
    REFERENCES `w4smvp3`.`university` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `w4smvp3`.`car_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `w4smvp3`.`car_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `car_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`, `car_id`),
  INDEX `fk_car_user_user1_idx` (`user_id` ASC),
  INDEX `fk_car_user_car1_idx` (`car_id` ASC),
  UNIQUE INDEX `user_car_UNIQUE` (`user_id` ASC, `car_id` ASC),
  CONSTRAINT `fk_car_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `w4smvp3`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_car_user_car1`
    FOREIGN KEY (`car_id`)
    REFERENCES `w4smvp3`.`car` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `w4smvp3`.`service_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `w4smvp3`.`service_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `service_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_service_user_user1_idx` (`user_id` ASC),
  INDEX `fk_service_user_service1_idx` (`service_id` ASC),
  UNIQUE INDEX `user_service_UNIQUE` (`user_id` ASC, `service_id` ASC),
  CONSTRAINT `fk_service_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `w4smvp3`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_user_service1`
    FOREIGN KEY (`service_id`)
    REFERENCES `w4smvp3`.`service` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
