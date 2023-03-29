
package com.electriHome.electriHome.respositories.adminRpo;

import com.electriHome.electriHome.models.admin.CargoEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elvis_agui
 */
@Repository
public interface CargoEmpleadoRepository extends  JpaRepository<CargoEmpleado, Integer>{
    
    @Override
    CargoEmpleado save(CargoEmpleado cargoEmpleado);
}
