/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electriHome.electriHome.models.admin;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author elvis_agui
 */
@Entity
@Table(name = "empleado", schema = "control_empleado")
public class EmpleadoEnty {
    
    @Id
   private String cui;
    
    
   private String nombre;
   private String apellido;
   private String passworde;
   private BigDecimal salario;

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

    @Override
    public String toString() {
        return "EmpleadoEnty{" + "cui=" + cui + ", nombre=" + nombre + ", apellido=" + apellido + ", passworde=" + passworde + ", salario=" + salario + '}';
    }
   
   
}
