
package com.electriHome.electriHome.models.venta;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author elvis_agui
 */
@Entity
@Table(name = "venta_producto", schema = "control_venta")
public class VentaProducto {
    
    @Id
    private String codigo;
    
    private Integer cantidadProducto;
    private BigDecimal totalGastado;
    private BigDecimal descuento;
    private BigDecimal ganaciaReal;
    private String cuiEmpleado;
    private String nitCliente;
    private Integer codigoSucursal;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public BigDecimal getTotalGastado() {
        return totalGastado;
    }

    public void setTotalGastado(BigDecimal totalGastado) {
        this.totalGastado = totalGastado;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getGanaciaReal() {
        return ganaciaReal;
    }

    public void setGanaciaReal(BigDecimal ganaciaReal) {
        this.ganaciaReal = ganaciaReal;
    }

    

    public String getCuiEmpleado() {
        return cuiEmpleado;
    }

    public void setCuiEmpleado(String cuiEmpleado) {
        this.cuiEmpleado = cuiEmpleado;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public Integer getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(Integer codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    @Override
    public String toString() {
        return "VentaProducto{" + "codigo=" + codigo + ", cantidadProducto=" + cantidadProducto + ", totalGastado=" + totalGastado + ", descuento=" + descuento + ", ganaciaReal=" + ganaciaReal + ", cuiEmpleado=" + cuiEmpleado + ", nitCliente=" + nitCliente + ", codigoSucursal=" + codigoSucursal + '}';
    }

    
    
    
}
