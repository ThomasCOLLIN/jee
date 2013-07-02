SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `mangaDB` ;
CREATE SCHEMA IF NOT EXISTS `mangaDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mangaDB` ;

-- -----------------------------------------------------
-- Table `mangaDB`.`Manga`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mangaDB`.`Manga` ;

CREATE  TABLE IF NOT EXISTS `mangaDB`.`Manga` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NOT NULL ,
  `description` VARCHAR(200) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mangaDB`.`Chapter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mangaDB`.`Chapter` ;

CREATE  TABLE IF NOT EXISTS `mangaDB`.`Chapter` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `idManga` BIGINT NOT NULL ,
  `file_path` TEXT NOT NULL ,
  `rank` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `mangaId_idx` (`idManga` ASC) ,
  CONSTRAINT `fk_manga`
    FOREIGN KEY (`idManga` )
    REFERENCES `mangaDB`.`Manga` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mangaDB`.`Genre`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mangaDB`.`Genre` ;

CREATE  TABLE IF NOT EXISTS `mangaDB`.`Genre` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mangaDB`.`Type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mangaDB`.`Type` ;

CREATE  TABLE IF NOT EXISTS `mangaDB`.`Type` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `description` VARCHAR(200) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mangaDB`.`Author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mangaDB`.`Author` ;

CREATE  TABLE IF NOT EXISTS `mangaDB`.`Author` (
  `id` BIGINT NOT NULL AUTO_INCREMENT ,
  `firstname` VARCHAR(50) NOT NULL ,
  `lastname` VARCHAR(50) NOT NULL ,
  `typeId` MEDIUMTEXT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `typeId_idx` (`typeId` ASC) ,
  CONSTRAINT `fk_type`
    FOREIGN KEY (`typeId` )
    REFERENCES `mangaDB`.`Type` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mangaDB`.`MangaGenre`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mangaDB`.`MangaGenre` ;

CREATE  TABLE IF NOT EXISTS `mangaDB`.`MangaGenre` (
  `idManga` BIGINT NOT NULL ,
  `idGenre` BIGINT NOT NULL ,
  CONSTRAINT `pk_MangaGenre`
    PRIMARY KEY (`idManga`, `idGenre`) ,
  CONSTRAINT `fk_manga`
    FOREIGN KEY (`idManga` )
    REFERENCES `mangaDB`.`Manga` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_genre`
    FOREIGN KEY (`idGenre` )
    REFERENCES `mangaDB`.`Genre` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mangaDB`.`MangaAuthor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mangaDB`.`MangaAuthor` ;

CREATE  TABLE IF NOT EXISTS `mangaDB`.`MangaAuthor` (
  `idManga` BIGINT NOT NULL ,
  `idAuthor` BIGINT NOT NULL ,
  CONSTRAINT `pk_MangaAuthor`
    PRIMARY KEY (`idManga`, `idAuthor`) ,
  CONSTRAINT `fk_manga`
    FOREIGN KEY (`idManga` )
    REFERENCES `mangaDB`.`Manga` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_author`
    FOREIGN KEY (`idAuthor` )
    REFERENCES `mangaDB`.`Author` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mangaDB` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
