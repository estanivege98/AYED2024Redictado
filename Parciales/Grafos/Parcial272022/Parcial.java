package Parciales.Grafos.Parcial272022;
import TP5.ejercicio1.*;
import TP5.ejercicio1.adjList.AdjListGraph;

import java.util.ArrayList;
import java.util.List;

public class Parcial {
    public List<String> caminoConPresupuesto(Graph<String> ciudad, String origen, String destino, int montoMaximo){
        Vertex<String> vOrigen = ciudad.search(origen);
        Vertex<String> vDestino = ciudad.search(destino);
        List<String> camino = new ArrayList<>();
        List<String> caminoMax = new ArrayList<>();
        if(vOrigen != null && vDestino != null){
            boolean[] visitados = new boolean[ciudad.getSize()];

            dfs(vOrigen, vDestino, camino, caminoMax, visitados, ciudad, montoMaximo);
        }
        return caminoMax;
    }

    private void dfs(Vertex<String> origen, Vertex<String> destino, List<String> camino, List<String> caminoMax, boolean[] visitados, Graph<String> ciudad, int montoMaximo){
        camino.add(origen.getData());
        visitados[origen.getPosition()] = true;
        if(origen.equals(destino)){
            caminoMax.clear();
            caminoMax.addAll(new ArrayList<String>(camino));
        }
        else {
            for(Edge<String> a : ciudad.getEdges(origen)){
                if(a.getWeight() <= montoMaximo){
                    Vertex<String> vDestino = a.getTarget();
                    if(!visitados[vDestino.getPosition()]){
                        visitados[vDestino.getPosition()] = true;
                        dfs(vDestino, destino, camino, caminoMax, visitados, ciudad, montoMaximo - a.getWeight());
                    }

                }

            }
        }
        visitados[origen.getPosition()] = false;
        camino.remove(camino.size()-1);

    }

    public static void main(String[] args){
        Graph<String> grafo = new AdjListGraph<String>();
        Vertex<String> v1 = grafo.createVertex("Lincoln");
        Vertex<String> v2 = grafo.createVertex("Chascomús");
        Vertex<String> v3 = grafo.createVertex("Cañuelas");
        Vertex<String> v4 = grafo.createVertex("Dolores");
        Vertex<String> v5 = grafo.createVertex("Verónica");
        Vertex<String> v6 = grafo.createVertex("Villa Urquiza");
        Vertex<String> v7 = grafo.createVertex("Ranchos");
        Vertex<String> v8 = grafo.createVertex("Berisso");

        grafo.connect(v1, v2, 70);
        grafo.connect(v2, v1, 70);
        grafo.connect(v1, v3, 50);
        grafo.connect(v3, v1, 50);
        grafo.connect(v1, v4, 90);
        grafo.connect(v4, v1, 90);
        grafo.connect(v2, v5, 80);
        grafo.connect(v5, v2, 80);
        grafo.connect(v2, v6, 60);
        grafo.connect(v6, v2, 60);
        grafo.connect(v3, v5, 85);
        grafo.connect(v5, v3, 85);
        grafo.connect(v3, v7, 90);
        grafo.connect(v7, v3, 90);
        grafo.connect(v4, v6, 70);
        grafo.connect(v6, v4, 70);
        grafo.connect(v4, v7, 70);
        grafo.connect(v7, v4, 70);
        grafo.connect(v5, v8, 60);
        grafo.connect(v8, v5, 60);
        grafo.connect(v6, v8, 90);
        grafo.connect(v8, v6, 90);
        grafo.connect(v7, v8, 75);
        grafo.connect(v8, v7, 75);

        Parcial p = new Parcial();

        System.out.println(p.caminoConPresupuesto(grafo, "Lincoln", "Berisso", 200));
    }
}
