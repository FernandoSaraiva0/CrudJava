CREATE DATABASE agenda;
use agenda;

create table contato (
	id_contato int not null auto_increment,
    nome varchar(50),
    telefone varchar(15),
    email varchar(15),
    Dat date default current_timestamp,
    primary key(id_contato)
);