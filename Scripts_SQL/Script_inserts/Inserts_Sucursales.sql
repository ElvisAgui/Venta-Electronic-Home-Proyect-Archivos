/*
*script para las inserciones iniciales del sucursales y bodega, de la cuidad
*/


 --ingresar con el usuario a la base de datos
psql -U usuario_sucursales electronic_home

--creacion de la cuidad
INSERT INTO control_sucursal_bodega.cuidad(codigo_postal, localidad, nombre) VALUES
('09000', 'Guatemala, departamento: Quetzaltenango', 'Quetzaltenango');

--creacion de las sucursales
INSERT INTO control_sucursal_bodega.sucursal(localidad, nombre, descripcion) VALUES
('Quetzaltenango, Quetzaltenango, zona 6, 4ta calle', 'Sucursal Central', 'sucursal ubicada en el centro de la cuidad, donde la demanda de productos es mayor por el numero de poblacion'),
('Quetzaltenango, Olintepeque, zona 3, 2da calle', 'Sucursal Norte', 'sucursal ubicada en el norte de la cuidad, donde la demanda de productos es mediana por el numero de poblacion reducida'),
('Quetzaltenango, Zunil, aldea central', 'Sucursal Sur', 'sucursal ubicada en el sur de la cuidad, donde la demanda de productos es baja por el numero de poblacion reducida');

--creacion de la bodega
INSERT INTO control_sucursal_bodega.bodega(localidad, nombre, descripcion) VALUES
('Quetzaltenango, Salcaja, zona central , camino principal', 'Bodega Central', 'bodega ubicada en el centro de la cuidad, para distribucion de la misma');

--realciones entre ellas
INSERT INTO control_sucursal_bodega.sucursal_cuidad(codigo_sucursal,codigo_cuidad) VALUES
(1,'09000'), (2,'09000'), (3, '09000');

INSERT INTO control_sucursal_bodega.bodega_cuidad(codigo_bodega,codigo_cuidad) VALUES
(1,'09000');