CREATE DEFINER=`root`@`localhost` PROCEDURE `rubriqueUpdate`(asCode CHAR(10), asIntitule VARCHAR(50), asId INT(11))
BEGIN
UPDATE rubrique SET code_rubrique  = asCode, intitule_rubrique = asIntitule WHERE id_rubrique = asId;
END