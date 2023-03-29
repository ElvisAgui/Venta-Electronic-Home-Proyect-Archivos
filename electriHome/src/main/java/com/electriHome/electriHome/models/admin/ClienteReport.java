
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
@Table(name = "cliente", schema = "control_venta")
public class ClienteReport {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nitCliente ;
    
    private String nombre;
    private String apellido;
    private BigDecimal ganacia;
    private BigInteger productos;

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
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

    public BigDecimal getGanacia() {
        return ganacia;
    }

    public void setGanacia(BigDecimal ganacia) {
        this.ganacia = ganacia;
    }

    

    public BigInteger getProductos() {
        return productos;
    }

    public void setProductos(BigInteger productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "ClienteReport{" + "nitCliente=" + nitCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", ganacia=" + ganacia + ", productos=" + productos + '}';
    }


    
    
    
}
