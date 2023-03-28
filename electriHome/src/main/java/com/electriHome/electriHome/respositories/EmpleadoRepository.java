package com.electriHome.electriHome.respositories;

import com.electriHome.electriHome.models.User;
import com.electriHome.electriHome.models.empleados.Empleado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elvis_agui
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

    @Query(value = "SELECT empleado.*, cargo.tipo_cargo, cargo.nombre_cargo, empSucur.codigo_sucursal\n"
            + "FROM control_empleado.empleado AS empleado "
            + "INNER JOIN control_empleado.cargo_empleado AS cargoEmp "
            + "ON empleado.cui = cargoEmp.cui_empleado  "
            + "INNER JOIN control_empleado.cargo AS cargo "
            + "ON cargo.codigo_id=cargoEmp.codigo_cargo "
            + "INNER JOIN control_empleado.empleado_sucursal AS empSucur "
            + "ON empleado.cui = empSucur.cui_empleado "
            + "WHERE empleado.cui=? AND empleado.passworde=? ;", nativeQuery = true)
    public List<Object[]> getEmpleadoSecion(@Param("cui") String cui, @Param("passworde") String passworde);

    @Query(value = "SELECT empleado.*, cargo.tipo_cargo, cargo.nombre_cargo, empSucur.codigo_bodega\n"
            + "FROM control_empleado.empleado AS empleado\n"
            + "INNER JOIN control_empleado.cargo_empleado AS cargoEmp\n"
            + "ON empleado.cui = cargoEmp.cui_empleado \n"
            + "INNER JOIN control_empleado.cargo AS cargo\n"
            + "ON cargo.codigo_id=cargoEmp.codigo_cargo\n"
            + "INNER JOIN control_empleado.empleado_bodega AS empSucur\n"
            + "ON empleado.cui = empSucur.cui_empleado\n"
            + "WHERE empleado.cui=?  AND empleado.passworde= ?\n"
            + ";", nativeQuery = true)
    public List<Object[]> getEmpleadoSesionBodega(@Param("cui") String cui, @Param("passworde") String passworde);
}
