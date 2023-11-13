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
import modelo.pojo.Promocion;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author eduar
 */
public class PromocionDAO {
    public static Mensaje registrarPromocion(Promocion promocion) {
    Mensaje msj = new Mensaje();
    msj.setError(true);
    SqlSession sqlSession = MyBatisUtil.getSession();

    if (sqlSession != null) {
        try {
            int filasAfectadas = sqlSession.insert("promocion.registrarPromocion", promocion);
            sqlSession.commit();

            if (filasAfectadas > 0) {
                msj.setError(false);
                msj.setMensaje("Promoción registrada correctamente");
            } else {
                msj.setMensaje("No se pudo registrar la promoción, intenta nuevamente");
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
    public static Mensaje editarPromocion(Promocion promocion) {
    Mensaje msj = new Mensaje();
    msj.setError(true);
    SqlSession sqlSession = MyBatisUtil.getSession();

    if (sqlSession != null) {
        try {
            int filasAfectadas = sqlSession.update("promocion.editarPromocion", promocion);
            sqlSession.commit();

            if (filasAfectadas > 0) {
                msj.setError(false);
                msj.setMensaje("Promoción editada correctamente");
            } else {
                msj.setMensaje("No se pudo editar la promoción, intenta nuevamente");
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
public static Mensaje eliminarPromocion(Integer idPromocion) {
    Mensaje msj = new Mensaje();
    msj.setError(true);
    SqlSession sqlSession = MyBatisUtil.getSession();

    if (sqlSession != null) {
        try {
            int filasAfectadas = sqlSession.delete("promocion.eliminarPromocion", idPromocion);
            sqlSession.commit();

            if (filasAfectadas > 0) {
                msj.setError(false);
                msj.setMensaje("Promoción eliminada correctamente");
            } else {
                msj.setMensaje("No se pudo eliminar la promoción, intenta nuevamente");
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
public static Mensaje cambiarEstadoPromocion(Integer idPromocion, Integer nuevoEstatusID) {
    Mensaje msj = new Mensaje();
    msj.setError(true);
    SqlSession sqlSession = MyBatisUtil.getSession();

    if (sqlSession != null) {
        try {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("idPromocion", idPromocion);
            parameters.put("nuevoEstatusID", nuevoEstatusID);

            int filasAfectadas = sqlSession.update("promocion.cambiarEstadoPromocion", parameters);
            sqlSession.commit();

            if (filasAfectadas > 0) {
                msj.setError(false);
                msj.setMensaje("Estado de la promoción cambiado correctamente");
            } else {
                msj.setMensaje("No se pudo cambiar el estado de la promoción, intenta nuevamente");
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

public static List<Promocion> buscarPromocion(String parametro) {
    List<Promocion> promociones = new ArrayList<>();
    SqlSession sqlSession = MyBatisUtil.getSession();

    if (sqlSession != null) {
        try {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("param", parametro);
            promociones = sqlSession.selectList("promocion.buscarPromocion", parameters);
        } finally {
            sqlSession.close();
        }
    }
    return promociones;
}


}
