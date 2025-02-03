package Parciales.Grafos.Parcial28112022;
import TP5.ejercicio1.*;
import TP5.ejercicio1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.List;
public class PruebaParcial28112022 {
    public static void main(String[] args){

        Graph<Estadio> mapaEstadios = new AdjListGraph<>();

        Estadio e1 = new Estadio("AI BAYT STADIUM", "Jor");
        Estadio e2 = new Estadio("LUSAIL STADIUM", "Lusail");
        Estadio e3 = new Estadio("EDUCATION CITY STADIUM", "Rayan");
        Estadio e4 = new Estadio("AL RAYYAN STADIUM", "Rayan");
        Estadio e5 = new Estadio("KHALIFA INTERNATIONAL STADIUM", "Doha");
        Estadio e6 = new Estadio("AL THUMAMA STADIUM", "Doha");
        Estadio e7 = new Estadio("STADIUM 947", "Doha");
        Estadio e8 = new Estadio("AL JANOUB STADIUM", "Wakrah");

        Vertex<Estadio> v1 = mapaEstadios.createVertex(e1);
        Vertex<Estadio> v2 = mapaEstadios.createVertex(e2);
        Vertex<Estadio> v3 = mapaEstadios.createVertex(e3);
        Vertex<Estadio> v4 = mapaEstadios.createVertex(e4);
        Vertex<Estadio> v5 = mapaEstadios.createVertex(e5);
        Vertex<Estadio> v6 = mapaEstadios.createVertex(e6);
        Vertex<Estadio> v7 = mapaEstadios.createVertex(e7);
        Vertex<Estadio> v8 = mapaEstadios.createVertex(e8);

        mapaEstadios.connect(v1, v2, 42);
        mapaEstadios.connect(v2, v1, 42);

        mapaEstadios.connect(v2, v3, 24);
        mapaEstadios.connect(v3, v2, 24);
        mapaEstadios.connect(v2, v7, 52);
        mapaEstadios.connect(v7, v2, 52);
        mapaEstadios.connect(v7, v8, 19);
        mapaEstadios.connect(v8, v7, 19);
        mapaEstadios.connect(v8, v6, 12);
        mapaEstadios.connect(v6, v8, 12);
        mapaEstadios.connect(v6, v5, 12);
        mapaEstadios.connect(v5, v6, 12);
        mapaEstadios.connect(v5, v4, 8);
        mapaEstadios.connect(v4, v5, 8);
        mapaEstadios.connect(v4, v3, 11);
        mapaEstadios.connect(v3, v4, 11);

        Parcial p = new Parcial();
        System.out.println(p.estadios(mapaEstadios, "AI BAYT STADIUM", 150).toString());
    }
}
