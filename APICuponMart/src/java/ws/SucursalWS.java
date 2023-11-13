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
import modelo.SucursalDAO;
import modelo.pojo.Mensaje;
import modelo.pojo.Sucursal;

@Path("sucursales")
public class SucursalWS {

  
    @POST
    @Path("/registrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registrarSucursal(String json) {
        Gson gson = new Gson();
        Sucursal sucursal = gson.fromJson(json, Sucursal.class);
       if(!sucursal.todosAtributosLlenos()){
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
       }
         return  SucursalDAO.agregarSucursal(sucursal);
    }

    @PUT
    @Path("/editar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje editarSucursal(@PathParam("id") int id, String json) {
         Gson gson = new Gson();
        Sucursal sucursal = gson.fromJson(json, Sucursal.class);
        if(sucursal.todosAtributosLlenos() && id > 0 ){
              throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return SucursalDAO.editarSucursal(sucursal);
    }

    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje eliminarSucursal(@PathParam("id") int id) {
     if(id >0){
        return SucursalDAO.eliminarSucursal(id);
     }else
         return new Mensaje(true, "El id esta vacio");
    }

    @GET
    @Path("/buscar/{parametro}")
    @Produces(MediaType.APPLICATION_JSON)
    public Sucursal buscarSucursal(@PathParam("parametro") String parametro) {
        if (parametro == null || parametro.trim().isEmpty()) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return SucursalDAO.buscarSucursal(parametro);
    }
}
