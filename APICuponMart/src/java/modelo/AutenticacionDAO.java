package modelo;

import com.google.gson.Gson;
import java.util.HashMap;
import modelo.pojo.Mensaje;
import modelo.pojo.RespuestaLoginEscritorio;
import modelo.pojo.Usuario;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import static org.apache.tomcat.jni.User.username;

public class AutenticacionDAO {

    public static RespuestaLoginEscritorio verificarSesionEscritorio(String jsonParam) {
        RespuestaLoginEscritorio respuesta = new RespuestaLoginEscritorio();
        respuesta.setError(true);

        SqlSession conexionBD = MyBatisUtil.getSession();
        if (conexionBD != null) {
            try {
                Gson gson = new Gson();
                Usuario usuarioParam = gson.fromJson(jsonParam, Usuario.class);

                Usuario usuario = conexionBD.selectOne("autenticacion.loginEscritorio", usuarioParam);

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
}
