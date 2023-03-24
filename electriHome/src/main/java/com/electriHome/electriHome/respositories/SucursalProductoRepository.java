
package com.electriHome.electriHome.respositories;

import com.electriHome.electriHome.models.venta.SucursalProducto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author elvis_agui
 */
public interface SucursalProductoRepository extends JpaRepository<SucursalProducto, Integer>{
    
    @Query(value = "SELECT * FROM control_almacenamiento.sucursal_almacenamiento_producto WHERE codigo_producto = ? AND codigo_sucursal = ?;", nativeQuery = true)
    public List<Object[]> getProductoAmacenado(@Param("codigoProducto") Integer codigoProducto,@Param("codigoSucursal") Integer codigoSucursal); 
    
    SucursalProducto findById(int id);
    
    @Override
    SucursalProducto save(SucursalProducto sucursalproducto);
    
}
