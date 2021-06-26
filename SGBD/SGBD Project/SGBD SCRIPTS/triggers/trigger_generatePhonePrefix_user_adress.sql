/*Se genereaza prefixul numarului de telefon in dependenta de tara (Moldova sau Romania)*/

DELIMITER $$
CREATE
	TRIGGER trigger_user_adress BEFORE INSERT
    ON user_adress
    FOR EACH ROW BEGIN
    IF NEW.country = "Moldova" AND NEW.phone IS NOT NULL THEN SET NEW.phone = CONCAT("+373 ", NEW.phone);
    ELSEIF NEW.country = "Romania" AND NEW.phone IS NOT NULL THEN SET NEW.phone = CONCAT("+40 ", NEW.phone);
    END IF;
    END$$
DELIMITER ;   