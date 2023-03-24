package com.electriHome.electriHome.models.venta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author elvis_agui
 */
@Entity
@Table(name = "items_venta_producto", schema = "control_venta")
public class ItemsVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_id")
    private Integer codigoId;
    
    private Integer cantidadProducto;
    private Integer codigoProducto;
    private String codigoVentaProducto;

    public Integer getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(Integer codigoId) {
        this.codigoId = codigoId;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoVentaProducto() {
        return codigoVentaProducto;
    }

    public void setCodigoVentaProducto(String codigoVentaProducto) {
        this.codigoVentaProducto = codigoVentaProducto;
    }

    @Override
    public String toString() {
        return "ItemsVenta{" + "codigoId=" + codigoId + ", cantidadProducto=" + cantidadProducto + ", codigoProducto=" + codigoProducto + ", codigoVentaProducto=" + codigoVentaProducto + '}';
    }

    
    
    
}
