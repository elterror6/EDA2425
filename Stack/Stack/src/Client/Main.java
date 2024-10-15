package Client;
import pilasPackage.*;
import java.util.Scanner;
/**
 * <p>
 * Clase para probar la estructura de pila con un ejercicio de palindromo.
 * </p>
 */
public class Main {
	/**
	 * <p>
	 * Metodo main para realizar la prueba del metodo del palindromo.<br>Comprueba si la cadena que se ha pasado por teclado es un palindromo o no.
	 * </p>
	 * @param args Argumentos adicionales
	 */
	public static void main(String[] args) {
		String s;
		Stack<Character> sstack = new StaticStack<>();
		Stack<Character> dstack = new DinamicStack<>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca una frase o palabra: ");
		s=sc.nextLine();
		
		
		System.out.println("Pila dinamica: ");
		if (Palindromo(s,dstack)) {
			System.out.println("La cadena es un palindromo.");
		} else {
			System.out.println("La cadena no es un palindromo.");
		}
		System.out.println("Pila estatica: ");
		if (Palindromo(s,sstack)) {
			System.out.println("La cadena es un palindromo.");
		} else {
			System.out.println("La cadena no es un palindromo.");
		}
	}
	/**
	 * <p>
	 * Metodo para ver si una cadena dada es un palindromo o no introduciendose una pila para facilitar la operacion y probar las clases DinamicStack y StaticStack.
	 * </p>
	 * @param <E> Elemento generico
	 * @param s Cadena de caracteres que puede ser un palindromo
	 * @param pila Pila para realizar la comprobacion del palindromo
	 * @return True si la cadena de caracteres dada es un palindromo o False si no lo es
	 */
	public static <E> boolean Palindromo(String s,Stack<E> pila) {
		Character c;
		boolean result = true;
		s=s.toLowerCase().replace(" ","");
		for(int i=0;i<s.length();i++) {
			c = s.charAt(i);
			pila.push((E) c);
		}
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!=(Character)pila.pop()) {
				result = false;
			}
		}
		return result;
	}

}
