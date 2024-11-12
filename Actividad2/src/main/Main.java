package main;
import java.util.*;
import Classes.*;

/**
 * La clase principal.
 */
public class Main {

	/**
	 * El metodo principal. Realiza las operaciones de compra, venta y consulta de ganancias en una cartera.
	 *
	 * @param args Los argumento, no se utilizan.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CarteraAcciones cartera = new CarteraAcciones();
		int ac;
		int price;
		int opt;
		
		do {
			menu();
			opt=input.nextInt();
			switch (opt) {
				case 1:
					System.out.println("Número de acciones: ");
					ac = input.nextInt();
					System.out.println("Precio actual de la acción: ");
					price = input.nextInt();
					
					cartera.Comprar(ac,price);
					
					break;
				case 2:
					System.out.println("Número de acciones: ");
					ac = input.nextInt();
					System.out.println("Precio actual de la acción: ");
					price = input.nextInt();
					try {
						cartera.Vender(ac,price);
					} catch (EmptyCarteraException e) {
						System.out.println(e);
					}
					
					break;
				case 3:
					System.out.println("Ganancias: "+cartera.getGanancias()+"€");
					break;
				case 4:
					System.out.println("Goodbye.");
					break;
				default:
					System.out.println("err:: Elija una opción que aparezca en el menú.");
			}
		} while (opt != 4);
		
		
	}
	
	/**
	 * Menu. El menu del programa.
	 */
	public static void menu () {
		System.out.println("Menú de programa\n--------------------------------------\n1.Compra acciones\n2.Vender acciones\n3.Ganancia de capital hasta el momento\n4.Salir");
	}
}
