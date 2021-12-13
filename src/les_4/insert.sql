
INSERT INTO `les_i`.`tfilmduration` (`pk`, `DurationMinutes`) VALUES ('1', '60');
INSERT INTO `les_i`.`tfilmduration` (`pk`, `DurationMinutes`) VALUES ('2', '90');
INSERT INTO `les_i`.`tfilmduration` (`pk`, `DurationMinutes`) VALUES ('3', '120');
;
INSERT INTO `les_i`.`tsrarttimes` (`SrartTime`) VALUES ('9:00');
INSERT INTO `les_i`.`tsrarttimes` (`SrartTime`) VALUES ('12:00');
INSERT INTO `les_i`.`tsrarttimes` (`SrartTime`) VALUES ('13:00');
INSERT INTO `les_i`.`tsrarttimes` (`SrartTime`) VALUES ('14:00');
INSERT INTO `les_i`.`tsrarttimes` (`SrartTime`) VALUES ('15:00');
INSERT INTO `les_i`.`tsrarttimes` (`SrartTime`) VALUES ('16:00');
INSERT INTO `les_i`.`tsrarttimes` (`SrartTime`) VALUES ('17:00');
INSERT INTO `les_i`.`tsrarttimes` (`SrartTime`) VALUES ('18:00');
INSERT INTO `les_i`.`tsrarttimes` (`SrartTime`) VALUES ('19:00');
INSERT INTO `les_i`.`tsrarttimes` (`SrartTime`) VALUES ('20:00');
INSERT INTO `les_i`.`tsrarttimes` (`SrartTime`) VALUES ('21:00');
INSERT INTO `les_i`.`tsrarttimes` (`SrartTime`) VALUES ('22:00');
INSERT INTO `les_i`.`tsrarttimes` (`SrartTime`) VALUES ('23:00');
;
INSERT INTO `les_i`.`tticketprices` (`Price`) VALUES ('100');
INSERT INTO `les_i`.`tticketprices` (`Price`) VALUES ('200');
INSERT INTO `les_i`.`tticketprices` (`Price`) VALUES ('300');
;
INSERT INTO `les_i`.`ttickets` (`ID`, `DateStamp`, `pkFilmTime`, `pkFilm`, `pkPrce`) VALUES ('0000001', '2021-10-11-23-33-33', '1', '2', '2');
INSERT INTO `les_i`.`ttickets` (`ID`, `DateStamp`, `pkFilmTime`, `pkFilm`, `pkPrce`) VALUES ('0000002', '2021-10-11-23-33-34', '2', '3', '1');
INSERT INTO `les_i`.`ttickets` (`ID`, `DateStamp`, `pkFilmTime`, `pkFilm`, `pkPrce`) VALUES ('0000003', '2021-10-11-23-33-35', '3', '1', '3');
INSERT INTO `les_i`.`ttickets` (`ID`, `DateStamp`, `pkFilmTime`, `pkFilm`, `pkPrce`) VALUES ('0000004', '2021-10-11-23-33-36', '2', '3', '1');
INSERT INTO `les_i`.`ttickets` (`ID`, `DateStamp`, `pkFilmTime`, `pkFilm`, `pkPrce`) VALUES ('0000005', '2021-10-11-23-33-40', '2', '1', '1');
INSERT INTO `les_i`.`ttickets` (`ID`, `DateStamp`, `pkFilmTime`, `pkFilm`, `pkPrce`) VALUES ('0000006', '2021-10-11-23-33-41', '5', '1', '2');
;
INSERT INTO `les_i`.`tscedule` (`Film`, `Time`) VALUES ('1', '2');
INSERT INTO `les_i`.`tscedule` (`Film`, `Time`) VALUES ('2', '4');
INSERT INTO `les_i`.`tscedule` (`Film`, `Time`) VALUES ('3', '1');




