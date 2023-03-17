
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

    public java.lang.Short getTipo_cargo() {
        return tipoCargo;
    }

    public void setTipo_cargo(java.lang.Short tipo_cargo) {
        this.tipoCargo = tipo_cargo;
    }

    public String getNombre_cargo() {
        return nombreCargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombreCargo = nombre_cargo;
    }

    public Integer getCodigo_sucursal() {
        return codigoSucursal;
    }

    public void setCodigo_sucursal(Integer codigo_sucursal) {
        this.codigoSucursal = codigo_sucursal;
    }

    @Override
    public String toString() {
        return "Empleado{" + "cui=" + cui + ", nombre=" + nombre + ", apellido=" + apellido + ", passworde=" + passworde + ", salario=" + salario + ", tipo_cargo=" + tipoCargo + ", nombre_cargo=" + nombreCargo + ", codigo_sucursal=" + codigoSucursal + '}';
    }
    
    
    
    
    
}
