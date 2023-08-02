package biblioteca.prestamo;

import java.util.ArrayList;

public class Autor {
	private String nombre;
	private ArrayList<Libro> librosEscritos;
	
	
	public Autor(String nombre, ArrayList<Libro> libosEscritos) {
		this.nombre = nombre;
		this.librosEscritos =  (ArrayList<Libro>) libosEscritos.clone();
	}
	
	public Autor(String nombre) {
		this.nombre = nombre;
		librosEscritos = new ArrayList<Libro>();
	}
	
	
	public Autor(Object autor) {
		setNombre(((Autor)autor).getNombre());
		this.librosEscritos = new ArrayList<Libro>();
		setLibrosEscritos(((Autor)autor).getLibrosEscritos());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Libro> getLibrosEscritos() {
		return librosEscritos;
	}

	public void setLibrosEscritos(ArrayList<Libro> libosEscritos) {
		this.librosEscritos.addAll(libosEscritos);
	}

	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", librosEscritos=" + librosEscritos + "]";
	}
	
	
}
