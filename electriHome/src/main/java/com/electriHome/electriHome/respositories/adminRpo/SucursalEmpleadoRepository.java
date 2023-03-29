
package com.electriHome.electriHome.respositories.adminRpo;

import com.electriHome.electriHome.models.admin.SucursalEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elvis_agui
 */
@Repository
public interface SucursalEmpleadoRepository extends JpaRepository<SucursalEmpleado, Integer>{
    
    @Override
    SucursalEmpleado save(SucursalEmpleado sucursalEmpleado);
}
