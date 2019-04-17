create database db_crud_mvc;

use db_crud_mvc;

create table TBL_USUARIO (
	ID int auto_increment not null unique,
    NOME varchar (255) not null,
    EMAIL varchar (100) not null,
    senha varchar (100) not null,
    primary key (ID)
);

select * from TBL_USUARIO;