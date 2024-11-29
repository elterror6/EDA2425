package main;

import java.io.BufferedReader;
import graphsDSESIUCLM.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import Classes.Weight;

import java.util.Iterator;
import java.util.Stack;

/**
 * La Clase principal.
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
		Graph<String,Weight> g = new TreeMapGraph();
		// Construimos el grafo.
		constructGraph(g);
		System.out.println("Game of Thrones - Relations\n---------------------------");
		// Enseñamos el número de personajes y el número de relaciones.
		System.out.println("Número de personajes: "+g.getN()+"\nNúmero de relaciones: "+g.getM());
		// Enseñar el personaje más conocido.
		System.out.println("Personaje más conocido: "+mostKnownCharacter(g));
		// Enseñar el personaje con más interacciones.
		System.out.println("Personaje con más interacciones: "+mostInterationableCharacter(g));
	}
	
	/**
	 * Construye un grafo de Nodos tipo cadena y aristas con tipo entero a través de un archivo csv. 
	 *
	 * @param g El grafo vacío
	 */
	public static void constructGraph(Graph<String,Weight> g){
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
	        	// ... tokenizo el contenido de la línea.
	        	StringTokenizer tokens = new StringTokenizer(line, ",");
	        	// Mientras el tokenizador tenga más tokens ...
	        	while(tokens.hasMoreTokens()){
	        		// ... guardo los tokens en distintas variables.
	        		// v1 es el primer nombre de la línea.
	        		String v1 = tokens.nextToken();
	        		// v2 es el segundo nombre de la línea.
	        		String v2 = tokens.nextToken();
	        		// p es el peso de la relación entre los personajes.
	        		Weight p = new Weight(v1,v2,Integer.parseInt(tokens.nextToken()));
	        		// Si v1 no existe ...
	        		if (g.getVertex(v1)==null) {
	        			// ... inserto el nodo v1 en el grafo.
	        			g.insertVertex(v1);
	        		}
	        		// Si v2 no existe ...
	        		if (g.getVertex(v2)==null) {
	        			// inserto el nodo v2 en el grafo.
	        			g.insertVertex(v2);
	        		}
	        		// Por último, inserto la arista de unión entre los vértices.
	        		g.insertEdge(g.getVertex(v1), g.getVertex(v2), p);
	        	}
	        }
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	/**
	 * Mira cuál es el personaje con más relaciones del grafo.
	 * 
	 * @return El nombre del personaje con más relaciones del grafo.
	 */
	public static String mostKnownCharacter(Graph<String,Weight> g) {
		// Creo los iteradores correspondientes.
		Iterator<Vertex<String>> itc = g.getVertices();
		Iterator<Edge<Weight>> itr;
		// Contador.
		int counter;
		// Nombre del personaje.
		Vertex<String> character;
		// Pilas para meter al siguiente con más relaciones
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
			// Si la pila de pesos esta vacía ...
			if (si.isEmpty()) {
				// ... introduzco el valor en la pila de pesos y en la de nombres, ...
				si.push(counter);
				sc.push(character.getElement());
			// si no, si el último valor es menor que las aristas contadas ...
			} else if (si.peek() <= counter) {
				// ... introduzco el valor en la pila de pesos y en la de nombres.
				si.push(counter);
				sc.push(character.getElement());
			}
		}
		// Devuelvo el nombre del último personaje de la pila.
		return sc.pop();
	}
	public static String mostInterationableCharacter (Graph<String,Weight> g) {
		// Creo los iteradores correspondientes.
		Iterator<Vertex<String>> itc = g.getVertices();
		Iterator<Edge<Weight>> itr;
		// Contador.
		int counter;
		// Nombre del personaje.
		Vertex<String> character;
		// Pilas para meter al siguiente con más relaciones
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
				Edge<Weight> ed = itr.next();
				// ... el contador se aumenta en 1.
				counter+=ed.getElement().getWeight();
			}
			// Si la pila de pesos esta vacía ...
			if (si.isEmpty()) {
				// ... introduzco el valor en la pila de pesos y en la de nombres, ...
				si.push(counter);
				sc.push(character.getElement());
			// si no, si el último valor es menor que las aristas contadas ...
			} else if (si.peek() <= counter) {
				// ... introduzco el valor en la pila de pesos y en la de nombres.
				si.push(counter);
				sc.push(character.getElement());
			}
		}
		// Devuelvo el nombre del último personaje de la pila.
		return sc.pop();
	}
}
