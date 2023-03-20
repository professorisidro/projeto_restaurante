create table if not exists tbl_categoria(
 	codigo integer auto_increment,
 	descricao varchar(100),
 	primary key(codigo)
 );
 
 create table if not exists tbl_prato (
 	codigo integer auto_increment,
 	nome varchar(100),
 	link_foto varchar(255),
 	preco double,
 	cod_categoria integer not null,
 	primary key (codigo),
 	constraint fm_categ foreign key (cod_categoria) references tbl_categoria (codigo)
 );