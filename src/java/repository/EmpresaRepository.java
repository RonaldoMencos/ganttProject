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
import model.Empresa;

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
    
    public List<Empresa> listarEmpresas() {
        Empresa empresa;
        List<Empresa> listEmpresa = new ArrayList<Empresa>();
        Conexion conexion = new Conexion();
        con = conexion.conectar();
        try {
            stm=con.prepareStatement("select * from empresa");
            rs=stm.executeQuery();
            while (rs.next()) {
                empresa = new Empresa(rs.getInt("idEmpresa"),rs.getString("nombre"),rs.getString("direccion"),rs.getString("email"),rs.getString("telefono"));
                listEmpresa.add(empresa);
            }
            conexion.desconectar();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(TareaRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEmpresa;
    }
    
    public Empresa listarEmpresaPorId(int idEmpresa) {
        Empresa empresa = new Empresa();
        Conexion conexion = new Conexion();
        con = conexion.conectar();
        try {
            stm=con.prepareStatement("select * from empresa where idEmpresa =?");
            stm.setInt(1, idEmpresa);
            rs=stm.executeQuery();
            while (rs.next()) {
                empresa = new Empresa(rs.getInt("idEmpresa"),rs.getString("nombre"),rs.getString("direccion"),rs.getString("email"),rs.getString("telefono"));
            }
            conexion.desconectar();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActividadRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empresa;
    }
    
}