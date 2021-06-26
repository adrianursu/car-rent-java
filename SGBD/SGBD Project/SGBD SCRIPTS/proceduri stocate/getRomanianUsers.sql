/*Aceasta procedura selecteaza userii din Ro*/
DROP PROCEDURE IF EXISTS spGetRomanianUsers;
DELIMITER $$

CREATE PROCEDURE spGetRomanianUsers()
BEGIN
SELECT user.id, CONCAT(first_name, " ", last_name) AS useri FROM user, user_adress WHERE user.id = user_adress.user_id_adress AND user_adress.country = "Romania";
END$$

DELIMITER ;