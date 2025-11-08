set names utf8;
set foreign_key_checks=0;
drop database if exists regist;
create database if not exists regist;
use regist;

drop table if exists login_user_transaction;

create table login_user_transaction(
	id int(100) not null primary key auto_increment,
	family_name varchar(100),
	last_name varchar(100),
	family_name_kana varchar(100),
	last_name_kana varchar(100),
	mail varchar(255),
	password varchar(255),
	gender int(1),
	postal_code varchar(7),
	prefecture varchar(100),
	address_1 varchar(100),
	address_2 varchar(255),
	authority int(1),
	delete_flg int(1),
	registered_time datetime,
	update_time datetime
);

drop table if exists gender_info_transaction;

create table gender_info_transaction(
	id int not null primary key,
	user_gender varchar(1),
	insert_date datetime,
	update_date datetime
);

drop table if exists authority_info_transaction;

create table authority_info_transaction(
	id int not null primary key,
	user_authority varchar(3),
	insert_date datetime,
	update_date datetime
);

drop table if exists flg_info_transaction;

create table flg_info_transaction(
	id int not null primary key,
	flg varchar(2),
	insert_date datetime,
	update_date datetime
);

INSERT INTO gender_info_transaction(id,user_gender)
VALUES(0,"男");
INSERT INTO gender_info_transaction(id,user_gender)
VALUES(1,"女");
INSERT INTO authority_info_transaction(id,user_authority)
VALUES(0,"一般");
INSERT INTO authority_info_transaction(id,user_authority)
VALUES(1,"管理者");
INSERT INTO flg_info_transaction(id,flg)
VALUES(0,"有効");
INSERT INTO flg_info_transaction(id,flg)
VALUES(1,"無効");
