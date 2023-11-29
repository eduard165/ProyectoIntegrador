/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteescritoriocuponsmart.modelo.dao;

import clienteescritoriocuponsmart.modelo.pojo.CodigoHTTP;
import clienteescritoriocuponsmart.utils.Constantes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author lizet
 */
public class ConexionHTTP {
    
    public static CodigoHTTP  peticionPOST(String url, String parametros){
    CodigoHTTP respuesta = new CodigoHTTP();
    
    try{
            URL urlServicio = new URL(url);
            HttpURLConnection conexionHTTP = (HttpURLConnection)urlServicio.openConnection();
            conexionHTTP.setRequestMethod("POST");
            conexionHTTP.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conexionHTTP.setDoOutput(true);
      
            OutputStream os = conexionHTTP.getOutputStream();
            os.write(parametros.getBytes());
            os.flush();
            os.close();
        
            int codigoRespuesta = conexionHTTP.getResponseCode();
            respuesta.setCodigoRespuesta(codigoRespuesta);
            if(codigoRespuesta==HttpURLConnection.HTTP_OK){
                respuesta.setContenido(convertirContenido(conexionHTTP.getInputStream()));
            }
            else{
                respuesta.setContenido("CODE ERROR" + codigoRespuesta);
            }
        }catch(MalformedURLException e){
            respuesta.setCodigoRespuesta(Constantes.ERROR_URL);
            respuesta.setContenido("Error" + e.getMessage());
        }catch(IOException iox){
            respuesta.setCodigoRespuesta(Constantes.ERROR_PETICION);
            respuesta.setContenido("Error" + iox.getMessage());
            
        }
        return respuesta;
        
        
    
    }
    
    
    public static CodigoHTTP peticionPOSTJson(String url, String json ){
        CodigoHTTP respuesta = new CodigoHTTP();
        try{
            URL urlServicio = new URL(url);
            HttpURLConnection conexionHTTP = (HttpURLConnection)urlServicio.openConnection();
            conexionHTTP.setRequestMethod("POST");
            conexionHTTP.setRequestProperty("Content-Type", "application/json");
            conexionHTTP.setDoOutput(true);
            
            //Escribir datos en el cuerpo de la petición
            
            OutputStream os = conexionHTTP.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();
            //Termina la escritura
            int codigoRespuesta = conexionHTTP.getResponseCode();
            respuesta.setCodigoRespuesta(codigoRespuesta);
            if(codigoRespuesta==HttpURLConnection.HTTP_OK){
                respuesta.setContenido(convertirContenido(conexionHTTP.getInputStream()));
            }
            else{
                respuesta.setContenido("CODE ERROR" + codigoRespuesta);
            }
        }catch(MalformedURLException e){
            respuesta.setCodigoRespuesta(Constantes.ERROR_URL);
            respuesta.setContenido("Error" + e.getMessage());
        }catch(IOException iox){
            respuesta.setCodigoRespuesta(Constantes.ERROR_PETICION);
            respuesta.setContenido("Error" + iox.getMessage());
            
        }
        return respuesta;
        
    }
    
    private static String convertirContenido(InputStream contenido) throws IOException{
        InputStreamReader inputLectura = new InputStreamReader(contenido);
        BufferedReader buffer = new BufferedReader(inputLectura);
        String cadenaEntrada;
        StringBuffer  cadenaBuffer = new StringBuffer();
        while((cadenaEntrada = buffer.readLine()) !=null){
            cadenaBuffer.append(cadenaEntrada);
            
        }
        buffer.close();
        return cadenaBuffer.toString();
    }
    
    
    
}
