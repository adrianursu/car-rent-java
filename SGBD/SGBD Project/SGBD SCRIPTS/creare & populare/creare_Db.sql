DROP DATABASE IF EXISTS car_rentals;
CREATE DATABASE car_rentals;
USE car_rentals;

SET NAMES utf8;
SET character_set_client = utf8mb4;

----------------------------------------------

CREATE TABLE car
(
id Integer NOT NULL AUTO_INCREMENT,
brand VARCHAR(25) NOT NULL,
model VARCHAR(25) NOT NULL,
year_of_fabrication Integer NOT NULL,
category ENUM("standard", "elegance", "premium") NOT NULL,
price_per_day Integer,

PRIMARY KEY (id)
);

----------------------------------------------

CREATE TABLE user
(
id Integer NOT NULL,
username VARCHAR(25) NOT NULL,
first_name VARCHAR(25) NOT NULL,
last_name VARCHAR(25) NOT NULL,
email VARCHAR(80) NOT NULL,
password VARCHAR(25) NOT NULL,
role ENUM("customer", "admin") NOT NULL,

PRIMARY KEY (id)
);

----------------------------------------------

CREATE TABLE review
(
id Integer NOT NULL,
description VARCHAR(300),
stars ENUM("1","2","3","4","5"),

PRIMARY KEY (id)
);

----------------------------------------------

CREATE TABLE order_details
(
order_id Integer NOT NULL,
start_date DATE NOT NULL,
end_date DATE NOT NULL,
pick_location VARCHAR(25) NOT NULL,
drop_location VARCHAR(25) NOT NULL,
car_id Integer NOT NULL,
user_id Integer NOT NULL,
review_id Integer NOT NULL UNIQUE,

PRIMARY KEY (order_id),

FOREIGN KEY (review_id) REFERENCES review(id),
FOREIGN KEY (car_id) REFERENCES car(id),
FOREIGN KEY (user_id) REFERENCES user(id)
); 

----------------------------------------------

CREATE TABLE user_adress
(
id Integer NOT NULL,
country VARCHAR(25),
city VARCHAR(25),
adress VARCHAR(35) ,
zipcode VARCHAR(10),
phone VARCHAR(25),
user_id_adress Integer NOT NULL UNIQUE,

PRIMARY KEY (id),
FOREIGN KEY (user_id_adress) REFERENCES user(id)
);



