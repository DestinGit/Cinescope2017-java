DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`appreciationDelete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`appreciationDelete`(asIdAppreciation INT(11))
BEGIN
  DELETE FROM appreciation WHERE ID_appreciation = asIdAppreciation;
END $$

DELIMITER ;

##########################################################################################################################

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`appreciationInsert`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`appreciationInsert`(asEtoile VARCHAR(5), asLIBELLE_appreciation VARCHAR(50))
BEGIN
INSERT INTO appreciation (ETOILE, LIBELLE_appreciation) VALUES (asEtoile, asLIBELLE_appreciation);
END $$

DELIMITER ;

##########################################################################################################################

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`appreciationSelectAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`appreciationSelectAll`()
BEGIN
SELECT * FROM appreciation;
END $$

DELIMITER ;

##########################################################################################################################

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`appreciationSelectOne`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`appreciationSelectOne`(asIdAppreciation INT(11))
BEGIN
SELECT * FROM appreciation WHERE ID_appreciation = asIdAppreciation;
END $$

DELIMITER ;

##########################################################################################################################


DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`appreciationUpdate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`appreciationUpdate`(asEtoile VARCHAR(5), asLibelleAppreciation VARCHAR(50), asIdAppreciation INT(11))
BEGIN
UPDATE appreciation SET ETOILE = asEtoile, LIBELLE_appreciation = asLibelleAppreciation WHERE ID_appreciation = asIdAppreciation;
END $$

DELIMITER ;

##########################################################################################################################

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`arrondissementDelete`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`arrondissementDelete`(asIdArrondissement INT(11))
BEGIN
DELETE FROM arrondissement WHERE ID_arrondissement = asIdArrondissement;
END $$

DELIMITER ;

##########################################################################################################################

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`arrondissementInsert`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`arrondissementInsert`(asCodeArrondissement VARCHAR(5), asNomArrondissement VARCHAR(50))
BEGIN
INSERT INTO arrondissement (CODE_arrondissement, NOM_arrondissement) VALUES (asCodeArrondissement, asNomArrondissement);
END $$

DELIMITER ;

##########################################################################################################################

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`arrondissementSelectAll`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`arrondissementSelectAll`()
BEGIN
  SELECT * FROM arrondissement;
END $$

DELIMITER ;

##########################################################################################################################

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`arrondissementSelectOne`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`arrondissementSelectOne`(asIdArrondissement INT(11))
BEGIN
SELECT * FROM arrondissement WHERE ID_arrondissement = asIdArrondissement;
END $$

DELIMITER ;

##########################################################################################################################

DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`arrondissementUpdate`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE  `cinescope2017`.`arrondissementUpdate`(asCodeArrondissement VARCHAR(5), asNomArrondissement VARCHAR(50), asIdArrondissement INT(11))
BEGIN
UPDATE arrondissement SET CODE_arrondissement = asCodeArrondissement, NOM_arrondissement = asNomArrondissement WHERE ID_arrondissement = asIdArrondissement;
END $$

DELIMITER ;

##########################################################################################################################