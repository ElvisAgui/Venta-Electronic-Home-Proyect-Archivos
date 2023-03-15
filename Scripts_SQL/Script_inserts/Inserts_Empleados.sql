/*
*script para las inserciones iniciales de los empleados
*/


 --ingresar con el usuario a la base de datos
psql -U usuario_empleados electronic_home

--empleados
INSERT INTO control_empleado.empleado(cui, nombre, apellido, passworde, salario) VALUES
--sucursal_central
('3245252250901', 'German Guillermo', 'Perez Perez', 'Q5Grz1loZT1QhO0uVvtwoQ==',  3200.50),
('3348255250901', 'Jose Manuel', 'Rodrigez Pauc', 'iN1pQWJtQp9Q8/i0FYbiVA==',  3300.00),
('3445252350901', 'Fernando Leonel', 'Yax Tax', 'H46pDYgW0U02usXv70Kihg==',  2900.50),
('3235252250801', 'Celso Geovani', 'Guitierrez Mendoza', 'BtNmcbSW8XXghKYEH6icMw==',  3600.75),
--sucursal norte
('3255252250901', 'Joel Francisco', 'Batz Tax', 'VyBsqTLE+jFQ8/i0FYbiVA==',  3200.00),
('3328255250901', 'Manuel Gerson', 'Pauc Tzoc', '9ODaFpeKUfaH5x0gxL4FeQ==',  3350.00),
('3448252350901', 'Maria Fernanda', 'Zapeta Soza', 'xTW4GmYRCpNNnaStIHHvng==',  2970.50),
('3235258250801', 'Lucia Noemi', 'Yax Yax', 'LS3iIr+SjuxNnaStIHHvng==',  3650.75),
--sucursal sur
('3255252250801', 'Josefa Maria', 'Marales Par', '3M03iWn9IpT5SxavPPlBKw==',  32220.00),
('3348255250902', 'Nancy Carmen', 'Mendoza Tzic', 'e6cG7DKXFGJwAxeahdCs8g==',  3350.00),
('3448252350903', 'Carmen Fernanda', 'Aguilar Mendoza', 'Q5Grz1loZT1QhO0uVvtwoQ==',  2970.50),
('3235258450801', 'Mario Joel', 'Tzoc Sapon', 'bsMvSKe0CNjghKYEH6icMw==',  3650.75),
--bodega
('3255252250902', 'Francisco Manuel', 'Batz Salcedo', 'yGa+cmRqadxyslmrrK4OdQ==',  3000.00),
('3328255250904', 'Manuel Rudy', 'Pauc Soza', '9ODaFpeKUfaH5x0gxL4FeQ==',  3150.00),
('3448272350901', 'Jerson Emanuel', 'Zapeta Tzoc', 'j6tlG73KrmGyN2HqBU6kqA==',  2970.50),
('3235278450801', 'Maria Jose', 'Tax Garcia', 'bsMvSKe0CNhNnaStIHHvng==',  3550.75),
--Admin
('3255752250801', 'Elvis Yonatan', 'Aguilar Velasquez', '6J7vgmDRUbIaClouSTf7dg==',  6300.00);

--cargos
INSERT INTO control_empleado.cargo(tipo_cargo, nombre_cargo) VALUES
(1, 'Vendedor'),(2, 'Encargado Inventario'),(3, 'Encargado Bodega'),(4, 'Administrador');

--RElacion empleado cargo
INSERT INTO control_empleado.cargo_empleado(codigo_cargo, cui_empleado) VALUES
(4, '3255752250801'), (3,'3255252250902'),(3,'3328255250904'),(3,'3448272350901'),(3,'3235278450801'),
(2,'3235258450801'),(2,'3235258250801'),(2,'3235252250801'),
(1,'3245252250901'),(1,'3348255250901'),(1,'3445252350901'),(1,'3255252250901'),(1,'3328255250901'),(1,'3448252350901'),
(1,'3255252250801'),(1,'3348255250902'),(1,'3448252350903');

--realcion entre empleado y sucursal que lo contrata
INSERT INTO control_empleado.empleado_sucursal(codigo_sucursal,cui_empleado) VALUES
(1,'3245252250901'),(2,'3255252250901'),(3,'3255252250801'),
(1,'3348255250901'),(2,'3328255250901'),(3,'3348255250902'),
(1,'3445252350901'),(2,'3448252350901'),(3,'3448252350903'),
(1,'3235252250801'),(2,'3235258250801'),(3,'3235258450801');

INSERT INTO control_empleado.empleado_bodega(codigo_bodega,cui_empleado) VALUES 
(1,'3255252250902'),
(1,'3328255250904'),
(1,'3448272350901'),
(1,'3235278450801');

/*
usuario 3245German Q5Grz1loZT1QhO0uVvtwoQ==
usuario 3348Jose iN1pQWJtQp9Q8/i0FYbiVA==
usuario 3345Fernando H46pDYgW0U02usXv70Kihg==
usuario 3235Celso BtNmcbSW8XXghKYEH6icMw==
usuario 3255Joel VyBsqTLE+jFQ8/i0FYbiVA==
usuario 3328Manuel 9ODaFpeKUfaH5x0gxL4FeQ==
usuario 3448Maria xTW4GmYRCpNNnaStIHHvng==
usuario 3235Lucia LS3iIr+SjuxNnaStIHHvng==
usuario 3255Josefa 3M03iWn9IpT5SxavPPlBKw==
usuario 3348Nancy e6cG7DKXFGJwAxeahdCs8g==
usuario 3448Carmen Q5Grz1loZT1QhO0uVvtwoQ==
usuario 3235Mario bsMvSKe0CNjghKYEH6icMw==
usuario 3255Francisco yGa+cmRqadxyslmrrK4OdQ==
usuario 3328Manuel 9ODaFpeKUfaH5x0gxL4FeQ==
usuario 3448Jerson j6tlG73KrmGyN2HqBU6kqA==
usuario 3235Maria bsMvSKe0CNhNnaStIHHvng==
usuario 3255Elvis 6J7vgmDRUbIaClouSTf7dg==
*/

