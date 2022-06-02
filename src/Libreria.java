import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Libreria {
	protected List<Libro> libros;
	private String cvsSplitBy = ",";
	private String generosSplitBy = " ";
	private int posTitulo = 0;
	private int posAutor = 1;
	private int posCantidadPaginas = 2;
	private int posGeneros = 3;
	private Tree indice;
	
	public Libreria() {
		libros = new ArrayList<>();
		indice = new Tree();
	}
	
	public List<Libro> obtenerLibros(String genero) {
		Iterator<Libro> i = indice.obtenerLibros(genero);
		ArrayList<Libro> res = new ArrayList<>();
		while (i.hasNext()) {
			Libro l = i.next();
			res.add(l);
		}
		return res;
	}
	
	public void loadFromCSV(String url) {
		String csvFile = url;
		String line = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			br.readLine(); //Descarto encabezado / primera línea
			while ((line = br.readLine()) != null) {
				String[] items = line.split(cvsSplitBy);
				String[] generos = items[posGeneros].split(generosSplitBy);
				Libro l = new Libro(items[posTitulo], items[posAutor], Integer.parseInt(items[posCantidadPaginas]));
				for (String genero:generos) {
					l.addGenero(genero);
				}
				libros.add(l);
				indice.add(l);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
