package com.electriHome.electriHome.respositories;

import com.electriHome.electriHome.models.venta.Producto;
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
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = "SELECT pro_Marc.codigo_id, producto.nombre, producto.precio, marca.nombre AS \"marca\",  almacen_S.cantidad_existente "
            + "FROM control_producto.producto AS producto "
            + "INNER JOIN control_producto.producto_marca AS pro_Marc "
            + "ON producto.codigo = pro_Marc.codigo_producto "
            + "INNER JOIN control_producto.marca AS marca "
            + "ON marca.codigo_id=pro_Marc.codigo_marca  "
            + "INNER JOIN control_almacenamiento.sucursal_almacenamiento_producto AS almacen_S "
            + "ON almacen_S.codigo_producto = pro_Marc.codigo_id "
            + "WHERE almacen_S.codigo_sucursal = ? AND producto.codigo=?;", nativeQuery = true)
    public List<Object[]> getProductoSucursal(@Param("codigoSucur") Integer codigoSucur, @Param("codigoP") String codigoP);
    
    
    @Query(value = "SELECT pro_Marc.codigo_id, producto.nombre, producto.precio, marca.nombre AS \"marca\",  almacen_S.cantidad_existente, producto.codigo "
            + "FROM control_producto.producto AS producto "
            + "INNER JOIN control_producto.producto_marca AS pro_Marc "
            + "ON producto.codigo = pro_Marc.codigo_producto "
            + "INNER JOIN control_producto.marca AS marca "
            + "ON marca.codigo_id=pro_Marc.codigo_marca  "
            + "INNER JOIN control_almacenamiento.sucursal_almacenamiento_producto AS almacen_S "
            + "ON almacen_S.codigo_producto = pro_Marc.codigo_id "
            + "WHERE almacen_S.codigo_sucursal = ?;", nativeQuery = true)
    public List<Object[]> getListProductosSucursal(@Param("codigoSucur") Integer codigoSucur);

}
