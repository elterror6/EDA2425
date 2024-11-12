package Classes;
import java.util.List;
import java.util.LinkedList;
/**
 * La clase que representa un Diccionario.
 */
public class Diccionario {
	
	/** La lista terminos. */
	private List<Termino> listaTerminos;
	
	/**
	 * Instancia un nuevo diccionario vacio.
	 */
	public Diccionario () {
		this.listaTerminos = new LinkedList<Termino>();
	}
	
	/**
	 * Introduce el termino al final de la lista.
	 *
	 * @param termino the termino
	 * @param definicion the definicion
	 */
	public void addTermino (String termino, String definicion) {
		Termino term = new Termino(termino, definicion);
		listaTerminos.add(term);
	}
	
	/**
	 * Elimina un termino dado.
	 *
	 * @param termino El termino a eliminar.
	 * @throws DiccionarioException La excepcion de diccionario.
	 */
	public void deleteTermino (String termino) throws DiccionarioException{
		int i = 0;
		boolean found = false;
		while (this.listaTerminos.size()>i || found) {
			if (this.listaTerminos.get(i).getTermino()==termino) {
				found = true;
			}
		}
		if (!found) {
			throw new DiccionarioException("Termino no encontrado.");
		}
	}
	
	/**
	 * Devuelve el numero de terminos del diccionario.
	 *
	 * @return El tamaño de la lista de terminos.
	 */
	public int countTerms() {
		return this.listaTerminos.size();
	}
}
