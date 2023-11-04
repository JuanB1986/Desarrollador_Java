use qatar2022;

-- Carga datos Departamentos
 INSERT INTO departamento(idDepartamento, nombre, presupuesto)
 VALUES ('11', 'compras', '12333.4');
 INSERT INTO departamento(idDepartamento, nombre, presupuesto)
 VALUES ('12', 'ingenieria', '34500.0');
 INSERT INTO departamento(idDepartamento, nombre, presupuesto)
 VALUES ('13', 'logistica', '75500.0');


-- Cargo datos de la tabla
 INSERT INTO empleado (idEmpleado, nombre, apellido, nacionalidad, dni, Departamento) 
 VALUES ('01', 'Juan', 'Banquero', 'Argentino', '32000111', '1'); 
 INSERT INTO empleado (idEmpleado, nombre, apellido, nacionalidad, dni, Departamento)
 VALUES ('02', 'Nikola', 'Tesla', 'Serbia', '1236896','2');

-- Actualiza nombre de empleado
UPDATE empleado SET nombre = 'Juan Manuel' WHERE nombre = 'Juan';

-- Borro departamento de la tabla
 DELETE FROM departamento
 WHERE nombre = 'logistica';

-- Consulta la tabla de departamentos
SELECT * FROM qatar2022.departamento;

-- Mostrar departamentos ordenador alfabeticamente.
SELECT * FROM qatar2022.departamento
ORDER BY nombre;



/*
-- Borro todos los campos
 DELETE FROM departamento
 WHERE idDepartamento = '11';
 DELETE FROM departamento
 WHERE idDepartamento = '12';
 DELETE FROM departamento
 WHERE idDepartamento = '13';
 DELETE FROM empleado
 WHERE idEmpleado = '01';
 DELETE FROM empleado
 WHERE idEmpleado = '02';
 DELETE FROM empleado
 WHERE idEmpleado = '03';
*/
