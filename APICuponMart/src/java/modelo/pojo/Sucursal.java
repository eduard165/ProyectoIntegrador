
package modelo.pojo;

public class Sucursal {

    private Integer idSucursal;
    private String nombre;
    private String telefono;
    private double latitud;
    private double longitud;
    private String nombreEncargado;
    private String empresaRFC;
    private Integer direccionID;

    public Sucursal() {
    }

    public Sucursal(Integer idSucursal, String nombre, String telefono, double latitud, double longitud, String nombreEncargado, String empresaRFC, Integer direccionID) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombreEncargado = nombreEncargado;
        this.empresaRFC = empresaRFC;
        this.direccionID = direccionID;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public String getEmpresaRFC() {
        return empresaRFC;
    }

    public void setEmpresaRFC(String empresaRFC) {
        this.empresaRFC = empresaRFC;
    }

    public Integer getDireccionID() {
        return direccionID;
    }

    public void setDireccionID(Integer direccionID) {
        this.direccionID = direccionID;
    }

 public Boolean validarDatos(){
     return  this.empresaRFC == null && this.direccionID < 0 && this.nombre == null && this.telefono == null && this.nombreEncargado == null;
 
    }
}
