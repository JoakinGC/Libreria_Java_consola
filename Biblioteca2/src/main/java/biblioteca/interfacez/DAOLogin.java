/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package biblioteca.interfacez;

import biblioteca.Usuario.Empleado;
import biblioteca.Usuario.Supervisor;

/**
 *
 * @author USUARIO
 */
public interface DAOLogin {
    public boolean iniciarSesionEmpleado(String nombre, String apellido)throws Exception;
    public boolean iniciarSesionSupervisor(String nombre, String apellido)throws Exception;
    public Supervisor supervisorIniciado(String nombre, String contra) throws Exception;
    public Empleado empleadoIniciado(String nombre, String contra) throws Exception;
    
}
