/*Functie ce returneaza numarul de stele oferit in review in baza id-ului masinii*/

DROP FUNCTION IF EXISTS getStars;

DELIMITER $$

CREATE FUNCTION getStars(id_car Integer)
RETURNS VARCHAR(1)
READS SQL DATA
BEGIN
	DECLARE nrStars VARCHAR(1);
    SELECT review.stars INTO nrStars FROM review, order_details WHERE id_car = review.id AND id_car = order_details.car_id;
    RETURN nrStars;
    END$$
    
DELIMITER ;    


    