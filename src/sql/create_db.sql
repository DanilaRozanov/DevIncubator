CREATE DATABASE db_incubator;

CREATE TABLE `db_incubator`.`user` (
 `userid` INT NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(45) NULL,
 `sureName` VARCHAR(45) NULL,
 PRIMARY KEY (`user_id`));

CREATE TABLE `db_incubator`.`account` (
 `account_id` INT NOT NULL AUTO_INCREMENT,
 `account` INT NOT NULL,
 `user_id` INT NOT NULL,
 PRIMARY KEY (`account_id`),
 INDEX `fk_user_id_to_user_user_id` (`user_id` ASC),
 CONSTRAINT `fk_user_id_to_user_user_id`
 FOREIGN KEY (`user_id`)
 REFERENCES `db_incubator`.`user` (`user_id`)
 ON DELETE CASCADE
 ON UPDATE CASCADE);

insert into account (account, user_id) values (7774, 1), (85625, 2), (2684, 3), (4146, 4), (5789, 5), (6844, 6), (458656, 7), (47976, 8), (4478, 9), (9786, 10);
insert into user (name, sureName) values ('Vlad','Ivanov'), ('Vova', 'Kovalchuk'), ('Sasha', 'Semenovich'), ('Dima', 'Durov'), ('Zhenya', 'Lishanenko'), ('Nastya', 'Reshetnyak'), ('Danila', 'Reshetnyak'), ('Nadya', 'Fizer'), ('Garik', 'Krotovich'), ('Alexander', 'Dragun');