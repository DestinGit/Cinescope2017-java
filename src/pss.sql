DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`artisteInsert`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`artisteInsert`(IN asNom VARCHAR(50))
BEGIN
INSERT INTO artiste(NOM_artiste) VALUES(asNom);
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`artisteSelectAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`artisteSelectAll`()
BEGIN
SELECT * FROM artiste;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`artisteSelectOne`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`artisteSelectOne`(IN asId INT)
BEGIN
SELECT * FROM artiste WHERE ID_artiste = asId;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`artisteUpdate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`artisteUpdate`(IN asId INT, IN asNom VARCHAR(50))
BEGIN
UPDATE artiste SET NOM_artiste = asNom WHERE ID_artiste = asId;
END $$

DELIMITER ;

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

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`rubriqueDelete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`rubriqueDelete`(IN asId INT)
BEGIN
DELETE FROM rubrique WHERE ID_rubrique = asId;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`rubriqueInsert`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`rubriqueInsert`(IN asCodeRubrique CHAR(2), IN asIntituleRubrique VARCHAR(50))
BEGIN
INSERT INTO rubrique(CODE_rubrique, INTITULE_rubrique) VALUES(asCodeRubrique, asIntituleRubrique);
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`rubriqueSelectAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`rubriqueSelectAll`()
BEGIN
SELECT * FROM rubrique;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`rubriqueSelectOne`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`rubriqueSelectOne`(IN asId INT)
BEGIN
SELECT * FROM rubrique WHERE ID_rubrique = asId;
END $$

DELIMITER ;

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`rubriqueUpdate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`rubriqueUpdate`(IN asId INT, IN asCode CHAR(2), IN asIntitule VARCHAR(50))
BEGIN
UPDATE rubrique SET CODE_rubrique = asCode, INTITULE_rubrique = asIntitule WHERE ID_rubrique = asId;
END $$

DELIMITER ;