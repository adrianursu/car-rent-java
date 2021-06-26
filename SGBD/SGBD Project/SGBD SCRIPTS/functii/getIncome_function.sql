/*Functia returneaza produsul dintre zilele de rental (obtinut prin datediff()) si pretul pe zi al unei inchirieri, rand cu rand prin intermediului cursorului */

DROP FUNCTION IF EXISTS getIncome;
DELIMITER $$

CREATE  FUNCTION getIncome()
 RETURNS int
    READS SQL DATA
BEGIN
	 DECLARE nrDaysRent Integer;
     DECLARE priceForRent Integer;
     DECLARE finished Integer DEFAULT 0;
     DECLARE aux Integer DEFAULT 0;
    
     DECLARE order_cursor CURSOR FOR
		SELECT datediff(end_date, start_date) as zile, car.price_per_day FROM order_details, car WHERE car.id = order_details.car_id;
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;
        
     OPEN order_cursor;
 		order_loop : WHILE (finished = 0) DO
 					   FETCH order_cursor INTO nrDaysRent, priceForRent;
                        IF finished = 1 THEN
 							LEAVE order_loop;
                        END IF;
                         SET aux =  aux + (nrDaysRent * priceForRent);
				   END WHILE;
     CLOSE order_cursor;                   
    RETURN aux;
    END$$
    
    DELIMITER ;