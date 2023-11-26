package modelo.pojo;

public class Direccion {

    private Integer idDireccion;
    private String calle;
    private Integer numero;
    private String codigoPostal;
    private String ciudad;
    private String colonia;
    private Integer idMunicipio;
    private Integer idCliente;
    private Integer idSucursa;
    private String empresaRFC;

    public Direccion() {
    }

    public Direccion(Integer idDireccion, String calle, Integer numero, String codigoPostal, String ciudad, String colonia, Integer idMunicipio, Integer idCliente, Integer idSucursa, String empresaRFC) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.idMunicipio = idMunicipio;
        this.idCliente = idCliente;
        this.idSucursa = idSucursa;
        this.empresaRFC = empresaRFC;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdSucursa() {
        return idSucursa;
    }

    public void setIdSucursa(Integer idSucursa) {
        this.idSucursa = idSucursa;
    }

    public String getEmpresaRFC() {
        return empresaRFC;
    }

    public void setEmpresaRFC(String empresaRFC) {
        this.empresaRFC = empresaRFC;
    }
    

    public Boolean validarCamposObligatorios() {
        return this.calle == null
                && this.ciudad == null
                && this.codigoPostal == null
                && this.colonia == null
                && this.idMunicipio == null
                && this.numero == null;
    }
    public Integer campoLleno() {
        if (empresaRFC != null) {
            return 1;
        } else if (idCliente != null) {
            return 2;
        } else if (idSucursa != null) {
            return 3;
        } else {
            return 4;
        }
    }
}
