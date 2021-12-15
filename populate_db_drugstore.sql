INSERT INTO `Slyvka_db_lab7_variant66`.`Street` (`name`) VALUES ('Naukova');
INSERT INTO `Slyvka_db_lab7_variant66`.`Street` (`name`) VALUES ('Poletaeva');
INSERT INTO `Slyvka_db_lab7_variant66`.`Street` (`name`) VALUES ('Prospekt');
INSERT INTO `Slyvka_db_lab7_variant66`.`Street` (`name`) VALUES ('Soborna');
INSERT INTO `Slyvka_db_lab7_variant66`.`Street` (`name`) VALUES ('Zelena');


INSERT INTO `Slyvka_db_lab7_variant66`.`Position` (`name`) VALUES ('Chief');
INSERT INTO `Slyvka_db_lab7_variant66`.`Position` (`name`) VALUES ('Intern');
INSERT INTO `Slyvka_db_lab7_variant66`.`Position` (`name`) VALUES ('Junior pharmaciest');


INSERT INTO `Slyvka_db_lab7_variant66`.`Heal_target` (`name`) VALUES ('Head');
INSERT INTO `Slyvka_db_lab7_variant66`.`Heal_target` (`name`) VALUES ('Heart');
INSERT INTO `Slyvka_db_lab7_variant66`.`Heal_target` (`name`) VALUES ('Kidney');
INSERT INTO `Slyvka_db_lab7_variant66`.`Heal_target` (`name`) VALUES ('Leg');
INSERT INTO `Slyvka_db_lab7_variant66`.`Heal_target` (`name`) VALUES ('Arm');
INSERT INTO `Slyvka_db_lab7_variant66`.`Heal_target` (`name`) VALUES ('Muscle');

INSERT INTO `Slyvka_db_lab7_variant66`.`Drug` (`name`, `ministry_code`, `only_be_recipt`, `narcotic`, `psychotropic`) VALUES ('Helper-104', '7890', '1', '1', '1');
INSERT INTO `Slyvka_db_lab7_variant66`.`Drug` (`name`, `ministry_code`, `only_be_recipt`, `narcotic`, `psychotropic`) VALUES ('704', '7890', '1', '1', '1');


INSERT INTO `Slyvka_db_lab7_variant66`.`Drugstore` (`name`, `building_nomber`, `web_url`, `open_time`, `close_time`, `working_on_saturday`, `working_on_sunday`, `Street_name`) VALUES ('Ranok', '12', 'www.ranok.com', '8:30:00', '23:30:00', '1', '1', 'Naukova');

INSERT INTO `Slyvka_db_lab7_variant66`.`Worker` (`name`, `surname`, `id_number`, `passport`, `seniority`, `birth_date`, `Position_name`, `Drugstore_name`) VALUES ('Stepan', 'Radchenko', '1234567890', 'BK1234', '3', '1900-12-31', 'Junior pharmaciest', 'Ranok');
INSERT INTO `Slyvka_db_lab7_variant66`.`Worker` (`name`, `surname`, `id_number`, `passport`, `seniority`, `birth_date`, `Position_name`, `Drugstore_name`) VALUES ('Tania', 'Symonenko', '1234682392', 'GY3217', '1', '2001-10-28', 'Junior pharmaciest', 'Ranok');
INSERT INTO `Slyvka_db_lab7_variant66`.`Worker` (`name`, `surname`, `id_number`, `passport`, `seniority`, `birth_date`, `Position_name`, `Drugstore_name`) VALUES ('Katia', 'Rudchenko', '23738428', '2324RH', '1', '2003-11-30', 'Intern', 'Ranok');
INSERT INTO `Slyvka_db_lab7_variant66`.`Worker` (`name`, `surname`, `id_number`, `passport`, `seniority`, `birth_date`, `Position_name`, `Drugstore_name`) VALUES ('Olya', 'Pepe', '2381849', 'FH1234', '5', '1988-02-12', 'Chief', 'Ranok');


INSERT INTO `Slyvka_db_lab7_variant66`.`Drug_has_Heal_target` (`Drug_name`, `Heal_target_name`) VALUES ('Helper-104', 'Heart');
INSERT INTO `Slyvka_db_lab7_variant66`.`Drug_has_Heal_target` (`Drug_name`, `Heal_target_name`) VALUES ('Helper-104', 'Head');
INSERT INTO `Slyvka_db_lab7_variant66`.`Drug_has_Heal_target` (`Drug_name`, `Heal_target_name`) VALUES ('Helper-104', 'Muscle');

INSERT INTO `Slyvka_db_lab7_variant66`.`Drugstore_has_Drug` (`Drugstore_name`, `Drug_name`) VALUES ('Ranok', 'Helper-104');
