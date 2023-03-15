/*
*script para las inserciones iniciales de las ventas, asi como clientes
*/


 --ingresar con el usuario a la base de datos
psql -U usuario_ventas electronic_home

--inserts de los clientes
INSERT INTO control_venta.cliente(nit, nombre, apellido) VALUES
('43214643', 'Miguel Elias', 'Barrios Perez'),('42236643', 'Francisco Ricardo', 'Vasquez Toc'),
('35152273', 'Luis Rodrigo', 'Zapeta Ixcaquic'),('65224643', 'Abigail Noemi', 'Ixcaquic Puac'),
('15234643', 'Maria Fernanda', 'Menchu Tzoc'),('26324643', 'Jorge Raul', 'Mendoza Tzul'),
('43221543', 'Mercedes Florinda', 'Flores Perez'),('43156543', 'Ingrid Elvira', 'Sapon Yax'),
('45614643', 'Mario Rodrigo', 'Ixchajchal Tzul'),('43212373', 'Sharon Abigail', 'Tzicap Aguilar'),
('86316443', 'Consumidor', 'Final');

--convencion para los codigos de venta: encript al igual que los password: venta#1 = 'WRYcRSvDdWs='
INSERT INTO control_venta.venta_producto(codigo, cantidad_producto, total_gastado, descuento, ganacia_real, cui_empleado, nit_cliente, codigo_sucursal) VALUES 
--ventas del sucursal sur
('WRYcRSvDdWs=', 3, 3426.57, 0, 3426.57,'3245252250901','43214643',1),
('0DfefmX5uKQ=', 3, 2926.35, 0, 2926.35,'3348255250901','42236643',1),
('QPNXKI0WeHM=', 2, 1900.5, 0, 1900.5,'3445252350901','35152273',1),
('bSHY8gLDB+A=', 4, 5379.4, 0, 5379.4,'3245252250901','65224643',1),
('dgbB3WgvM/U=', 1, 2200.15, 0, 2200.15,'3348255250901','15234643',1),
--ventas del sucursal norte
('CXMKFLtdTX0=', 2, 1792.85, 0, 1792.85,'3255252250901','26324643',2),
('5grnR3xd0iY=', 3, 2410.06, 0, 2410.06,'3255252250901','43221543',2),
('pdjD15JHKeg=', 1, 350.25, 0, 350.25,'3448252350901','43156543',2),
('atji8fPIZnw=', 4, 1401.00, 0, 1401.00,'3328255250901','45614643',2),
('u3bLMi71185Q8/i0FYbiVA==', 1, 1750.29, 0, 1750.29,'3328255250901','43212373',2),
--ventas del sucursal Sur
('KuNVU8SRzHRQ8/i0FYbiVA==', 1, 498.26, 0, 498.26,'3255252250801','86316443',3),
('33KAmbq7h/BQ8/i0FYbiVA==', 2, 1665.3, 0, 1665.3,'3348255250902','86316443',3),
('Fzm4+LOhhOVQ8/i0FYbiVA==', 2, 1953.32, 0, 953.32,'3448252350903','43156543',3),
('GbmXSqfEbQVQ8/i0FYbiVA==', 1, 2139.50, 24.79, 2096.71,'3448252350903','35152273',3),
('esV3waXy3hJQ8/i0FYbiVA==', 1, 3800.2, 76.00, 3724.42,'3348255250902','45614643',3);

--inserciones para los items de la compra
INSERT INTO control_venta.items_venta_producto(cantidad_producto, codigo_producto, codigo_venta_producto) VALUES 
(1,1,'WRYcRSvDdWs='),(1,2,'WRYcRSvDdWs='),(1,7,'WRYcRSvDdWs='),
(2,9,'0DfefmX5uKQ='),(1,18,'0DfefmX5uKQ='),
(2,17,'QPNXKI0WeHM='),
(2,5,'bSHY8gLDB+A='),(2,6,'bSHY8gLDB+A='),
(1,11,'dgbB3WgvM/U='),
(1,9,'CXMKFLtdTX0='),(1,12,'CXMKFLtdTX0='),
(1,34,'5grnR3xd0iY='),(1,33,'5grnR3xd0iY='),(1,31,'5grnR3xd0iY='),
(1,21,'pdjD15JHKeg='),(1,15,'u3bLMi71185Q8/i0FYbiVA=='),
(4,21,'atji8fPIZnw='),
(1,33,'KuNVU8SRzHRQ8/i0FYbiVA=='),
(1,3,'33KAmbq7h/BQ8/i0FYbiVA=='),(1,7,'33KAmbq7h/BQ8/i0FYbiVA=='),
(1,19,'Fzm4+LOhhOVQ8/i0FYbiVA=='),(1,4,'Fzm4+LOhhOVQ8/i0FYbiVA=='),
(1,5,'GbmXSqfEbQVQ8/i0FYbiVA=='),
(1,16,'esV3waXy3hJQ8/i0FYbiVA==');









