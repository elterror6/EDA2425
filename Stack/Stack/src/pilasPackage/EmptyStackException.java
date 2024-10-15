package pilasPackage;

/**
 * EmptyStackException
 * <p>
 * Clase que representa una excepción que se produce cuando se intenta realizar una operación y la pila está vacía.
 * </p>
 * @author Daniel Díaz García
 * @author Diego Repullo Higueruela
 */
public class EmptyStackException extends RuntimeException {
    /**
     * Constructor
     * <p>
     * Método constructor que crea una excepción con un mensaje personalizado.
     * </p>
     * @param err Mensaje personalizado de la excepción
     */
    public EmptyStackException(String err) {
        super(err);
    }
}
