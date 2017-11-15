CREATE DEFINER=`root`@`localhost` PROCEDURE `rubriqueSelectOne`(IN asId INT(11))
BEGIN
SELECT * FROM rubrique WHERE id_rubrique = asId;
END