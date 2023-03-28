/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electriHome.electriHome.respositories.inventario;

import com.electriHome.electriHome.models.bodega.ProductoMarca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author elvis_agui
 */
@Repository
public interface ProductoMarcaRepository extends JpaRepository<ProductoMarca, Integer>{
    
    @Override
    ProductoMarca save(ProductoMarca productoMarca);
    
    ProductoMarca findById(int id);
}
