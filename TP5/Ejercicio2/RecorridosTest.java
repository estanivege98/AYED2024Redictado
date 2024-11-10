package TP5.Ejercicio2;
import java.util.*;
import TP5.ejercicio1.*;
import ejercicio1.adjList.AdjListGraph;


import static org.junit.Assert.assertEquals;
import static org.junit.*;

public class RecorridosTest {


    private Graph<String> createTestGraph(){
        Graph<String> grafo = new AdjListGraph<>();

        // Creo los vertices
        Vertex<String> a = grafo.createVertex("A");
        Vertex<String> b = grafo.createVertex("B");
        Vertex<String> c = grafo.createVertex("C");
        Vertex<String> d = grafo.createVertex("D");
        Vertex<String> e = grafo.createVertex("E");

        // Conecto los vertices
        grafo.connect(a, b);
        grafo.connect(a, c);
        grafo.connect(b, d);
        grafo.connect(c, e);

        return grafo;
    }

    @org.junit.Test
    public void testDfs(){
        Graph<String> grafo = createTestGraph();
        Recorridos<String> recorridos = new Recorridos<>();

        List<String> camino = recorridos.dfs(grafo);

        // Verifico que el camino sea el correcto
        List<String> expectedOrder = List.of("A", "B", "D", "C", "E");
        assertEquals(expectedOrder, camino);
    }
    @org.junit.Test
    public void testBfs(){
        Graph<String> grafo = createTestGraph();
        Recorridos<String> recorridos = new Recorridos<>();

        List<String> camino = recorridos.bfs(grafo);

        // Verifico que el camino sea el correcto
        List<String> expectedOrder = List.of("A", "B", "C", "D", "E");
        assertEquals(expectedOrder, camino);
    }

    @org.junit.Test
    public void testDfsDisconnected(){
        // Creo un grafo diferente al anterior
        Graph<String> grafo = new AdjListGraph<>();

        // Creo los vertices
        Vertex<String> a = grafo.createVertex("A");
        Vertex<String> b = grafo.createVertex("B");
        Vertex<String> c = grafo.createVertex("C");

        // Conecto los vertices
        grafo.connect(a, b);
        // En este test, el vertice "C" no esta conectado a ningun otro vertice

        Recorridos<String> recorridos = new Recorridos<>();
        List<String> camino = recorridos.dfs(grafo);

        // Verifico que el camino sea el correcto
        List<String> expectedOrder = List.of("A", "B", "C");
        assertEquals(expectedOrder, camino);

    }

    @org.junit.Test
    public void testBfsDisconnected(){
        // Creo un grafo diferente al anterior
        Graph<String> grafo = new AdjListGraph<>();

        // Creo los vertices
        Vertex<String> a = grafo.createVertex("A");
        Vertex<String> b = grafo.createVertex("B");
        Vertex<String> c = grafo.createVertex("C");

        // Conecto los vertices
        grafo.connect(a, b);
        // En este test, el vertice "C" no esta conectado a ningun otro vertice

        Recorridos<String> recorridos = new Recorridos<>();
        List<String> camino = recorridos.bfs(grafo);

        // Verifico que el camino sea el correcto
        List<String> expectedOrder = List.of("A", "B", "C");
        assertEquals(expectedOrder, camino);
    }
}
