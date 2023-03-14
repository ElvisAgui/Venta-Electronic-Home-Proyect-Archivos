/*
*script para las inserciones iniciales de los empleados
*/


 --ingresar con el usuario a la base de datos
psql -U usuario_empleados electronic_home

--empleados
INSERT INTO control_empleado.empleado(cui, nombre, apellido, passworde, salario) VALUES
--sucursal_central
('3245252250901', 'German Guillermo', 'Perez Perez', '',  3200.50),
('3348255250901', 'Jose Manuel', 'Rodrigez Pauc', '',  3300.00),
('3445252350901', 'Fernando Leonel', 'Yax Tax', '',  2900.50),
('3235252250801', 'Celso Geovani', 'Guitierrez Mendoza', '',  3600.75),
--sucursal norte
('3255252250901', 'Joel Francisco', 'Batz Tax', '',  3200.00),
('3328255250901', 'Manuel Gerson', 'Pauc Tzoc', '',  3350.00),
('3448252350901', 'Maria Fernanda', 'Zapeta Soza', '',  2970.50),
('3235258250801', 'Lucia Noemi', 'Yax Yax', '',  3650.75),
--sucursal sur
('3255252250801', 'Josefa Maria', 'Marales Par', '',  32220.00),
('3348255250902', 'Nancy Carmen', 'Mendoza Tzic', '',  3350.00),
('3448252350903', 'Carmen Fernanda', 'Aguilar Mendoza', '',  2970.50),
('3235258450801', 'Mario Joel', 'Tzoc Sapon', '',  3650.75),
--bodega
('3255252250902', 'Francisco Manuel', 'Batz Salcedo', '',  3000.00),
('3328255250904', 'Manuel Rudy', 'Pauc Soza', '',  3150.00),
('3448272350901', 'Jerson Emanuel', 'Zapeta Tzoc', '',  2970.50),
('3235278450801', 'Maria Jose', 'Tax Garcia', '',  3550.75),
--Admin
('3255752250801', 'Elvis Yonatan', 'Aguilar Velasquez', '',  6300.00);

--cargos
INSERT INTO control_empleado.cargo(tipo_cargo, nombre_cargo) VALUES
(1, 'Vendedor'),(2, 'Encargado Inventario'),(3, 'Encargado Bodega'),(4, 'Administrador');

--RElacion empleado cargo
INSERT INTO control_empleado.cargo_empleado(codigo_cargo, cui_empleado) VALUES
(4, '3255752250801'), (3,'3255252250902'),(3,'3328255250904'),(3,'3448272350901'),(3,'3235278450801'),
(2,'3235258450801'),(2,'3235258250801'),(2,'3235252250801'),
(1,'3245252250901'),(1,'3348255250901'),(1,'3445252350901'),(1,'3255252250901'),(1,'3328255250901'),(1,'3448252350901'),
(1,'3255252250801'),(1,'3348255250902'),(1,'3448252350903');



