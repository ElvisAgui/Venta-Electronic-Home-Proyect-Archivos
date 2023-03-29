/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.electriHome.electriHome.models.admin;

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
@Table(name = "cargo", schema = "control_empleado")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_id")
    private Integer codigoId;
    
    private java.lang.Short  tipoCargo;
    private String nombreCargo;

    public Integer getCodigoId() {
        return codigoId;
    }

    public void setCodigoId(Integer codigoId) {
        this.codigoId = codigoId;
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

    @Override
    public String toString() {
        return "Cargo{" + "codigoId=" + codigoId + ", tipoCargo=" + tipoCargo + ", nombreCargo=" + nombreCargo + '}';
    }
    
    
    
}
