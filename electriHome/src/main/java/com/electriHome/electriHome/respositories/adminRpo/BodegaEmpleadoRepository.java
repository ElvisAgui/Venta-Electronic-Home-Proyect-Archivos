
package com.electriHome.electriHome.respositories.adminRpo;

import com.electriHome.electriHome.models.admin.BodegaEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elvis_agui
 */
@Repository
public interface BodegaEmpleadoRepository extends JpaRepository<BodegaEmpleado, Integer>{
    
    @Override
    BodegaEmpleado save(BodegaEmpleado bodegaEmpleado);
}
