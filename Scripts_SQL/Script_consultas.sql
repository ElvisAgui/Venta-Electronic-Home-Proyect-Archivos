SELECT empleado.*, cargo.tipo_cargo, cargo.nombre_cargo, empSucur.empleado_bodega
FROM control_empleado.empleado AS empleado
INNER JOIN control_empleado.cargo_empleado AS cargoEmp
ON empleado.cui = cargoEmp.cui_empleado 
INNER JOIN control_empleado.cargo AS cargo
ON cargo.codigo_id=cargoEmp.codigo_cargo
INNER JOIN control_empleado.empleado_bodega AS empSucur
ON empleado.cui = empSucur.cui_empleado
WHERE empleado.cui='3255252250902' AND empleado.passworde='yGa+cmRqadxyslmrrK4OdQ==' ;

SELECT pro_Marc.codigo_id, producto.nombre, producto.precio, marca.nombre,  almacen_S.cantidad_existente
FROM control_producto.producto AS producto
INNER JOIN control_producto.producto_marca AS pro_Marc
ON producto.codigo = pro_Marc.codigo_producto
INNER JOIN control_producto.marca AS marca
ON marca.codigo_id=pro_Marc.codigo_marca 
INNER JOIN control_almacenamiento.sucursal_almacenamiento_producto AS almacen_S
ON almacen_S.codigo_producto = pro_Marc.codigo_id
WHERE almacen_S.codigo_sucursal = 1 AND producto.codigo='00156600';


SELECT pro_Marc.codigo_id, producto.nombre, producto.precio, marca.nombre,  almacen_S.cantidad_existente, producto.codigo
FROM control_producto.producto AS producto
INNER JOIN control_producto.producto_marca AS pro_Marc
ON producto.codigo = pro_Marc.codigo_producto
INNER JOIN control_producto.marca AS marca
ON marca.codigo_id=pro_Marc.codigo_marca 
INNER JOIN control_almacenamiento.bodega_almacenamiento_producto AS almacen_S
ON almacen_S.codigo_producto = pro_Marc.codigo_id
WHERE almacen_S.codigo_bodega = 1;

SELECT ganacia_real FROM control_venta.venta_producto WHERE nit_cliente = '35152273';

SELECT ganacia_real FROM control_venta.venta_producto WHERE nit_cliente = '35152273'ORDER BY fecha DESC LIMIT 1;;


SELECT pedido.*, producto.nombre, marca.nombre AS "marca", producto.codigo
FROM control_almacenamiento.pedido AS pedido 
INNER JOIN control_producto.producto_marca AS pro_Marc
ON pedido.codigo_producto=pro_Marc.codigo_id
INNER JOIN control_producto.producto AS producto
ON producto.codigo = pro_Marc.codigo_producto
INNER JOIN control_producto.marca AS marca
ON marca.codigo_id=pro_Marc.codigo_marca
WHERE pedido.estado = 'Enviado' AND pedido.codigo_sucursal=1;
 
SELECT venta.nit_cliente, cliente.nombre, cliente.apellido,
SUM(venta.total_gastado) AS Ganancia, SUM(venta.cantidad_producto) AS productos
FROM control_venta.venta_producto AS venta
INNER JOIN control_venta.cliente AS cliente
ON venta.nit_cliente = cliente.nit
GROUP BY nit_cliente,cliente.nombre, cliente.apellido
ORDER BY Ganancia DESC LIMIT 10;


--empleados con más ventas 
SELECT venta.cui_empleado, empleado.nombre, empleado.apellido,
SUM(venta.cantidad_producto) AS productos
FROM control_venta.venta_producto AS venta
INNER JOIN control_empleado.empleado AS empleado
ON venta.cui_empleado = empleado.cui
GROUP BY venta.cui_empleado,empleado.nombre, empleado.apellido
ORDER BY productos DESC LIMIT 10;

---empleados con más ingresos 

SELECT venta.cui_empleado, empleado.nombre, empleado.apellido,
SUM(venta.total_gastado) AS Ganancia
FROM control_venta.venta_producto AS venta
INNER JOIN control_empleado.empleado AS empleado
ON venta.cui_empleado = empleado.cui
GROUP BY venta.cui_empleado,empleado.nombre, empleado.apellido
ORDER BY Ganancia DESC LIMIT 3;


--productos más vendidos
SELECT producto.codigo, producto.nombre, prod_Marc.precio, marca.nombre AS  "marca",
SUM(item.cantidad_producto) AS veces_vendida
FROM control_venta.items_venta_producto AS item
INNER JOIN control_producto.producto_marca AS prod_marc
ON item.codigo_producto = prod_marc.codigo_id
INNER JOIN control_producto.producto AS producto
ON prod_marc.codigo_producto = producto.codigo
INNER JOIN control_producto.marca AS marca
ON prod_marc.codigo_marca = marca.codigo_id
GROUP BY producto.codigo, producto.nombre, prod_Marc.precio,marca.nombre,item.codigo_producto
ORDER BY veces_vendida DESC LIMIT 10;


SELECT control_venta.items_venta_producto.codigo_producto , SUM(control_venta.items_venta_producto.cantidad_producto)  AS veces_vendida FROM control_venta.items_venta_producto
GROUP BY control_venta.items_venta_producto.codigo_producto
ORDER BY veces_vendida DESC LIMIT 10;


--productos más ingresos
SELECT producto.codigo, producto.nombre, prod_Marc.precio, marca.nombre AS  "marca",
SUM(item.cantidad_producto) * prod_Marc.precio AS ingresos
FROM control_venta.items_venta_producto AS item
INNER JOIN control_producto.producto_marca AS prod_marc
ON item.codigo_producto = prod_marc.codigo_id
INNER JOIN control_producto.producto AS producto
ON prod_marc.codigo_producto = producto.codigo
INNER JOIN control_producto.marca AS marca
ON prod_marc.codigo_marca = marca.codigo_id
GROUP BY producto.codigo, producto.nombre, prod_Marc.precio,marca.nombre,item.codigo_producto
ORDER BY ingresos DESC LIMIT 10;


--productos más vendidos por sucursal
SELECT producto.codigo, producto.nombre, prod_Marc.precio, marca.nombre AS  "marca",
SUM(item.cantidad_producto) AS veces_vendida
FROM control_venta.items_venta_producto AS item
INNER JOIN control_producto.producto_marca AS prod_marc
ON item.codigo_producto = prod_marc.codigo_id
INNER JOIN control_producto.producto AS producto
ON prod_marc.codigo_producto = producto.codigo
INNER JOIN control_producto.marca AS marca
ON prod_marc.codigo_marca = marca.codigo_id
INNER JOIN control_venta.venta_producto AS venta
ON venta.codigo = item.codigo_venta_producto
WHERE venta.codigo_sucursal=1
GROUP BY producto.codigo, producto.nombre, prod_Marc.precio,marca.nombre,item.codigo_producto
ORDER BY veces_vendida DESC LIMIT 5;


--productos más ingresos oor sucursal
SELECT producto.codigo, producto.nombre, prod_Marc.precio, marca.nombre AS  "marca",
SUM(item.cantidad_producto) * prod_Marc.precio AS ingresos
FROM control_venta.items_venta_producto AS item
INNER JOIN control_producto.producto_marca AS prod_marc
ON item.codigo_producto = prod_marc.codigo_id
INNER JOIN control_producto.producto AS producto
ON prod_marc.codigo_producto = producto.codigo
INNER JOIN control_producto.marca AS marca
ON prod_marc.codigo_marca = marca.codigo_id
INNER JOIN control_venta.venta_producto AS venta
ON venta.codigo = item.codigo_venta_producto
WHERE venta.codigo_sucursal=1
GROUP BY producto.codigo, producto.nombre, prod_Marc.precio,marca.nombre,item.codigo_producto
ORDER BY ingresos DESC LIMIT 5;


--sucursal mas ventas
SELECT control_sucursal_bodega.sucursal.nombre, COUNT(*) AS total_ventas
FROM control_venta.venta_producto INNER JOIN
control_sucursal_bodega.sucursal ON control_sucursal_bodega.sucursal.codigo_id=control_venta.venta_producto.codigo_sucursal
GROUP BY codigo_sucursal,control_sucursal_bodega.sucursal.nombre
ORDER BY total_ventas DESC;


--sucursal mas ingresos
SELECT control_sucursal_bodega.sucursal.nombre, SUM(control_venta.venta_producto.total_gastado) AS total_ganancia
FROM control_venta.venta_producto INNER JOIN
control_sucursal_bodega.sucursal ON control_sucursal_bodega.sucursal.codigo_id=control_venta.venta_producto.codigo_sucursal
GROUP BY control_venta.venta_producto.codigo_sucursal,control_sucursal_bodega.sucursal.nombre
ORDER BY total_ganancia DESC;





INSERT INTO control_producto.producto(codigo, nombre, descripcion, precio) VALUES
('00111100','Deshumidificador LG 01','Deshumidificador marca lg mayor resistencia',520.99);--lG

UPDATE control_producto.producto_marca SET codigo_producto='00111100' WHERE codigo_id = 6;

INSERT INTO control_producto.producto(codigo, nombre, descripcion, precio) VALUES
('00112100','Aire acondicionado portátil','Aire acondicionado de otra marca',1120.99);--bosh

UPDATE control_producto.producto_marca SET codigo_producto='00112100' WHERE codigo_id = 10;


INSERT INTO control_producto.producto(codigo, nombre, descripcion) VALUES
('00222100','Freidora','Freidora integrada');--panasonic

UPDATE control_producto.producto_marca SET codigo_producto='00222100' WHERE codigo_id = 18;


INSERT INTO control_producto.producto(codigo, nombre, descripcion) VALUES
('00222200','Freidora','Freidora integrada');--panasonic

UPDATE control_producto.producto_marca SET codigo_producto='00222200' WHERE codigo_id = 19;



INSERT INTO control_producto.producto(codigo, nombre, descripcion) VALUES
('00555200','Ventilador de pie','ventilador para el pie y suelos');--panasonic

UPDATE control_producto.producto_marca SET codigo_producto='00555200' WHERE codigo_id = 20;


INSERT INTO control_producto.producto(codigo, nombre, descripcion) VALUES
('00333200','Ventilador de pie','ventilador para el pie y suelos');--panasonic

UPDATE control_producto.producto_marca SET codigo_producto='00333200' WHERE codigo_id = 26;


INSERT INTO control_producto.producto(codigo, nombre, descripcion) VALUES
('00566200','Congelador','Congelador de alta resistencia');--panasonic

UPDATE control_producto.producto_marca SET codigo_producto='00566200' WHERE codigo_id = 33;

INSERT INTO control_producto.producto(codigo, nombre, descripcion) VALUES
('00996200','Congelador','Congelador de alta resistencia');--panasonic

UPDATE control_producto.producto_marca SET codigo_producto='00996200' WHERE codigo_id = 27;


INSERT INTO control_producto.producto(codigo, nombre, descripcion) VALUES
('00566600','Plancha para Ropa','Planca de ropa');--panasonic

UPDATE control_producto.producto_marca SET codigo_producto='00566600' WHERE codigo_id = 28;


INSERT INTO control_producto.producto(codigo, nombre, descripcion) VALUES
('00776600','Plancha para Ropa','Planca de ropa');--panasonic

UPDATE control_producto.producto_marca SET codigo_producto='00776600' WHERE codigo_id = 34;


INSERT INTO control_producto.producto(codigo, nombre, descripcion) VALUES
('00888700','Cafetera de Goteo','cafetera con altas temperaturas');--panasonic

UPDATE control_producto.producto_marca SET codigo_producto='00888700' WHERE codigo_id = 30;

INSERT INTO control_producto.producto(codigo, nombre, descripcion) VALUES
('00878700','Cafetera de Goteo','cafetera con altas temperaturas');--panasonic

UPDATE control_producto.producto_marca SET codigo_producto='00878700' WHERE codigo_id = 36;

INSERT INTO control_producto.producto(codigo, nombre, descripcion) VALUES
('00448700','Refrigeradora Mediana','Refri mediana para familias pequeñas');--panasonic

UPDATE control_producto.producto_marca SET codigo_producto='00448700' WHERE codigo_id = 29;