package com.electriHome.electriHome.respositories.inventario;

import com.electriHome.electriHome.models.bodega.BodegaProducto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author elvis_agui
 */
public interface BodegaProductoRepository extends JpaRepository<BodegaProducto, Integer> {

    @Query(value = "SELECT * FROM control_almacenamiento.bodega_almacenamiento_producto WHERE codigo_producto = ? AND codigo_bodega = 1;", nativeQuery = true)
    public List<Object[]> getProductoAmacenado(@Param("codigoProducto") Integer codigoProducto);

    @Override
    BodegaProducto save(BodegaProducto bodegaProducto);
}
