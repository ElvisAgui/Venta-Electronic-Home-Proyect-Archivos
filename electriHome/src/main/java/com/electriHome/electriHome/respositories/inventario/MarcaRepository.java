package com.electriHome.electriHome.respositories.inventario;

import com.electriHome.electriHome.models.bodega.Marca;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elvis_agui
 */
@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
    
    @Override
    Marca save(Marca marca);

    @Override
    List<Marca> findAll();
}
