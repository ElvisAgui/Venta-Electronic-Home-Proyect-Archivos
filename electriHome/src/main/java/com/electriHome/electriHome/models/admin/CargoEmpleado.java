
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
@Table(name = "cargo_empleado", schema = "control_empleado")
public class CargoEmpleado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_id")
    private Integer codigoId;
    
    private Integer codigoCargo;
    private String cuiEmpleado;

    public Integer getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(Integer codigoId) {
        this.codigoId = codigoId;
    }

    public Integer getCodigoCargo() {
        return codigoCargo;
    }

    public void setCodigoCargo(Integer codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    public String getCuiEmpleado() {
        return cuiEmpleado;
    }

    public void setCuiEmpleado(String cuiEmpleado) {
        this.cuiEmpleado = cuiEmpleado;
    }
    
    
    
}
