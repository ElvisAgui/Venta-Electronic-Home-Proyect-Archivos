package com.electriHome.electriHome.respositories.adminRpo;

import com.electriHome.electriHome.models.admin.EmpleadoReport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elvis_agui
 */
@Repository
public interface EmpleadoReportRepository extends JpaRepository<EmpleadoReport, String> {

    @Query(value = "SELECT venta.cui_empleado, empleado.nombre, empleado.apellido,\n"
            + "SUM(venta.cantidad_producto) AS productos\n"
            + "FROM control_venta.venta_producto AS venta\n"
            + "INNER JOIN control_empleado.empleado AS empleado\n"
            + "ON venta.cui_empleado = empleado.cui\n"
            + "GROUP BY venta.cui_empleado,empleado.nombre, empleado.apellido\n"
            + "ORDER BY productos DESC LIMIT 3;", nativeQuery = true)
    public List<Object[]> getEmpleadoMasVentas();

    @Query(value = "SELECT venta.cui_empleado, empleado.nombre, empleado.apellido,\n"
            + "SUM(venta.total_gastado) AS Ganancia\n"
            + "FROM control_venta.venta_producto AS venta\n"
            + "INNER JOIN control_empleado.empleado AS empleado\n"
            + "ON venta.cui_empleado = empleado.cui\n"
            + "GROUP BY venta.cui_empleado,empleado.nombre, empleado.apellido\n"
            + "ORDER BY Ganancia DESC LIMIT 3;", nativeQuery = true)
    public List<Object[]> getEmpleadoMasIngresos();

}
