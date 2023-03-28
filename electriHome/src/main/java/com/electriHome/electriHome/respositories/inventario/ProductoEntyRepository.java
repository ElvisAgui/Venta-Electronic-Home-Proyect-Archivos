
package com.electriHome.electriHome.respositories.inventario;

import com.electriHome.electriHome.models.bodega.ProductoEnty;
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
public interface ProductoEntyRepository extends JpaRepository<ProductoEnty, String>{
    
    @Query(value = "SELECT * FROM control_producto.producto WHERE codigo = ?;", nativeQuery = true)
    public List<Object[]> getProducto(@Param("codigo") String codigo); 
    
    
    @Override
    ProductoEnty save(ProductoEnty produto);
}
