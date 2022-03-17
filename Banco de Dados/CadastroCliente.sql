create database cadastrocliente;

use cadastrocliente;

create table cliente (
id int primary key auto_increment,
nome varchar(30) not null,
cpf varchar(12) not null,
telefone varchar(15) not null
)