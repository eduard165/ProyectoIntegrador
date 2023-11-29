/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteescritoriocuponsmart.modelo.dao;

import clienteescritoriocuponsmart.modelo.pojo.CodigoHTTP;
import clienteescritoriocuponsmart.modelo.pojo.RespuestaLoginEscritorio;
import clienteescritoriocuponsmart.utils.Constantes;
import com.google.gson.Gson;
import java.net.HttpURLConnection;

/**
 *
 * @author lizet
 */
public class InicioSesionDAO {
    
    
    
    public static RespuestaLoginEscritorio validarSesionUsuario(String username, String password){
    RespuestaLoginEscritorio respuestaWS = new RespuestaLoginEscritorio();
    String url = Constantes.URL_WS+"autenticacion/validacionUsuario";
    String parametros = String.format("username=%s&password=%s", username,password);
    CodigoHTTP respuestaConexion = ConexionHTTP.peticionPOSTJson(url, parametros);
    if(respuestaConexion.getCodigoRespuesta() == HttpURLConnection.HTTP_OK){
        
        Gson gson = new Gson();
        respuestaWS = gson.fromJson(respuestaConexion.getContenido(), RespuestaLoginEscritorio.class);
        
       
    }else{
        respuestaWS.setError(true);
        respuestaWS.setContenido("Hubo un error  con la petición, inténtelo más tarde.");
        
    }
    return respuestaWS;
}

}