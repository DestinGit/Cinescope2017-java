CREATE DEFINER=`root`@`localhost` PROCEDURE `rubriqueDelete`(IN asId INT(11))
BEGIN
DELETE FROM rubrique WHERE id_rubrique = asId;
END