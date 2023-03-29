
package com.electriHome.electriHome.models.admin;

import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "producto", schema = "control_producto")
public class SucursalReport {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;
    
    private BigInteger totalVentas;
    private BigDecimal totalIngresos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(BigInteger totalVentas) {
        this.totalVentas = totalVentas;
    }

    public BigDecimal getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(BigDecimal totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    @Override
    public String toString() {
        return "SucursalReport{" + "nombre=" + nombre + ", totalVentas=" + totalVentas + ", totalIngresos=" + totalIngresos + '}';
    }
    
    
}
