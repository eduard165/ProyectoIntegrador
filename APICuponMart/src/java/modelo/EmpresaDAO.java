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
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import modelo.pojo.Empresa;
import modelo.pojo.Mensaje;

/**
 *
 * @author eduar
 */
public class EmpresaDAO {
    
    public static Mensaje agregarEmpresa(Empresa empresa) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.insert("empresa.agregarEmpresa", empresa);
                sqlSession.commit();
                
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Se agregó correctamente la empresa");
                } else {
                    msj.setMensaje("No se pudo agregar la empresa, intenta nuevamente");
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
    
    public static Mensaje editarEmpresa(Empresa empresa) {
        Mensaje msj = new Mensaje();
        msj.setError(true);
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                int filasAfectadas = sqlSession.update("empresa.editarEmpresa", empresa);
                sqlSession.commit();
                
                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Se editó correctamente la empresa");
                } else {
                    msj.setMensaje("No se pudo editar la empresa, intenta nuevamente");
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
    
   public static Mensaje eliminarEmpresa(String RFC) {
    Mensaje msj = new Mensaje();
    msj.setError(true);
    SqlSession sqlSession = MyBatisUtil.getSession();

    if (sqlSession != null) {
        try {
            // Verificar si la empresa tiene sucursales
            int sucursalesAsociadas = sqlSession.selectOne("empresa.contarSucursalesAsociadas", RFC);

            if (sucursalesAsociadas == 0) {
                int filasAfectadas = sqlSession.delete("empresa.eliminarEmpresa", RFC);
                sqlSession.commit();

                if (filasAfectadas > 0) {
                    msj.setError(false);
                    msj.setMensaje("Se eliminó correctamente la empresa");
                } else {
                    msj.setMensaje("No se pudo eliminar la empresa, intenta nuevamente");
                }
            } else {
                msj.setMensaje("No se puede eliminar la empresa. Tiene sucursales asociadas.");
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

    public static List<Empresa> buscarEmpresas(String parametro) {
        List<Empresa> empresas = new ArrayList<>();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                Map<String, Object> parameters = new HashMap<>();
                parameters.put("param", parametro);
                empresas = sqlSession.selectList("empresa.buscarEmpresa", parameters);
            } finally {
                sqlSession.close();
            }
        }
        return empresas;
    }
public static Empresa buscarEmpresa(String parametro) {
    Empresa empresa = null;
    SqlSession sqlSession = MyBatisUtil.getSession();
    if (sqlSession != null) {
        try {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("param", parametro);

            empresa = sqlSession.selectOne("empresa.buscarEmpresa", parameters);
        } finally {
            sqlSession.close();
        }
    }
    return empresa;
}

   
}
