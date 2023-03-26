package com.electriHome.electriHome.models.inventario;

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
@Table(name = "pedido", schema = "control_almacenamiento")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoId;
    
    private Integer codigoProducto;
    private Integer codigoSucursal;
    private Integer codigoBodega;
    private String sucuralSolicitante;
    private Integer cantidad;
    private String estado;
    private String cuiEmpleado;

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

    public Integer getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(Integer codigoBodega) {
        this.codigoBodega = codigoBodega;
    }

    public String getSucuralSolicitante() {
        return sucuralSolicitante;
    }

    public void setSucuralSolicitante(String sucuralSolicitante) {
        this.sucuralSolicitante = sucuralSolicitante;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCuiEmpleado() {
        return cuiEmpleado;
    }

    public void setCuiEmpleado(String cuiEmpleado) {
        this.cuiEmpleado = cuiEmpleado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigoId=" + codigoId + ", codigoProducto=" + codigoProducto + ", codigoSucursal=" + codigoSucursal + ", codigoBodega=" + codigoBodega + ", sucuralSolicitante=" + sucuralSolicitante + ", cantidad=" + cantidad + ", estado=" + estado + ", cuiEmpleado=" + cuiEmpleado + '}';
    }
    
    
    
    

}
