package Client;
import pilasPackage.*;
public class Main {

	public static void main(String[] args) {
		 DinamicStack<Integer> dstack = new DinamicStack<>();
		 System.out.println("Pila Dinámica:");
	     for (int i = 0; i < 10; i++) {
	         dstack.push(i);
	     }

	     while (dstack.isEmpty() == false) { 
	         System.out.print(dstack.pop() + " "  );
	     }
	     System.out.println();
	     StaticStack<Integer> sstack = new StaticStack<>();
	     System.out.println("Pila Estática: ");
	     for (int i = 0; i < 10; i++) {
	         sstack.push(i);
	     }

	     while (sstack.isEmpty() == false) { 
	         System.out.print(sstack.pop() + " "  );
	     }
	}

}
