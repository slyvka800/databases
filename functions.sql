DELIMITER //

CREATE FUNCTION GetAbbreviation (
	name varchar(20), surname varchar(45)
)
RETURNS varchar(2)
DETERMINISTIC
BEGIN
	RETURN concat(LEFT(name, 1), LEFT(surname, 1));
END//

CREATE FUNCTION GetStreets (
	street_key varchar(40)
)
RETURNS varchar(40)
DETERMINISTIC
BEGIN
	RETURN (SELECT name FROM Street where name = street_key);
END//

DELIMITER ;

SELECT GetAbbreviation(name, surname) FROM Worker;
SELECT *, GetStreets(Street_name) from Drugstore;