package com.electriHome.electriHome.respositories.adminRpo;

import com.electriHome.electriHome.models.admin.SucursalReport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elvis_agui
 */
@Repository
public interface SucursalReportRepository extends JpaRepository<SucursalReport, String> {

    @Query(value = "SELECT control_sucursal_bodega.sucursal.nombre, COUNT(*) AS total_ventas\n"
            + "FROM control_venta.venta_producto INNER JOIN\n"
            + "control_sucursal_bodega.sucursal ON control_sucursal_bodega.sucursal.codigo_id=control_venta.venta_producto.codigo_sucursal\n"
            + "GROUP BY codigo_sucursal,control_sucursal_bodega.sucursal.nombre\n"
            + "ORDER BY total_ventas DESC;", nativeQuery = true)
    public List<Object[]> getSucursalMasVentas();

    @Query(value = "SELECT control_sucursal_bodega.sucursal.nombre, SUM(control_venta.venta_producto.total_gastado) AS total_ganancia\n"
            + "FROM control_venta.venta_producto INNER JOIN\n"
            + "control_sucursal_bodega.sucursal ON control_sucursal_bodega.sucursal.codigo_id=control_venta.venta_producto.codigo_sucursal\n"
            + "GROUP BY control_venta.venta_producto.codigo_sucursal,control_sucursal_bodega.sucursal.nombre\n"
            + "ORDER BY total_ganancia DESC;", nativeQuery = true)
    public List<Object[]> getSucursalMasIngresos();

}
