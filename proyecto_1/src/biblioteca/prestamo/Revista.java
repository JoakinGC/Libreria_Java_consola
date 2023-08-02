package biblioteca.prestamo;

import java.util.ArrayList;
import java.util.Objects;

public class Revista {
	private String IdRevista;
	private String titulo;
	private ArrayList<Editorial> editoriales;
	public Revista(String idRevista, String titulo, ArrayList<Editorial> editoriales) {
		IdRevista = idRevista;
		this.titulo = titulo;
		this.editoriales = editoriales;
	}
	

	public String getIdRevista() {
		return IdRevista;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public ArrayList<Editorial> getEditoriales() {
		return editoriales;
	}
	public void setEditoriales(ArrayList<Editorial> editoriales) {
		this.editoriales = editoriales;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(IdRevista);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revista other = (Revista) obj;
		return Objects.equals(IdRevista, other.getIdRevista());
	}
	
	public boolean equalsSinID(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revista other = (Revista) obj;
		return Objects.equals(editoriales, other.getEditoriales()) && Objects.equals(titulo, other.getTitulo());
	}
	@Override
	public String toString() {
		return "Revista [IdRevista=" + IdRevista + ", titulo=" + titulo + ", editoriales=" + editoriales.toString() + "]";
	}
	
	
	
	
}
