DROP TABLE IF EXISTS `cinescope2017`.`appreciation`;
CREATE TABLE  `cinescope2017`.`appreciation` (
  `ID_appreciation` int(11) NOT NULL AUTO_INCREMENT,
  `ETOILE` varchar(5) NOT NULL,
  `LIBELLE_appreciation` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_appreciation`),
  UNIQUE KEY `Index_etoile_unique` (`ETOILE`),
  UNIQUE KEY `Index_appreciation_unique` (`LIBELLE_appreciation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`apprecier`;
CREATE TABLE  `cinescope2017`.`apprecier` (
  `ID_media` int(11) NOT NULL,
  `ID_film` int(11) NOT NULL,
  `ID_appreciation` int(11) NOT NULL,
  PRIMARY KEY (`ID_media`,`ID_film`),
  KEY `FK_appreciationapprecier` (`ID_appreciation`),
  KEY `FK_mediaapprecier_film` (`ID_film`),
  CONSTRAINT `FK_appreciationapprecier` FOREIGN KEY (`ID_appreciation`) REFERENCES `appreciation` (`ID_appreciation`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_mediaapprecier_film` FOREIGN KEY (`ID_film`) REFERENCES `film` (`ID_film`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_mediaapprecier_media` FOREIGN KEY (`ID_media`) REFERENCES `media` (`ID_media`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`arrondissement`;
CREATE TABLE  `cinescope2017`.`arrondissement` (
  `ID_arrondissement` int(11) NOT NULL AUTO_INCREMENT,
  `CODE_arrondissement` varchar(5) NOT NULL,
  `NOM_arrondissement` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_arrondissement`),
  UNIQUE KEY `Index_code_arrond_unique` (`CODE_arrondissement`),
  UNIQUE KEY `Index_arrond_nom_unique` (`NOM_arrondissement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`article`;
CREATE TABLE  `cinescope2017`.`article` (
  `ID_article` int(11) NOT NULL AUTO_INCREMENT,
  `ID_journaliste` int(11) NOT NULL,
  `ID_film` int(11) DEFAULT NULL,
  `TITRE_article` varchar(50) NOT NULL,
  `TEXTE_article` varchar(50) NOT NULL,
  `PHOTO_article` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_article`),
  KEY `FK_filmarticle` (`ID_film`),
  KEY `FK_journalistearticle` (`ID_journaliste`),
  CONSTRAINT `FK_filmarticle` FOREIGN KEY (`ID_film`) REFERENCES `film` (`ID_film`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_journalistearticle` FOREIGN KEY (`ID_journaliste`) REFERENCES `journaliste` (`ID_journaliste`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`artiste`;
CREATE TABLE  `cinescope2017`.`artiste` (
  `ID_artiste` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_artiste` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_artiste`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`cinema`;
CREATE TABLE  `cinescope2017`.`cinema` (
  `ID_cinema` int(11) NOT NULL AUTO_INCREMENT,
  `ID_ville` int(11) DEFAULT NULL,
  `ID_arrondissement` int(11) DEFAULT NULL,
  `CODE_cinema` varchar(10) NOT NULL,
  `NOM_cinema` varchar(50) NOT NULL,
  `ADRESSE_cinema` varchar(100) DEFAULT NULL,
  `TELEPHONE_cinema` varchar(50) DEFAULT NULL,
  `TARIFS_cinema` varchar(100) DEFAULT NULL,
  `DIVERS_cinema` varchar(100) DEFAULT NULL,
  `RESEAU_cinema` varchar(50) DEFAULT NULL,
  `ACCES_HANDICAPES` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_cinema`),
  UNIQUE KEY `CODE_cinema` (`CODE_cinema`),
  KEY `FK_cinemaarrondissement` (`ID_arrondissement`),
  KEY `FK_cinemaville` (`ID_ville`),
  CONSTRAINT `FK_cinemaarrondissement` FOREIGN KEY (`ID_arrondissement`) REFERENCES `arrondissement` (`ID_arrondissement`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_cinemaville` FOREIGN KEY (`ID_ville`) REFERENCES `ville` (`ID_ville`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`departement`;
CREATE TABLE  `cinescope2017`.`departement` (
  `ID_departement` int(11) NOT NULL AUTO_INCREMENT,
  `CODE_departement` char(3) NOT NULL,
  `NOM_departement` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_departement`),
  UNIQUE KEY `Index_code_departement_unique` (`CODE_departement`),
  UNIQUE KEY `Index_nom_departement_unique` (`NOM_departement`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`festival`;
CREATE TABLE  `cinescope2017`.`festival` (
  `ID_festival` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_festival` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`ID_festival`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`film`;
CREATE TABLE  `cinescope2017`.`film` (
  `ID_film` int(11) NOT NULL AUTO_INCREMENT,
  `ID_genre` int(11) NOT NULL,
  `TITRE_film` varchar(50) NOT NULL,
  `TITRE_ORIGINAL` varchar(50) DEFAULT NULL,
  `TOTAL_ENTREES` decimal(10,0) DEFAULT NULL,
  `DATE_SORTIE` date DEFAULT NULL,
  `ENTREES_SEMAINE` decimal(10,0) DEFAULT NULL,
  `NOMBRE_SEMAINES` decimal(5,0) DEFAULT NULL,
  `ANNEE` decimal(4,0) DEFAULT NULL,
  `DUREE` varchar(10) DEFAULT NULL,
  `CONDENSE` varchar(1000) DEFAULT NULL,
  `COULEURS` varchar(20) DEFAULT NULL,
  `INTERDICTION_film` int(11) DEFAULT NULL,
  `PUBLIC_film` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_film`),
  KEY `FK_filmgenre` (`ID_genre`),
  CONSTRAINT `FK_filmgenre` FOREIGN KEY (`ID_genre`) REFERENCES `genre` (`ID_genre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`film_festival`;
CREATE TABLE  `cinescope2017`.`film_festival` (
  `ID_film` int(11) NOT NULL,
  `ID_festival` int(11) NOT NULL,
  PRIMARY KEY (`ID_film`,`ID_festival`),
  KEY `FK_filmfestival_festival` (`ID_festival`),
  CONSTRAINT `FK_filmfestival_festival` FOREIGN KEY (`ID_festival`) REFERENCES `festival` (`ID_festival`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_filmfestival_film` FOREIGN KEY (`ID_film`) REFERENCES `film` (`ID_film`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`film_rubrique`;
CREATE TABLE  `cinescope2017`.`film_rubrique` (
  `id_film` int(11) NOT NULL,
  `id_rubrique` int(11) NOT NULL,
  PRIMARY KEY (`id_film`,`id_rubrique`),
  KEY `id_rubrique` (`id_rubrique`),
  CONSTRAINT `film_rubrique_ibfk_1` FOREIGN KEY (`id_film`) REFERENCES `film` (`ID_film`),
  CONSTRAINT `film_rubrique_ibfk_2` FOREIGN KEY (`id_rubrique`) REFERENCES `rubrique` (`ID_rubrique`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`genre`;
CREATE TABLE  `cinescope2017`.`genre` (
  `ID_genre` int(11) NOT NULL AUTO_INCREMENT,
  `CODE_genre` char(2) NOT NULL,
  `LIBELLE_genre` varchar(50) NOT NULL,
  `genre_GRAMMATICAL` char(1) NOT NULL,
  PRIMARY KEY (`ID_genre`),
  UNIQUE KEY `Index_code_genre_unique` (`CODE_genre`),
  UNIQUE KEY `Index_libelle_genre_unique` (`LIBELLE_genre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`jouer`;
CREATE TABLE  `cinescope2017`.`jouer` (
  `ID_artiste` int(11) NOT NULL,
  `ID_film` int(11) NOT NULL,
  `RANG_ACTEUR` decimal(2,0) DEFAULT NULL,
  `VOIX` char(1) DEFAULT NULL,
  PRIMARY KEY (`ID_artiste`,`ID_film`),
  KEY `FK_film_ACTEUR` (`ID_film`),
  CONSTRAINT `FK_ACTEUR` FOREIGN KEY (`ID_artiste`) REFERENCES `artiste` (`ID_artiste`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_film_ACTEUR` FOREIGN KEY (`ID_film`) REFERENCES `film` (`ID_film`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`journaliste`;
CREATE TABLE  `cinescope2017`.`journaliste` (
  `ID_journaliste` int(11) NOT NULL AUTO_INCREMENT,
  `ID_media` int(11) NOT NULL,
  `NOM_journaliste` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_journaliste`),
  UNIQUE KEY `Index_nom_journaliste_unique` (`NOM_journaliste`),
  KEY `FK_journalistemedia` (`ID_media`),
  CONSTRAINT `FK_journalistemedia` FOREIGN KEY (`ID_media`) REFERENCES `media` (`ID_media`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`media`;
CREATE TABLE  `cinescope2017`.`media` (
  `ID_media` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_media` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`ID_media`),
  UNIQUE KEY `Index_media_unique` (`NOM_media`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`pays`;
CREATE TABLE  `cinescope2017`.`pays` (
  `ID_pays` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_pays` varchar(50) NOT NULL,
  `MASCULIN` varchar(50) NOT NULL,
  `FEMININ` varchar(50) NOT NULL,
  `NEUTRE` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_pays`),
  UNIQUE KEY `Index_pays_unique` (`NOM_pays`),
  UNIQUE KEY `Index_pays_masculin_unique` (`MASCULIN`),
  UNIQUE KEY `Index_pays_feminin_unique` (`FEMININ`),
  UNIQUE KEY `Index_pays_neutre_unique` (`NEUTRE`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`produire`;
CREATE TABLE  `cinescope2017`.`produire` (
  `ID_pays` int(11) NOT NULL,
  `ID_film` int(11) NOT NULL,
  `RANG_PRODUCTION` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`ID_pays`,`ID_film`),
  KEY `FK_produire_film` (`ID_film`),
  CONSTRAINT `FK_produire_film` FOREIGN KEY (`ID_film`) REFERENCES `film` (`ID_film`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_produire_pays` FOREIGN KEY (`ID_pays`) REFERENCES `pays` (`ID_pays`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`projeter`;
CREATE TABLE  `cinescope2017`.`projeter` (
  `ID_film` int(11) NOT NULL,
  `ID_salle` int(11) NOT NULL,
  `VERSION_PROJECTION` char(2) DEFAULT NULL,
  `HORAIRES_PROJECTION` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_film`,`ID_salle`),
  KEY `FK_projeter_salle` (`ID_salle`),
  CONSTRAINT `FK_projeter_film` FOREIGN KEY (`ID_film`) REFERENCES `film` (`ID_film`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_projeter_salle` FOREIGN KEY (`ID_salle`) REFERENCES `salle` (`ID_salle`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`realiser`;
CREATE TABLE  `cinescope2017`.`realiser` (
  `ID_artiste` int(11) NOT NULL,
  `ID_film` int(11) NOT NULL,
  `RANG_REALISATEUR` int(11) NOT NULL,
  PRIMARY KEY (`ID_artiste`,`ID_film`),
  KEY `FK_realiser_film` (`ID_film`),
  CONSTRAINT `FK_realiser_artiste` FOREIGN KEY (`ID_artiste`) REFERENCES `artiste` (`ID_artiste`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_realiser_film` FOREIGN KEY (`ID_film`) REFERENCES `film` (`ID_film`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`rubrique`;
CREATE TABLE  `cinescope2017`.`rubrique` (
  `ID_rubrique` int(11) NOT NULL AUTO_INCREMENT,
  `CODE_rubrique` char(2) NOT NULL,
  `INTITULE_rubrique` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_rubrique`),
  UNIQUE KEY `Index_code_rubrique_unique` (`CODE_rubrique`),
  UNIQUE KEY `Index_intitule_rubrique_unique` (`INTITULE_rubrique`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`salle`;
CREATE TABLE  `cinescope2017`.`salle` (
  `ID_salle` int(11) NOT NULL AUTO_INCREMENT,
  `ID_cinema` int(11) NOT NULL,
  `ID_festival` int(11) DEFAULT NULL,
  `NOM_salle` varchar(50) DEFAULT NULL,
  `DESCRIPTION_salle` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_salle`),
  KEY `FK_sallecinema` (`ID_cinema`),
  KEY `FK_sallefestival_festival` (`ID_festival`),
  CONSTRAINT `FK_sallecinema` FOREIGN KEY (`ID_cinema`) REFERENCES `cinema` (`ID_cinema`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`situer_metro`;
CREATE TABLE  `cinescope2017`.`situer_metro` (
  `ID_cinema` int(11) NOT NULL,
  `ID_station_metro` int(11) NOT NULL,
  PRIMARY KEY (`ID_cinema`,`ID_station_metro`),
  KEY `FK_SITUERMETRO_metro` (`ID_station_metro`),
  CONSTRAINT `FK_SITUERMETRO_cinema` FOREIGN KEY (`ID_cinema`) REFERENCES `cinema` (`ID_cinema`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SITUERMETRO_metro` FOREIGN KEY (`ID_station_metro`) REFERENCES `station_metro` (`ID_station_metro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`station_metro`;
CREATE TABLE  `cinescope2017`.`station_metro` (
  `ID_station_metro` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_station_metro` varchar(254) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  PRIMARY KEY (`ID_station_metro`),
  UNIQUE KEY `Index_nom_station_unique` (`NOM_station_metro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`utilisateurs`;
CREATE TABLE  `cinescope2017`.`utilisateurs` (
  `pseudo` varchar(45) NOT NULL,
  `mdp` varchar(45) NOT NULL,
  PRIMARY KEY (`pseudo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cinescope2017`.`ville`;
CREATE TABLE  `cinescope2017`.`ville` (
  `ID_ville` int(11) NOT NULL AUTO_INCREMENT,
  `ID_departement` int(11) NOT NULL,
  `CP` char(5) NOT NULL,
  `NOM_ville` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_ville`),
  KEY `FK_villedepartement` (`ID_departement`),
  CONSTRAINT `FK_villedepartement` FOREIGN KEY (`ID_departement`) REFERENCES `departement` (`ID_departement`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP VIEW IF EXISTS `cinescope2017`.`cinemas_paris`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW  `cinescope2017`.`cinemas_paris` AS select 1 AS `ID_cinema`,1 AS `ID_ville`,1 AS `ID_arrondissement`,1 AS `CODE_cinema`,1 AS `NOM_cinema`,1 AS `ADRESSE_cinema`,1 AS `TELEPHONE_cinema`,1 AS `TARIFS_cinema`,1 AS `DIVERS_cinema`,1 AS `RESEAU_cinema`,1 AS `ACCES_HANDICAPES`;

DROP VIEW IF EXISTS `cinescope2017`.`cinemas_peripherie`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW  `cinescope2017`.`cinemas_peripherie` AS select 1 AS `ID_cinema`,1 AS `ID_ville`,1 AS `ID_arrondissement`,1 AS `CODE_cinema`,1 AS `NOM_cinema`,1 AS `ADRESSE_cinema`,1 AS `TELEPHONE_cinema`,1 AS `TARIFS_cinema`,1 AS `DIVERS_cinema`,1 AS `RESEAU_cinema`,1 AS `ACCES_HANDICAPES`;

DROP VIEW IF EXISTS `cinescope2017`.`films_autres`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW  `cinescope2017`.`films_autres` AS select 1 AS `ID_film`,1 AS `ID_genre`,1 AS `TITRE_film`,1 AS `TITRE_ORIGINAL`,1 AS `TOTAL_ENTREES`,1 AS `DATE_SORTIE`,1 AS `ENTREES_SEMAINE`,1 AS `NOMBRE_SEMAINES`,1 AS `ANNEE`,1 AS `DUREE`,1 AS `CONDENSE`,1 AS `COULEURS`,1 AS `INTERDICTION_film`,1 AS `PUBLIC_film`;

DROP VIEW IF EXISTS `cinescope2017`.`films_nouveaux`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW  `cinescope2017`.`films_nouveaux` AS select 1 AS `ID_film`,1 AS `ID_genre`,1 AS `TITRE_film`,1 AS `TITRE_ORIGINAL`,1 AS `TOTAL_ENTREES`,1 AS `DATE_SORTIE`,1 AS `ENTREES_SEMAINE`,1 AS `NOMBRE_SEMAINES`,1 AS `ANNEE`,1 AS `DUREE`,1 AS `CONDENSE`,1 AS `COULEURS`,1 AS `INTERDICTION_film`,1 AS `PUBLIC_film`;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`departementDelete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`departementDelete`(IN `aiId` INT)
DELETE FROM departement WHERE id_departement = aiId $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`departementInsert`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`departementInsert`(IN asCode CHAR(3), IN asName VARCHAR(50))
BEGIN
INSERT INTO departement(code_departement, nom_departement) VALUES (asCode, asName);
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`departementSelectAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`departementSelectAll`()
BEGIN
SELECT * FROM departement;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`departementSelectOne`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`departementSelectOne`(IN `aiId` INT)
BEGIN
SELECT * FROM departement WHERE id_departement = aiId;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`departementUpdate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`departementUpdate`(IN aiId INT, IN asCp CHAR(3), IN asName VARCHAR(50))
BEGIN
UPDATE departement SET code_departement = asCp, nom_departement = asName WHERE id_departement = aiId;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`genreDelete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`genreDelete`(IN asId INT)
BEGIN
DELETE FROM genre WHERE ID_genre = asId;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`genreInsert`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`genreInsert`(IN asCodeGenre CHAR(2), IN asLibelleGenre VARCHAR(50), IN asGenreGram CHAR(1))
BEGIN
INSERT INTO genre(CODE_genre,LIBELLE_genre,genre_GRAMMATICAL) VALUES(asCodeGenre,asLibelleGenre,asGenreGram);
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`genreSelectAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`genreSelectAll`()
BEGIN
SELECT * FROM genre g;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`genreSelectOne`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`genreSelectOne`(IN asId INT)
BEGIN
SELECT * FROM genre WHERE ID_genre = asId;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`genreUpdate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`genreUpdate`(IN aiId INT, IN asCodeGenre CHAR(2), IN asLibelleGenre VARCHAR(50), IN asGenreGram CHAR(1))
BEGIN
UPDATE genre SET CODE_genre = asCodeGenre, LIBELLE_genre = asLibelleGenre, genre_GRAMMATICAL = asGenreGram WHERE ID_genre = aiId;
END $$

DELIMITER ;

DELIMITER $$

DROP FUNCTION IF EXISTS `cinescope2017`.`Insert_Into`$$
CREATE DEFINER=`root`@`localhost` FUNCTION  `cinescope2017`.`Insert_Into`(asNom VARCHAR(50), asMasculin VARCHAR(50), asFeminin VARCHAR(50), asNeutre VARCHAR(50)) RETURNS int(11)
    NO SQL
    DETERMINISTIC
BEGIN
   DECLARE LastID INT;

   SET LastID = -1;
   INSERT INTO pays(NOM_pays, MASCULIN, FEMININ, NEUTRE) VALUES(asNom,asMasculin,asFeminin,asNeutre);
   SELECT LAST_INSERT_ID() INTO LastID FROM DUAL;
   RETURN LastID;
END;

 $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`media_delete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`media_delete`(paramID_MEDIA INT)
BEGIN
	DELETE
	FROM cinescope2017.media
	WHERE ID_media = paramID_MEDIA ;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`media_insert`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`media_insert`(paramID_MEDIA INT,paramNOM_MEDIA VARCHAR(254) )
BEGIN
	INSERT INTO cinescope2017.media(ID_media,NOM_media)
	VALUES(paramID_MEDIA,paramNOM_MEDIA) ;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`media_select_all`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`media_select_all`()
BEGIN
	SELECT * 
	FROM cinescope2017.media ;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`media_select_one`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`media_select_one`(paramID_MEDIA INT)
BEGIN
	SELECT * 
	FROM cinescope2017.media
	WHERE ID_media = paramID_MEDIA ;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`media_update`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`media_update`(paramID_MEDIA INT,paramNOM_MEDIA VARCHAR(254) )
BEGIN
	UPDATE cinescope2017.media
	SET NOM_media = paramNOM_MEDIA
	WHERE ID_media = paramID_MEDIA ;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`paysDelete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`paysDelete`(IN asId INT)
BEGIN
DELETE FROM pays WHERE ID_pays = asId;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`paysInsert`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`paysInsert`(IN asName VARCHAR(50), IN asMale VARCHAR(50), IN asFemale VARCHAR(50), IN asNeutre VARCHAR(50))
BEGIN
INSERT INTO pays(NOM_pays, MASCULIN, FEMININ, NEUTRE) VALUES(asName,asMale,asFemale,asNeutre);
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`paysSelectAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`paysSelectAll`()
BEGIN
SELECT * FROM pays p;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`paysSelectOne`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`paysSelectOne`(IN asId INT)
BEGIN
SELECT * FROM pays WHERE ID_pays = asId;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`paysUpdate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`paysUpdate`(IN asId INT, IN asName VARCHAR(50), IN asMale VARCHAR(50), IN asFemale VARCHAR(50), IN asNeutre VARCHAR(50))
BEGIN
UPDATE pays SET NOM_pays = asName, MASCULIN = asMale, FEMININ = asFemale, NEUTRE = asNeutre WHERE ID_pays = asId;
END $$

DELIMITER ;