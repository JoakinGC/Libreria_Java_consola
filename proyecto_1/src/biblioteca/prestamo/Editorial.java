package biblioteca.prestamo;

import java.util.ArrayList;

public class Editorial {
	private String nombre;
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	
	public Editorial(String nombre, ArrayList<Libro> libros) {
		
		this.nombre = nombre;
		this.setLibros(libros);
	}
	
	public Editorial (String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros.addAll(libros);
	}

	@Override
	public String toString() {
		return "Editorial [nombre=" + nombre + ", libros=" + libros + "]";
	}
	
	
}
