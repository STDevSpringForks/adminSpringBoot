#Hibernate
create user 'hbuser'@'localhost' identified by 'hbuser';
grant all privileges on * . * to 'hbuser'@'localhost';

create database if not exists hibernate_adminSpringMVC;
use hibernate_adminSpringMVC;

drop table if exists person;
create table person(
	id int(11) not null auto_increment,
    firstName varchar(45) not null,
	lastName varchar(45) not null,
	gender varchar(1) not null,
	email varchar(45) not null unique,
    primary key (id)
) engine = InnoDB default charset=latin1;

#Start Froy 07/12/2016 ---------------------------------------------
drop table if exists payment;
create table payment(
	id int(11) not null,
	amount  numeric(15,2) default null,
    primary key (id)
);
drop table if exists promo_codes;
create table promo_codes(
	id int(11) not null,
	promo_code  varchar(6) default null,
    primary key (id)
);

ALTER TABLE `hibernate_adminspringmvc`.`payment` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `hibernate_adminspringmvc`.`promo_codes` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

#End Froy 07/12/2016 ---------------------------------------------

#Start Froy 27/12/2016 -------------------------------------------
create table objetos (id int(11) auto_increment, objeto blob,primary key (id));
#End Froy 27/12/2016 -------------------------------------------

