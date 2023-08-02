package biblioteca.Usuario;

import java.util.Objects;

public class Socio extends Usuario implements Comparable<Socio>{
	private String idSocio;
	private boolean penalizacion;
	private boolean activo;

	public Socio() {
		super();		
	}

	public Socio(String nombre, String apellido, int edad, String dni,String idSocio) {
		super(nombre, apellido, edad, dni);
		this.idSocio = idSocio;
		penalizacion = false;
		activo = false;
	}

	public String getIdSocio() {
		return idSocio;
	}

	public boolean isPenalizacion() {
		return penalizacion;
	}

	public void setPenalizacion(boolean penalizacion) {
		this.penalizacion = penalizacion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Socio [idSocio=" + idSocio + ", penalizacion=" + penalizacion + ", activo=" + activo + ", toString()="
				+ super.toString() + "]";
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idSocio);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		return Objects.equals(idSocio, other.idSocio);
	}

	@Override
	public int compareTo(Socio o) {
		return this.idSocio.compareTo(o.getIdSocio());
	}
}
