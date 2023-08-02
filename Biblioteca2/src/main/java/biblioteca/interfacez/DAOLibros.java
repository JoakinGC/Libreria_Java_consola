/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package biblioteca.interfacez;

import biblioteca.models.LibrosDB;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface DAOLibros {
    public void registrar(LibrosDB libro)throws Exception;
    public void modificar(LibrosDB libro)throws Exception;
    public void eliminar(LibrosDB libro)throws Exception;
    public List<LibrosDB> listar()throws Exception;
    
}
