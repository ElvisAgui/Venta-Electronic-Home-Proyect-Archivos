SELECT empleado.*, cargo.tipo_cargo, cargo.nombre_cargo, empSucur.codigo_sucursal
FROM control_empleado.empleado AS empleado
INNER JOIN control_empleado.cargo_empleado AS cargoEmp
ON empleado.cui = cargoEmp.cui_empleado 
INNER JOIN control_empleado.cargo AS cargo
ON cargo.codigo_id=cargoEmp.codigo_cargo
INNER JOIN control_empleado.empleado_sucursal AS empSucur
ON empleado.cui = empSucur.cui_empleado
WHERE empleado.cui='3245252250901' AND empleado.passworde='Q5Grz1loZT1QhO0uVvtwoQ==' ;

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
INNER JOIN control_almacenamiento.sucursal_almacenamiento_producto AS almacen_S
ON almacen_S.codigo_producto = pro_Marc.codigo_id
WHERE almacen_S.codigo_sucursal = 1;

SELECT ganacia_real FROM control_venta.venta_producto WHERE nit_cliente = '35152273';

SELECT ganacia_real FROM control_venta.venta_producto WHERE nit_cliente = '35152273'ORDER BY fecha DESC LIMIT 1;;