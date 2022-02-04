CREATE DATABASE optimizedfinances;

USE optimizedfinances;

CREATE TABLE usuario(
    id_usuario INT NOT NULL AUTO_INCREMENT,
    nombres VARCHAR(90) NOT NULL,
    correo VARCHAR(45) NOT NULL,
    clave VARCHAR(45) NOT NULL,
    PRIMARY KEY(id_usuario)
)ENGINE=InnoDB;

CREATE TABLE acciones(
    id_acciones INT NOT NULL AUTO_INCREMENT,
    tipo_acciones VARCHAR(45) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    tipo_gasto VARCHAR(45) NOT NULL,
    fecha_inicio DATE,
    fecha_final DATE NOT NULL,
    valor BIGINT NOT NULL,
    id_usuario INT NOT NULL,
    INDEX(id_usuario),
    PRIMARY KEY(id_acciones),
    CONSTRAINT fk_acciones
    FOREIGN KEY (id_usuario) 
    REFERENCES usuario(id_usuario);
)ENGINE=InnoDB;

CREATE TABLE salario(
    id_salario INT NOT NULL,
    valor BIGINT NOT NULL,
    periodo INT NOT NULL,
    id_usuario INT NOT NULL,
    PRIMARY KEY (id_salario),
    INDEX (id_usuario),
    CONSTRAINT fk_salario
    FOREIGN KEY (id_usuario)
    REFERENCES usuario(id_usuario)
)ENGINE=InnoDB;
