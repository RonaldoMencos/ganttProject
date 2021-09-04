package repository;


import connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            st=conn.prepareStatement("insert into usuario(nombre,apellido,email,password)"+"values ('"+nombre+"','"+apellido+"','"+email+"',"+password+")");
            respuesta= st.executeUpdate();
            c1.desconectar();
            conn.close();
            st.close();
        }
        
        catch(Exception ex){
           ex.printStackTrace();
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
        catch(Exception ex){
            ex.printStackTrace();
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
        
        catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    
}