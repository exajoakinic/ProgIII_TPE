
import java.util.Collections;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

public class Tree {

	private String value;
	private List<Libro> libros;
	private Tree left;
	private Tree right;

	private final String SEPARADOR = "|"; // Separador para imprimir el árbol

	public Tree() {
		this(null);
		
	}

	public Tree(String value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.libros = new LinkedList<>();
	}

	public void printPreOrder() {
		System.out.println(this.getPreOrder());
	}

	private String getPreOrder() {
		if (this.isEmpty())
			return "-" + SEPARADOR;
		String res = "";

		res += this.value + SEPARADOR;

		if (this.left == null)
			res += "-" + SEPARADOR;
		else
			res += this.left.getPreOrder();

		if (this.right == null)
			res += "-" + SEPARADOR;
		else
			res += this.right.getPreOrder();

		return res;
	}

	public void printInOrder() {
		System.out.println(this.getInOrder());
	}

	private String getInOrder() {
		if (this.isEmpty())
			return "-";
		String res = "";

		if (this.left == null)
			res += "-" + "<";
		else
			res += "(" + this.left.getInOrder() + ")<";

		res += this.value;

		if (this.right == null)
			res += ">-";
		else
			res += ">(" + this.right.getInOrder() + ")";

		return res;
	}
	
	public void add(Libro l) {
		Iterator<String> i = l.iterarGeneros();
		while (i.hasNext()) {
			String g = i.next();
			this.add(g, l);
		}
	}

	private void add(String value, Libro l) {
		if (this.isEmpty()) {
			this.value = value;
			this.libros.add(l);
			return;
		}
		if (this.value.equals(value)) {
			libros.add(l);
			return;
		}
		if (this.value.compareTo(value) > 0) { // debo buscar por izquierda
			if (this.left == null) {
				this.left = new Tree();
			}
			this.left.add(value, l);
		} else {
			if (this.right == null) {
				this.right = new Tree();
			}
			this.right.add(value, l);
		}
	}


	public Iterator<Libro> obtenerLibros(String genero) {
		Tree nodoGenero = this.buscarGenero(genero);
		if (nodoGenero != null)
			return nodoGenero.libros.iterator();
		else {
			return Collections.emptyIterator();
		}
			
	}
	
	private Tree buscarGenero(String genero) {
		if (this.isEmpty()) {
			return null;
		}
		if (this.value.equals(genero)) {
			return this;
		}
		if (this.value.compareTo(genero) > 0) {
			if (this.left != null)
				return this.left.buscarGenero(genero);
			else
				return null;
		} else {
			if (this.right != null)
				return this.right.buscarGenero(genero);
			else
				return null;
		}
	}
	public boolean isEmpty() {
		return (this.value == null);
	}
}
