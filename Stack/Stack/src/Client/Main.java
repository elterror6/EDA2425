package Client;
import pilasPackage.*;
public class Main {

	public static void main(String[] args) {
		Stack<Character> sstack = new StaticStack<>();
		Stack<Character> dstack = new DinamicStack<>();
		System.out.println("Pila dinamica: ");
		if (Palindromo("Amigo no gima",dstack)) {
			System.out.println("La cadena es un palindromo.");
		} else {
			System.out.println("La cadena no es un palindromo.");
		}
		System.out.println("Pila estatica: ");
		if (Palindromo("Amigo no gima",sstack)) {
			System.out.println("La cadena es un palindromo.");
		} else {
			System.out.println("La cadena no es un palindromo.");
		}
	}
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
