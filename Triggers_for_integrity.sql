USE `Slyvka_db_lab7_variant66`;

DELIMITER //

CREATE TRIGGER position_before_delete 
BEFORE DELETE
ON Position FOR EACH ROW
BEGIN
	IF OLD.name IN (SELECT Position_name FROM Worker) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK constraint. Position is referenced.";
    END IF;
END//

CREATE TRIGGER position_before_update
BEFORE UPDATE
ON Position FOR EACH ROW
BEGIN
	IF OLD.name IN (SELECT Position_name FROM Worker) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK constraint. Position is referenced.";
    END IF;
END//

CREATE TRIGGER worker_before_insert
BEFORE INSERT
ON Worker FOR EACH ROW
BEGIN
	IF NOT new.Position_name IN (SELECT name FROM Position) THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK CONSTRAINT. Referenced position not found.";
	END IF;
    
    IF NOT new.Drugstore_name IN (SELECT name FROM Drugstore) THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = "FK CONSTRAINT. Referenced drugstore not found.";
	END IF;
END//

CREATE TRIGGER street_before_delete 
BEFORE DELETE
ON Street FOR EACH ROW
BEGIN
	IF OLD.name IN (SELECT Street_name FROM Drugstore) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK constraint. Street is referenced.";
    END IF;
END//

CREATE TRIGGER street_before_update
BEFORE UPDATE
ON Street FOR EACH ROW
BEGIN
	IF OLD.name IN (SELECT Street_name FROM Drugstore) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK constraint. Street is referenced.";
    END IF;
END//

CREATE TRIGGER heal_target_before_delete 
BEFORE DELETE
ON Heal_target FOR EACH ROW
BEGIN
	IF OLD.name IN (SELECT Heal_target_name FROM Drug_has_Heal_target) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK constraint. Heal target is referenced.";
    END IF;
END//

CREATE TRIGGER heal_target_before_update
BEFORE UPDATE
ON Heal_target FOR EACH ROW
BEGIN
	IF OLD.name IN (SELECT Heal_target_name FROM Drug_has_Heal_target) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK constraint. Heal target is referenced.";
    END IF;
END//

CREATE TRIGGER drug_has_heal_target_before_insert
BEFORE INSERT
ON Drug_has_Heal_target FOR EACH ROW
BEGIN
	IF NOT NEW.Heal_target_name IN (SELECT name FROM Heal_target) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK constraint. Heal target not found.";
    END IF;
END//