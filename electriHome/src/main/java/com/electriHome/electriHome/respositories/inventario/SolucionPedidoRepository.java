/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electriHome.electriHome.respositories.inventario;

import com.electriHome.electriHome.models.inventario.SolucionPedido;
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
public interface SolucionPedidoRepository extends JpaRepository<SolucionPedido, Integer> {

    @Query(value = "SELECT pedido.*, producto.nombre, marca.nombre AS \"marca\", producto.codigo "
            + "FROM control_almacenamiento.pedido AS pedido "
            + "INNER JOIN control_producto.producto_marca AS pro_Marc "
            + "ON pedido.codigo_producto=pro_Marc.codigo_id "
            + "INNER JOIN control_producto.producto AS producto "
            + "ON producto.codigo = pro_Marc.codigo_producto "
            + "INNER JOIN control_producto.marca AS marca "
            + "ON marca.codigo_id=pro_Marc.codigo_marca "
            + "WHERE pedido.estado = ? AND pedido.codigo_sucursal=?;", nativeQuery = true)
    public List<Object[]> getSolicitudesSucursal(@Param("estado") String estado, @Param("codigoSucur") Integer codigoSucur);
    
    
    @Query(value = "SELECT pedido.*, producto.nombre, marca.nombre AS \"marca\", producto.codigo "
            + "FROM control_almacenamiento.pedido AS pedido "
            + "INNER JOIN control_producto.producto_marca AS pro_Marc "
            + "ON pedido.codigo_producto=pro_Marc.codigo_id "
            + "INNER JOIN control_producto.producto AS producto "
            + "ON producto.codigo = pro_Marc.codigo_producto "
            + "INNER JOIN control_producto.marca AS marca "
            + "ON marca.codigo_id=pro_Marc.codigo_marca "
            + "WHERE pedido.estado = ? AND pedido.codigo_bodega=?;", nativeQuery = true)
    public List<Object[]> getSolicitudesBodega(@Param("estado") String estado, @Param("codigoSucur") Integer codigoSucur);

}
