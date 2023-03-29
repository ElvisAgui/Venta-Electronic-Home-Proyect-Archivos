
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
@Table(name = "empleado_bodega", schema = "control_empleado")
public class BodegaEmpleado {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_id")
    private Integer codigoId;
    
    private Integer codigoBodega;
    private String cuiEmpleado;

    public Integer getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(Integer codigoId) {
        this.codigoId = codigoId;
    }

    public Integer getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(Integer codigoBodega) {
        this.codigoBodega = codigoBodega;
    }

    public String getCuiEmpleado() {
        return cuiEmpleado;
    }

    public void setCuiEmpleado(String cuiEmpleado) {
        this.cuiEmpleado = cuiEmpleado;
    }

    @Override
    public String toString() {
        return "BodegaEmpleado{" + "codigoId=" + codigoId + ", codigoBodega=" + codigoBodega + ", cuiEmpleado=" + cuiEmpleado + '}';
    }
    
    
    
}
