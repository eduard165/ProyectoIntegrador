package modelo;

import com.google.gson.Gson;
import modelo.pojo.Cliente;
import modelo.pojo.RespuestaLoginCliente;
import modelo.pojo.RespuestaLoginUsuario;
import modelo.pojo.Usuario;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;


public class AutenticacionDAO {

    public static RespuestaLoginUsuario verificarSesionUsuario(Usuario usuario) {
        RespuestaLoginUsuario respuesta = new RespuestaLoginUsuario();
        respuesta.setError(true);

        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                Gson gson = new Gson();
                 usuario = conexionBD.selectOne("autenticacion.verificarCredencialesUsuario", usuario);

                if (usuario != null) {
                    respuesta.setError(false);
                    respuesta.setContenido("Bienvenid(@) " + usuario.getNombre() + " al sistema .");
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
    
    public static RespuestaLoginCliente verificarSesionCliente(Cliente cliente) {
        RespuestaLoginCliente respuesta = new RespuestaLoginCliente();
        respuesta.setError(true);

        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                Gson gson = new Gson();

             cliente = conexionBD.selectOne("autenticacion.verificarCredencialesCliente", cliente);

                if (cliente != null) {
                    respuesta.setError(false);
                    respuesta.setContenido("Bienvenid(@) " + cliente.getNombre() + " al sistema .");
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
