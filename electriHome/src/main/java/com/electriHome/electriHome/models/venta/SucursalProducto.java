
package com.electriHome.electriHome.models.venta;

import java.sql.Date;
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
@Table(name = "sucursal_almacenamiento_producto", schema = "control_almacenamiento")
public class SucursalProducto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_id")
    private Integer codigoId;
                            
    private Integer codigoProducto;
    private Integer codigoSucursal;
    private Integer cantidadExistente;
    private Date fechaAdquisicion;

    public Integer getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(Integer codigoId) {
        this.codigoId = codigoId;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Integer getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(Integer codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public Integer getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(Integer cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    @Override
    public String toString() {
        return "SucursalProducto{" + "codigoId=" + codigoId + ", codigoProducto=" + codigoProducto + ", codigoSucursal=" + codigoSucursal + ", cantidadExistente=" + cantidadExistente + ", fechaAdquisicion=" + fechaAdquisicion + '}';
    }

    
    
    
    
}
