/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electriHome.electriHome.respositories;

import com.electriHome.electriHome.models.venta.VentaProducto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author elvis_agui
 */
public interface VentaProductoRepository extends JpaRepository<VentaProducto, String> {

    @Query(value = "SELECT ganacia_real FROM control_venta.venta_producto WHERE nit_cliente =?;", nativeQuery = true)
    public List<Object[]> getDescuento(@Param("nit") String nit);
    
    @Override
    VentaProducto save(VentaProducto ventaProducto);
    
    
    
}
