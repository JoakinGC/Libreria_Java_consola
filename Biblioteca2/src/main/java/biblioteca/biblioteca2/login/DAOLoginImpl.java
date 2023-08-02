/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.biblioteca2.login;

import biblioteca.Usuario.Empleado;
import biblioteca.Usuario.Supervisor;
import biblioteca.conexion.Database;
import biblioteca.interfacez.DAOLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class DAOLoginImpl extends Database implements DAOLogin{

    public DAOLoginImpl(){
        
    }
    
    
    @Override
    public boolean iniciarSesionEmpleado(String nombre, String contra) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from Empleado where nombre = ? and contresena = ?;");
            st.setString(1,nombre);
            st.setString(2,contra);            
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                st.close();
                return true;
            }
            
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally{
            
            this.Cerrar();
            
        }
        return false;
        
    }

    @Override
    public boolean iniciarSesionSupervisor(String nombre, String contra)throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from Supervisor where nombre = ? and contresena = ?;");
            st.setString(1,nombre);
            st.setString(2,contra);            
            
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                st.close();              
                return true;                
            }
            
            
            st.close();
            
        } catch (Exception e) {
            
        }finally{
            this.Cerrar();            
        }
        return false;
    }
    
    

    

    @Override
    public Empleado empleadoIniciado(String nombre, String contra) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Supervisor supervisorIniciado(String nombre, String contra) throws Exception {
        Supervisor s = new Supervisor();
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from Supervisor where nombre = ? and contresena = ?;");
            st.setString(1,nombre);
            st.setString(2,contra);            
            
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                System.out.println(nombre );
                Timestamp fechaAltaAux = rs.getTimestamp("dia_alta");
                LocalDateTime fechaAlta = fechaAltaAux.toLocalDateTime();
                
                s.setNombre(nombre);
                s.setApellido(rs.getString("apellido"));
                s.setContrasena(rs.getString("contresena"));
                s.setDiaAlta(fechaAlta);
                s.setEdad(rs.getInt("edad"));
                s.setIdSupervisor(rs.getString("id_supervisor"));
                
                Timestamp fechaBaja = rs.getTimestamp("dia_baja");
                
                if(rs.wasNull()){
                    
                    s.setDiaBaja(null);
                    
                }else{
                    LocalDateTime localDateTime = fechaBaja.toLocalDateTime();                                        
                    s.setDiaBaja(localDateTime);
                }
                
                
                //falta asignar empleados
                                               
                st.close();                
                return s;                
            }
            
            
            st.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }finally{
            this.Cerrar();            
        }
        return s;
    }
    
    
}
