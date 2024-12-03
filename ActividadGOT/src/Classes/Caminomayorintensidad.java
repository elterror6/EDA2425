package Classes;

import java.util.*;

import graphsDSESIUCLM.Weight;

public class Caminomayorintensidad {
    private Map<String, List<Weight>> grafo;

    public Caminomayorintensidad(Map<String, List<Weight>> grafo) {
        this.grafo = grafo;
    }

    public List<String> encontrarCamino(String inicio, String destino) {
        List<String> camino = new ArrayList<>();
        Set<String> visitados = new HashSet<>();

        if (dfs(inicio, destino, camino, visitados)) {
            return camino;
        }

        return null; // No se encontró un camino
    }

    private boolean dfs(String actual, String destino, List<String> camino, Set<String> visitados) {
        camino.add(actual);
        visitados.add(actual);

        if (actual.equals(destino)) {
            return true; // Llegamos al destino
        }

        // Obtener los vecinos ordenados por peso descendente
        List<Weight> vecinos = grafo.getOrDefault(actual, new ArrayList<>());
        vecinos.sort((w1, w2) -> Integer.compare(w2.getWeight(), w1.getWeight()));

        // Recorrer los vecinos no visitados
        for (Weight relacion : vecinos) {
            String vecino = obtenerVecino(actual, relacion);
            if (!visitados.contains(vecino)) {
                if (dfs(vecino, destino, camino, visitados)) {
                    return true;
                }
            }
        }

        // Retroceder (backtracking)
        camino.remove(camino.size() - 1);
        return false;
    }
}
