
package com.electriHome.electriHome.models.admin;

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
@Table(name = "empleado_sucursal", schema = "control_empleado")
public class SucursalEmpleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_id")
    private Integer codigoId;
    
    private Integer codigoSucursal;
    private String cuiEmpleado;

    public Integer getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(Integer codigoId) {
        this.codigoId = codigoId;
    }

    public Integer getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(Integer codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getCuiEmpleado() {
        return cuiEmpleado;
    }

    public void setCuiEmpleado(String cuiEmpleado) {
        this.cuiEmpleado = cuiEmpleado;
    }

    @Override
    public String toString() {
        return "SucursalEmpleado{" + "codigoId=" + codigoId + ", codigoSucursal=" + codigoSucursal + ", cuiEmpleado=" + cuiEmpleado + '}';
    }
    
    
}
