# Projeto Restaurante SpringBoot

O objetivo deste projeto é ser um exemplo prático para incluirmos testes de software usando os recursos do banco de dados H2 (in memory)

Basicamente temos 2 tabelas:

Categoria e Pratos

Um prato pertence a uma unica categoria

Uma categoria pode ter vários pratos associados a ela


## Tecnologias utilizadas
- Java 17
- SpringBoot 3.0.4
- MySQL 8.0

## Script do Banco de dados
```
  create database db_restaurante;
  use db_restaurante;
  create table tbl_categoria(
    codigo integer not null auto_increment primary key,
    descricao varchar(100)
  );
  
  create table tbl_prato(
     codigo integer not null auto_increment primary key,
     nome varchar(100),
     link_foto varchar(255),
     preco double,
     cod_categoria integer not null,
     constraint fk_categ foreign key (cod_categoria) references tbl_categoria(codigo)
  );  
 ```