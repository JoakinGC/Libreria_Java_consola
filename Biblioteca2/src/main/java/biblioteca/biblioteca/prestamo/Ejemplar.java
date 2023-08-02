package biblioteca.prestamo;

import java.util.Objects;

public class Ejemplar  implements Comparable<Ejemplar>{
	private String idEjemplar;
	private Libro libro;
	private Revista revista;
	
	
	public Ejemplar(String idEjemplar, Libro libro) {
		
		this.idEjemplar = idEjemplar;
		this.libro = libro;
		this.revista = null;
		
	}
	
	public Ejemplar(String idEjemplar,  Revista revista) {
		
		this.idEjemplar = idEjemplar;
		this.revista = revista;
		this.libro = null;
	}

	public String getIdEjemplar() {
		return idEjemplar;
	}

	
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Revista getRevista() {
		return revista;
	}

	public void setRevista(Revista revista) {
		this.revista = revista;
	}
	

	
	@Override
	public int compareTo(Ejemplar otroEjemplar) {
	    return this.idEjemplar.compareTo(otroEjemplar.idEjemplar);
	}

	@Override
	public String toString() {
		
		
		return (libro == null) ? "Ejemplar [idEjemplar=" + idEjemplar + ", revista=" + revista.toString() + "]" :"Ejemplar [idEjemplar=" + idEjemplar + ", libro=" + libro.toString()  + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEjemplar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ejemplar other = (Ejemplar) obj;
		return Objects.equals(idEjemplar, other.idEjemplar);
	}

	

	

}

