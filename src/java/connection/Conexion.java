package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    public String user,password,url,driver;
    public Connection conn;
    
    public Conexion() {
        this.user="sa";
        //Si estas en lab es Umg$19
        this.password="123456";
        this.url="jdbc:sqlserver://LAPTOP-MTSM710B\\SQLEXPRESS:1433;databaseName=gantt_project";
        this.driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.conn=null;
    }
    
    public Connection conectar() {       
        try {
            Class.forName(this.driver);
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void desconectar() throws SQLException {
        this.conn.close();
    }
}
