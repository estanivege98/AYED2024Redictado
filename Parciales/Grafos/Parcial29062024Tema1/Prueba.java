package Parciales.Grafos.Parcial29062024Tema1;
import TP5.ejercicio1.*;
import TP5.ejercicio1.adjList.AdjListGraph;

public class Prueba {
    public static void main(String[] args){
        Graph<String> g = new AdjListGraph<>();
        Vertex<String> v1 = g.createVertex("Lionel");
        Vertex<String> v2 = g.createVertex("Angel");
        Vertex<String> v3 = g.createVertex("Rodrigo");
        Vertex<String> v4 = g.createVertex("Emiliano");
        Vertex<String> v5 = g.createVertex("Julian");
        Vertex<String> v6 = g.createVertex("Lautaro");
        Vertex<String> v7 = g.createVertex("Diego");
        Vertex<String> v8 = g.createVertex("Enzo");

        g.connect(v1, v2);

        g.connect(v1, v3);

        g.connect(v2, v1);
        g.connect(v2, v5);
        g.connect(v2, v7);
        g.connect(v2, v8);

        g.connect(v3, v1);
        g.connect(v3, v4);
        g.connect(v3, v5);

        g.connect(v4, v3);
        g.connect(v4, v6);
        g.connect(v4, v8);

        g.connect(v5, v2);
        g.connect(v5, v3);
        g.connect(v5, v6);

        g.connect(v6, v4);
        g.connect(v6, v5);
        g.connect(v6, v7);

        g.connect(v7, v2);
        g.connect(v7, v6);
        g.connect(v7, v8);

        g.connect(v8, v7);
        g.connect(v8, v2);
        g.connect(v8, v4);

        Parcial p = new Parcial();
        System.out.println(p.invitacionMasterClass(g, "Lionel", 2, 4));
    }
}
