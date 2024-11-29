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
		// Ense�amos el n�mero de personajes y el n�mero de relaciones.
		System.out.println("N�mero de personajes: "+g.getN()+"\nN�mero de relaciones: "+g.getM());
		// Ense�ar el personaje m�s conocido.
		System.out.println("Personaje m�s conocido: "+mostKnownCharacter(g));
		// Ense�ar el personaje con m�s interacciones.
		System.out.println("Personaje con m�s interacciones: "+mostInterationableCharacter(g));
	}
	
	/**
	 * Construye un grafo de Nodos tipo cadena y aristas con tipo entero a trav�s de un archivo csv. 
	 *
	 * @param g El grafo vac�o
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
	        	// ... tokenizo el contenido de la l�nea.
	        	StringTokenizer tokens = new StringTokenizer(line, ",");
	        	// Mientras el tokenizador tenga m�s tokens ...
	        	while(tokens.hasMoreTokens()){
	        		// ... guardo los tokens en distintas variables.
	        		// v1 es el primer nombre de la l�nea.
	        		String v1 = tokens.nextToken();
	        		// v2 es el segundo nombre de la l�nea.
	        		String v2 = tokens.nextToken();
	        		// p es el peso de la relaci�n entre los personajes.
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
	        		// Por �ltimo, inserto la arista de uni�n entre los v�rtices.
	        		g.insertEdge(g.getVertex(v1), g.getVertex(v2), p);
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
	public static String mostKnownCharacter(Graph<String,Weight> g) {
		// Creo los iteradores correspondientes.
		Iterator<Vertex<String>> itc = g.getVertices();
		Iterator<Edge<Weight>> itr;
		// Contador.
		int counter;
		// Nombre del personaje.
		Vertex<String> character;
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
				sc.push(character.getElement());
			// si no, si el �ltimo valor es menor que las aristas contadas ...
			} else if (si.peek() <= counter) {
				// ... introduzco el valor en la pila de pesos y en la de nombres.
				si.push(counter);
				sc.push(character.getElement());
			}
		}
		// Devuelvo el nombre del �ltimo personaje de la pila.
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
				Edge<Weight> ed = itr.next();
				// ... el contador se aumenta en 1.
				counter+=ed.getElement().getWeight();
			}
			// Si la pila de pesos esta vac�a ...
			if (si.isEmpty()) {
				// ... introduzco el valor en la pila de pesos y en la de nombres, ...
				si.push(counter);
				sc.push(character.getElement());
			// si no, si el �ltimo valor es menor que las aristas contadas ...
			} else if (si.peek() <= counter) {
				// ... introduzco el valor en la pila de pesos y en la de nombres.
				si.push(counter);
				sc.push(character.getElement());
			}
		}
		// Devuelvo el nombre del �ltimo personaje de la pila.
		return sc.pop();
	}
}
