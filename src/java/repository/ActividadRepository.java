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
import model.Actividad;

public class ActividadRepository {
    private Connection conn;
    private PreparedStatement  st;
    private ResultSet rs;
    
    public ActividadRepository() {
        this.conn=null;
        this.st=null;
    }
    
    public int insertar (String titulo, String descripcion, Date fechaInicio, Date fechaFin,int tarea) {
        int respuesta = 0;
        Conexion conexion = new Conexion();
        conn = conexion.conectar();
        try {
            st=conn.prepareStatement("insert into actividad(titulo,descripcion,fechaInicio,fechaFin,tarea) values (?,?,?,?,?)");
            st.setString(1, titulo);
            st.setString(2, descripcion);
            st.setDate(3, new java.sql.Date(fechaInicio.getTime()));
            st.setDate(4, new java.sql.Date(fechaFin.getTime()));
            st.setInt(5, tarea);
            respuesta=st.executeUpdate();
            conexion.desconectar();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActividadRepository.class.getName()).log(Level.SEVERE, null, ex);
        }              
        return respuesta;
    }
    
    public int actualizar (String titulo, String descripcion, Date fechaInicio, Date fechaFin,int tarea,int idActividad) {
        int respuesta = 0;
        Conexion conexion = new Conexion();
        conn = conexion.conectar();
        try {
            st=conn.prepareStatement("update actividad set titulo =?,descripcion=?,fechaInicio=?,fechaFin=?,tarea=? where idActividad=?");
            st.setString(1, titulo);
            st.setString(2, descripcion);
            st.setDate(3, new java.sql.Date(fechaInicio.getTime()));
            st.setDate(4, new java.sql.Date(fechaFin.getTime()));
            st.setInt(5, tarea);
            st.setInt(6, idActividad);
            respuesta=st.executeUpdate();
            conexion.desconectar();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActividadRepository.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return respuesta;
    }
    
    public int eliminar (int idActividad) {
        int respuesta = 0;
        Conexion conexion = new Conexion();
        conn = conexion.conectar();
        try {
            st=conn.prepareStatement("delete from actividad where idActividad=?");         
            st.setInt(1, idActividad);
            respuesta=st.executeUpdate();
            conexion.desconectar();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActividadRepository.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return respuesta;
    }
    
    public List<Actividad> listarActividades() {
        Actividad actividad;
        List<Actividad> listActividad = new ArrayList<Actividad>();
        Conexion conexion = new Conexion();
        conn = conexion.conectar();
        try {
            st=conn.prepareStatement("select * from actividad");
            rs=st.executeQuery();
            while (rs.next()) {
                actividad = new Actividad(rs.getInt("idActividad"),rs.getInt("tarea"),
                        rs.getString("titulo"),rs.getString("descripcion"),rs.getDate("fechaInicio"),rs.getDate("fechaFin"));
                listActividad.add(actividad);
            }
            conexion.desconectar();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActividadRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listActividad;
    }
    
    public Actividad listarActividadPorId(int idActividad) {
        Actividad actividad = new Actividad();
        Conexion conexion = new Conexion();
        conn = conexion.conectar();
        try {
            st=conn.prepareStatement("select * from actividad where idActividad =?");
            st.setInt(1, idActividad);
            rs=st.executeQuery();
            while (rs.next()) {
                actividad = new Actividad(rs.getInt("idActividad"),rs.getInt("tarea"),
                        rs.getString("titulo"),rs.getString("descripcion"),rs.getDate("fechaInicio"),rs.getDate("fechaFin"));
            }
            conexion.desconectar();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActividadRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actividad;
    }
    
    public List<Actividad> listarActividadesPorProyecto(int tarea) {
        Actividad actividad;
        List<Actividad> listActividad= new ArrayList<Actividad>();
        Conexion conexion = new Conexion();
        conn = conexion.conectar();
        try {
            st=conn.prepareStatement("select * from actividad where tarea = ?");
            st.setInt(1, tarea);
            rs=st.executeQuery();
            while (rs.next()) {
                actividad = new Actividad(rs.getInt("idActividad"),rs.getInt("tarea"),
                        rs.getString("titulo"),rs.getString("descripcion"),rs.getDate("fechaInicio"),rs.getDate("fechaFin"));
                listActividad.add(actividad);
            }
            conexion.desconectar();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(TareaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listActividad;
    }
    
}
