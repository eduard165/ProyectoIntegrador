/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

/**
 *
 * @author eduar
 */
public class Empresa {
   private String RFC;
    private String nombre;
    private String nombreComercial;
    private String logo;
    private String representanteLegal;
    private String email;
    private String telefono;
    private String paginaWeb;
    private String estatusID;
    private Integer direccionID; 

    public Empresa() {
    }

    public Empresa(String RFC, String nombre, String nombreComercial, String logo, String representanteLegal, String email, String telefono, String paginaWeb, String estatusID, Integer direccionID) {
        this.RFC = RFC;
        this.nombre = nombre;
        this.nombreComercial = nombreComercial;
        this.logo = logo;
        this.representanteLegal = representanteLegal;
        this.email = email;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.estatusID = estatusID;
        this.direccionID = direccionID;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getEstatusID() {
        return estatusID;
    }

    public void setEstatusID(String estatus) {
        this.estatusID = estatus;
    }

    public Integer getDireccionID() {
        return direccionID;
    }

    public void setDireccionID(Integer direccion) {
        this.direccionID = direccion;
    }
    
    
}
