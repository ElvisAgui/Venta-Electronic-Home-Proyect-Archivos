package com.electriHome.electriHome.respositories.adminRpo;

import com.electriHome.electriHome.models.admin.ProductoReport;
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
public interface ProductoReportRepository extends JpaRepository<ProductoReport, String> {

    @Query(value = "SELECT producto.codigo, producto.nombre, prod_Marc.precio, marca.nombre AS  \"marca\",\n"
            + "SUM(item.cantidad_producto) AS veces_vendida\n"
            + "FROM control_venta.items_venta_producto AS item\n"
            + "INNER JOIN control_producto.producto_marca AS prod_marc\n"
            + "ON item.codigo_producto = prod_marc.codigo_id\n"
            + "INNER JOIN control_producto.producto AS producto\n"
            + "ON prod_marc.codigo_producto = producto.codigo\n"
            + "INNER JOIN control_producto.marca AS marca\n"
            + "ON prod_marc.codigo_marca = marca.codigo_id\n"
            + "GROUP BY producto.codigo, producto.nombre, prod_Marc.precio,marca.nombre\n"
            + "ORDER BY veces_vendida DESC LIMIT 10;", nativeQuery = true)
    public List<Object[]> getProductoMasVendido();

    @Query(value = "SELECT producto.codigo, producto.nombre, prod_Marc.precio, marca.nombre AS  \"marca\",\n"
            + "SUM(item.cantidad_producto) * prod_Marc.precio AS ingresos\n"
            + "FROM control_venta.items_venta_producto AS item\n"
            + "INNER JOIN control_producto.producto_marca AS prod_marc\n"
            + "ON item.codigo_producto = prod_marc.codigo_id\n"
            + "INNER JOIN control_producto.producto AS producto\n"
            + "ON prod_marc.codigo_producto = producto.codigo\n"
            + "INNER JOIN control_producto.marca AS marca\n"
            + "ON prod_marc.codigo_marca = marca.codigo_id\n"
            + "GROUP BY producto.codigo, producto.nombre, prod_Marc.precio,marca.nombre,item.codigo_producto\n"
            + "ORDER BY ingresos DESC LIMIT 10;", nativeQuery = true)
    public List<Object[]> getProductoMasIngresos();

    @Query(value = "SELECT producto.codigo, producto.nombre, prod_Marc.precio, marca.nombre AS  \"marca\",\n"
            + "SUM(item.cantidad_producto) AS veces_vendida\n"
            + "FROM control_venta.items_venta_producto AS item\n"
            + "INNER JOIN control_producto.producto_marca AS prod_marc\n"
            + "ON item.codigo_producto = prod_marc.codigo_id\n"
            + "INNER JOIN control_producto.producto AS producto\n"
            + "ON prod_marc.codigo_producto = producto.codigo\n"
            + "INNER JOIN control_producto.marca AS marca\n"
            + "ON prod_marc.codigo_marca = marca.codigo_id\n"
            + "INNER JOIN control_venta.venta_producto AS venta\n"
            + "ON venta.codigo = item.codigo_venta_producto\n"
            + "WHERE venta.codigo_sucursal=?\n"
            + "GROUP BY producto.codigo, producto.nombre, prod_Marc.precio,marca.nombre,item.codigo_producto\n"
            + "ORDER BY veces_vendida DESC LIMIT 5;", nativeQuery = true)
    public List<Object[]> getProductoMasVendidoSucursal(@Param("codigoSucur") Integer codigoSucur);

    @Query(value = "SELECT producto.codigo, producto.nombre, prod_Marc.precio, marca.nombre AS  \"marca\",\n"
            + "SUM(item.cantidad_producto) * prod_Marc.precio AS ingresos\n"
            + "FROM control_venta.items_venta_producto AS item\n"
            + "INNER JOIN control_producto.producto_marca AS prod_marc\n"
            + "ON item.codigo_producto = prod_marc.codigo_id\n"
            + "INNER JOIN control_producto.producto AS producto\n"
            + "ON prod_marc.codigo_producto = producto.codigo\n"
            + "INNER JOIN control_producto.marca AS marca\n"
            + "ON prod_marc.codigo_marca = marca.codigo_id\n"
            + "INNER JOIN control_venta.venta_producto AS venta\n"
            + "ON venta.codigo = item.codigo_venta_producto\n"
            + "WHERE venta.codigo_sucursal=?\n"
            + "GROUP BY producto.codigo, producto.nombre, prod_Marc.precio,marca.nombre,item.codigo_producto\n"
            + "ORDER BY ingresos DESC LIMIT 5;", nativeQuery = true)
    public List<Object[]> getProductoMasIngresoSucursal(@Param("codigoSucur") Integer codigoSucur);

}
