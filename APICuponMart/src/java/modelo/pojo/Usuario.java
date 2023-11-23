package modelo.pojo;

public class Usuario {

    private Integer idUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String CURP;
    private String correoElectronico;
    private String username;
    private String password; // Ajusta el nombre del atributo según tu script de base de datos
    private Integer rolID;
    private String empresaRFC; // Puede ser nulo si el usuario no es Administrador Comercial

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String CURP, String correoElectronico, String username, String password, Integer rolID, String empresaRFC) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.CURP = CURP;
        this.correoElectronico = correoElectronico;
        this.username = username;
        this.password = password;
        this.rolID = rolID;
        this.empresaRFC = empresaRFC;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRolID() {
        return rolID;
    }

    public void setRolID(Integer rolID) {
        this.rolID = rolID;
    }

    public String getEmpresaRFC() {
        return empresaRFC;
    }

    public void setEmpresaRFC(String empresaRFC) {
        this.empresaRFC = empresaRFC;
    }

    public String obtenerTipoUsuario() {
        if (this.getRolID() != null) {
            switch (this.getRolID()) {
                case 1:
                    return "Administrador general";
                case 2:
                    return "Administrador comercial";
                // Agrega más casos según sea necesario para otros roles
                default:
                    return "Rol no especificado";
            }
        } else {
            return "Rol no especificado";
        }
    }
    public Boolean todosAtributosLlenos(){
        return this.username.isEmpty() && this.password.isEmpty();
    }
}
