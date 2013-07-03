-- -----------------------------------------------------
-- Data for table `mangaDB`.`Manga`
-- -----------------------------------------------------
START TRANSACTION;
USE `mangaDB`;
INSERT INTO `mangaDB`.`Manga` (`name`, `description`) VALUES ('Hitsugime no Chaika', 'Toru Acura, an incredibly lazy man with some hidden talents, has been forced by his sister Akari to actually go outside and search for work.');
INSERT INTO `mangaDB`.`Manga` (`name`, `description`) VALUES ('Chocolat', 'Chocolat is a mature comedy series about halforphan Tatsumi Chiyoko whose father was caught in huge debt. Now living with Omugi Matsukichi.');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mangaDB`.`Chapter`
-- -----------------------------------------------------
START TRANSACTION;
USE `mangaDB`;
INSERT INTO `mangaDB`.`Chapter` (`idManga`, `file_path`, `number`) VALUES (1, 'http://dl.crazytje.be/dl.php?id=2h2lf5m6c9cv8lk2mka3tv6j37&file=51d1a283-ed80-4e2b-96b3-49fad0359e0c&lid=51d1a283-a22c-4c6a-be24-49fad0359e0c', 16);
INSERT INTO `mangaDB`.`Chapter` (`idManga`, `file_path`, `number`) VALUES (2, 'http://dl.crazytje.be/dl.php?id=2h2lf5m6c9cv8lk2mka3tv6j37&file=51d1a275-ef30-4714-b960-4686d0359e0c&lid=51d1a275-1a5c-4bcf-b050-4686d0359e0c', 60);

COMMIT;

-- -----------------------------------------------------
-- Data for table `mangaDB`.`Genre`
-- -----------------------------------------------------
START TRANSACTION;
USE `mangaDB`;
INSERT INTO `mangaDB`.`Genre` (`name`) VALUES ('Action');
INSERT INTO `mangaDB`.`Genre` (`name`) VALUES ('Comedy');
INSERT INTO `mangaDB`.`Genre` (`name`) VALUES ('Drama');
INSERT INTO `mangaDB`.`Genre` (`name`) VALUES ('Romance');
INSERT INTO `mangaDB`.`Genre` (`name`) VALUES ('Seinen');
INSERT INTO `mangaDB`.`Genre` (`name`) VALUES ('Adventure');
INSERT INTO `mangaDB`.`Genre` (`name`) VALUES ('Fantasy');
INSERT INTO `mangaDB`.`Genre` (`name`) VALUES ('Shonen');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mangaDB`.`Type`
-- -----------------------------------------------------
START TRANSACTION;
USE `mangaDB`;
INSERT INTO `mangaDB`.`Type` (`job`) VALUES ('Writter');
INSERT INTO `mangaDB`.`Type` (`job`) VALUES ('Drawer');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mangaDB`.`Author`
-- -----------------------------------------------------
START TRANSACTION;
USE `mangaDB`;
INSERT INTO `mangaDB`.`Author` (`firstname`, `lastname`, `typeId`) VALUES ('Ichirou', 'SAKAKI ', '1');
INSERT INTO `mangaDB`.`Author` (`firstname`, `lastname`, `typeId`) VALUES ('Eisaku', 'KUBONOUCHI', '2');

COMMIT;

-- -----------------------------------------------------
-- Data for table `mangaDB`.`MangaGenre`
-- -----------------------------------------------------
START TRANSACTION;
USE `mangaDB`;
INSERT INTO `mangaDB`.`MangaGenre` (`idManga`, `idGenre`) VALUES (1, 1);
INSERT INTO `mangaDB`.`MangaGenre` (`idManga`, `idGenre`) VALUES (1, 2);
INSERT INTO `mangaDB`.`MangaGenre` (`idManga`, `idGenre`) VALUES (1, 4);
INSERT INTO `mangaDB`.`MangaGenre` (`idManga`, `idGenre`) VALUES (1, 5);
INSERT INTO `mangaDB`.`MangaGenre` (`idManga`, `idGenre`) VALUES (2, 2);
INSERT INTO `mangaDB`.`MangaGenre` (`idManga`, `idGenre`) VALUES (2, 5);

COMMIT;

-- -----------------------------------------------------
-- Data for table `mangaDB`.`MangaAuthor`
-- -----------------------------------------------------
START TRANSACTION;
USE `mangaDB`;
INSERT INTO `mangaDB`.`MangaAuthor` (`idManga`, `idAuthor`) VALUES (1, 1);
INSERT INTO `mangaDB`.`MangaAuthor` (`idManga`, `idAuthor`) VALUES (2, 2);

COMMIT;
