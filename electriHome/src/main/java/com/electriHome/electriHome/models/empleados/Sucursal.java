
package com.electriHome.electriHome.models.empleados;

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
@Table(name = "sucursal", schema = "control_sucursal_bodega")
public class Sucursal {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoId;
    @Column
    private String localidad;
    @Column
    private String nombre;
    @Column
    private String descripcion;

    public Integer getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(Integer codigoId) {
        this.codigoId = codigoId;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "codigoId=" + codigoId + ", localidad=" + localidad + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
