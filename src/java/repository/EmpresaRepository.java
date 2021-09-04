package repository;

import connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpresaRepository{
    private Connection con;
    private PreparedStatement  stm;
    private ResultSet rs;
    
    public int insertar_Empresa(String nombre, String direccion, String email, String telefono){
        int respuesta=0;
        Conexion c1=new Conexion();
        
        
        con=c1.conectar();
        
        try
        {
            stm=con.prepareStatement("insert into Empresa(nombre,direccion,email,telefono) values (?,?,?,?);");
            stm.setString(1, nombre);
            stm.setString(2, direccion);
            stm.setString(3, email);
            stm.setString(4, telefono);
            respuesta= stm.executeUpdate();
        
        c1.desconectar();
        con.close();
        stm.close();
        }
        
        catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public int actualizar_Empresa(int idEmpresa, String nombre, String direccion, String email, String telefono){
        int respuesta=0;
   
        Conexion c1=new Conexion();               
        con=c1.conectar();
        
        try
        {
            stm=con.prepareStatement("update Empresa set nombre= ? ,direccion= ? ,email= ?,telefono= ? where idEmpresa = ?;");
            stm.setString(1, nombre);
            stm.setString(2, direccion); 
            stm.setString(3, email);
            stm.setString(4, telefono);
            stm.setInt(5, idEmpresa);
            respuesta= stm.executeUpdate();
        
        c1.desconectar();
        con.close();
        stm.close();
        }
        
        catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    public int eliminar_Empresa(int idEmpresa){
        int respuesta=0;
        Conexion c1=new Conexion();
        
        
        con=c1.conectar();
        
        try
        {
            stm=con.prepareStatement(" delete from Empresa where idEmpresa= " +idEmpresa+" ;");
            respuesta= stm.executeUpdate();
        
        c1.desconectar();
        con.close();
        stm.close();
        }
        
        catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }
    
    
}