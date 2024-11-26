
package graphsDSESIUCLM;

import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

/**
 * This class implements the interface Graph. Associative containers in the form
 * of treeMaps are used to represent the set of vertices and edges. Therefore,
 * locating or deleting edges and nodes are guarenteed to be done in
 * logarithmic time.
 *
 * @author Alfonso Niño
 * @author Camelia Muñoz-Caro
 * @author Crescencio Bravo
 * @version November 2014
 *
 */
public class TreeMapGraph<V, E> implements Graph<V, E> {

  /**
   * vertices is an associative container containing the vertices/nodes of the
   * graph.
   */
  private TreeMap<String, Vertex<V>> vertices;

  /**
   * edges is an associative container containing the edges of the graph.
   */
  private TreeMap<String, Edge<E>> edges;


  /**
   * Constructor. An empty graph is created.
   */
  public TreeMapGraph(){
    vertices = new TreeMap();
    edges    = new TreeMap();
  }

  /**
   * This method inserts a vertex in the graph storing element e. If the graph
   * already contains a vertex with the ID corresponding to the element e no
   * new vertex is added. If no vertex stores an element with the same ID than
   * e, a new vertex is created and added.
   * @param e The element to store in the vertex.
   * @return The vertex stored in the graph that contains element e.
   */
  @Override
  public Vertex<V> insertVertex(V e){
    InVertex<V> v = new InVertex(e);
    Vertex<V> n;
    n = vertices.get(v.getID());
    if (n == null){
      vertices.put(v.getID(), v);
      n = v;
    }
    return n;
  }

  /**
   * This method inserts an edge in the graph, defined by vertex u and v and
   * storing element e. If the graph already contains an edge with the ID
   * corresponding to the element e no new edge is added. If no edge stores an
   * element with the same ID than e, a new edge is created and added.
   *
   * <P>This method allows to add multiple edges between two vertices by using a
   * different ID for each one.
   *
   * @param u The first node defining the edge
   * @param v The second node defining the edge
   * @param e The element stored in the edge
   * @return The edge stored in the graph that contains element e
   */
  @Override
  public Edge<E> insertEdge (Vertex<V> u, Vertex<V> v, E e){
    Edge<E> aux, ed;
    Vertex<V> n1, n2;

    n1 = vertices.get(u.getID());
    if (n1 == null) {
      vertices.put(u.getID(), u);
      n1 = u;
    }
    n2 = vertices.get(v.getID());
    if (n2 == null){
      vertices.put(v.getID(), v);
      n2 = v;
    }
    aux = new InEdge(n1, n2, e);

    // Looking for the same edge
    ed = edges.get(((InEdge)aux).getID());

    if (ed == null){
      edges.put(((InEdge)aux).getID(), aux);
      ed = aux;
      ((InVertex)n1).addEdge(ed);
      ((InVertex)n2).addEdge(ed);
    }
    return ed;
  }

  /**
   * Inserts an edge in the graph, defined by elements u and v (for the
   * vertices) and  storing e in the edge. If the graph already
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
  public Edge<E> insertEdge (Element u, Element v, E e){
    Vertex<V> ue = new InVertex(u);
    Vertex<V> ve = new InVertex(v);
    return insertEdge(ue, ve, e);
  }

  /**
   * This method inserts an edge in the graph defined by vertex u and v. The ID
   * of the new edge is a string obtained as: u.getID()+"-"+v.getID() + an
   * unique integer labeling that edge.
   *
   * <P> Notice that multiple edges between two nodes can be added in this
   * way since all the edges would have different ID.
   *
   * @param u The first node defining the edge
   * @param v The second node defining the edge
   * @return The edge stored in the graph
   */
  @Override
  public Edge<E> insertEdge (Vertex<V> u, Vertex<V> v){
    Edge<E> aux, ed;
    Vertex<V> n1, n2;

    n1 = vertices.get(u.getID());
    if (n1 == null){
      vertices.put(u.getID(), u);
      n1 = u;
    }
    n2 = vertices.get(v.getID());
    if (n2 == null) {
      vertices.put(v.getID(), v);
      n2 = v;
    }
    aux = new InEdge(n1, n2);

    // Now, we do not look if an edge with the same ID that aux is in the graph
    // because each time a new edge is created without providing a specific
    // element with its own ID (as in the previous method:
    // insertEdge (Vertex<V> u, Vertex<V> v, E ) the new edge has a new ID
    // different from the all the other
    ed = edges.get(((InEdge)aux).getID());
    edges.put(((InEdge)aux).getID(), aux);
    ed = aux;
    ((InVertex)n1).addEdge(ed);
    ((InVertex)n2).addEdge(ed);

    return ed;
  }

  /**
   * Inserts an edge in the graph, defined by elements u and v. If
   * one of the nodes used to define the edge
   * does not exist in the graph it is created and inserted.
   * @param u Element defining the first node used to define the edge
   * @param v Element defining the second node used to define the edge
   * @return The edge created
   */
  @Override
  public Edge<E> insertEdge (Element u, Element v){
    Vertex<V> ue = new InVertex(u);
    Vertex<V> ve = new InVertex(v);
    return insertEdge(ue, ve);
  }


  /**
   * Returns an array with the two end vertices of an edge
   * @param edge The edge whose vertices we want
   * @return An array with the two end vertices
   */
  @Override
  public Vertex<V>[] endVertices (Edge<E> edge){
    return ((InEdge)edge).getEndVertices();
  }


  /**
   * Provides the vertex opposite to one provided on the given edge. If the
   * vertex used as parameter does not belong to the edge a null value is
   * returned
   * @param v     The node whose opposite we want
   * @param edge  The edge used to obtain the opossite
   * @return      The vertex opposite to the one used as parameter on the given
   *              edge or null if the node v does not belong to the edge
   */
  @Override
  public Vertex<V>  opposite(Vertex<V> v, Edge<E> edge){
    return ((InEdge)edge).opposite(v);
  }


  /**
   * Determines if two vertices are adjacent
   * @param u The first vertex used
   * @param v The second vertex used
   * @return True if u and v are adjacent, false otherwise
   */
  @Override
  public boolean areAdjacent(Vertex<V> u, Vertex<V> v){
    boolean adj = false;
    Edge<E> e;
    Iterator<Edge<E>> it = ((InVertex)u).iteratorEdges();
    while (it.hasNext() && !adj){
      e = it.next();
      if (v.getID().equals(((InEdge)e).opposite(u).getID())) {
        adj = true;
      }
    }
    return adj;
  }


  /**
   * Replaces the element contained in the vertex v by the new element e if the
   * ID of the vertex and the element are the same.
   * @param v  The vertex to work with
   * @param e  The new element to store in v
   * @return   The updated vertex or null if v does not belong to the graph
   */
  @Override
  public Vertex<V> replaceVertex (Vertex<V> v, V e){
    String ID = "x&L82%iA"; //Very unlikely ID

    //Determining key
    if (e instanceof Element) {
      ID = ((Element)e).getID();
    } else  if (e instanceof Integer || e instanceof Long ||
                e instanceof Short   || e instanceof Float||
			          e instanceof Double) {
      ID = ID.valueOf(e);
    } else if (e instanceof String) {
      ID = (String) e;
    }

    //Searching the vertex with that ID (null if the ID does not exist))
    v = vertices.get(v.getID());
    if (v != null) {
      ((InVertex)v).setElement(e);
    }
    return v;
  }


  /**
   * Replaces the element contained in the edge edge by the new element e if the
   * ID of the edge and the element are the same.
   * @param edge  The edge to work with
   * @param e     The new element to store in edge
   * @return      The updated edge or null if edge does not belong to the graph
   */
  @Override
  public Edge<E> replaceEdge (Edge<E> edge, E e){
    String ID = "x&L82%iA"; //Very unlikely ID

    //Determining key
    if (e instanceof Element) {
      ID = ((Element)e).getID();
    } else  if (e instanceof Integer || e instanceof Long ||
                e instanceof Short   || e instanceof Float||
		            e instanceof Double) {
      ID = ID.valueOf(e);
    } else if (e instanceof String) {
      ID = (String) e;
    }

    edge = edges.get(edge.getID());
    if (edge != null){
      ((InEdge)edge).setElement(e);
    }
    return edge;
  }


  /**
   * Removes vertex v and all its edges from the graph
   * @param v The vertex to remove
   * @return  The removed vertex or null if the vertex does not belong to the
   *          graph
   */
  @Override
  public Vertex<V> removeVertex(Vertex<V> v) {
    v = vertices.get(v.getID());
    if (v != null) {
      Iterator<Edge<E>> it = ((InVertex)v).iteratorEdges();
      while(it.hasNext()){
        edges.remove(it.next().getID());
      }
      vertices.remove(v.getID());
    }
    return v;
  }


  /**
   * Removes and edge from the graph
   * @param edge The edge to remove
   * @return  The removed edge or null if the edge does not belong to the
   *          graph
   */
  @Override
  public Edge<E> removeEdge (Edge<E> edge){
    //Searching for the edge in the graph (not strictly necessary)
    edge = edges.get(edge.getID());

    if (edge != null) {
      //Erasing edge from its end vertices
      Vertex<V>[] v = ((InEdge)edge).getEndVertices();
      ((InVertex)v[0]).eraseEdge(edge);
      ((InVertex)v[1]).eraseEdge(edge);
      // Erasing edge from edge list
      edges.remove(edge.getID());
    }
    return edge;
  }

  /**
   * Removes and edge given through its ID from the graph
   * @param id The ID of the edge to remove
   * @return  The removed edge or null if the edge does not belong to the
   *          graph
   */
  @Override
  public Edge<E> removeEdge (String id){
    Edge <E> edge = edges.get(id);
    if (edge != null) {
      //Erasing edge from its end vertices
      Vertex<V>[] v = ((InEdge)edge).getEndVertices();
      ((InVertex)v[0]).eraseEdge(edge);
      ((InVertex)v[1]).eraseEdge(edge);
      // Erasing edge from edge list
      edges.remove(edge.getID());
    }
    return edge;
  }

  /**
   * Returns an iterator to the edges incident on vertex v
   * @param v  The vertex whose incident edges we want
   * @return   An iterator to the edges incident on vertex v
   */
  @Override
  public Iterator<Edge<E>> incidentEdges(Vertex<V> v){
    return ((InVertex)v).iteratorEdges();
  }


  /**
   * Returns an iterator to the vertices of the graph
   * @return An iterator to the vertices of the graph
   */
  @Override
  public Iterator<Vertex<V>> getVertices(){
    return vertices.values().iterator();
  }

  /**
   * Returns an iterator to the edges of the graph
   * @return An iterator to the edges of the graph
   */
  @Override
  public Iterator<Edge<E>> getEdges(){
    return edges.values().iterator();
  }

  /**
   * Determines if a vertex exists in the graph. The vertex is identified by its
   * ID.
   * @param v The vertex to check.
   * @return True if the vertex already exists in the grapg, false otherwise.
   */
  @Override
  public boolean exists(Vertex<V> v){
    return vertices.containsKey(v.getID());
  }

  /**
   * Determines if an edge exists in the graph. The edge is identified by its
   * ID.
   * @param e The edge to check.
   * @return True if the edge already exists in the grapg, false otherwise.
   */
  @Override
  public boolean exists(Edge<E> e){
    return edges.containsKey(e.getID());
  }

  /**
   * Returns the vertex with the provided ID.
   * @param id The ID of the vertex.
   * @return The vertex with that ID or null if it does not exist in the graph.
   */
  public Vertex<V> getVertex(String id){
    return vertices.get(id);
  }

  /**
   * Returns the edge with the provided ID.
   * @param id The ID of the edge.
   * @return The edge with that ID or null if it does not exist in the graph.
   */
  public Edge<E> getEdge(String id){
    return edges.get(id);
  }

  /**
   * Returns the number of vertices in the graph.
   * @return The number of vertices in the graph.
   */
  @Override
  public int getN(){
    return vertices.size();
  }

  /**
   * Returns the number of edges in the graph.
   * @return The number of edges in the graph.
   */
  @Override
  public int getM(){
    return edges.size();
  }



  //*********************** INNER CLASSES **************************************

  /**
   * This is an inner class representing a node/vertex in the present graph. The
   * generic type V must implement the interface Element
   * @param <V> The type of elements stored in the node
   */

  public class InVertex<V> implements Vertex<V> {
    /**
     * A string is used as an ID to identify the node/vertex.
     */
    private String ID;

    /**
     * The element to store in this node/vertex.
     */
    private V element;

    /**
     * The adjacency list is represented by a list.
     */
    private List<Edge<E>> adjList;


    /**
     * Constructor. The ID is taken or generated from the element.
     * @param e    Element/ID of the node/vertex.
     */
    public InVertex (V e){
      //Determining ID and element
      if (e instanceof Element) {
        ID = ((Element)e).getID();
      } else  if (e instanceof Integer || e instanceof Long ||
                  e instanceof Short) {
        ID = ID.valueOf(e);
      } else if (e instanceof String) {
        ID = (String) e;
      }

      element = e;
      adjList = new LinkedList();
    }


    /**
     * This method returns the ID of the node/vertex.
     * @return The string defining the ID.
     */
    @Override
    public String getID() {
      return ID;
    }

    /**
     * This method returns the element contained in the node/vertex or null if
     * the node/vertex stores nothing.
     * @return The element in the node.
     */
    @Override
    public V getElement(){
      return element;
    }

    /**
     * This method changes the element in the node/vertex.
     * @param e The new element to store
     */
    public void setElement(V e){
      element = e;
    }

    /**
     * Returns an iterator to the edges list.
     * @return An iterator to the edge list.
     */
    public Iterator<Edge<E>> iteratorEdges(){
      return adjList.iterator();
    }

    /**
     * Adds an edge to the adjacency list.
     * @param e The edge to add.
     */
    public void addEdge(Edge<E> e){
      adjList.add(e);
    }

    /**
     * Erases an edge from the adjacency list.
     * @param e The edge to erase.
     */
    public void eraseEdge(Edge<E> e){
      adjList.remove(e);
    }

    /**
     * Checks if two nodes have the same content.
     * @param n The node to check with.
     * @return True if the two nodes have the same content.
     */
    public boolean equals (Object n) {
      return element.equals(((Vertex<V>) n).getElement());
    }
  }


  //----------------------------------------------------------------------------

  /**
   * This is an inner class representing an edge in the present graph
   * @param <E> The type of elements stored in the edge
   */
  private class InEdge<E> implements Edge<E> {
    /**
     * A string is used as an ID to identify the edge.
     */
    private String ID;

    /**
     * The element to store in this edge.
     */
    private E element;

    /**
     * An array with two elements storing the vertices defining the current
     * edge.
     */
    private Vertex<V>[] endVertices;


    /**
     * Constructor.
     * @param e The element stored in the edge.
     * @param n1 The first vertex defining the edge.
     * @param n2 The second vertex defining the edge.
     */
    public InEdge(Vertex<V> n1, Vertex<V> n2, E e){
      endVertices = (Vertex<V>[])new Vertex[2];

      if (e instanceof Element) {
        ID = ((Element)e).getID();
        element = e;
      } else  if (e instanceof Integer || e instanceof Long ||
                  e instanceof Short   || e instanceof Float||
				  e instanceof Double) {
        ID = ID.valueOf(e);
        element = e;
      } else if (e instanceof String) {
        ID = (String) e;
		element = null;
      }

      endVertices[0] = n1;
      endVertices[1] = n2;
    }

    /**
     * Constructor
     * @param n1 The first vertex defining the edge.
     * @param n2 The second vertex defining the edge.
     */
    public InEdge(Vertex<V> n1, Vertex<V> n2){
      endVertices = (Vertex<V>[])new Vertex[2];
      element = null;
      ID = n1.getID() + "-" + n2.getID();       // Id of the edge
      ID = ID +"("+ ID.valueOf(edges.size())+")";
      endVertices[0] = n1;
      endVertices[1] = n2;
    }


    /**
     * This method returns the ID of the edge.
     * @return The string defining the ID.
     */
    public String getID() {
      return ID;
    }

    /**
     * This method returns the element in the edge or null if
     * the edge stores nothing.
     * @return The element in the edge
     */
    public E getElement(){
      return element;
    }

    /**
     * This method changes the element in the edge.
     * @param e The new element to store in the edge.
     */
    public void setElement(E e){
      element = e;
    }

    /**
     * The method returns the vertices defining the edge.
     * @return An array with the two vertices defining the edge.
     */
    public Vertex<V>[] getEndVertices(){
      return endVertices;
    }

    /**
     * This method returns the vertex opposite to the one used as parameter
     * along the present edge.If the vertex used as parameter is not one of
     * the two defining the edge the method returns null.
     * @param n The vertex whose opposite we want to locate.
     * @return The vertex opposite to n on the current edge or null if n does
     * not define the current edge.
     */
    public Vertex<V> opposite(Vertex<V> n){
      Vertex<V> aux = null;
      if (n.getID().equals(endVertices[0].getID())){
        aux = endVertices[1];
      } else if (n.getID().equals(endVertices[1].getID())){
        aux = endVertices[0];
      }
      return aux;
    }
}

}
