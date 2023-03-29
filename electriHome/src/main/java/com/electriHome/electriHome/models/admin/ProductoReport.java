/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ProductoReport {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigo;
    
    private String nombre;
    private  BigDecimal precio;
    private String marca;
    private BigInteger vecesVendida;
    private BigDecimal ingresos;
    

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigInteger getVecesVendida() {
        return vecesVendida;
    }

    public void setVecesVendida(BigInteger vecesVendida) {
        this.vecesVendida = vecesVendida;
    }

    public BigDecimal getIngresos() {
        return ingresos;
    }

    public void setIngresos(BigDecimal ingresos) {
        this.ingresos = ingresos;
    }

    @Override
    public String toString() {
        return "ProductoReport{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", marca=" + marca + ", vecesVendida=" + vecesVendida + ", ingresos=" + ingresos + '}';
    }
    


   
    

    
    
    
}
