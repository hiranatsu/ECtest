set names utf8;
set foreign_key_checks = 0;
drop database if exists testdb2;

create database if not exists testdb2;
use testdb2;

drop table if exists identity_infomation;

create table identity_infomation(
	id int not null primary key auto_increment,
	user_name varchar(50),
	user_adress varchar(50)
);

INSERT INTO identity_infomation  VALUES(1, "ひらの", "東京"),(2, "さなだ", "千葉"),(3, "ごとう", "神奈川");