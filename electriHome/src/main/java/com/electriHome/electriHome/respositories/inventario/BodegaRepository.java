
package com.electriHome.electriHome.respositories.inventario;

import com.electriHome.electriHome.models.inventario.Bodega;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elvis_agui
 */
@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer>{
    
    Bodega findById(int id);
    
    @Override
    List<Bodega> findAll();
}
