package biblioteca.prestamo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import biblioteca.Usuario.Empleado;
import biblioteca.Usuario.Socio;

public class Prestamo  implements Comparable<Prestamo>{
	
	private Socio socio;
	private ArrayList<Ejemplar> listarEjemplares;
	private String idPrestamo;
	private Date fechaIni;
	private Date fechaFin;
	private Empleado empleado;
	private boolean devuelto;
		
	public Prestamo(Socio socio, ArrayList<Ejemplar> listarEjemplares, String idPrestamo, Date fechaIni, Date fechaFin,
			Empleado empleado) {
		this.socio = socio;
		this.listarEjemplares = new ArrayList<Ejemplar>();
		this.listarEjemplares.addAll(listarEjemplares);
		setIdPrestamo(idPrestamo);
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.empleado = empleado;
		this.devuelto = false;
	}


	public Socio getSocio() {
		return socio;
	}


	public boolean isDevuelto() {
		return devuelto;
	}


	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}


	public void setSocio(Socio socio) {
		this.socio = socio;
	}


	public ArrayList<Ejemplar> getListarEjemplares() {
		return listarEjemplares;
	}


	public void setListarEjemplares(ArrayList<Ejemplar> listarEjemplares) {
		this.listarEjemplares = listarEjemplares;
	}


	public String getIdPrestamo() {
		return idPrestamo;
	}


	private void setIdPrestamo(String idPrestamo) {
		this.idPrestamo = idPrestamo;
	}


	public Date getFechaIni() {
		return fechaIni;
	}


	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	


	@Override
	public int compareTo(Prestamo o) {
		
		return this.idPrestamo.compareTo(o.getIdPrestamo());
	}


	


	@Override
	public int hashCode() {
		return Objects.hash(idPrestamo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		return Objects.equals(idPrestamo, other.idPrestamo);
	}
	
	
	
	
}
