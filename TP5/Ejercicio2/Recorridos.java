package TP5.Ejercicio2;
import java.util.*;
import TP5.ejercicio1.*;
import TP5.Cola.Queue;
public class Recorridos<T> {

    public List<T> dfs(Graph<T> grafo){
        List<T> camino = new LinkedList<T>();
        boolean[] visitados = new boolean[grafo.getSize()];
        for (Vertex<T> vertice : grafo.getVertices()) {
            if(!visitados[vertice.getPosition()]){
                dfsHelper(grafo, vertice, visitados, camino);
            }
        }
        return camino;
    }

    private void dfsHelper(Graph<T> grafo, Vertex<T> vertice, boolean[] visitados, List<T> camino){
        camino.addLast(vertice.getData());
        visitados[vertice.getPosition()] = true;
        List<Edge<T>> adyacentes = grafo.getEdges(vertice);
        for (Edge<T> edge : adyacentes) {
            Vertex<T> destino = edge.getTarget();
            if(!visitados[destino.getPosition()]){
                dfsHelper(grafo, destino, visitados, camino);
            }
        }

    }

    public List<T> bfs(Graph<T> grafo){
        List<T> camino = new LinkedList<T>();
        boolean[] visitados = new boolean[grafo.getSize()];
        for (Vertex<T> vertice : grafo.getVertices()) {
            if(!visitados[vertice.getPosition()]){
                bfsHelper(grafo, vertice, visitados, camino);
            }
        }
        return camino;
    }

    private void bfsHelper(Graph<T> grafo, Vertex<T> vertice, boolean[] visitados, List<T> camino){
        Queue<Vertex<T>> cola = new Queue<>();
        cola.enqueue(vertice);
        visitados[vertice.getPosition()] = true;
        while (!cola.isEmpty()) {
            Vertex<T> actual = cola.dequeue();
            camino.addLast(actual.getData());
            List<Edge<T>> adyacentes = grafo.getEdges(actual);
            for (Edge<T> edge : adyacentes) {
                Vertex<T> destino = edge.getTarget();
                if(!visitados[destino.getPosition()]){
                    cola.enqueue(destino);
                    visitados[destino.getPosition()] = true;
                }
            }
        }
    }
}
