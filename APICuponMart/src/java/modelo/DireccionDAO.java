package modelo;

import modelo.pojo.Cliente;
import modelo.pojo.Direccion;
import modelo.pojo.Empresa;
import modelo.pojo.Mensaje;
import modelo.pojo.Sucursal;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class DireccionDAO {

    public static Mensaje agregarDomicilio(Direccion direccion) {
        Mensaje msj = new Mensaje();
        msj.setError(true);

        try (SqlSession sqlSession = MyBatisUtil.getSession()) {
            if (sqlSession != null) {
                switch (direccion.campoLleno()) {
                    case 1:
                        procesarConsultaInset(sqlSession, "direccion.agregarDireccionPorEmpresa", direccion, msj,
                                "Se agregó correctamente el domicilio de la empresa",
                                "No se pudo agregar el domicilio de la empresa, intenta nuevamente");
                        break;
                    case 2:
                        procesarConsultaInset(sqlSession, "direccion.agregarDireccionPorCliente", direccion, msj,
                                "Se agregó correctamente el domicilio",
                                "No se pudo agregar el domicilio correctamente, intenta nuevamente");
                        break;
                    case 3:
                        procesarConsultaInset(sqlSession, "direccion.agregarDireccionPorSucursal", direccion, msj,
                                "Se agregó correctamente el domicilio de la sucursal",
                                "No se pudo agregar el domicilio de la sucursal, intenta nuevamente");
                        break;
                    default:
                        msj.setMensaje("Error: campos no válidos");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            msj.setMensaje("ERROR: " + e.getMessage());
        }

        return msj;
    }

    public static Mensaje editarDomicilio(Direccion direccion) {
        Mensaje msj = new Mensaje();
        msj.setError(true);

        try (SqlSession sqlSession = MyBatisUtil.getSession()) {
            if (sqlSession != null) {
                switch (direccion.campoLleno()) {
                    case 1:
                        procesarConsultaUpdate(sqlSession, "direccion.editarDireccionPorEmpresa", direccion, msj,
                                "Se agregó correctamente el domicilio de la empresa",
                                "No se pudo agregar el domicilio de la empresa, intenta nuevamente");
                        break;
                    case 2:
                        procesarConsultaUpdate(sqlSession, "direccion.editarDireccionPorCliente", direccion, msj,
                                "Se agregó correctamente el domicilio",
                                "No se pudo agregar el domicilio correctamente, intenta nuevamente");
                        break;
                    case 3:
                        procesarConsultaUpdate(sqlSession, "direccion.editarDireccionPorSucursal", direccion, msj,
                                "Se agregó correctamente el domicilio de la sucursal",
                                "No se pudo agregar el domicilio de la sucursal, intenta nuevamente");
                        break;
                    default:
                        msj.setMensaje("Error: campos no válidos");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            msj.setMensaje("ERROR: " + e.getMessage());
        }

        return msj;
    }
    
    private static void procesarConsultaInset(SqlSession sqlSession, String consulta, Direccion direccion, Mensaje msj, String mensajeExito, String mensajeError) {
        try {
            int filasAfectadas = sqlSession.insert(consulta, direccion);
            sqlSession.commit();

            if (filasAfectadas > 0) {
                msj.setError(false);
                msj.setMensaje(mensajeExito);
            } else {
                msj.setMensaje(mensajeError);
            }
        } catch (Exception e) {
            e.printStackTrace();
            msj.setMensaje("ERROR: " + e.getMessage());
        }
    }

    private static void procesarConsultaUpdate(SqlSession sqlSession, String consulta, Direccion direccion, Mensaje msj, String mensajeExito, String mensajeError) {
        try {
            int filasAfectadas = sqlSession.update(consulta, direccion);
            sqlSession.commit();
            if (filasAfectadas > 0) {
                msj.setError(false);
                msj.setMensaje(mensajeExito);
            } else {
                msj.setMensaje(mensajeError);
            }
        } catch (Exception e) {
            e.printStackTrace();
            msj.setMensaje("ERROR: " + e.getMessage());
        }
    }

    public static Direccion obtenerDomicilioEmpresa(String empresaRFC) {
        Direccion direccion = new Direccion();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                direccion = sqlSession.selectOne("domicilio.obtenerDireccionPorEmpresa", empresaRFC);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqlSession.close();
            }
        }
        return direccion;
    }

    public static Direccion obtenerDomicilioCliente(Integer idCliente) {
        Direccion direccion = new Direccion();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                direccion = sqlSession.selectOne("domicilio.obtenerDireccionPorCliente", idCliente);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqlSession.close();
            }
        }
        return direccion;
    }

    public static Direccion obtenerDomicilioSucursal(Integer idSucursal) {
        Direccion direccion = new Direccion();

        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                direccion = sqlSession.selectOne("domicilio.obtenerDireccionPorSucursal", idSucursal);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqlSession.close();
            }
        }
        return direccion;
    }

    public static Mensaje eliminarDireccionCliente(Integer idCliente) {
        Mensaje mensaje = new Mensaje();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                Cliente cliente = sqlSession.selectOne("direccion.obtenerDireccionPorCliente", idCliente);
                if (cliente != null) {
                    int numeroDeFilasAfectadas = sqlSession.delete("direccion.eliminarDireccionPorCliente", idCliente);
                    sqlSession.commit();
                    if (numeroDeFilasAfectadas > 0) {
                        mensaje.setError(false);
                        mensaje.setMensaje("Paciente eliminado con éxito");
                    } else {
                        mensaje.setMensaje("No se pudo eliminar el Paciente");
                    }
                } else {
                    mensaje.setMensaje("Error: el usuario que desea eliminar no se encuntra en el sistema");
                }
            } catch (Exception e) {
                mensaje.setMensaje("Error: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return mensaje;
    }

    public static Mensaje eliminarDireccionEmpresa(String empresaRFC) {
        Mensaje mensaje = new Mensaje();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                Cliente cliente = sqlSession.selectOne("direccion.obtenerDireccionPorEmpresa", empresaRFC);
                if (cliente != null) {
                    int numeroDeFilasAfectadas = sqlSession.delete("direccion.eliminarDireccionPorCliente", empresaRFC);
                    sqlSession.commit();
                    if (numeroDeFilasAfectadas > 0) {
                        mensaje.setError(false);
                        mensaje.setMensaje("Direcccion eliminada con exito");
                    } else {
                        mensaje.setMensaje("No se pudo eliminar");
                    }
                } else {
                    mensaje.setMensaje("Error: la direccion que desea eliminar no se encuntra en el sistema");
                }
            } catch (Exception e) {
                mensaje.setMensaje("Error: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return mensaje;
    }

    public static Mensaje eliminarDireccionSucursal(Integer idSucursal) {
        Mensaje mensaje = new Mensaje();
        SqlSession sqlSession = MyBatisUtil.getSession();
        if (sqlSession != null) {
            try {
                Cliente cliente = sqlSession.selectOne("direccion.obtenerDireccionPorCliente", idSucursal);
                if (cliente != null) {
                    int numeroDeFilasAfectadas = sqlSession.delete("direccion.eliminarDireccionPorSucursal", idSucursal);
                    sqlSession.commit();
                    if (numeroDeFilasAfectadas > 0) {
                        mensaje.setError(false);
                        mensaje.setMensaje("Direccion eliminada con éxito");
                    } else {
                        mensaje.setMensaje("No se pudo eliminar ");
                    }
                } else {
                    mensaje.setMensaje("Error: la direccion que desea eliminar no se encuntra en el sistema");
                }
            } catch (Exception e) {
                mensaje.setMensaje("Error: " + e.getMessage());
            } finally {
                sqlSession.close();
            }
        }
        return mensaje;
    }
}
