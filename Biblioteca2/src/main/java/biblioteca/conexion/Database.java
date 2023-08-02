/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Database {
    
    protected Connection conexion;
    protected final String JBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    protected final String DB_URL = "jdbc:mysql://127.0.0.1:3307/biblioteca_Db";    
    //jdbc:mysql://127.0.0.1:3307/libreria_db
    
    protected final String USER = "Javi";
    protected final String contra = "simanadulto1J";
    
    public void  Conectar()throws ClassNotFoundException{
        try {
            conexion = DriverManager.getConnection(DB_URL,USER,contra);
            Class.forName(JBC_DRIVER);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }        
        
        
    public  void testConnection() {
        try {
            // Verificar la conexión ejecutando una consulta simple
            String query = "SELECT 1";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("La conexión a la base de datos está funcionando correctamente.");
            
            // Cerrar los recursos utilizados
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al probar la conexión a la base de datos: " + ex.getMessage());
        }
    


    }
    
    public void Cerrar() throws SQLException{
        if(conexion != null){
            conexion.close();
        }
    }
    
}
