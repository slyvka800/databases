DELIMITER //

CREATE PROCEDURE set_drug(IN name VARCHAR(30), IN ministry_code INT, IN only_by_recipt tinyint, IN narcotic TINYINT, IN psychotropic TINYINT)
begin
	INSERT INTO `Slyvka_db_lab7_variant66`.`Drug` (`name`, `ministry_code`, `only_be_recipt`, `narcotic`, `psychotropic`)
    values (name, ministry_code, only_by_recipt, narcotic, psychotropic);
end //

CREATE PROCEDURE set_default_positions()
begin
	declare i int default 1;
    SET i = 1;
    
    WHILE i <= 10 DO
		insert into `Slyvka_db_lab7_variant66`.`Position` (`name`) values (concat("Noname", i));
		SET i = i + 1;
	END WHILE;
end //

CREATE DEFINER=`root`@`localhost` PROCEDURE `create_tables`()
begin
	declare finished INTEGER default 0;
    DECLARE curr_db_name VARCHAR(20) default "";
    DECLARE tables_count INT default 0;
    DECLARE table_counter INT default 1;
    
    DECLARE current_worker CURSOR FOR
		SELECT name from `Slyvka_db_lab7_variant66`.`Worker`;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;
    
    OPEN current_worker;
    
    get_worker: Loop
		Fetch current_worker INTO curr_db_name;
        if finished = 1 then
			LEAVE get_worker;
		END if;
        
       SET tables_count = FLOOR( 1 + RAND( ) *9 );
       SET @create_db = concat('CREATE SCHEMA IF NOT EXISTS ', curr_db_name, ' DEFAULT CHARACTER SET utf8');
       PREPARE stmt FROM @create_db;
	   EXECUTE stmt;
       DEALLOCATE PREPARE stmt;
       
		SET table_counter = 1;
        WHILE table_counter <= tables_count DO
			SET @create_table = concat('CREATE TABLE IF NOT EXISTS `', curr_db_name, '`.`', curr_db_name, table_counter, '` (
			`name` VARCHAR(20) NOT NULL,
			PRIMARY KEY (`name`))
			ENGINE = InnoDB;');
            PREPARE stmt2 FROM @create_table;
            EXECUTE stmt2;
            DEALLOCATE PREPARE stmt2;
            SET table_counter = table_counter + 1;
            
        END WHILE;


	END LOOP get_worker;
    
    CLOSE current_worker;
end//

DELIMITER ;

select FLOOR( 1 + RAND( ) *9 );

call set_drug('Noshpa', 9834, 0, 0, 0);
call set_default_positions();
call create_tables();
