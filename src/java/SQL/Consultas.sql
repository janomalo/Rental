
CREATE TABLE `usuarios` (
  `id` INT(255) NOT NULL AUTO_INCREMENT,
   
  `nombres` VARCHAR(100) NOT NULL,
  `apellidos` VARCHAR(100) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `contraseña` VARCHAR(255) NOT NULL,
  `fecha_registro` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_email` (`email`)
) ENGINE=INNODB DEFAULT CHARSET=latin1





CREATE TABLE usuarios(
id          int(255) auto_increment not null,
nombre      varchar(100) not null,
apellido    varchar(100) not null,
email       varchar(255) not null,
password    varchar(255) not null,
fecha       date not null,
CONSTRAINT pk_usuarios PRIMARY KEY(id),
CONSTRAINT uq_email UNIQUE(email)

)ENGINE=InnoDb;






CREATE TABLE categorias(

id          int(255) auto_increment not null,
nombre      varchar(100) not null,
CONSTRAINT pk_categorias PRIMARY KEY (id)
 
)ENGINE=InnoDb;


CREATE TABLE entradas(
id              int(255) auto_increment not null,
usuario_id      int (255) not null ,
categoria_id    int(255) not null ,
titulo          varchar(255) not null,
descripcion     MEDIUMTEXT,
fecha           date not null,
CONSTRAINT pk_entradas PRIMARY KEY(id),
CONSTRAINT fk_entradas_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
CONSTRAINT fk_entradas_categoria FOREIGN KEY (categoria_id) REFERENCES categorias(id)

)ENGINE=InnoDb;


#CONSULTAS SQL RENTAL#

CREATE TABLE roles(
id          int(255) auto_increment not null,
nombre      varchar(100) not null,
CONSTRAINT pk_roles PRIMARY KEY(id)
)ENGINE=InnoDb;

/*roles creada sin problemas*/


CREATE TABLE usuarios(
id          int(255) auto_increment not null,
dni         varchar(50) not null,
rol_id      int(10) not null,
nombres      varchar(100) not null,
apellidos    varchar(100) not null,
telefono    varchar(50) not null,
email       varchar(255) not null,
password    varchar(255) not null,
fecha_registro   date not null,
CONSTRAINT pk_usuarios PRIMARY KEY(id),
CONSTRAINT fk_usuarios_rol FOREIGN KEY (rol_id) REFERENCES roles(id),
CONSTRAINT uq_email UNIQUE(email)

)ENGINE=InnoDb;

/*Usuarios creada sin problemas*/

#datos a Insertar#
INSERT INTO usuarios VALUES(null,"34860730",1,"Alejandro","Molina","+542944335790","ale@ale.com","1234","2019-11-07");




#Categoria#

CREATE TABLE categorias(
id               int(255) auto_increment not null,
nombre     varchar(100) not null,
CONSTRAINT pk_categorias PRIMARY KEY(id)
)ENGINE=InnoDb;


