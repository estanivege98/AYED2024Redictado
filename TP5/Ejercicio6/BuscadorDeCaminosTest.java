package TP5.Ejercicio6;

import TP5.ejercicio1.*;
import TP5.ejercicio1.adjList.AdjListGraph;

import java.util.List;
public class BuscadorDeCaminosTest {
    public static void main (String[] args){
        Graph<String> bosque = new AdjListGraph<>();
        Vertex<String> v1 = bosque.createVertex("Casa Caperucita");
        Vertex<String> v2 = bosque.createVertex("Claro 1");
        Vertex<String> v3 = bosque.createVertex("Claro 2");
        Vertex<String> v4 = bosque.createVertex("Claro 3");
        Vertex<String> v5 = bosque.createVertex("Claro 4");
        Vertex<String> v6 = bosque.createVertex("Claro 5");
        Vertex<String> v7 = bosque.createVertex("Casa Abuelita");


        bosque.connect(v1, v4, 4);
        bosque.connect(v1, v2, 3);
        bosque.connect(v1, v3, 4);

        bosque.connect(v4, v1, 4);
        bosque.connect(v2, v1, 3);
        bosque.connect(v3, v1, 4);

        bosque.connect(v4, v6, 15);
        bosque.connect(v6, v4, 15);

        bosque.connect(v2, v6, 3);
        bosque.connect(v6, v2, 3);

        bosque.connect(v2, v3, 4);
        bosque.connect(v3, v2, 4);

        bosque.connect(v3, v6, 11);
        bosque.connect(v6, v3, 11);

        bosque.connect(v6, v7, 4);
        bosque.connect(v7, v6, 4);

        bosque.connect(v5, v7, 9);
        bosque.connect(v7, v5, 9);

        BuscadorDeCaminos buscar = new BuscadorDeCaminos(bosque);
        List<List<String>> camino = buscar.recorridosMasSeguro();

        for (List<String> lista : camino) {
            System.out.println("-----------------");
            System.out.println("Camnio");
            System.out.println();
            for (String elemento : lista) {
                System.out.println(elemento);
            }
            System.out.println();
        }
    }
}

