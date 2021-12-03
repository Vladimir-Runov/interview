
CREATE DATABASE `les_i` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `tfilmduration` (
  `pk` int unsigned NOT NULL AUTO_INCREMENT,
  `DurationMinutes` float unsigned NOT NULL,
  PRIMARY KEY (`pk`),
  UNIQUE KEY `pk_UNIQUE` (`pk`),
  UNIQUE KEY `DurationMinutes_UNIQUE` (`DurationMinutes`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `les_i`.`tsrarttimes` (
  `pk` INT NOT NULL AUTO_INCREMENT,
  `SrartTime` TIME NULL,
  PRIMARY KEY (`pk`),
  UNIQUE INDEX `pk_UNIQUE` (`pk` ASC) VISIBLE,
  UNIQUE INDEX `SrartTime_UNIQUE` (`SrartTime` ASC) VISIBLE);

CREATE TABLE `les_i`.`tfilms` (
  `pk` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `year` INT NULL,
  `pkDuration` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`pk`),
  UNIQUE INDEX `pk_UNIQUE` (`pk` ASC) VISIBLE,
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC) VISIBLE,
  INDEX `pkDuration_idx` (`pkDuration` ASC) VISIBLE,
  CONSTRAINT `pkDuration`
    FOREIGN KEY (`pkDuration`)
    REFERENCES `les_i`.`tfilmduration` (`pk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `les_i`.`tticketprices` (
  `pk` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Price` FLOAT NOT NULL,
  PRIMARY KEY (`pk`));

CREATE TABLE `les_i`.`ttickets` (
  `pk` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `ID` VARCHAR(45) NOT NULL,
  `DateStamp` DATETIME NOT NULL,
  `pkFilmTime` INT UNSIGNED NOT NULL,
  `pkFilm` INT UNSIGNED NOT NULL,
  `pkPrce` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`pk`),
  INDEX `pkPrice_idx` (`pkPrce` ASC) VISIBLE,
  INDEX `pkFilm_idx` (`pkFilm` ASC) VISIBLE,
  INDEX `pkFilmSeansTime_idx` (`pkFilmTime` ASC) VISIBLE,
  CONSTRAINT `pkPrice`
    FOREIGN KEY (`pkPrce`)
    REFERENCES `les_i`.`tticketprices` (`pk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pkFilm`
    FOREIGN KEY (`pkFilm`)
    REFERENCES `les_i`.`tfilms` (`pkDuration`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pkFilmSeansTime`
    FOREIGN KEY (`pkFilmTime`)
    REFERENCES `les_i`.`tsrarttimes` (`pk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

;


CREATE TABLE `les_i`.`tscedule` (
  `pk` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Film` INT UNSIGNED NOT NULL,
  `Time` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`pk`),
  UNIQUE INDEX `pk_UNIQUE` (`pk` ASC) VISIBLE,
  INDEX `Film_idx` (`Film` ASC) VISIBLE,
  INDEX `Time_idx` (`Time` ASC) VISIBLE,
  CONSTRAINT `Film`
    FOREIGN KEY (`Film`)
    REFERENCES `les_i`.`tfilms` (`pk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Time`
    FOREIGN KEY (`Time`)
    REFERENCES `les_i`.`tsrarttimes` (`pk`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = '	';



SELECT t.*, film.* , st.SrartTime, DATE_ADD(st.SrartTime, INTERVAL  dur.DurationMinutes  MINUTE) as Finish, dur.DurationMinutes
FROM les_i.ttickets as t
left join les_i.tfilms as film on film.pk = t.pkFilm
left join les_i.tfilmduration as dur on dur.pk = film.pkDuration
left join les_i.tsrarttimes as st on st.pk = t.pkFilmTime

order by st.SrartTime
/* CREATE TEMPORARY TABLE `tmp_table */
