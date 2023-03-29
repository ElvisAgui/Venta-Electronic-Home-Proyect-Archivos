
package com.electriHome.electriHome.respositories.adminRpo;

import com.electriHome.electriHome.models.admin.Cargo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author elvis_agui
 */
public interface CargoRepository extends JpaRepository<Cargo, Integer>{
    @Override
    List<Cargo> findAll();
}
