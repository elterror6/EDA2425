package Main;
import Classes.*;
import java.util.InputMismatchException;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * La Clase Principal.
 */
public class Main {

	/**
	 * El metodo main.
	 *
	 * @param args Los argumentos
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Diccionario d = new Diccionario();
		int opt=0;
		do {
			try {
				
				menu();
				opt = input.nextInt();
				input.nextLine();
				String termino, definicion;
				switch (opt) {
					case 1:
						System.out.println("T�rmino:");
						termino = input.nextLine();
						System.out.println("Definici�n:");
						definicion = input.nextLine();
						
						d.addTermino(termino, definicion);
						
						System.out.println("T�rmino "+termino+" a�adido satisfactoriamente al diccionario.");
						break;
					case 2:
						System.out.println("T�rmino:");
						termino = input.nextLine();
						
						d.deleteTermino(termino);
						
						System.out.println("T�rmino "+termino+" eliminado satisfactoriamente.");
						break;
					case 3:
						System.out.println("T�rmino:");
						termino = input.nextLine();
						
						System.out.println(d.getTermino(termino).toString());
						break;
					case 4:
						System.out.println("T�rminos totales en el diccionario: "+d.countTerms());
						break;
					case 5:
						System.out.println("Goodbye.");
						break;
					default:
						System.out.println("La opci�n que se ha introducido no es v�lida.");
				}
			} catch (InputMismatchException e) {
				System.out.println(e+": La opci�n dada no es un n�mero entero.");
				input.nextLine();
			} catch (DiccionarioException e) {
				System.out.println(e);
			}
		} while (opt != 5);
		input.close();
	}
	
	/**
	 * Menu.
	 */
	public static void menu() {
		System.out.println("-----------------------------------------\nMen� principal\n-----------------------------------------\n1) A�adir un termino al diccionario.\n2) Eliminar un t�rmino del diccionario.\n3) Consultar un t�rmino en el diccionario\n4) Consultar el n�mero de t�rminos del diccionario.\n5) Salir.\n-----------------------------------------\n");
	}
}
