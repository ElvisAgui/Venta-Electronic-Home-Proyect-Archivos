package com.electriHome.electriHome.respositories.adminRpo;

import com.electriHome.electriHome.models.admin.ClienteReport;
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
public interface ClienteReportRepository extends JpaRepository<ClienteReport, String> {

    @Query(value = "SELECT venta.nit_cliente, cliente.nombre, cliente.apellido,\n"
            + "SUM(venta.total_gastado) AS Ganancia, SUM(venta.cantidad_producto) AS productos\n"
            + "FROM control_venta.venta_producto AS venta\n"
            + "INNER JOIN control_venta.cliente AS cliente\n"
            + "ON venta.nit_cliente = cliente.nit\n"
            + "GROUP BY nit_cliente,cliente.nombre, cliente.apellido\n"
            + "ORDER BY Ganancia DESC LIMIT 10;", nativeQuery = true)
    public List<Object[]> getClientesReport();

}
