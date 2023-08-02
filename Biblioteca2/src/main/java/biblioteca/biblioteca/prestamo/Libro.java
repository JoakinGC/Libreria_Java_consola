package biblioteca.prestamo;

import java.util.ArrayList;
import java.util.Objects;

public class Libro {
	private String titulo;
	private String isbn;
	private ArrayList<Editorial> editorial = new ArrayList<Editorial>();
	private ArrayList<Autor> autores = new ArrayList<Autor>();
	private ArrayList<Genero> generos = new ArrayList<Genero>();
	
	
	public Libro(String titulo, String isbn, ArrayList<Editorial> editorial, ArrayList<Autor> autores, ArrayList<Genero> genero) {
		this.titulo = titulo;
		this.isbn = isbn;
		
		this.editorial.addAll(editorial);
		this.autores.addAll(autores);
		this.generos.addAll(genero);
	}
	
	public Libro (String titulo, String isbn, ArrayList<Editorial> editorial,Genero genero) {

		this.titulo = titulo;
		this.isbn = isbn;
		this.editorial.addAll(editorial);
		this.generos.add(genero);
	
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	

	public ArrayList<Editorial> getEditorial() {
		return editorial;
	}

	public void setEditorial(ArrayList<Editorial> editorial) {
		this.editorial = editorial;
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}
	public void setAutores(ArrayList<Autor>autores) {
		autores.clear();
		autores.addAll(autores);
	}


	public ArrayList<Genero> getGeneros() {
		return generos;
	}
	
	public void setGeneros(ArrayList<Genero> generos) {
		generos.clear();
		generos.addAll(generos);
	}

	

	
	
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}

	public boolean equalsSinISBN(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autores, other.autores) || Objects.equals(editorial, other.editorial)
				|| Objects.equals(generos, other.generos) || Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", isbn=" + isbn + ", editorial=" + editorial.toString() + ", autores=" + autores.toString()
				+ ", generos=" + generos + "]";
	}
	
	
}
