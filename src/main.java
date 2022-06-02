
public class main {

	public static void main(String[] args) {
		Biblioteca l = new Biblioteca();
		l.loadFromCSV("./src/csv/dataset4.csv");
		int i = 0;
		String genero = "filosofía";
		for (Libro libro: l.obtenerLibros(genero)) {
			System.out.println(libro);
			i++;
		}
		System.out.println(i + " libros de " + genero);
	}

}
