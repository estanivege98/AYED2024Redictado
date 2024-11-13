package TP5.Ejercicio6;

import TP5.ejercicio1.*;

import java.util.List;
import java.util.LinkedList;

public class BuscadorDeCaminos {
    Graph<String> bosque;

    public BuscadorDeCaminos(Graph<String> bosque) {
        this.bosque = bosque;
    }

    public List<List<String>> recorridosMasSeguro(){
        Vertex<String> v1 = this.bosque.search("Casa Caperucita");
        Vertex<String> v2 = this.bosque.search("Casa Abuelita");
        List<List<String>> caminos = new LinkedList<>();
        if(v1 == null || v2 == null) return caminos;
        List<String> caminoAct = new LinkedList<>();
        boolean[] visitados = new boolean[this.bosque.getSize()];
        this.recorridosMasSeguroHelper(v1, "Casa Abuelita", caminoAct, caminos, visitados);
        return caminos;
    }

    private void recorridosMasSeguroHelper(Vertex<String> v1, String casaAbuelita, List<String> caminoAct, List<List<String>> caminos, boolean[] visitados){
        visitados[v1.getPosition()] = true;
        caminoAct.add(v1.getData());
        if(v1.getData().equals(casaAbuelita)){
            caminos.add(new LinkedList<>(caminoAct));
        } else {
            for(Edge<String> e : this.bosque.getEdges(v1)){
                Vertex<String> e1 = e.getTarget();
                if(!visitados[e1.getPosition()] && e.getWeight() < 5){
                    this.recorridosMasSeguroHelper(e1, casaAbuelita, caminoAct, caminos, visitados);
                }
            }
        }
        visitados[v1.getPosition()] = false;
        caminoAct.remove(caminoAct.size() - 1);
    }
}
