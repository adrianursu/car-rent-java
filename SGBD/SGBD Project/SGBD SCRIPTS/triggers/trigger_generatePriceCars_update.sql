/*Se genereaza pretul pe zi al unei masini in dependenta de categoria din care face parte*/

DELIMITER $$
CREATE
	TRIGGER trigger_car_price_update BEFORE UPDATE
    ON car
    FOR EACH ROW BEGIN
        IF NEW.category = "standard" THEN SET NEW.price_per_day = 15;
        ELSEIF NEW.category = "elegance" THEN SET NEW.price_per_day = 30;
        ELSEIF NEW.category = "premium" THEN SET NEW.price_per_day = 65;
    END IF;
    END$$
DELIMITER ;   