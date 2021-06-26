/*Daca descrierea nu se introduce la review, aceasta se genereaza automat in functie de steaua acordata*/

DELIMITER $$
CREATE
	TRIGGER trigger_stars BEFORE INSERT
    ON review
    FOR EACH ROW BEGIN
    IF NEW.stars = "1" AND NEW.description IS NULL THEN SET NEW.description = "Bad service!";
    ELSEIF NEW.stars = "2" AND NEW.description IS NULL THEN SET NEW.description = "Acceptable!";
    ELSEIF NEW.stars = "3" AND NEW.description IS NULL THEN SET NEW.description = "There is space for improvements";
    ELSEIF NEW.stars = "4" AND NEW.description IS NULL THEN SET NEW.description = "Good service!";
    ELSEIF NEW.stars = "5" AND NEW.description IS NULL THEN SET NEW.description = "I love it and i'll recommend to my friends!";
    ELSEIF NEW.stars IS NULL AND NEW.description IS NULL THEN SET NEW.description = "No stars selected!";
    END IF;
    END$$
DELIMITER ;   
 
