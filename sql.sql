CREATE TABLE usuario(
    id_usuario INT AUTO_INCREMENT NOT NULL,
    nombres VARCHAR(90) NOT NULL,
    correo VARCHAR(45) NOT NULL,
    clave VARCHAR(45) NOT NULL,
    PRIMARY KEY(id_usuario)
)ENGINE=InnoDB;

CREATE TABLE acciones(
    id_acciones INT AUTO_INCREMENT NOT NULL,
    tipo_acciones VARCHAR(45) NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    tipo_gasto VARCHAR(45) NOT NULL,
    fecha_inicio DATE,
    fecha_final DATE NOT NULL,
    valor BIGINT NOT NULL,
    id_usuario INT NOT NULL,
    INDEX (id_usuario),
    PRIMARY KEY(id_acciones),
    CONSTRAINT fk_acciones
    FOREIGN KEY (id_usuario) 
    REFERENCES usuario(id_usuario)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)ENGINE=InnoDB;

CREATE TABLE salario(
    id_salario INT AUTO_INCREMENT NOT NULL,
    valor BIGINT NOT NULL,
    periodo INT NOT NULL,
    id_usuario INT NOT NULL,
    actual BIGINT NOT NULL,
    PRIMARY KEY (id_salario),
    INDEX (id_usuario),
    CONSTRAINT fk_salario
    FOREIGN KEY (id_usuario)
    REFERENCES usuario(id_usuario)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)ENGINE=InnoDB;


DELIMITER //

CREATE PROCEDURE update_salary(
    in id_user INT
)
BEGIN
    DECLARE added BIGINT DEFAULT NULL;
    DECLARE cur_day INT DEFAULT NULL;
    DECLARE period INT;
    DECLARE to_sum BIGINT;
    DECLARE cur_salary BIGINT;

    SELECT actual INTO cur_salary FROM salario WHERE id_usuario=id_user;
    SELECT period INTO period FROM salario WHERE id_usuario=id_user;
    SELECT valor INTO to_sum FROM salario WHERE id_usuario=id_user;
    SET cur_day = DAY(CURRENT_DATE());
    SET added = cur_salary + to_sum;

    IF cur_day = period  THEN
        UPDATE salario SET actual = added WHERE id_usuario=id_user;
    ELSEIF cur_day = 1 AND DAY(CURRENT_DATE()-1) < 30 THEN 
        UPDATE salario SET actual = added WHERE id_usuario=id_user;
    END IF;
END //

DELIMITER ;
