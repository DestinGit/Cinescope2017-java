CREATE DEFINER=`root`@`localhost` PROCEDURE `rubriqueInsert`(IN asCode CHAR(2), IN asIntitule VARCHAR(50))
BEGIN
INSERT INTO rubrique (code_rubrique, intitule_rubrique) VALUES (asCode, asIntitule);
END