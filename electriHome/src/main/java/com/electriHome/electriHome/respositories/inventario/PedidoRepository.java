
package com.electriHome.electriHome.respositories.inventario;

import com.electriHome.electriHome.models.inventario.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elvis_agui
 */
@Repository
public interface PedidoRepository extends  JpaRepository<Pedido, Integer>{
    
    
    @Override
    Pedido save(Pedido pedido);
    
}
