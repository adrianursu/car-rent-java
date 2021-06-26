/*Aceasta functie returneaza pretul unei inchirieri in dependenta de id_ul masinii (input) si numarul de zile obtinut prin functia built-in datediff()*/

DROP FUNCTION IF EXISTS getPriceForRental;
DELIMITER $$

CREATE FUNCTION getPriceForRental(id_car Integer)
RETURNS Integer
READS SQL DATA
BEGIN
	DECLARE nrDaysRent Integer;
    DECLARE priceForRent Integer;

		SELECT datediff(end_date, start_date) INTO nrDaysRent FROM order_details WHERE id_car = order_details.car_id;
        SELECT car.price_per_day INTO priceForRent FROM car WHERE id_car = car.id;
        SET priceForRent = priceForRent * nrDaysRent;
                  
    RETURN priceForRent;
    END$$
    
DELIMITER ;    

