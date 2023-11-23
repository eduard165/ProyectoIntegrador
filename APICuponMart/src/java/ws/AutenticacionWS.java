/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.AutenticacionDAO;
import modelo.pojo.RespuestaLoginCliente;
import modelo.pojo.RespuestaLoginUsuario;
import modelo.pojo.Usuario;

/**
 *
 * @author eduar
 */
@Path("login")
public class AutenticacionWS {
    
    @POST
    @Path("/validacionUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaLoginUsuario verificarUsuario(String json) {
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(json, Usuario.class);
       if(usuario.todosAtributosLlenos()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
       }
         return  AutenticacionDAO.verificarSesionUsuario(json);
    }
    
    @POST
    @Path("/validacionCliente")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaLoginCliente verificarCliente(String json) {
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(json, Usuario.class);
       if(usuario.todosAtributosLlenos()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
       }
         return  AutenticacionDAO.verificarSesionCliente(json);
    }
}
