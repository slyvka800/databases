USE `Slyvka_db_lab7_variant66`;

DELIMITER //

CREATE TRIGGER street_cardinality_validation
AFTER DELETE
ON Street FOR EACH ROW
BEGIN
	IF (SELECT COUNT(*) FROM Street) < 2 OR (SELECT COUNT(*) FROM Street) THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "STREET CARDINALITY MUST BE BETWEEN 2 AND 6";
	END IF;
END// 
