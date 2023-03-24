
package com.electriHome.electriHome.models.empleados;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class Empleado {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cui ;
    
    private String nombre;
    private String apellido;
    private String passworde;
    private BigDecimal salario;
    private java.lang.Short tipoCargo;
    private String nombreCargo;
    private Integer codigoSucursal;

    public Empleado(String cui, String nombre, String apellido, String passworde, BigDecimal salario, java.lang.Short tipoCargo, String nombreCargo, Integer codigoSucursal) {
        this.cui = cui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.passworde = passworde;
        this.salario = salario;
        this.tipoCargo = tipoCargo;
        this.nombreCargo = nombreCargo;
        this.codigoSucursal = codigoSucursal;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
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

    public String getPassworde() {
        return passworde;
    }

    public void setPassworde(String passworde) {
        this.passworde = passworde;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Short getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(Short tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public Integer getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(Integer codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }


    @Override
    public String toString() {
        return "Empleado{" + "cui=" + cui + ", nombre=" + nombre + ", apellido=" + apellido + ", passworde=" + passworde + ", salario=" + salario + ", tipo_cargo=" + tipoCargo + ", nombre_cargo=" + nombreCargo + ", codigo_sucursal=" + codigoSucursal + '}';
    }
    
    
    
    
    
}
