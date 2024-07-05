CREATE DATABASE JavaCRUD;
USE JavaCRUD;

CREATE TABLE user (
	id int not null auto_increment,
	nome varchar(45) not null,
    login varchar(45) not null,
    email varchar(45) not null,
	senha varchar(45) not null,
    primary key(id)
);

SELECT * FROM user;
SELECT id, nome, login, email, senha FROM user WHERE id = 2;