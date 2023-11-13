/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.pojo.Mensaje;
import modelo.pojo.Usuario;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author eduar
 */
public class UsuarioDAO {

    public static Mensaje registrarUsuario(Usuario usuario) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();

        if (sqlSession != null) {
            try {
                // Verificar el rol del usuario antes de agregarlo
                if (puedeRegistrarUsuario(usuario)) {
                    int filasAfectadas = sqlSession.insert("usuario.agregarUsuario", usuario);
                    sqlSession.commit();

                    if (filasAfectadas > 0) {
                        msj.setError(false);
                        msj.setMensaje("Usuario registrado correctamente");
                    } else {
                        msj.setMensaje("No se pudo registrar el usuario, intenta nuevamente");
                    }
                } else {
                    msj.setMensaje("No tienes los permisos necesarios para registrar este usuario");
                }
            } catch (Exception e) {
                e.printStackTrace();
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return msj;
    }

    private static boolean puedeRegistrarUsuario(Usuario usuario) {
        return usuario != null
                && (usuario.getRolID() == 1
                || (usuario.getRolID() == 2 && usuario.getEmpresaRFC() != null));
    }

    public static Mensaje editarUsuario(Usuario usuario) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();

        if (sqlSession != null) {
            try {
                // Verificar el rol del usuario antes de editar
                if (puedeEditarUsuario(usuario)) {
                    int filasAfectadas = sqlSession.update("usuario.editarUsuario", usuario);
                    sqlSession.commit();

                    if (filasAfectadas > 0) {
                        msj.setError(false);
                        msj.setMensaje("Usuario editado correctamente");
                    } else {
                        msj.setMensaje("No se pudo editar el usuario, intenta nuevamente");
                    }
                } else {
                    msj.setMensaje("No tienes los permisos necesarios para editar este usuario");
                }
            } catch (Exception e) {
                e.printStackTrace();
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return msj;
    }

    private static boolean puedeEditarUsuario(Usuario usuario) {
        return usuario != null && usuario.getRolID() != null && usuario.getRolID() > 0 && usuario.getRolID() < 3 && usuario.getEmpresaRFC() != null;
    }

    public static Mensaje eliminarUsuario(Integer idUsuario) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();

        if (sqlSession != null) {
            try {
                // Obtener información del usuario antes de eliminarlo para verificar el rol
                Usuario usuario = sqlSession.selectOne("usuario.obtenerUsuarioPorId", idUsuario);

                int filasAfectadas = sqlSession.delete("usuario.eliminarUsuario", idUsuario);
                sqlSession.commit();

                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Usuario eliminado correctamente");
                } else {
                    msj.setMensaje("No se pudo eliminar el usuario, intenta nuevamente");
                }

            } catch (Exception e) {
                e.printStackTrace();
                msj.setMensaje("ERROR: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return msj;
    }

    public static List<Usuario> buscarUsuarios(String parametro) {
        List<Usuario> usuarios = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("param", parametro);

                usuarios = sqlSession.selectList("usuario.buscarUsuario", parameters);
            } finally {
                sqlSession.close();
            }
        }
        return usuarios;
    }

    public static Usuario buscarUsuario(String parametro) {
        Usuario usuario = null;
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("param", parametro);

                usuario = sqlSession.selectOne("usuario.buscarUsuario", parameters);
            } finally {
                sqlSession.close();
            }
        }
        return usuario;
    }

}
