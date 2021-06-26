/*Aceasta procedura selecteaza masinile cu 5 stele la review*/
DROP PROCEDURE IF EXISTS spGet5StarCars;
DELIMITER $$

CREATE PROCEDURE spGet5StarCars()
BEGIN
SELECT CONCAT(car.brand, " ", car.model) AS car_with_5stars FROM car, order_details, review WHERE car.id = order_details.car_id AND order_details.review_id = review.id AND review.stars = "5";
END$$

DELIMITER ;