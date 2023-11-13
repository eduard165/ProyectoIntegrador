/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author eduar
 */
public class Promocion {

    private int idPromocion;
    private String nombrePromocion;
    private String descripcion;
    private String imagen;
    private LocalDate fechaInicio;
    private LocalDate fechaTermino;
    private String restricciones;
    private Integer tipoPromocionID; // Referencia a la entidad TipoPromocion
    private BigDecimal porcentajeDescuento;
    private String codigoPromocion;
    private Integer estatus;
    private String empresaRFC;
    private Integer estatusID;

    public Promocion() {
    }

    public Promocion(int idPromocion, String nombrePromocion, String descripcion, String imagen, LocalDate fechaInicio, LocalDate fechaTermino, String restricciones, Integer tipoPromocionID, BigDecimal porcentajeDescuento, String codigoPromocion, Integer estatus, String empresaRFC, Integer estatusID) {
        this.idPromocion = idPromocion;
        this.nombrePromocion = nombrePromocion;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.restricciones = restricciones;
        this.tipoPromocionID = tipoPromocionID;
        this.porcentajeDescuento = porcentajeDescuento;
        this.codigoPromocion = codigoPromocion;
        this.estatus = estatus;
        this.empresaRFC = empresaRFC;
        this.estatusID = estatusID;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getNombrePromocion() {
        return nombrePromocion;
    }

    public void setNombrePromocion(String nombrePromocion) {
        this.nombrePromocion = nombrePromocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(LocalDate fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    public Integer getTipoPromocionID() {
        return tipoPromocionID;
    }

    public void setTipoPromocionID(Integer tipoPromocionID) {
        this.tipoPromocionID = tipoPromocionID;
    }

    public BigDecimal getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getCodigoPromocion() {
        return codigoPromocion;
    }

    public void setCodigoPromocion(String codigoPromocion) {
        this.codigoPromocion = codigoPromocion;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public String getEmpresaRFC() {
        return empresaRFC;
    }

    public void setEmpresaRFC(String empresaRFC) {
        this.empresaRFC = empresaRFC;
    }

    public Integer getEstatusID() {
        return estatusID;
    }

    public void setEstatusID(Integer estatusID) {
        this.estatusID = estatusID;
    }

    public boolean todosAtributosLlenos() {
        return nombrePromocion != null
                && descripcion != null
                && imagen != null
                && fechaInicio != null
                && fechaTermino != null
                && restricciones != null
                && tipoPromocionID != null
                && porcentajeDescuento != null
                && codigoPromocion != null
                && estatus != null
                && empresaRFC != null
                && estatusID != null;
    }

}
