package modelo;

import com.google.gson.Gson;
import modelo.pojo.Cliente;
import modelo.pojo.RespuestaLoginCliente;
import modelo.pojo.RespuestaLoginUsuario;
import modelo.pojo.Usuario;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;


public class AutenticacionDAO {

    public static RespuestaLoginUsuario verificarSesionUsuario(String jsonParam) {
        RespuestaLoginUsuario respuesta = new RespuestaLoginUsuario();
        respuesta.setError(true);

        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                Gson gson = new Gson();
                Usuario usuarioParam = gson.fromJson(jsonParam, Usuario.class);

                Usuario usuario = conexionBD.selectOne("autenticacion.verificarCredencialesUsuario", usuarioParam);

                if (usuario != null) {
                    respuesta.setError(false);
                    respuesta.setContenido("Bienvenid(@) " + usuario.getNombre() + " al sistema de control nutricional.");
                    respuesta.setUsuario(usuario);
                } else {
                    respuesta.setContenido("Numero de personal y/o contraseña incorrectos, favor de verificar");
                }
            } catch (Exception e) {
                respuesta.setContenido("Error: " + e.getMessage());
            } finally {
                conexionBD.close();
            }

        } else {
            respuesta.setContenido("Error: Por el momento no hay conexion en la base de datos");
        }

        return respuesta;
    }
    
    public static RespuestaLoginCliente verificarSesionCliente(String jsonParam) {
        RespuestaLoginCliente respuesta = new RespuestaLoginCliente();
        respuesta.setError(true);

        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                Gson gson = new Gson();
                Cliente clienteParam = gson.fromJson(jsonParam, Cliente.class);

                  Cliente cliente = conexionBD.selectOne("autenticacion.verificarCredencialesCliente", clienteParam);

                if (cliente != null) {
                    respuesta.setError(false);
                    respuesta.setContenido("Bienvenid(@) " + cliente.getNombre() + " al sistema de control nutricional.");
                    respuesta.setCliente(cliente);
                } else {
                    respuesta.setContenido("Numero de personal y/o contraseña incorrectos, favor de verificar");
                }
            } catch (Exception e) {
                respuesta.setContenido("Error: " + e.getMessage());
            } finally {
                conexionBD.close();
            }

        } else {
            respuesta.setContenido("Error: Por el momento no hay conexion en la base de datos");
        }

        return respuesta;
    }
}
