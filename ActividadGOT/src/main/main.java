package main;

import java.io.BufferedReader;
import graphsDSESIUCLM.Graph;
import graphsDSESIUCLM.TreeMapGraph;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * La Clase principal.
 */
public class main {

	/**
	 * El metodo principal.
	 *
	 * @param args los argumentos
	 */
	private final static String PATH = "src/stormofswords.csv";
	public static void main(String[] args) {
		
	}
	
	/**
	 * Construye un grafo de Nodos tipo cadena y aristas con tipo entero a trav�s de un archivo csv. 
	 *
	 * @param g El grafo vac�o
	 */
	public static void constructGraph(Graph<String,Integer> g){
	    BufferedReader bf = null;
	    try {
	        bf = new BufferedReader(new FileReader(PATH));
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    }
	    String line = null;
	    try {
	    	// Mientras el archivo tenga lineas ...
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
	        		String p = tokens.nextToken();
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
	        		g.insertEdge(g.getVertex(v1), g.getVertex(v2), Integer.parseInt(p));
	        	}
	        }
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
}
