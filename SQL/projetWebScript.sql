-- MySQL Script generated by MySQL Workbench
-- Mon Feb 21 19:11:52 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema projetWeb
-- -----------------------------------------------------
-- Base de donnees utilise pour le projet final de web 2
DROP SCHEMA IF EXISTS `projetWeb` ;

-- -----------------------------------------------------
-- Schema projetWeb
--
-- Base de donnees utilise pour le projet final de web 2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projetWeb` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `projetWeb` ;

-- -----------------------------------------------------
-- Table `projetWeb`.`clinique`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projetWeb`.`clinique` ;

CREATE TABLE IF NOT EXISTS `projetWeb`.`clinique` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `adresse` VARCHAR(45) NOT NULL,
  `tel` VARCHAR(45) NOT NULL,
  `services` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetWeb`.`medecin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projetWeb`.`medecin` ;

CREATE TABLE IF NOT EXISTS `projetWeb`.`medecin` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  `profession` VARCHAR(45) NOT NULL,
  `nbProfessionnel` VARCHAR(45) NOT NULL,
  `ententes` VARCHAR(45) NOT NULL,
  `adresse` VARCHAR(45) NOT NULL,
  `lieuProfession` VARCHAR(45) NOT NULL,
  `clinique_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_medecin_clinique_idx` (`clinique_id` ASC),
  CONSTRAINT `fk_medecin_clinique`
    FOREIGN KEY (`clinique_id`)
    REFERENCES `projetWeb`.`clinique` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetWeb`.`patient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projetWeb`.`patient` ;

CREATE TABLE IF NOT EXISTS `projetWeb`.`patient` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  `nam` VARCHAR(45) NOT NULL,
  `nbSequentiel` INT UNSIGNED NOT NULL,
  `dateNaissance` VARCHAR(45) NOT NULL,
  `sexe` CHAR(1) NOT NULL,
  `clinique_id` INT UNSIGNED NOT NULL,
  `medecin_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nam_UNIQUE` (`nam` ASC),
  UNIQUE INDEX `nbSequentiel_UNIQUE` (`nbSequentiel` ASC),
  INDEX `fk_patient_clinique1_idx` (`clinique_id` ASC),
  INDEX `fk_patient_medecin1_idx` (`medecin_id` ASC),
  CONSTRAINT `fk_patient_clinique1`
    FOREIGN KEY (`clinique_id`)
    REFERENCES `projetWeb`.`clinique` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_patient_medecin1`
    FOREIGN KEY (`medecin_id`)
    REFERENCES `projetWeb`.`medecin` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projetWeb`.`rendezVous`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `projetWeb`.`rendezVous` ;

CREATE TABLE IF NOT EXISTS `projetWeb`.`rendezVous` (
  `id` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `medecin_id` INT UNSIGNED NOT NULL,
  `patient_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rendezVous_medecin1_idx` (`medecin_id` ASC),
  INDEX `fk_rendezVous_patient1_idx` (`patient_id` ASC),
  CONSTRAINT `fk_rendezVous_medecin1`
    FOREIGN KEY (`medecin_id`)
    REFERENCES `projetWeb`.`medecin` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rendezVous_patient1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `projetWeb`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
