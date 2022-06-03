import java.util.List;

public class main {

	public static void main(String[] args) {
		Timer t = new Timer();
		for (int i=1; i<=4; i++) {
			Biblioteca l = new Biblioteca();
			t.start();
			l.loadFromCSV("./src/csv/dataset" + i + ".csv");
			System.out.println("dataset" + i);
			System.out.println("Tiempo: " + t.stop() + " Total Libros: " + l.cantidadLibros());
			t.start();
			List<Libro> libros = l.obtenerLibros("leyendas");
			System.out.println("Tiempo leyendas: " + t.stop() + " Total Libros: " + libros.size());
			t.start();
			libros = l.obtenerLibros("filosofía");
			System.out.println("Tiempo Filosofía: " + t.stop() + " Total Libros: " + libros.size());
			t.start();
			libros = l.obtenerLibros("inexistente");
			System.out.println("Tiempo inexistente: " + t.stop() + " Total Libros: " + libros.size());
			System.out.println("");
		}
	}

}
