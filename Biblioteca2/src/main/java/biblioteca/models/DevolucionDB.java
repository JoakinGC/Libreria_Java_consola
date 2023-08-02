/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca.models;

import java.time.LocalDate;

/**
 *
 * @author USUARIO
 */
public class DevolucionDB {
    private int idDevulucion;
    private int idUsu;
    private int idLibro;
    private String fechaSalida;
    private String fechaDeEntrega;

    public int getIdDevulucion() {
        return idDevulucion;
    }

    public void setIdDevulucion(int idDevulucion) {
        this.idDevulucion = idDevulucion;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaDeEntrega() {
        return fechaDeEntrega;
    }

    public void setFechaDeEntrega(String fechaDeEntrega) {
        this.fechaDeEntrega = fechaDeEntrega;
    }

    
}
