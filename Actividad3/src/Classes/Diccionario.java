package Classes;
import java.util.List;
import java.util.LinkedList;
public class Diccionario {
	private List<Termino> listaTerminos;
	
	public Diccionario () {
		this.listaTerminos = new LinkedList<Termino>();
	}
	
	public void addTermino (String termino, String definicion) {
		Termino term = new Termino(termino, definicion);
		listaTerminos.add(term);
	}
	
	public void deleteTermino (String termino) throws DiccionarioException{
		int i = 0;
		boolean found = false;
		while (this.listaTerminos.size()>i || found) {
			if (this.listaTerminos.get(i).getTermino()==termino) {
				found = true;
			}
		}
		if (!found) {
			throw new DiccionarioException("Termino no encontrado");
		}
	}
	
	public int countTerms() {
		return this.listaTerminos.size();
	}
}
