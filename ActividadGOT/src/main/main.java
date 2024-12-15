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
 * @author Daniel Díaz García
 * @author Diego Repullo Higueruela
 */
public class main {
	/**
	 * La ruta donde esta el archivo .csv.
	 */
	private final static String PATH = "src/main/stormofswords.csv";

	/**
	 * El metodo principal.
	 *
	 * @param args los argumentos
	 */
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		Graph<DecoratedElement<String>, Weight<String>> g = new TreeMapGraph<>();
		Scanner input = new Scanner(System.in);
		int opt;
		// Construimos el grafo.
		constructGraph(g);
		System.out.println("Game of Thrones - Relations\n---------------------------");
		// Enseñamos el número de personajes y el número de relaciones.
		System.out.println("Número de personajes: " + g.getN() + "\nNúmero de relaciones: " + g.getM());
		System.out.println("---------------------------");
		// Enseñar el personaje más conocido.
		System.out.println("Personajes más conocido: " + mostKnownCharacter(g));
		// Enseñar el personaje con más interacciones.
		System.out.println("Personajes con más interacciones: " + mostInterationableCharacter(g));
		System.out.println("---------------------------");
		// Enseñar el personaje menos conocido.
		System.out.println("Personaje más desconocido: " + mostUnknownCharacter(g));
		// Enseñar el personaje con menos interacciones.
		System.out.println("Personaje con menos interacciones: " + lessInterationableCharacter(g));
		System.out.println("---------------------------");
		System.out.println("1. Camino más corto entre dos personajes.");
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
			s = g.getVertex(source.hashCode() + "");
			d = g.getVertex(destination.hashCode() + "");
			int d1 = BFS(g, s, d);
			System.out.println("Existen entre " + source + " y " + destination + " una distancia de " + d1 + ".");
			break;
		case 2:
			String source1, destination1;
			Vertex<DecoratedElement<String>> s1, d2;
			input.nextLine();
			System.out.println("Elige un personaje de inicio: ");
			source1 = input.nextLine();
			System.out.println("Elige un personaje de destino: ");
			destination1 = input.nextLine();
			s1 = g.getVertex(source1.hashCode() + "");
			d2 = g.getVertex(destination1.hashCode() + "");
			boolean ctr = DFS(g, s1, d2, stack);
			if (!ctr) {
				System.out.println(stack);
				System.out.println("Camino no encontrado.");
			} else {
				while (!stack.isEmpty()) {
					if (stack.size()>1) {
						System.out.print(stack.pop() + " -- ");
					} else {
						System.out.println(stack.pop());
					}
					
				}
			}
			break;
		default:
			System.out.println("ERR: Opci�n no v�lida.");
		}
		input.close();

	}

	/**
	 * Construye un grafo de Nodos tipo cadena y aristas con tipo entero a través
	 * de un archivo csv.
	 * 
	 * @param g El grafo vac�o
	 */
	public static void constructGraph(Graph<DecoratedElement<String>, Weight<String>> g) {
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
			while ((line = bf.readLine()) != null) {
				// ... tokenizo el contenido de la línea.
				StringTokenizer tokens = new StringTokenizer(line, ",");
				// Mientras el tokenizador tenga más tokens ...
				while (tokens.hasMoreTokens()) {
					// ... guardo los tokens en distintas variables.
					// v1 es el primer nombre de la línea.
					String e1 = tokens.nextToken();
					DecoratedElement<String> v1 = new DecoratedElement<String>(e1.hashCode() + "", e1);
					// v2 es el segundo nombre de la línea.
					String e2 = tokens.nextToken();
					DecoratedElement<String> v2 = new DecoratedElement<String>(e2.hashCode() + "", e2);
					// p es el peso de la relación entre los personajes.
					Weight<String> p = new Weight<String>(v1, v2, Integer.parseInt(tokens.nextToken()));
					// Si v1 no existe ...
					if (g.getVertex(v1.getElement()) == null) {
						// ... inserto el nodo v1 en el grafo.
						g.insertVertex(v1);
					}
					// Si v2 no existe ...
					if (g.getVertex(v2.getElement()) == null) {
						// inserto el nodo v2 en el grafo.
						g.insertVertex(v2);
					}
					// Por último, inserto la arista de unión entre los vértices.
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
	 * @param g El grafo
	 * @return Pila con los nombres de los personajes m�s conocidos.
	 */
	public static Stack<String> mostKnownCharacter(Graph<DecoratedElement<String>, Weight<String>> g) {
		// Creo los iteradores correspondientes.
		Iterator<Vertex<DecoratedElement<String>>> itc = g.getVertices();
		Iterator<Edge<Weight<String>>> itr;
		// Contador.
		int counter;
		// Nombre del personaje.
		Vertex<DecoratedElement<String>> character;
		// Pilas para meter al siguiente con más relaciones
		Stack<String> sc = new Stack<>();
		int max = 0;

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
			// Si la pila de pesos esta vacía ...
			if (counter > max) {
				// ... introduzco el valor en la pila de pesos y en la de nombres, ...
				max = counter;
				while (!sc.isEmpty()) {
					sc.pop();
				}
				sc.push(character.getElement().getElement());
				// si no, si el último valor es menor que las aristas contadas ...
			} else if (counter == max) {
				// ... introduzco el valor en la pila de pesos y en la de nombres.
				sc.push(character.getElement().getElement());
			}
		}
		// Devuelvo el nombre del último personaje de la pila.
		return sc;
	}

	/**
	 * Comprueba cu�l es el personaje con m�s interacciones del grafo.
	 * 
	 * @param g El grafo
	 * @return Pila con los nombres de los personajes m�s interaccionados
	 */
	public static Stack<String> mostInterationableCharacter(Graph<DecoratedElement<String>, Weight<String>> g) {
		// Creo los iteradores correspondientes.
		Iterator<Vertex<DecoratedElement<String>>> itc = g.getVertices();
		Iterator<Edge<Weight<String>>> itr;
		// Contador.
		int counter;
		// Nombre del personaje.
		Vertex<DecoratedElement<String>> character;
		// Pilas para meter al siguiente con más relaciones
		Stack<String> sc = new Stack<>();
		int max = 0;

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
				// ... el contador se aumenta en el peso de la interacción.
				counter += ed.getElement().getWeight();
			}
			// Si la pila de pesos esta vacía ...
			if (counter > max) {
				// ... introduzco el valor en la pila de pesos y en la de nombres, ...
				max = counter;
				while (!sc.isEmpty()) {
					sc.pop();
				}
				sc.push(character.getElement().getElement());
				// si no, si el último valor es menor que las aristas contadas ...
			} else if (counter == max) {
				// ... introduzco el valor en la pila de pesos y en la de nombres.
				sc.push(character.getElement().getElement());
			}
		}
		// Devuelvo el nombre del último personaje de la pila.
		return sc;
	}

	/**
	 * Comprueba cu�l es el personaje con menos relaciones del grafo.
	 * 
	 * @param g El grafo
	 * @return Pila con los personajes menos conocidos.
	 */
	public static Stack<String> mostUnknownCharacter(Graph<DecoratedElement<String>, Weight<String>> g) {
		// Creo los iteradores correspondientes.
		Iterator<Vertex<DecoratedElement<String>>> itc = g.getVertices();
		Iterator<Edge<Weight<String>>> itr;
		// Contador.
		int counter;
		// Nombre del personaje.
		Vertex<DecoratedElement<String>> character;
		// Pilas para meter al siguiente con más relaciones
		Stack<String> sc = new Stack<>();
		int min = 0;

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
			// Si la pila de pesos esta vacía ...
			if (counter < min || min == 0) {
				// ... introduzco el valor en la pila de pesos y en la de nombres, ...
				min = counter;
				while (!sc.isEmpty()) {
					sc.pop();
				}
				sc.push(character.getElement().getElement());
				// si no, si el último valor es mayor que las aristas contadas ...
			} else if (counter == min) {
				// ... introduzco el valor en la pila de pesos y en la de nombres.
				sc.push(character.getElement().getElement());
			}
		}
		// Devuelvo el nombre del último personaje de la pila.
		return sc;
	}

	/**
	 * Comprueba cu�l es el personaje con menos interacciones del grafo.
	 * 
	 * @param g El grafo
	 * @return Pila con los nombres de los personajes con menos interacciones.
	 */
	public static Stack<String> lessInterationableCharacter(Graph<DecoratedElement<String>, Weight<String>> g) {
		// Creo los iteradores correspondientes.
		Iterator<Vertex<DecoratedElement<String>>> itc = g.getVertices();
		Iterator<Edge<Weight<String>>> itr;
		// Contador.
		int counter;
		// Nombre del personaje.
		Vertex<DecoratedElement<String>> character;
		// Pilas para meter al siguiente con más relaciones
		Stack<String> sc = new Stack<>();
		int min = 0;

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
				// ... el contador se aumenta en el peso de la interacción.
				counter += ed.getElement().getWeight();
			}
			// Si la pila de pesos esta vacía ...
			if (counter < min || min == 0) {
				// ... introduzco el valor en la pila de pesos y en la de nombres, ...
				min = counter;
				while (!sc.isEmpty()) {
					sc.pop();
				}
				sc.push(character.getElement().getElement());
				// si no, si el último valor es mayor que las aristas contadas ...
			} else if (counter == min) {
				// ... introduzco el valor en la pila de pesos y en la de nombres.
				sc.push(character.getElement().getElement());
			}
		}
		// Devuelvo el nombre del último personaje de la pila.
		return sc;
	}

	/**
	 * Recorrido de un grafo g de elementos decorados en BFS entre dos vértices.
	 * 
	 * @param g           El grafo
	 * @param source      El personaje de empiece
	 * @param destination El personaje de destino
	 * @return La distancia que existe entre los dos v�rtices dados.
	 */
	public static int BFS(Graph<DecoratedElement<String>, Weight<String>> g, Vertex<DecoratedElement<String>> source,
			Vertex<DecoratedElement<String>> destination) {
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

	/**
	 * M�todo que recorre en DFS el grafo para saber la secuencia de personajes que
	 * unen dos personajes dados. Devuelve un valor booleano para en el backtracking
	 * saber si es el camino correcto.
	 * 
	 * @param g           El grafo
	 * @param source      El personaje de empiece
	 * @param destination El personaje de destino
	 * @return Si encuentra el personaje de destino devuelve true, si no false
	 */
	public static boolean DFS(Graph<DecoratedElement<String>, Weight<String>> g,
			Vertex<DecoratedElement<String>> source, Vertex<DecoratedElement<String>> destination, Stack<String> s) {
		Vertex<DecoratedElement<String>> u = null;
		Edge<Weight<String>> e = null;
		// Previsit
		boolean found = false;
		if (source.getElement().equals(destination.getElement())) {
			s.push(source.getElement().getElement());
			return true;
		}

		source.getElement().setVisited(true);

		e = greatherEdge(source, g);
		u = g.opposite(source, e);
		if (!u.getElement().getVisited()) {
			u.getElement().setParent(source.getElement());
			found = DFS(g, u, destination, s);
		}

		// Postvisit
		if (found) {
			s.push(source.getElement().getElement());
			return true;
		} else {
			return false;
		}

	}

	/**
	 * M�todo que devuelve arista de mayor peso .
	 *
	 * @param v El vertice
	 * @param g El grafo
	 * @return Arista de mayor peso de un vertice
	 */
	public static Edge<Weight<String>> greatherEdge(Vertex<DecoratedElement<String>> v,
			Graph<DecoratedElement<String>, Weight<String>> g) {
		Iterator<Edge<Weight<String>>> iEdge = g.incidentEdges(v);
		Edge<Weight<String>> edge;
		Edge<Weight<String>> r = null;
		while (iEdge.hasNext()) {
			edge = iEdge.next();
			if (r == null) {
				r = edge;
			} else if (edge.getElement().getWeight() > r.getElement().getWeight() && !g.opposite(v, edge).getElement().getVisited()) {
				r = edge;
			}
		}
		return r;
	}
}
