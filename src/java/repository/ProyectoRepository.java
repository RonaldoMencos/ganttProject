package repository;

import connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;


public class ProyectoRepository {
    private Connection con;
    private PreparedStatement  stm;
    private ResultSet rs;
    
    public int insertar_Proyecto(int empresa, String titulo, String descripcion, Date fechaInicio, Date fechaFin) {
        int respuesta = 0;
        Conexion c1 = new Conexion(); 

        con = c1.conectar();

        try {
            stm = con.prepareStatement("insert into proyecto(titulo,descripcion,fechaInicio,fechaFin,empresa) values (?,?,?,?,?)");
            stm.setString(1, titulo);
            stm.setString(2, descripcion);
            stm.setDate(3, new java.sql.Date(fechaInicio.getTime()));
            stm.setDate(4, new java.sql.Date(fechaFin.getTime()));
            stm.setInt(5, empresa);
            respuesta = stm.executeUpdate();
            c1.desconectar();
            con.close();
            stm.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respuesta;
    }

    public int actualizar_Proyecto(int idProyecto, int empresa, String titulo, String descripcion, Date fechaInicio, Date fechaFin) {
        int respuesta = 0;

        Conexion c1 = new Conexion();

        con = c1.conectar();
        try {
            stm = con.prepareStatement("update Proyecto set empresa= ?,titulo= ?,descripcion=?,fechaInicio= ?,fechaFin=? where idProyecto =? ;");
            stm.setInt(1, empresa);
            stm.setString(2, titulo);
            stm.setString(3, descripcion);
            stm.setDate(4, new java.sql.Date(fechaInicio.getTime()));
            stm.setDate(5, new java.sql.Date(fechaFin.getTime()));
            stm.setInt(6, idProyecto);
            respuesta = stm.executeUpdate();

            c1.desconectar();
            con.close();
            stm.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respuesta;
    }

    public int eliminar_Proyecto(int idProyecto) {
        int respuesta = 0;
        Conexion c1 = new Conexion();

        con = c1.conectar();

        try {
            stm = con.prepareStatement("delete from Proyecto where idProyecto= ? ;");
            stm.setInt(1, idProyecto);
            respuesta = stm.executeUpdate();
            c1.desconectar();
            con.close();
            stm.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respuesta;
    }
}
