/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

import java.time.LocalDate;

/**
 *
 * @author eduar
 */
public class Cupon {
    private Integer idCupon;
    private String codigoCupon;
    private Integer promocionID;
     private LocalDate fechaGeneracion;
     private Integer estausID;

    public Cupon() {
    }

    public Cupon(Integer idCupon, String codigoCupon, Integer promocionID, LocalDate fechaGeneracion, Integer estausID) {
        this.idCupon = idCupon;
        this.codigoCupon = codigoCupon;
        this.promocionID = promocionID;
        this.fechaGeneracion = fechaGeneracion;
        this.estausID = estausID;
    }

    public Integer getIdCupon() {
        return idCupon;
    }

    public void setIdCupon(Integer idCupon) {
        this.idCupon = idCupon;
    }

    public String getCodigoCupon() {
        return codigoCupon;
    }

    public void setCodigoCupon(String codigoCupon) {
        this.codigoCupon = codigoCupon;
    }

    public Integer getPromocionID() {
        return promocionID;
    }

    public void setPromocionID(Integer promocionID) {
        this.promocionID = promocionID;
    }

    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDate fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Integer getEstausID() {
        return estausID;
    }

    public void setEstausID(Integer estausID) {
        this.estausID = estausID;
    }
     
}
