CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `cinescope2014`.`v_ville` AS
    SELECT 
        `v`.`ID_ville` AS `ID_ville`,
        `d`.`ID_departement` AS `ID_departement`,
        `v`.`CP` AS `CP`,
        `v`.`NOM_ville` AS `NOM_ville`,
        `d`.`NOM_departement` AS `NOM_departement`
    FROM
        (`cinescope2014`.`ville` `v`
        JOIN `cinescope2014`.`departement` `d` ON ((`v`.`ID_departement` = `d`.`ID_departement`)))