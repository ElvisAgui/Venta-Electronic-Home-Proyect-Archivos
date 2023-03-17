
package com.electriHome.electriHome.models;

import javax.persistence.*;



/**
 *
 * @author elvis_agui
 */


@Entity
@Table(name = "empleado_sucur", schema = "control_empleado")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cui ;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String passworde;
    @Column
    private double salario;

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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    
}
