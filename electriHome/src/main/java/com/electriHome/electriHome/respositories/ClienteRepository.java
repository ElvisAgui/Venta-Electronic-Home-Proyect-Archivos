package com.electriHome.electriHome.respositories;

import com.electriHome.electriHome.models.Cliente;
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
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query(value = "SELECT * FROM control_venta.cliente WHERE nit = ?;", nativeQuery = true)
    public List<Object[]> getCliente(@Param("nit") String nit);  
    
    @Override
      List<Cliente> findAll(); 

    @Override
    Cliente save(Cliente cliente);

}
