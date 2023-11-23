/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.EmpresaDAO;

import modelo.pojo.Empresa;
import modelo.pojo.Mensaje;

/**
 *
 * @author eduar
 */
@Path("empresas")
public class EmpresaWS {

    private Gson gson = new Gson();

    public EmpresaWS() {
    }

    @Path("/agregarEmpresa")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje agregarEmpresa(String json) {
        Gson gsons = new Gson();
        Empresa empresa = gsons.fromJson(json, Empresa.class);
        if (!validarCamposObligatorios(empresa) || !validarFormatoCorreo(empresa.getEmail())) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return  EmpresaDAO.agregarEmpresa(empresa);

       
    }

    @Path("/editarEmpresa")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Mensaje editarEmpresa(String json) {
        Gson gsons = new Gson();
        Empresa empresa = gson.fromJson(json, Empresa.class);
        if (!validarCamposObligatorios(empresa) || !validarFormatoCorreo(empresa.getEmail())) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return EmpresaDAO.editarEmpresa(empresa);

    }

@Path("/eliminarEmpresa/{RFC}")
@DELETE
@Produces(MediaType.APPLICATION_JSON)
public Mensaje eliminarEmpresa(@PathParam("RFC") String RFC) {
    if (RFC != null && !RFC.isEmpty()) {
         return EmpresaDAO.eliminarEmpresa(RFC);
    } else {
        return new Mensaje(true, "El RFC no puede estar vacío");
    }
}


    @Path("/buscarEmpresa/{parametro}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Empresa buscarEmpresa(@PathParam("parametro") String parametro) {
        if (parametro == null || parametro.trim().isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
      return  EmpresaDAO.buscarEmpresa(parametro);
    }
    
    @Path("/buscarEmpresas/{parametro}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> buscarEmpresas(@PathParam("parametro") String parametro) {
        if (parametro == null || parametro.trim().isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
      return  EmpresaDAO.buscarEmpresas(parametro);
    }


    private boolean validarCamposObligatorios(Empresa empresa) {
        return empresa.getNombre() != null
                && empresa.getRFC() != null
                && empresa.getEmail() != null
                && empresa.getDireccionID() != null;
        
    }

    private boolean validarFormatoCorreo(String correo) {
    String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
    return correo != null && correo.matches(regex);
    }


}
