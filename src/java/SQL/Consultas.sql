
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
INSERT INTO usuarios(id,dni,rol_id,nombres,apellidos,telefono,email,password,fecha_registro,direccion,user,habilitado) VALUES(NULL,'"+usu.getDni()+"','"+usu.getRol()+"','"+usu.getNombres()+"','"+usu.getApellidos()+"','"+usu.getTelefono()+"','"+usu.getEmail()+"',SHA1('"+usu.getPassword()+"'),CURDATE(),'"+usu.getDireccion()+"','"+usu.getUser()+"','"+usu.getHabilitado()+"');





#Categoria#

CREATE TABLE categorias(
id               int(255) auto_increment not null,
nombre     varchar(100) not null,
estado     boolean not null,
CONSTRAINT pk_categorias PRIMARY KEY(id)
)ENGINE=InnoDb;

#datos#

INSERT INTO categorias VALUES(NULL,"Ski","1");
INSERT INTO categorias VALUES(NULL,"Snowboard","1");
INSERT INTO categorias VALUES(NULL,"General","1");


#Producto#

CREATE TABLE productos(
id              int(255) auto_increment not null,
categoria_id    int(255) not null,
nombre          varchar(100) not null,
descripcion     varchar(300) ,
stock           int(100) not null,
precio          float not null,
estado          boolean not null,
CONSTRAINT pk_productos PRIMARY KEY(id),
CONSTRAINT fk_categoria_id FOREIGN KEY (categoria_id) REFERENCES categorias(id)
)ENGINE=InnoDb;

#DATOS PRODUCTOS#
INSERT INTO productos VALUES(null,3,"Antiparras","Antiparras adulto",1,50.00,1);
INSERT INTO productos VALUES(null,1,"Completo Deportivo Adulto","Equipo completo deportivo para persona adulta",1,700,1);
INSERT INTO productos VALUES(NULL,3,"Ski deportivo","equipo completo",1,50.00,1,LOAD_FILE('C:/Users/Alejandro/Documents/GitHub/Rental/img/skidepo.jpg'))


#TEMPORADA#

CREATE TABLE temporadas(
id              int(255) auto_increment not null,
descripcion     varchar(300) not null,
fecha_desde     date not null,
fecha_hasta     date not null,
precio          float not null,
CONSTRAINT pk_temporada PRIMARY KEY(id),
)ENGINE=InnoDb;

#RESERVA#

CREATE TABLE reservas( 
id              int(255) auto_increment not null,
temporada_id    int(255) not null,
usuario_id      int(255)not null,
precio          float not null,
fecha_reserva   date not null,
cantidad_dias   int(100)
CONSTRAINT pk_reservas PRIMARY KEY(id),
CONSTRAINT fk_temporada_id FOREIGN KEY (temporada_id) REFERENCES temporadas(id),
CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
)ENGINE=InnoDb;



)ENGINE=InnoDb

#Lista_Producto#

CREATE TABLE lista_productos(
id          int(255) auto_increment not null,
reserva_id  int(255) not null,
producto_id int(255) not null,
cantidad    int(100) not null,
CONSTRAINT pk_lista_productos PRIMARY KEY(id),
CONSTRAINT fk_reserva_id FOREIGN KEY(reserva_id) REFERENCES reservas(id),
CONSTRAINT fk_producto_id FOREIGN KEY(producto_id) REFERENCES productos(id)
)ENGINE=InnoDb;