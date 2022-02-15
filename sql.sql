CREATE TABLE usuario(
    id_usuario INT AUTO_INCREMENT NOT NULL,
    nombres VARCHAR(90) NOT NULL,
    correo VARCHAR(45) NOT NULL,
    clave VARCHAR(45) NOT NULL,
    PRIMARY KEY(id_usuario)
)ENGINE=InnoDB;

CREATE TABLE gastos(
    id_gasto INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(20) NOT NULL,
    precio BIGINT NOT NULL,
    fecha DATE NOT NULL,
    id_usuario INT NOT NULL,
    PRIMARY KEY (id_gasto),
    INDEX (id_usuario),
    CONSTRAINT fk_gastos
    FOREIGN KEY (id_usuario)
    REFERENCES usuario(id_usuario)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)ENGINE=InnoDB;

CREATE TABLE ahorros(
    id_ahorro INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(50),
    valor BIGINT NOT NULL,
    fecha_inicio DATE,
    fecha_final DATE NOT NULL,
    id_usuario INT NOT NULL,
    INDEX (id_usuario),
    PRIMARY KEY (id_ahorro),
    CONSTRAINT fk_ahorros
    FOREIGN KEY (id_usuario)
    REFERENCES usuario(id_usuario)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)ENGINE=InnoDB;

CREATE TABLE metas(
    id_meta INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(50),
    precio BIGINT NOT NULL,
    fecha_final DATE NOT NULL,
    id_usuario INT NOT NULL,
    PRIMARY KEY (id_meta),
    INDEX(id_usuario),
    CONSTRAINT fk_meta
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

    IF MOD(cur_day, period) = 0 THEN
        UPDATE salario SET actual = added WHERE id_usuario=id_user;
        SELECT actual FROM salario WHERE id_usuario=id_user;
    ELSEIF cur_day = 1 AND DAY(CURRENT_DATE()-1) < 30 THEN 
        UPDATE salario SET actual = added WHERE id_usuario=id_user;
        SELECT actual FROM salario WHERE id_usuario=id_user;
    ELSE
        SELECT actual FROM salario WHERE id_usuario=id_user;
    END IF;
END //

DELIMITER ;
