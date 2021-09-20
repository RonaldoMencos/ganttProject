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
import model.Tarea;

public class TareaRepository {
    private Connection conn;
    private PreparedStatement  st;
    private ResultSet rs;
    
    public TareaRepository() {
        this.conn=null;
        this.st=null;
    }
    
    public int insertar (int proyecto, String titulo, String descripcion, Date fechaInicio, Date fechaFin) {
        int respuesta = 0;
        Conexion conexion = new Conexion();
        conn = conexion.conectar();
        try {
            st=conn.prepareStatement("insert into tarea(proyecto,titulo,descripcion,fechaInicio,fechaFin) values (?,?,?,?,?)");
            st.setInt(1, proyecto);
	    st.setString(2, titulo);
	    st.setString(3, descripcion);			
            st.setDate(4, new java.sql.Date(fechaInicio.getTime()));
            st.setDate(5, new java.sql.Date(fechaFin.getTime()));
            respuesta=st.executeUpdate();
            conexion.desconectar();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(TareaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }              
        return respuesta;
    }
    
    public int actualizar (int idTarea, int proyecto, String titulo, String descripcion, Date fechaInicio, Date fechaFin) {
        int respuesta = 0;
        Conexion conexion = new Conexion();
        conn = conexion.conectar();
        try {
            st=conn.prepareStatement("update tarea set titulo =?,descripcion=?,fechaInicio=?,fechaFin=?,proyecto=? where idTarea=?");
            st.setString(1, titulo);
            st.setString(2, descripcion);
            st.setDate(3, new java.sql.Date(fechaInicio.getTime()));
            st.setDate(4, new java.sql.Date(fechaFin.getTime()));
            st.setInt(5, proyecto);
            st.setInt(6, idTarea);
            respuesta=st.executeUpdate();
            conexion.desconectar();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(TareaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return respuesta;
    }
    
    public int eliminar (int idtarea) {
        int respuesta = 0;
        Conexion conexion = new Conexion();
        conn = conexion.conectar();
        try {
            st=conn.prepareStatement("delete from tarea where idtarea=?");         
            st.setInt(1, idtarea);
            respuesta=st.executeUpdate();
            conexion.desconectar();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(TareaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return respuesta;
    }
    
    public List<Tarea> listarTareas() {
        Tarea tarea;
        List<Tarea> listTarea = new ArrayList<Tarea>();
        Conexion conexion = new Conexion();
        conn = conexion.conectar();
        try {
            st=conn.prepareStatement("select * from tarea");
            rs=st.executeQuery();
            while (rs.next()) {
                tarea = new Tarea(rs.getInt("idTarea"),rs.getInt("proyecto"),
                        rs.getString("titulo"),rs.getString("descripcion"),rs.getDate("fechaInicio"),rs.getDate("fechaFin"));
                listTarea.add(tarea);
            }
            conexion.desconectar();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(TareaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTarea;
    }
    
    public Tarea listarTareaPorId(int idTarea) {
        Tarea tarea = new Tarea();
        Conexion conexion = new Conexion();
        conn = conexion.conectar();
        try {
            st=conn.prepareStatement("select * from tarea where idTarea =?");
            st.setInt(1, idTarea);
            rs=st.executeQuery();
            while (rs.next()) {
                tarea = new Tarea(rs.getInt("idTarea"),rs.getInt("proyecto"),
                        rs.getString("titulo"),rs.getString("descripcion"),rs.getDate("fechaInicio"),rs.getDate("fechaFin"));
            }
            conexion.desconectar();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActividadRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarea;
    }
}
