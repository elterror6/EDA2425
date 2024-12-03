package main;

import java.io.BufferedReader;
import graphsDSESIUCLM.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import Classes.DecoratedElement;
import Classes.Weight;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * La Clase principal.
 * 
 * @author Daniel D�az Garc�a
 * @author Diego Repullo Higueruela
 */
public class main {
	/**
	 * La ruta donde esta el archivo .csv.
	 */
	private final static String PATH = "src/stormofswords.csv";
	/**
	 * El metodo principal.
	 *
	 * @param args los argumentos
	 */
	public static void main(String[] args) {
		Graph<DecoratedElement<String>,Weight<String>> g = new TreeMapGraph<>();
		Scanner input = new Scanner(System.in);
		int opt;
		// Construimos el grafo.
		constructGraph(g);
		System.out.println("Game of Thrones - Relations\n---------------------------");
		// Ense�amos el n�mero de personajes y el n�mero de relaciones.
		System.out.println("N�mero de personajes: "+g.getN()+"\nN�mero de relaciones: "+g.getM());
		System.out.println("---------------------------");
		// Ense�ar el personaje m�s conocido.
		System.out.println("Personaje m�s conocido: "+mostKnownCharacter(g));
		// Ense�ar el personaje con m�s interacciones.
		System.out.println("Personaje con m�s interacciones: "+mostInterationableCharacter(g));
		System.out.println("---------------------------");
		// Ense�ar el personaje menos conocido.
		System.out.println("Personaje m�s desconocido: "+mostUnknownCharacter(g));
		// Ense�ar el personaje con menos interacciones.
		System.out.println("Personaje con menos interacciones: "+lessInterationableCharacter(g));
		System.out.println("---------------------------");
		System.out.println("1. Camino m�s corto entre dos personajes.");
		System.out.println("2. Secuencia de personajes entre dos personajes.");
		opt = input.nextInt();
		switch (opt) {
			case 1:
				String source, destination;
				Vertex<DecoratedElement<String>> s, d;
				input.nextLine();
				System.out.println("Elige un personaje de inicio: ");
				source = input.nextLine();
				System.out.println("Elige un personaje de destino: ");
				destination = input.nextLine();
				s = g.getVertex(source.hashCode()+"");
				d = g.getVertex(destination.hashCode()+"");
				int d1 = BFS(g,s,d);
				System.out.println("Existen entre "+source+" y "+destination+" una distancia de "+ d1+".");
				break;
			case 2:
				break;
			default:
				System.out.println("ERR: Opci�n no v�lida.");
		}
		input.close();
		
	}
	
	/**
	 * Construye un grafo de Nodos tipo cadena y aristas con tipo entero a trav�s de un archivo csv. 
	 *
	 * @param g El grafo vac�o
	 */
	public static void constructGraph(Graph<DecoratedElement<String>,Weight<String>> g){
	    BufferedReader bf = null;
	    try {
	        bf = new BufferedReader(new FileReader(PATH));
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    }
	    String line = null;
	    try {
	    	// Mientras el archivo tenga lineas ...
	    	bf.readLine();
	        while ((line = bf.readLine())!=null) {
	        	// ... tokenizo el contenido de la l�nea.
	        	StringTokenizer tokens = new StringTokenizer(line, ",");
	        	// Mientras el tokenizador tenga m�s tokens ...
	        	while(tokens.hasMoreTokens()){
	        		// ... guardo los tokens en distintas variables.
	        		// v1 es el primer nombre de la l�nea.
	        		String e1 = tokens.nextToken();
	        		DecoratedElement<String> v1 = new DecoratedElement<String>(e1.hashCode()+"",e1);
	        		// v2 es el segundo nombre de la l�nea.
	        		String e2 = tokens.nextToken();
	        		DecoratedElement<String> v2 = new DecoratedElement<String>(e2.hashCode()+"",e2);
	        		// p es el peso de la relaci�n entre los personajes.
	        		Weight<String> p = new Weight<String>(v1,v2,Integer.parseInt(tokens.nextToken()));
	        		// Si v1 no existe ...
	        		if (g.getVertex(v1.getElement())==null) {
	        			// ... inserto el nodo v1 en el grafo.
	        			g.insertVertex(v1);
	        		}
	        		// Si v2 no existe ...
	        		if (g.getVertex(v2.getElement())==null) {
	        			// inserto el nodo v2 en el grafo.
	        			g.insertVertex(v2);
	        		}
	        		// Por �ltimo, inserto la arista de uni�n entre los v�rtices.
	        		g.insertEdge(v1, v2, p);
	        	}
	        }
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	/**
	 * Mira cu�l es el personaje con m�s relaciones del grafo.
	 * 
	 * @return El nombre del personaje con m�s relaciones del grafo.
	 */
	public static String mostKnownCharacter(Graph<DecoratedElement<String>,Weight<String>> g) {
		// Creo los iteradores correspondientes.
		Iterator<Vertex<DecoratedElement<String>>> itc = g.getVertices();
		Iterator<Edge<Weight<String>>> itr;
		// Contador.
		int counter;
		// Nombre del personaje.
		Vertex<DecoratedElement<String>> character;
		// Pilas para meter al siguiente con m�s relaciones
		Stack<String> sc = new Stack<>();
		Stack<Integer> si = new Stack<>();
		
		// Mientras siga habiendo vertices ...
		while (itc.hasNext()) {
			// ... igualo contador a 0 ...
			counter = 0;
			// ... consigo su nombre ...
			character = itc.next();
			// ... y creo un iterador de sus aristas.
			itr = g.incidentEdges(character);
			// Mientras siga teniendo aristas ...
			while (itr.hasNext()) {
				// ... paso al siguiente ...
				itr.next();
				// ... el contador se aumenta en 1.
				++counter;
			}
			// Si la pila de pesos esta vac�a ...
			if (si.isEmpty()) {
				// ... introduzco el valor en la pila de pesos y en la de nombres, ...
				si.push(counter);
				sc.push(character.getElement().getElement());
			// si no, si el �ltimo valor es menor que las aristas contadas ...
			} else if (si.peek() <= counter) {
				// ... introduzco el valor en la pila de pesos y en la de nombres.
				si.push(counter);
				sc.push(character.getElement().getElement());
			}
		}
		// Devuelvo el nombre del �ltimo personaje de la pila.
		return sc.pop();
	}
	/**
	 * Comprueba cu�l es el personaje con m�s interacciones del grafo.
	 * 
	 * @return El nombre del personaje con m�s interacciones del grafo.
	 */
	public static String mostInterationableCharacter (Graph<DecoratedElement<String>,Weight<String>> g) {
		// Creo los iteradores correspondientes.
		Iterator<Vertex<DecoratedElement<String>>> itc = g.getVertices();
		Iterator<Edge<Weight<String>>> itr;
		// Contador.
		int counter;
		// Nombre del personaje.
		Vertex<DecoratedElement<String>> character;
		// Pilas para meter al siguiente con m�s relaciones
		Stack<String> sc = new Stack<>();
		Stack<Integer> si = new Stack<>();
		
		// Mientras siga habiendo vertices ...
		while (itc.hasNext()) {
			// ... igualo contador a 0 ...
			counter = 0;
			// ... consigo su nombre ...
			character = itc.next();
			// ... y creo un iterador de sus aristas.
			itr = g.incidentEdges(character);
			// Mientras siga teniendo aristas ...
			while (itr.hasNext()) {
				// ... paso al siguiente ...
				Edge<Weight<String>> ed = itr.next();
				// ... el contador se aumenta en el peso de la interacci�n.
				counter+=ed.getElement().getWeight();
			}
			// Si la pila de pesos esta vac�a ...
			if (si.isEmpty()) {
				// ... introduzco el valor en la pila de pesos y en la de nombres, ...
				si.push(counter);
				sc.push(character.getElement().getElement() );
			// si no, si el �ltimo valor es menor que las aristas contadas ...
			} else if (si.peek() <= counter) {
				// ... introduzco el valor en la pila de pesos y en la de nombres.
				si.push(counter);
				sc.push(character.getElement().getElement());
			}
		}
		// Devuelvo el nombre del �ltimo personaje de la pila.
		return sc.pop();
	}
	/**
	 * Comprueba cu�l es el personaje con menos relaciones del grafo.
	 * 
	 * @return El nombre del personaje con menos relaciones del grafo.
	 */
	public static String mostUnknownCharacter (Graph<DecoratedElement<String>,Weight<String>> g) {
		// Creo los iteradores correspondientes.
		Iterator<Vertex<DecoratedElement<String>>> itc = g.getVertices();
		Iterator<Edge<Weight<String>>> itr;
		// Contador.
		int counter;
		// Nombre del personaje.
		Vertex<DecoratedElement<String>> character;
		// Pilas para meter al siguiente con m�s relaciones
		Stack<String> sc = new Stack<>();
		Stack<Integer> si = new Stack<>();
		
		// Mientras siga habiendo vertices ...
		while (itc.hasNext()) {
			// ... igualo contador a 0 ...
			counter = 0;
			// ... consigo su nombre ...
			character = itc.next();
			// ... y creo un iterador de sus aristas.
			itr = g.incidentEdges(character);
			// Mientras siga teniendo aristas ...
			while (itr.hasNext()) {
				// ... paso al siguiente ...
				itr.next();
				// ... el contador se aumenta en 1.
				++counter;
			}
			// Si la pila de pesos esta vac�a ...
			if (si.isEmpty()) {
				// ... introduzco el valor en la pila de pesos y en la de nombres, ...
				si.push(counter);
				sc.push(character.getElement().getElement());
			// si no, si el �ltimo valor es mayor que las aristas contadas ...
			} else if (si.peek() >= counter) {
				// ... introduzco el valor en la pila de pesos y en la de nombres.
				si.push(counter);
				sc.push(character.getElement().getElement());
			}
		}
		// Devuelvo el nombre del �ltimo personaje de la pila.
		return sc.pop();
	}
	/**
	 * Comprueba cu�l es el personaje con menos interacciones del grafo.
	 * 
	 * @return El nombre del personaje con m�s relaciones del grafo.
	 */
	public static String lessInterationableCharacter (Graph<DecoratedElement<String>,Weight<String>> g) {
		// Creo los iteradores correspondientes.
		Iterator<Vertex<DecoratedElement<String>>> itc = g.getVertices();
		Iterator<Edge<Weight<String>>> itr;
		// Contador.
		int counter;
		// Nombre del personaje.
		Vertex<DecoratedElement<String>> character;
		// Pilas para meter al siguiente con m�s relaciones
		Stack<String> sc = new Stack<>();
		Stack<Integer> si = new Stack<>();
		
		// Mientras siga habiendo vertices ...
		while (itc.hasNext()) {
			// ... igualo contador a 0 ...
			counter = 0;
			// ... consigo su nombre ...
			character = itc.next();
			// ... y creo un iterador de sus aristas.
			itr = g.incidentEdges(character);
			// Mientras siga teniendo aristas ...
			while (itr.hasNext()) {
				// ... paso al siguiente ...
				Edge<Weight<String>> ed = itr.next();
				// ... el contador se aumenta en el peso de la interacci�n.
				counter+=ed.getElement().getWeight();
			}
			// Si la pila de pesos esta vac�a ...
			if (si.isEmpty()) {
				// ... introduzco el valor en la pila de pesos y en la de nombres, ...
				si.push(counter);
				sc.push(character.getElement().getElement());
			// si no, si el �ltimo valor es mayor que las aristas contadas ...
			} else if (si.peek() >= counter) {
				// ... introduzco el valor en la pila de pesos y en la de nombres.
				si.push(counter);
				sc.push(character.getElement().getElement());
			}
		}
		// Devuelvo el nombre del �ltimo personaje de la pila.
		return sc.pop();
	}
	/**
	 * Recorrido de un grafo g de elementos decorados en BFS entre dos v�rtices.
	 * 
	 * @return La distancia que existe entre los dos v�rtices dados.
	 */
	 public static int BFS (Graph<DecoratedElement<String>,Weight<String>> g, Vertex<DecoratedElement<String>> source, Vertex<DecoratedElement<String>> destination) {
		 	Queue<Vertex<DecoratedElement<String>>> q = new LinkedList<>();
		    boolean noEnd = true;
		    Vertex<DecoratedElement<String>> u, v = null;
		    Edge<Weight<String>> e;
		    Iterator<Edge<Weight<String>>> it;

		    source.getElement().setVisited(true);
		    q.offer(source);
		    while (!q.isEmpty() && noEnd) {
		      u = q.poll();
		      it = g.incidentEdges(u);
		      while (it.hasNext() && noEnd) {
		        e = it.next();
		        v = g.opposite(u, e);
		        if (!(v.getElement()).getVisited()) {
		          (v.getElement()).setVisited(true);
		          (v.getElement()).setParent(u.getElement());
		          (v.getElement()).setDistance(((u.getElement()).getDistance()) + 1);
		          q.offer(v);
		          noEnd = !(v.getElement().equals(destination.getElement()));
		        }
		      }
		    }
		    if (noEnd) {
		      v.getElement().setParent(null);
		    }
		    return v.getElement().getDistance();
	 }

}
