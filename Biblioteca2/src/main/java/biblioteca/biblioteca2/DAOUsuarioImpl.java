/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.biblioteca2;

import biblioteca.conexion.Database;
import biblioteca.interfacez.DAOUser;
import biblioteca.models.UsersDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class DAOUsuarioImpl extends Database implements DAOUser{
    
    public DAOUsuarioImpl(){
        
    }
    
    @Override
    public void registrar(UsersDB user) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO Usuarios(nombre,apellido,edad,dni) values (?,?,?,?);");
            st.setString(1,user.getNombre());
            st.setString(2,user.getApellido());
            st.setInt(3,user.getEdad());
            st.setString(4,user.getDni());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void modificar(UsersDB user) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE Usuarios SET nombre=?, apellido = ?,edad = ?,dni = ? WHERE id_usuario = ?;");
            st.setString(1,user.getNombre());
            st.setString(2,user.getApellido());
            st.setInt(3,user.getEdad());
            st.setString(4,user.getDni());
            st.setInt(5,user.getId());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM Usuarios where id_usuario = ?;");
            st.setInt(1,id);            
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public List<UsersDB> listar(String nombre) throws Exception {
        List<UsersDB> lista = null;
        try {
            this.Conectar();
            
                String Query = nombre.isEmpty() ? "select * from usuarios;" : "select * from usuarios where nombre like '%"+nombre+"%';";
                PreparedStatement st = this.conexion.prepareStatement(Query);
            
                lista = new ArrayList();
                ResultSet rs = st.executeQuery();
            
                while(rs.next()){
                    UsersDB user = new UsersDB();
                    user.setId(rs.getInt("id_usuario"));
                    user.setNombre(rs.getString("nombre"));
                    user.setApellido(rs.getString("apellido"));
                    user.setEdad(rs.getInt("edad"));
                    user.setDni(rs.getString("dni"));
                    lista.add(user);                
                }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        
        return lista;
    }

    @Override
    public UsersDB getUserById(int id) throws Exception {
        UsersDB user = new UsersDB();
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("select * from usuarios where id_usuario = ?;");
            
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                
                user.setId(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setEdad(rs.getInt("edad"));
                user.setDni(rs.getString("dni"));
                ;               
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        
        return user;
    }
    
}
