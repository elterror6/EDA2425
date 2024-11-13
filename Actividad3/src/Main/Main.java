package Main;
import Classes.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

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
						System.out.println("Término:");
						termino = input.nextLine();
						System.out.println("Definición:");
						definicion = input.nextLine();
						
						d.addTermino(termino, definicion);
						
						System.out.println("Término "+termino+" añadido satisfactoriamente al diccionario.");
						break;
					case 2:
						System.out.println("Término:");
						termino = input.nextLine();
						
						d.deleteTermino(termino);
						
						System.out.println("Término "+termino+" eliminado satisfactoriamente.");
						break;
					case 3:
						System.out.println("Término:");
						termino = input.nextLine();
						
						System.out.println(d.getTermino(termino).toString());
						break;
					case 4:
						System.out.println("Términos totales en el diccionario: "+d.countTerms());
						break;
					case 5:
						System.out.println("Goodbye.");
						break;
					default:
						System.out.println("La opción que se ha introducido no es válida.");
				}
			} catch (InputMismatchException e) {
				System.out.println(e+": La opción dada no es un número entero.");
				input.nextLine();
			} catch (DiccionarioException e) {
				System.out.println(e);
			}
		} while (opt != 5);
		input.close();
	}
	public static void menu() {
		System.out.println("-----------------------------------------\nMenú principal\n-----------------------------------------\n1) Añadir un termino al diccionario.\n2) Eliminar un término del diccionario.\n3) Consultar un término en el diccionario\n4) Consultar el número de términos del diccionario.\n5) Salir.\n-----------------------------------------\n");
	}
}
