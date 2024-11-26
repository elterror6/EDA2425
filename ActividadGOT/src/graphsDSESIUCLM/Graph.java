
package graphsDSESIUCLM;

import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

/**
 * This interface defines the functionality of an undirected graph where
 * elements can be stored in vertices and edges.
 *
 * @author Alfonso Niño
 * @author Camelia Muñoz-Caro
 * @author Crescencio Bravo
 * @version November 2014
 *
 */

public interface Graph<V, E> {
/**
 * Inserts a vertex with element e in the graph
 * @param e
 * @return The vertex inserted
 */
  public Vertex<V> insertVertex(V e);

  /**
   * Inserts an edge in the graph defined by vertex u and v. If one of the
   * nodes used to define the edge
   * does not exist in the graph it is created and inserted.
   * @param u First node defining the edge
   * @param v Second node defining the edge
   * @return The edge created
   */
  public Edge<E> insertEdge (Vertex<V> u, Vertex<V> v);


  /**
   * Inserts an edge in the graph, defined by elements u and v. If
   * one of the nodes used to define the edge
   * does not exist in the graph it is created and inserted.
   * @param u Element defining the first node used to define the edge
   * @param v Element defining the second node used to define the edge
   * @return The edge created
   */
  public Edge<E> insertEdge (Element u, Element v);

  /**
   * Inserts an edge in the graph, defined by vertex u and v and
   * storing element e. If the graph already contains an edge with the key
   * corresponding to the element e no new edge is added. If no edge stores an
   * element with the same key than e, a new adge is created and added. If
   * one of the nodes used to define the edge
   * does not exist in the graph it is created and inserted.
   * @param u First node defining the edge
   * @param v Second node defining the edge
   * @param e The element to store in the edge
   * @return The edge created
   */
  public Edge<E> insertEdge (Vertex<V> u, Vertex<V> v, E e);

  /**
   * Inserts an edge in the graph, defined by elements u and v (for the
   * vertices) and  storing element e (in the edge). If the graph already
   * contains an edge with the key
   * corresponding to the element e no new edge is added. If no edge stores an
   * element with the same key than e, a new adge is created and added. If
   * one of the nodes used to define the edge
   * does not exist in the graph it is created and inserted.
   * @param u Element defining the first node used to define the edge
   * @param v Element defining the second node used to define the edge
   * @param e The element to store in the edge
   * @return The edge created
   */
  public Edge<E> insertEdge (Element u, Element v, E e);

  /**
   * Returns an array with the two end vertices of an edge
   * @param edge The edge whose vertices we want
   * @return An arry with the two end vertices
   */
  public Vertex<V>[] endVertices (Edge<E> edge);

  /**
   * Provides the vertex opposite to one provided on the edge given. If the
   * vertex used as parameter does not belong to the edge a null value is
   * returned
   * @param v     The node whose opposite we want
   * @param edge  The edge used to obtain the opossite
   * @return      The vertex opposite to the one used as parameter on the given
   *              edge or null if the node v does not belong to the edge
   */
  public Vertex<V>  opposite(Vertex<V> v, Edge<E> edge);

  /**
   * Determines if two vertices are adjacent
   * @param u The first vertex used
   * @param v The second vertex used
   * @return True if u and v are adjacent, false otherwise
   */
  public boolean areAdjacent(Vertex<V> u, Vertex<V> v);

  /**
   * Replaces the element contained in the vertex v by the new element e if the
   * key of the vertex and the element are the same.
   * @param v  The vertex to work with
   * @param e  The new element to store in v
   * @return   The updated vertex or null if v does not belong to the graph
   */
  public Vertex<V> replaceVertex (Vertex<V> v, V e);

  /**
   * Replaces the element contained in the edge edge by the new element e if the
   * key of the edge and the element are the same.
   * @param edge  The edge to work with
   * @param e     The new element to store in edge
   * @return      The updated edge or null if edge does not belong to the graph
   */
  public Edge<E> replaceEdge (Edge<E> edge, E e);

  /**
   * Removes vertex v and all its edges from the graph
   * @param v The vertex to remove
   * @return  The removed vertex or null if the vertex does not belong to the
   *          graph
   */
  public Vertex<V> removeVertex (Vertex<V> v);

  /**
   * Removes and edge from the graph
   * @param edge The edge to remove
   * @return  The removed edge or null if the edge does not belong to the
   *          graph
   */
  public Edge<E> removeEdge (Edge<E> edge);

  /**
   * Removes and edge given throug its ID from the graph
   * @param id The ID of the edge to remove
   * @return  The removed edge or null if the edge does not belong to the
   *          graph
   */
  public Edge<E> removeEdge (String id);

  /**
   * Returns an iterator to the edges incident on vertex v
   * @param v  The vertex whose incident edges we want
   * @return   An iterator to the edges incident on vertex v
   */
  public Iterator<Edge<E>> incidentEdges(Vertex<V> v);

  /**
   * Returns an iterator to the vertices of the graph
   * @return An iterator to the vertices of the graph
   */
  public Iterator<Vertex<V>> getVertices();

  /**
   * Returns an iterator to the edges of the graph
   * @return An iterator to the edges of the graph
   */
  public Iterator<Edge<E>> getEdges();

  /**
   * Determines if a vertex exists in the graph. The vertex is identified by its
   * ID.
   * @param v The vertex to check.
   * @return True if the vertex already exists in the grapg, false otherwise.
   */
  public boolean exists(Vertex<V> v);

  /**
   * Determines if an edge exists in the graph. The edge is identified by its
   * ID.
   * @param e The edge to check.
   * @return True if the edge already exists in the grapg, false otherwise.
   */
  public boolean exists(Edge<E> e);

  /**
   * Returns the vertex with the provided ID.
   * @param id The ID of the vertex.
   * @return The vertex with that ID or null if it does not exist in the graph.
   */
  public Vertex<V> getVertex(String id);

  /**
   * Returns the edge with the provided ID.
   * @param id The ID of the edge.
   * @return The edge with that ID or null if it does not exist in the graph.
   */
  public Edge<E> getEdge(String id);

  /**
   * Returns the number of vertices in the graph.
   * @return The number of vertices in the graph.
   */
  public int getN();

  /**
   * Returns the number of edges in the graph.
   * @return The number of edges in the graph.
   */
  public int getM();

}
