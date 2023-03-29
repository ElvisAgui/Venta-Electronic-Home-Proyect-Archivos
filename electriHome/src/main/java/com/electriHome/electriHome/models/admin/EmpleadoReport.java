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
@Table(name = "empleado", schema = "control_empleado")
public class EmpleadoReport {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cuiEmpleado;
    
    
    private String nombre;
    private String apellido;
    private BigInteger productos;
    private BigDecimal ganancia;
    
    public String getCuiEmpleado() {
        return cuiEmpleado;
    }

    public void setCuiEmpleado(String cuiEmpleado) {
        this.cuiEmpleado = cuiEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public BigInteger getProductos() {
        return productos;
    }

    public void setProductos(BigInteger productos) {
        this.productos = productos;
    }

    public BigDecimal getGanancia() {
        return ganancia;
    }

    public void setGanancia(BigDecimal ganancia) {
        this.ganancia = ganancia;
    }

    @Override
    public String toString() {
        return "EmpleadoReport{" + "cuiEmpleado=" + cuiEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", productos=" + productos + ", ganancia=" + ganancia + '}';
    }
    
    

  

    
    
    
    
}
