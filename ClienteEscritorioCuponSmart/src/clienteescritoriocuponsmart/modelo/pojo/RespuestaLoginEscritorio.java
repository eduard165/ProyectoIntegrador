
package clienteescritoriocuponsmart.modelo.pojo;

/**
 *
 * @author lizet
 */
public class RespuestaLoginEscritorio {
    private Boolean error;
    private String contenido;
    private Usuario usuarioSesion;

    public RespuestaLoginEscritorio() {
    }

    public RespuestaLoginEscritorio(Boolean error, String contenido, Usuario usuarioSesion) {
        this.error = error;
        this.contenido = contenido;
        this.usuarioSesion = usuarioSesion;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Usuario getUsuarioSesion() {
        return usuarioSesion;
    }

    public void setUsuarioSesion(Usuario usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }
    
    
    
    
}
