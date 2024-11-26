
package graphsDSESIUCLM;

/**
 * This interface defines the existence of a string used as an ID for an element
 * to store in a vertex or an edge. This ID will be used as key for the vertex
 * or edge.
 *
 * WARNING: Remember to include an equals method in the class implementing
 * this interface if needed.
 *
 * @author Alfonso Niño
 * @author Camelia Muñoz-Caro
 * @author Crescencio Bravo
 * @version November 2014
 *
 */
public interface Element {
  /**
   * This method returns the ID of the element
   * @return A string with the ID of the element
   */
  String getID();

}
