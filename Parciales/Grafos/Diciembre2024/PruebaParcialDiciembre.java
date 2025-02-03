package Parciales.Grafos.Diciembre2024;
import TP5.ejercicio1.*;
import TP5.ejercicio1.adjList.AdjListGraph;

public class PruebaParcialDiciembre {
    public static void main(String[] args) {
        Graph<String> grafo = new AdjListGraph<>();

        Vertex<String> v1 = grafo.createVertex("origen");
        Vertex<String> v2 = grafo.createVertex("Lotus");
        Vertex<String> v3 = grafo.createVertex("Toleman");
        Vertex<String> v4 = grafo.createVertex("Alfa Romeo");
        Vertex<String> v5 = grafo.createVertex("Mercedes");
        Vertex<String> v6 = grafo.createVertex("Ferrari");
        Vertex<String> v7 = grafo.createVertex("McLaren");
        Vertex<String> v8 = grafo.createVertex("Williams");

        grafo.connect(v1, v2, 1);
        grafo.connect(v1, v3, 2);
        grafo.connect(v3, v2, 2);
        grafo.connect(v2, v7, 2);
        grafo.connect(v7, v8,2);

        grafo.connect(v1, v4, 3);
        grafo.connect(v4, v5, 3);
        grafo.connect(v5, v6, 3);

        grafo.connect(v1, v6, 4);
        grafo.connect(v6, v7, 4);
        grafo.connect(v7, v8, 4);

        Parcial p = new Parcial();
        System.out.println(p.pilotoQuePasoPorMasEscuderias(grafo));
    }
}
