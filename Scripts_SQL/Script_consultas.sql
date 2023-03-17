SELECT empleado.*, cargo.tipo_cargo, cargo.nombre_cargo, empSucur.codigo_sucursal
FROM control_empleado.empleado AS empleado
INNER JOIN control_empleado.cargo_empleado AS cargoEmp
ON empleado.cui = cargoEmp.cui_empleado 
INNER JOIN control_empleado.cargo AS cargo
ON cargo.codigo_id=cargoEmp.codigo_cargo
INNER JOIN control_empleado.empleado_sucursal AS empSucur
ON empleado.cui = empSucur.cui_empleado
WHERE empleado.cui='3245252250901' AND empleado.passworde='Q5Grz1loZT1QhO0uVvtwoQ==' ;