import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Libro {
	private String titulo;
	private String autor;
	private int cantidadPaginas;
	private List<String> generos;

	public Libro(String titulo, String autor, int cantidadPaginas) {
		this.titulo = titulo;
		this.autor = autor;
		this.cantidadPaginas = cantidadPaginas;
		this.generos = new ArrayList<>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(int cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}
	
	public void addGenero(String genero) {
		generos.add(genero);
	}
	
	public Iterator<String> iterarGeneros() {
		return this.generos.iterator();
	}
	
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", cantidadPaginas=" + cantidadPaginas + ", generos="
				+ generos + "]";
	}
}
