package com.electriHome.electriHome.respositories;

import com.electriHome.electriHome.models.empleados.Sucursal;
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
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

    Sucursal findById(int id);

    @Override
    List<Sucursal> findAll();
}
