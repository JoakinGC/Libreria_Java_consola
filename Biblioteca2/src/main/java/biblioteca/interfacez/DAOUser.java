/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package biblioteca.interfacez;

import biblioteca.models.UsersDB;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface DAOUser {
    public void registrar(UsersDB user)throws Exception;
    public void modificar(UsersDB user)throws Exception;
    public void eliminar(int id)throws Exception;
    public List<UsersDB> listar(String nombre)throws Exception;
    public UsersDB getUserById(int id) throws Exception;
    
}
