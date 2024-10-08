package Client;
import pilasPackage.*;
public class Main {

	public static void main(String[] args) {
		 DinamicStack<Integer> dstack = new DinamicStack<>();
		 System.out.println("Pila Dinámica:");
	     for (int i = 0; i < 20; i++) {
	         dstack.push(i);
	     }
	     System.out.println("\tPrueba toString: ");
	     System.out.println("\t"+dstack.toString());
	     System.out.println("\tPrueba del POP: ");
	     System.out.print("\t");
	     while (dstack.isEmpty() == false) { 
	         System.out.print(dstack.pop() + " "  );
	     }
	     
	     System.out.println();
	     
	     StaticStack<Integer> sstack = new StaticStack<>();
	     System.out.println("Pila Estática: ");
	     for (int i = 40; i < 60; i++) {
	         sstack.push(i);
	     }
	     System.out.println("\tPrueba toString: ");
	     System.out.println("\t"+sstack.toString());
	     System.out.println("\tPrueba del POP: ");
	     System.out.print("\t");
	     while (sstack.isEmpty() == false) { 
	         System.out.print(sstack.pop() + " "  );
	     }
	}

}
