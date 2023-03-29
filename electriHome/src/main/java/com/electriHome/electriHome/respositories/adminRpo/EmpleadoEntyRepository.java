
package com.electriHome.electriHome.respositories.adminRpo;

import com.electriHome.electriHome.models.admin.EmpleadoEnty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elvis_agui
 */
@Repository
public interface EmpleadoEntyRepository extends JpaRepository<EmpleadoEnty, String>{
    
    @Override
    EmpleadoEnty save(EmpleadoEnty empleadoEnty);
}
