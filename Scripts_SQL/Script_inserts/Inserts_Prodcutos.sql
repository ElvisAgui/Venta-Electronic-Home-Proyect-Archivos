/*
*Script encargado de insertar a los productos, marcas 
*/

 --ingresar con el usuario a la base de datos
psql -U usuario_productos electronic_home

--convencion de codigos de producto: numeros de 4 digitos dos ceros al iinicio y dos al final
--ejemplo 00XXXX00 donde X son los digitos entre 1-9
INSERT INTO control_producto.producto(codigo, nombre, descripcion) VALUES
('00123400','Licuadora','Licuadora de 3 velocidades super resistente'),
('00125600','Batidora de mano','Batidora de mano util para la cocina'),
('00112600','Batidora de vaso','Batidora de vaso mejor utilidad'),
('00165600','Cafetera de Goteo','cafetera de consumo reducido'),
('00178600','Cafetera italiana','Cafetera italiana moderna para el cafe'),
('00781600','Tostadora','Tostadora de pan, con sensores de calentamiento'),
('00156600','Sandwichera','Para hacer los sandwiches mas ricos'),
('00156900','Plancha de ropa','Deja tu ropa sin arrugas'),
('00186600','Aspiradora de mano','Aspiradora tradicional para mejor comodidad'),
('00165500','Aspiradora de trineo','Aspiradora con trineo para espacios extensos y para mejor comodidad'),
('00169600','Robot aspirador','Aspiradora sin tener que trabajar de mas'),
('00177600','Lavadora','Lavadora, con capacidad de 49gal'),
('00169900','Secadora de ropa','contiene calibrador para el aire de salida'),
('00199600','Lavavajillas','Capacidad grande y usable de varias maneras'),
('00145600','Refrigeradora','Refrigeradora Mediana'),
('00167700','Congelador','Mantiene los productos a bajas temperaturas para conservarlas'),
('00176600','Horno eléctrico','Con cabina extra grande'),
('00115600','Microondas','Microondas pequeño, bajo consumo'),
('00196600','Freidora','Frie las cosas a un punto de coccion al gusto'),
('00191600','Parrilla eléctrica','Parrilla para los asados, electrica, simula las basas'),
('00169500','Estufa eléctrica','Estufa para cocina, electrica con resistencias'),
('00151600','Campana extractora','Campana que extrae olores'),
('00116600','Deshumidificador','utili para quitar la humedad de los lugares'),
('00111600','Humidificador','Humificador util para agregar humedad al aire'),
('00161100','Ventilador de pie','Ventilador para colocar en el piso, especial para los pies'),
('00162200','Ventilador de techo','Ventilador tipo colgable'),
('00163300','Aire acondicionado portátil','Maquina de aire acodicionado util para lugares con frio o calor'),
('00164400','Enfriador de aire evaporativo','enfriador para el aire que se evapora'),
('00155600','Calefactor eléctrico','calefactor con 4 cambios de calor'),
('00166600','Termo eléctrico','termo electronico de 4 vasos');

--Marcas
INSERT INTO control_producto.marca(nombre, descripcion) VALUES 
('Samsung','Marca Creadora y Distribuidora de electrodomesticos'),
('LG','Marca Creadora y Distribuidora de electrodomesticos'),
('Whirlpool','Marca Creadora y Distribuidora de electrodomesticos'),
('Bosch','Marca Creadora y Distribuidora de electrodomesticos'),
('General Electric (GE)','Marca Creadora y Distribuidora de electrodomesticos'),
('Electrolux','Marca Creadora y Distribuidora de electrodomesticos'),
('Philips','Marca Creadora y Distribuidora de electrodomesticos'),
('Panasonic','Marca Creadora y Distribuidora de electrodomesticos'),
('Sharp','Marca Creadora y Distribuidora de electrodomesticos'),
('Sony','Marca Creadora y Distribuidora de electrodomesticos'),
('Miele','Marca Creadora y Distribuidora de electrodomesticos'),
('Dyson','Marca Creadora y Distribuidora de electrodomesticos'),
('Kenmore','Marca Creadora y Distribuidora de electrodomesticos'),
('KitchenAid','Marca Creadora y Distribuidora de electrodomesticos'),
('Siemens','Marca Creadora y Distribuidora de electrodomesticos');

--representacion de los productos diferentes
INSERT INTO control_producto.producto_marca(codigo_marca, codigo_producto, precio) VALUES
(1,'00123400',1200.93),(1,'00156600',1499.99),(1,'00163300',939.65),(2,'00162200',1099.17),(2,'00169500',2139.5),(2,'00116600',550.2),
(3,'00116600',725.65),(3,'00196600',1899.99),(3,'00199600',1100.55),(4,'00163300',1598.9),(4,'00169900',2200.15),(4,'00112600',690.30),
(5,'00161100',520.20),(5,'00166600',420.25),(6,'00115600',1750.29),(6,'00177600',3800.20),(7,'00169600',950.25),(8,'00196600',725.25),
(9,'00196600',855.15),(9,'00161100',650.5),(11,'00167700',350.25),(11,'00156900',689.63),(10,'00145600',3565.25),(10,'00165600',1100.64),
(12,'00164400',850.25),(12,'00161100',450.25),(12,'00167700',450.5),(13,'00156900',758.26),(13,'00145600',2789.25),(13,'00165600',1225.25),
(14,'00164400',980.65),(14,'00161100',395.25),(14,'00167700',498.26),(15,'00156900',940.15),(15,'00145600',3100.25),(15,'00165600',1450.25);



--update para ingresar el precio de cada producto_marca inicialmente estaban en producto
/*
UPDATE control_producto.producto_marca SET precio = 1200.93 WHERE codigo_id=1;
UPDATE control_producto.producto_marca SET precio = 1499.99 WHERE codigo_id=2;
UPDATE control_producto.producto_marca SET precio = 939.65 WHERE codigo_id=3;
UPDATE control_producto.producto_marca SET precio = 1099.17 WHERE codigo_id=4;
UPDATE control_producto.producto_marca SET precio = 2139.5 WHERE codigo_id=5;
UPDATE control_producto.producto_marca SET precio = 550.2 WHERE codigo_id=6;
UPDATE control_producto.producto_marca SET precio = 725.65 WHERE codigo_id=7;
UPDATE control_producto.producto_marca SET precio = 1899.99 WHERE codigo_id=8;
UPDATE control_producto.producto_marca SET precio = 1100.55 WHERE codigo_id=9;
UPDATE control_producto.producto_marca SET precio = 1598.9 WHERE codigo_id=10;
UPDATE control_producto.producto_marca SET precio = 2200.15 WHERE codigo_id=11;
UPDATE control_producto.producto_marca SET precio = 690.30 WHERE codigo_id=12;
UPDATE control_producto.producto_marca SET precio = 520.20 WHERE codigo_id=13;
UPDATE control_producto.producto_marca SET precio = 420.25 WHERE codigo_id=14;
UPDATE control_producto.producto_marca SET precio = 1750.29 WHERE codigo_id=15;
UPDATE control_producto.producto_marca SET precio = 3800.20 WHERE codigo_id=16;
UPDATE control_producto.producto_marca SET precio = 950.25 WHERE codigo_id=17;
UPDATE control_producto.producto_marca SET precio = 725.25 WHERE codigo_id=18;
UPDATE control_producto.producto_marca SET precio = 855.15 WHERE codigo_id=19;
UPDATE control_producto.producto_marca SET precio = 650.5 WHERE codigo_id=20;
UPDATE control_producto.producto_marca SET precio = 350.25 WHERE codigo_id=21;
UPDATE control_producto.producto_marca SET precio = 689.63 WHERE codigo_id=22;
UPDATE control_producto.producto_marca SET precio = 3565.25 WHERE codigo_id=23;
UPDATE control_producto.producto_marca SET precio = 1100.64 WHERE codigo_id=24;
UPDATE control_producto.producto_marca SET precio = 850.25 WHERE codigo_id=25;
UPDATE control_producto.producto_marca SET precio = 450.25 WHERE codigo_id=26;
UPDATE control_producto.producto_marca SET precio = 450.5 WHERE codigo_id=27;
UPDATE control_producto.producto_marca SET precio = 758.26 WHERE codigo_id=28;
UPDATE control_producto.producto_marca SET precio = 2789.25 WHERE codigo_id=29;
UPDATE control_producto.producto_marca SET precio = 1225.25 WHERE codigo_id=30;
UPDATE control_producto.producto_marca SET precio = 980.65 WHERE codigo_id=31;
UPDATE control_producto.producto_marca SET precio = 395.25 WHERE codigo_id=32;
UPDATE control_producto.producto_marca SET precio = 498.26 WHERE codigo_id=33;
UPDATE control_producto.producto_marca SET precio = 940.15 WHERE codigo_id=34;
UPDATE control_producto.producto_marca SET precio = 3100.25 WHERE codigo_id=35;
UPDATE control_producto.producto_marca SET precio = 1450.25 WHERE codigo_id=36;
*/
