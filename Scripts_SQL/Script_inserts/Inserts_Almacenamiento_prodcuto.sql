/*
*script para las inserciones iniciales de los almacenamientos de bodega y sucursales con los respectivos productos
*/


 --ingresar con el usuario a la base de datos
psql -U usuario_almacemientos electronic_home

--registros de la bodega y productos almacenados en ella
INSERT INTO control_almacenamiento.bodega_almacenamiento_producto(codigo_producto, codigo_bodega, cantidad_existente) VALUES 
(1,1,3),(2,1,4),(3,1,3),(4,1,5),(5,1,2),(6,1,3),(7,1,4),(8,1,3),(9,1,1),(10,1,4),(11,1,3),(12,1,3),(13,1,1),(14,1,7),(15,1,6),
(16,1,3),(17,1,2),(18,1,3),(19,1,7),(20,1,5),(21,1,3),(22,1,3),(23,1,3),(24,1,1),(25,1,2),(26,1,3),(27,1,1),(28,1,4),(29,1,5),(30,1,2);

INSERT INTO control_almacenamiento.sucursal_almacenamiento_producto(codigo_producto,codigo_sucursal,cantidad_existente) VALUES 
--sucursal central
(1,1,3),(2,1,4),(3,1,3),(4,1,5),(5,1,2),(6,1,3),(7,1,4),(8,1,3),(9,1,1),(10,1,4),(11,1,3),(12,1,3),(13,1,1),(14,1,7),(15,1,6),
(16,1,1),(17,1,2),(18,1,3),(19,1,7),(20,1,2),(21,1,3),(22,1,1),(33,1,3),(24,1,1),(34,1,2),(26,1,3),(36,1,1),(28,1,4),(35,1,5),(30,1,2),
--sucursal norte
(1,2,3),(2,2,4),(3,2,3),(31,2,4),(5,2,1),(30,2,1),(25,2,4),(8,2,3),(9,2,1),(10,2,2),(36,2,2),(12,2,4),(13,2,3),(14,2,2),(15,2,1),
(16,2,1),(17,2,2),(18,2,1),(19,2,2),(20,2,3),(21,2,3),(22,2,1),(33,2,3),(24,2,1),(34,2,2),
--sucursal sur
(1,3,3),(2,3,1),(3,3,1),(4,3,1),(5,3,1),(16,3,1),(7,3,2),(18,3,1),(19,3,1),(20,3,2),(11,3,1),(24,3,1),(13,3,1),(31,3,1),(33,3,2);