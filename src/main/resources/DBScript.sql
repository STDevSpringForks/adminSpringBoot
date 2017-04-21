#Hibernate
create user 'hbuser'@'localhost' identified by 'hbuser';
grant all privileges on * . * to 'hbuser'@'localhost';

create database if not exists hibernate_adminSpringMVC;
use hibernate_adminSpringMVC;

drop table if exists generalProfile;
create table generalProfile(
	id int(11) not null auto_increment,
    firstName varchar(45) default null,
	lastName varchar(45) default null,
	sexo varchar(45) default null,
    primary key (id)
) engine = InnoDB auto_increment = 6 default charset=latin1

drop table if exists person;
create table person(
	id int(11) not null auto_increment,
    firstName varchar(45) not null,
	lastName varchar(45) not null,
	gender varchar(1) not null,
	email varchar(45) not null unique,
    primary key (id)
) engine = InnoDB default charset=latin1

#Start Froy 07/12/2016 ---------------------------------------------
drop table if exists payment;
create table payment(
	id int(11) not null,
	amount  numeric(15,2) default null,
    primary key (id)
)
drop table if exists promo_codes;
create table promo_codes(
	id int(11) not null,
	promo_code  varchar(6) default null,
    primary key (id)
)

ALTER TABLE `hibernate_adminspringmvc`.`payment` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `hibernate_adminspringmvc`.`promo_codes` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

#End Froy 07/12/2016 ---------------------------------------------

--Start Froy 27/12/2016 -------------------------------------------
create table objetos (id int(11) auto_increment, objeto blob,primary key (id));
#End Froy 27/12/2016 -------------------------------------------

#Start Froy 20/Abr/2017 -------------------------------------------
drop table if exists gastosDetails;
create table gastosDetails(
	rid bigint(11) not null,
	tipoGasto  varchar(15) not null,
    monto decimal(10,4) not null,
    descripcion varchar(9999) not null,
    pathComprobante varchar(500) not null,
    photo longblob,
    primary key (rid)
)
#End Froy 20/Abr/2017 -------------------------------------------

#Start Froy 20/Abr/2017 -------------------------------------------
 INSERT INTO `hibernate_adminspringmvc`.`gastosdetails`
(`rid`,
`tipoGasto`,
`monto`,
`descripcion`,
`pathComprobante`)
VALUES
(1,
'Automovil',
496.00,
'Refrendo anual de placas vehiculares 2017',
'/adminHome/gastos/Automovil_1');
#End Froy 20/Abr/2017 -------------------------------------------