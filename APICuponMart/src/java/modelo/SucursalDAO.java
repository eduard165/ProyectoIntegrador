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
import modelo.pojo.Empresa;
import modelo.pojo.Mensaje;
import modelo.pojo.Sucursal;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author eduar
 */
public class SucursalDAO {
    public static Mensaje agregarSucursal(Sucursal sucursal) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.insert("sucursal.agregarSucursal", sucursal);
                sqlSession.commit();
                
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Se agregó correctamente la sucursal");
                } else {
                    msj.setMensaje("No se pudo agregar la sucursal, intenta nuevamente");
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
        public static Mensaje editarSucursal(Sucursal sucursal) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.update("sucursal.editarSucursal", sucursal);
                sqlSession.commit();
                
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Se editó correctamente la sucursal");
                } else {
                    msj.setMensaje("No se pudo editar la sucursal, intenta nuevamente");
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
    
   public static Mensaje eliminarSucursal(Integer idSucursal) {
    Mensaje msj = new Mensaje();
    msj.setError(true);
    SqlSession sqlSession = MyBatisUtil.getSession();

    if (sqlSession != null) {
        try {
            // Verificar promociones asociadas
            int promocionesAsociadas = sqlSession.selectOne("sucursal.contarPromocionesAsociadas", idSucursal);

            if (promocionesAsociadas == 0) {
                int filasAfectadas = sqlSession.delete("sucursal.eliminarSucursal", idSucursal);
                sqlSession.commit();

                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Se eliminó correctamente la sucursal");
                } else {
                    msj.setMensaje("No se pudo eliminar la sucursal, intenta nuevamente");
                }
            } else {
                msj.setMensaje("No se puede eliminar la sucursal. Tiene promociones asociadas.");
            }

        } catch (Exception e) {
            // Manejar errores específicos
            e.printStackTrace();
            msj.setMensaje("ERROR: " + e.getMessage());
        } finally {
            sqlSession.close();
        }
    }

    return msj;
}
public static List<Sucursal> buscarSucursales(String parametro) {
    List<Sucursal> sucursales = new ArrayList<>();
    SqlSession sqlSession = MyBatisUtil.getSession();

    if (sqlSession != null) {
        try {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("param", parametro);
            sucursales = sqlSession.selectList("sucursal.buscarSucursal", parameters);
        } finally {
            sqlSession.close();
        }
    }
    return sucursales;
}
public static Sucursal buscarSucursal(String parametro) {
    Sucursal sucursal = null;
    SqlSession sqlSession = MyBatisUtil.getSession();
    if (sqlSession != null) {
        try {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("param", parametro);

            // Modificar la consulta según tus necesidades
            sucursal = sqlSession.selectOne("sucursal.buscarSucursal", parameters);
        } finally {
            sqlSession.close();
        }
    }
    return sucursal;
}



}
