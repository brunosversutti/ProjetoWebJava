CREATE DATABASE PROJETOFINAL

USE PROJETOFINAL

CREATE TABLE USUARIO(
idusuario INT IDENTITY NOT NULL,
EMAIL VARCHAR(40),
NOME VARCHAR(50),
CPF VARCHAR(50),
ENDERECO VARCHAR(50),
TELEFONE VARCHAR(50),
DATA_NASCIMENTO VARCHAR(50),
LOGIN VARCHAR(50),
SENHA VARCHAR(50),
CONSTRAINT "USUARIO_PK" PRIMARY KEY (idusuario)
);


CREATE TABLE IMOVEL(
idimovel INT IDENTITY NOT NULL,

ENDERECO VARCHAR(50) ,
CEP VARCHAR(9) ,
PRECO MONEY ,
METRAGEM REAL ,
QUADRA VARCHAR(4) ,
LOTE INT ,
SITUACAO VARCHAR(11),
CONSTRAINT "IMOVEL_PK" PRIMARY KEY (idimovel),
);

drop table IMOVEL