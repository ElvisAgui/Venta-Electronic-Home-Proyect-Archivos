/*
*usuarios y roles gestores de la base de datos
*cada usuario se le asignara roles para gestionar la base de datos, por schemas y tablas 
*existiran 5 usuarios, encargado de ventas, empleados, producto, almacenamientos y bodega junto a sucursal
*/

\c electronic_home  --ingrese a la base de datos primero

--Creacion de Usuarios
CREATE USER usuario_ventas WITH PASSWORD 'User1PsqlVentas?';                --usuarios encargado de todo lo realcionado a: las ventas como clientes, y venta                        
CREATE USER usuario_empleados WITH PASSWORD 'User2PsqlEmpleados?';          --usuarios encargado de todo lo realcionado a: los empleados como cargos y puestos de trabajo         
CREATE USER usuario_productos WITH PASSWORD 'User3Psqlproductos?';          --usuarios encargado de todo lo realcionado a: los productos como marcas, producto         
CREATE USER usuario_almacemientos WITH PASSWORD 'User4PsqlAlmacenes?';      --usuarios encargado de todo lo realcionado a: gestionar los alamcenamientos de los productos en sucursales y bodega    
CREATE USER usuario_sucursales WITH PASSWORD 'User5PsqlSucursales?';        --usuarios encargado de todo lo realcionado a: gestionar las bodegas y sucrusales    



/*
*apartado para creacion de roles
*cada rol sera encargado de cada schema, esto con fienes de eficiencia y no estar creado
*roles por cada tabla
*Todos los roles podran, insertar, modificar y consultar.
*/

--creacion de rol encargado del Schema 'control_sucursal_bodega'
CREATE ROLE gestor_sucursales;
GRANT CONNECT ON DATABASE electronic_home TO gestor_sucursales;
GRANT USAGE ON SCHEMA control_sucursal_bodega TO gestor_sucursales;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA control_sucursal_bodega TO gestor_sucursales;
ALTER DEFAULT PRIVILEGES IN SCHEMA control_sucursal_bodega GRANT SELECT, INSERT, UPDATE ON TABLES TO gestor_sucursales; 
GRANT USAGE ON ALL SEQUENCES IN SCHEMA control_sucursal_bodega TO gestor_sucursales;

--creacion de rol encargado del schema 'control_empleado'
CREATE ROLE gestor_empleado;
GRANT CONNECT ON DATABASE electronic_home TO gestor_empleado;
GRANT USAGE ON SCHEMA control_empleado TO gestor_empleado;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA control_empleado TO gestor_empleado;
ALTER DEFAULT PRIVILEGES IN SCHEMA control_empleado GRANT SELECT, INSERT, UPDATE ON TABLES TO gestor_empleado;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA control_empleado TO gestor_empleado;

--creacion de rol encargado del schema 'control_producto'
CREATE ROLE gestor_productos;
GRANT CONNECT ON DATABASE electronic_home TO gestor_productos;
GRANT USAGE ON SCHEMA control_producto TO gestor_productos;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA control_producto TO gestor_productos;
ALTER DEFAULT PRIVILEGES IN SCHEMA control_producto GRANT SELECT, INSERT, UPDATE ON TABLES TO gestor_productos;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA control_producto TO gestor_productos;

--creacion de rol encargado del schema 'control_almacenamiento'
CREATE ROLE gestor_almacenamiento;
GRANT CONNECT ON DATABASE electronic_home TO gestor_almacenamiento;
GRANT USAGE ON SCHEMA control_almacenamiento TO gestor_almacenamiento;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA control_almacenamiento TO gestor_almacenamiento;
ALTER DEFAULT PRIVILEGES IN SCHEMA control_almacenamiento GRANT SELECT, INSERT, UPDATE ON TABLES TO gestor_almacenamiento;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA control_almacenamiento TO gestor_almacenamiento;

--creacion de rol encargado del schema 'control_venta'
CREATE ROLE gestor_ventas;
GRANT CONNECT ON DATABASE electronic_home TO gestor_ventas;
GRANT USAGE ON SCHEMA control_venta TO gestor_ventas;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA control_venta TO gestor_ventas;
ALTER DEFAULT PRIVILEGES IN SCHEMA control_venta GRANT SELECT, INSERT, UPDATE ON TABLES TO gestor_ventas;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA control_venta TO gestor_ventas;


/*
*apartado para asignar cada rol a cada usuario
*/
GRANT gestor_sucursales TO usuario_sucursales;
GRANT gestor_almacenamiento TO usuario_almacemientos;
GRANT gestor_empleado TO usuario_empleados;
GRANT gestor_productos TO usuario_productos;
GRANT gestor_ventas TO usuario_ventas;