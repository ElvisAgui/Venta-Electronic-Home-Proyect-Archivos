/*
* Script para
* creacion de la base de datos de Electrodomesticos Electronic-Homes
* Schemas y Tablas
*/

--cracion tabla
CREATE DATABASE electronic_home;


--ingreso a la base de datos
\c electronic_home

--creacion Schemas
CREATE SCHEMA control_sucursal_bodega;      --schema que agurpa las tablas: bodega, sucursal, cuidad y realciones entre ellas
CREATE SCHEMA control_empleado;             --schema que agrupa las tablas: empleados, roles
CREATE SCHEMA control_producto;             --schema que agurpa las tablas: productos, marcas y sus relaciones
CREATE SCHEMA control_almacenamiento;       --schema que agrupa las tablas: almacenamiento de producto con refencia a bodega y sucurasales
CREATE SCHEMA control_venta;                --schema que agurpa las tablas: venta, items de venta, clientes

/*
* creacion de las respectivas tablas
*/

--tablas del schema control sucursal y de bodega
CREATE TABLE control_sucursal_bodega.cuidad(
    codigo_postal VARCHAR(15) PRIMARY KEY,
    localidad VARCHAR(100) NOT NULL,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE control_sucursal_bodega.sucursal(
    codigo_id SERIAL PRIMARY KEY,
    localidad VARCHAR(100) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(150) NOT NULL
);

CREATE TABLE control_sucursal_bodega.bodega(
    codigo_id SERIAL PRIMARY KEY,
    localidad VARCHAR(100) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(150) NOT NULL
);

CREATE TABLE control_sucursal_bodega.sucursal_cuidad(
    codigo_id SERIAL PRIMARY KEY,
    codigo_sucursal INTEGER NOT NULL,
    codigo_cuidad VARCHAR(15) NOT NULL,
    FOREIGN KEY (codigo_sucursal) REFERENCES control_sucursal_bodega.sucursal(codigo_id),
    FOREIGN KEY (codigo_cuidad) REFERENCES control_sucursal_bodega.cuidad(codigo_postal) ON UPDATE CASCADE
);


CREATE TABLE control_sucursal_bodega.bodega_cuidad(
    codigo_id SERIAL PRIMARY KEY,
    codigo_bodega INTEGER NOT NULL,
    codigo_cuidad VARCHAR(15) NOT NULL,
    FOREIGN KEY (codigo_bodega) REFERENCES control_sucursal_bodega.bodega(codigo_id),
    FOREIGN KEY (codigo_cuidad) REFERENCES control_sucursal_bodega.cuidad(codigo_postal) ON UPDATE CASCADE
);


--tablas del schema control de empleados
CREATE TABLE control_empleado.empleado(
    cui VARCHAR(13) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    passworde VARCHAR(100) NOT NULL,
    salario DECIMAL(10,2) NOT NULL
);

CREATE TABLE control_empleado.cargo(
    codigo_id SERIAL PRIMARY KEY,
    tipo_cargo SMALLINT NOT NULL,
    nombre_cargo VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE control_empleado.cargo_empleado(
    codigo_id SERIAL PRIMARY KEY,
    codigo_cargo INTEGER NOT NULL,
    cui_empleado VARCHAR(13) NOT NULL,
    FOREIGN KEY (codigo_cargo) REFERENCES control_empleado.cargo(codigo_id),
    FOREIGN KEY (cui_empleado) REFERENCES control_empleado.empleado(cui) ON UPDATE CASCADE
);

CREATE TABLE control_empleado.empleado_sucursal(
    codigo_id SERIAL PRIMARY KEY,
    codigo_sucursal INTEGER NOT NULL,
    cui_empleado VARCHAR(13) NOT NULL,
    FOREIGN KEY (cui_empleado) REFERENCES control_empleado.empleado(cui) ON UPDATE CASCADE,
    FOREIGN KEY (codigo_sucursal) REFERENCES control_sucursal_bodega.sucursal(codigo_id)
);

CREATE TABLE control_empleado.empleado_bodega(
    codigo_id SERIAL PRIMARY KEY,
    codigo_bodega INTEGER NOT NULL,
    cui_empleado VARCHAR(13) NOT NULL,
    FOREIGN KEY (codigo_bodega) REFERENCES control_sucursal_bodega.bodega(codigo_id),
    FOREIGN KEY (cui_empleado) REFERENCES control_empleado.empleado(cui) ON UPDATE CASCADE
);


--tablas del eschema control de productos
CREATE TABLE control_producto.producto(
    codigo VARCHAR(15) NOT NULL PRIMARY KEY,
    precio DECIMAL(10,2) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(150) NOT NULL
);

ALTER TABLE control_producto.producto DROP COLUMN precio;


CREATE TABLE control_producto.marca(
    codigo_id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    descripcion VARCHAR(150) NOT NULL
);

CREATE TABLE control_producto.producto_marca(
    codigo_id SERIAL PRIMARY KEY,
    codigo_marca INTEGER NOT NULL,
    codigo_producto VARCHAR(15) NOT NULL,
    FOREIGN KEY (codigo_marca) REFERENCES control_producto.marca(codigo_id),
    FOREIGN KEY (codigo_producto) REFERENCES control_producto.producto(codigo) ON UPDATE CASCADE
);
ALTER TABLE control_producto.producto_marca ADD COLUMN precio DECIMAL(10,2) NOT NULL;


--tablas del schema control de almacenamiento de productos en bodegas y sucursales
CREATE TABLE control_almacenamiento.bodega_almacenamiento_producto(
    codigo_id SERIAL PRIMARY KEY,
    codigo_producto INTEGER NOT NULL,
    codigo_bodega INTEGER NOT NULL,
    cantidad_existente INTEGER NOT NULL,
    fecha_adquisicion TIMESTAMP DEFAULT now(),
    FOREIGN KEY (codigo_bodega) REFERENCES control_sucursal_bodega.bodega(codigo_id),
    FOREIGN KEY (codigo_producto) REFERENCES control_producto.producto_marca(codigo_id)
);

CREATE TABLE control_almacenamiento.sucursal_almacenamiento_producto(
    codigo_id SERIAL PRIMARY KEY,
    codigo_producto INTEGER NOT NULL,
    codigo_sucursal INTEGER NOT NULL,
    cantidad_existente INTEGER NOT NULL,
    fecha_adquisicion TIMESTAMP DEFAULT now(),
    FOREIGN KEY (codigo_sucursal) REFERENCES control_sucursal_bodega.sucursal(codigo_id),
    FOREIGN KEY (codigo_producto) REFERENCES control_producto.producto_marca(codigo_id)  
);

CREATE TABLE control_almacenamiento.pedido(
    codigo_id SERIAL PRIMARY KEY,
    codigo_producto INTEGER NOT NULL,
    codigo_sucursal INTEGER,
    codigo_bodega INTEGER,
    sucural_solicitante VARCHAR(30) NOT NULL,
    cantidad INTEGER NOT NULL,
    estado VARCHAR(12) NOT NULL,
    cui_empleado VARCHAR(13) NOT NULL,
    FOREIGN KEY (codigo_sucursal) REFERENCES control_sucursal_bodega.sucursal(codigo_id),
    FOREIGN KEY (codigo_bodega) REFERENCES control_sucursal_bodega.bodega(codigo_id),
    FOREIGN KEY (codigo_producto) REFERENCES control_producto.producto_marca(codigo_id),  
    FOREIGN KEY (cui_empleado) REFERENCES control_empleado.empleado(cui) ON UPDATE CASCADE
);


--tablas del schema de control de ventas
CREATE TABLE control_venta.cliente(
    nit VARCHAR(13) NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL
);

CREATE TABLE control_venta.venta_producto(
    codigo VARCHAR(15) NOT NULL PRIMARY KEY,
    cantidad_producto INTEGER NOT NULL,
    total_gastado DECIMAL(10,2) NOT NULL,
    descuento DECIMAL(10,2) NOT NULL,
    ganacia_real DECIMAL(10,2) NOT NULL,
    cui_empleado VARCHAR(13) NOT NULL,
    nit_cliente VARCHAR(13) NOT NULL,
    codigo_sucursal INTEGER NOT NULL, 
    FOREIGN KEY (nit_cliente) REFERENCES control_venta.cliente(nit) ON UPDATE CASCADE,
    FOREIGN KEY (codigo_sucursal) REFERENCES control_sucursal_bodega.sucursal(codigo_id),
    FOREIGN KEY (cui_empleado) REFERENCES control_empleado.empleado(cui) ON UPDATE CASCADE
);
ALTER TABLE control_venta.venta_producto ALTER COLUMN codigo TYPE varchar(50);
ALTER TABLE control_venta.venta_producto ADD COLUMN fecha  TIMESTAMP DEFAULT now();

CREATE TABLE control_venta.items_venta_producto(
    codigo_id SERIAL NOT NULL PRIMARY KEY,
    cantidad_producto INTEGER NOT NULL,
    codigo_producto INTEGER NOT NULL,
    codigo_venta_producto VARCHAR(15) NOT NULL,
    FOREIGN KEY (codigo_venta_producto) REFERENCES control_venta.venta_producto(codigo),
    FOREIGN KEY (codigo_producto) REFERENCES control_producto.producto_marca(codigo_id)
);

ALTER TABLE control_venta.items_venta_producto ALTER COLUMN codigo_venta_producto  TYPE varchar(50);