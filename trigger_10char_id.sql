USE `Slyvka_db_lab7_variant66`

DELIMITER //

CREATE TRIGGER id_number_ten_characters
BEFORE INSERT 
on Worker FOR EACH ROW
BEGIN
	IF LENGTH( NEW.id_number ) != 10 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Id number must have 10 characters";
	END IF;
END//
