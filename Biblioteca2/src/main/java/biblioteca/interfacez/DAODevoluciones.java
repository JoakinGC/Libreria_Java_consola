/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package biblioteca.interfacez;

import biblioteca.models.DevolucionDB;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface DAODevoluciones {
    public void registrar(DevolucionDB  devolucion);
    public void actualizar(DevolucionDB  devolucion);
    //public void registrar(DevolucionDB  devolucion);
    public List<DevolucionDB> listar();
}
