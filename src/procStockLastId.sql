﻿DELIMITER $$

DROP PROCEDURE IF EXISTS `cinescope2017`.`newID` $$

CREATE PROCEDURE `cinescope2017`.`newID` ()
BEGIN
    SELECT LAST_INSERT_ID() FROM DUAL;
END $$

DELIMITER ;
