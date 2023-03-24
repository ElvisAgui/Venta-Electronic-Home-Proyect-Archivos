
package com.electriHome.electriHome.respositories;

import com.electriHome.electriHome.models.venta.ItemsVenta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author elvis_agui
 */
public interface itemsVentaRepository extends JpaRepository<ItemsVenta, Integer>{
    
    @Override
    ItemsVenta save(ItemsVenta itemsVenta);
    
}
