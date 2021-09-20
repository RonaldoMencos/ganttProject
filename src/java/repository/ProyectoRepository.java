package repository;

import connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Proyecto;
import model.Tarea;


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
    
    public List<Proyecto> listarProyectos() {
        Proyecto proyecto;
        List<Proyecto> listProyecto = new ArrayList<Proyecto>();
        Conexion conexion = new Conexion();
        con = conexion.conectar();
        try {
            stm=con.prepareStatement("select * from proyecto");
            rs=stm.executeQuery();
            while (rs.next()) {
                proyecto = new Proyecto(rs.getInt("idProyecto"),rs.getInt("empresa"),
                        rs.getString("titulo"),rs.getString("descripcion"),rs.getDate("fechaInicio"),rs.getDate("fechaFin"));
                listProyecto.add(proyecto);
            }
            conexion.desconectar();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(TareaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listProyecto;
    }
    
    public Proyecto listarProyectoPorId(int idProyecto) {
        Proyecto proyecto = new Proyecto();
        Conexion conexion = new Conexion();
        con = conexion.conectar();
        try {
            stm=con.prepareStatement("select * from proyecto where idProyecto =?");
            stm.setInt(1, idProyecto);
            rs=stm.executeQuery();
            while (rs.next()) {
                proyecto = new Proyecto(rs.getInt("idProyecto"),rs.getInt("empresa"),
                        rs.getString("titulo"),rs.getString("descripcion"),rs.getDate("fechaInicio"),rs.getDate("fechaFin"));
            }
            conexion.desconectar();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActividadRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proyecto;
    }
}
