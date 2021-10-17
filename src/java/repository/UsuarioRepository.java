package repository;


import connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

public class UsuarioRepository{
    private Connection conn;
    private PreparedStatement  st;
    private ResultSet rs;
    
    public int insertar_usuario(String nombre, String apellido, String email, String password){
        int respuesta=0;
        Conexion c1=new Conexion();        
        conn=c1.conectar();    
        
        try
        {
            st=conn.prepareStatement("insert into usuario(nombre,apellido,email,password)"+"values ('"+nombre+"','"+apellido+"','"+email+"','"+password+"')");
            respuesta= st.executeUpdate();
            c1.desconectar();
            conn.close();
            st.close();
        }
        
        catch(SQLException ex){
        }
        return respuesta;
    }
    
    public int actualizar_usuario(String nombre, String apellido, String email, String password ,int idUsuario){
        int respuesta=0;        
        Conexion c1=new Conexion();             
        conn=c1.conectar();
      
        try
        {
            st=conn.prepareStatement("update usuario set nombre= '"+nombre+"',apellido= '"+apellido+"',email= '"+email+"',password= '"+password +"' where idUsuario = "+idUsuario+" ");
            respuesta= st.executeUpdate();       
            c1.desconectar();
            conn.close();
            st.close();
        }
        catch(SQLException ex){
        }
        return respuesta;
    }
    
    public int eliminar(int idUsuario){
        int respuesta=0;
        Conexion c1=new Conexion();
        conn=c1.conectar();
        
        try
        {
            st=conn.prepareStatement(" delete from usuario where idUsuario= " +idUsuario+" ");
            respuesta= st.executeUpdate();
            c1.desconectar();
            conn.close();
            st.close();
        }
        
        catch(SQLException ex){
        }
        return respuesta;
    }
    
    public List<Usuario> listarUsuario() {
        Usuario usuario;
        List<Usuario> listUsuario = new ArrayList<>();
        Conexion conexion = new Conexion();
        conn = conexion.conectar();
        try {
            st=conn.prepareStatement("select * from Usuario");
            rs=st.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(rs.getInt("idUsuario"),
                        rs.getString("nombre"),rs.getString("apellido"),rs.getString("email"),rs.getString("password"));
                listUsuario.add(usuario);
            }
            conexion.desconectar();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActividadRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUsuario;
    }
    
    public Usuario listarUsuarioPorId(int idUsuario) {
        Usuario usuario = new Usuario();
        Conexion conexion = new Conexion();
        conn = conexion.conectar();
        try {
            st=conn.prepareStatement("select * from usuario where idUsuario =?");
            st.setInt(1, idUsuario);
            rs=st.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(rs.getInt("idUsuario"),
                        rs.getString("nombre"),rs.getString("apellido"),rs.getString("email"),rs.getString("password"));
            }
            conexion.desconectar();
            st.close();
        } catch (SQLException ex) {
            
        }
        return usuario;
    }
    
     public Usuario autenticar(String email, String password){
        Usuario usuario = new Usuario();
        Conexion c1=new Conexion();        
        conn=c1.conectar();    
        
        try
        {
            st=conn.prepareStatement("select * from usuario where email = ? and password = ?");
            st.setString(1, email);
            st.setString(2, password);
            rs=st.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(rs.getInt("idUsuario"),
                        rs.getString("nombre"),rs.getString("apellido"),rs.getString("email"),rs.getString("password"));
            }
            c1.desconectar();
            conn.close();
            st.close();
        }
        
        catch(SQLException ex){
        }
        return usuario;
    }
}