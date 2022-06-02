
public class main {

	public static void main(String[] args) {
		Libreria l = new Libreria();
		l.loadFromCSV("./src/csv/dataset2.csv");
//		System.out.println(l.libros);
		for (Libro libro: l.obtenerLibros("gastronomía")) {
			System.out.println(libro);
		}
	}

}
