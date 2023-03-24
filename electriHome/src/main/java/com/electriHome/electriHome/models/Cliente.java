package com.electriHome.electriHome.models;

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
@Table(name = "cliente", schema = "control_venta")
public class Cliente {

    @Id
    private String nit;

    private String nombre;
    private String apellido;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    @Override
    public String toString() {
        return "Cliente{" + "nit=" + nit + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }

}
