package Parciales.Grafos.Diciembre2024;

import TP5.ejercicio1.*;

import java.util.ArrayList;
import java.util.List;

public class Parcial {
    public List<String> pilotoQuePasoPorMasEscuderias(Graph<String> escuderias){
        List<String> lisAct = new ArrayList<>();
        List<String> lisMax = new ArrayList<>();
        boolean [] visitados = new boolean[escuderias.getSize()];
        Vertex<String> origen = escuderias.search("origen");
        visitados[origen.getPosition()] = true;
        List<Edge<String>> adyacentes = escuderias.getEdges(origen);
        for(Edge<String> a : adyacentes){
            helper(a, lisAct, lisMax, visitados, escuderias);
        }
        return lisMax;
    }

    private void helper(Edge<String> pilotoAct, List<String> listaAct, List<String> listaMax, boolean[] visitados, Graph<String> escuderias){
        Vertex<String> destino = pilotoAct.getTarget();
        listaAct.add(destino.getData());
        if(!visitados[destino.getPosition()]){
            visitados[destino.getPosition()] = true;
            List<Edge<String>> adyacentes = escuderias.getEdges(destino);
            for(Edge<String> a : adyacentes){
                if(a.getWeight() == pilotoAct.getWeight()){
                    helper(a, listaAct, listaMax, visitados, escuderias);
                }
            }
        }
        if(listaAct.size() > listaMax.size()){
            listaMax.clear();
            listaMax.addAll(new ArrayList<String> (listaAct));
        }
        visitados[destino.getPosition()] = false;
        listaAct.remove(listaAct.size()-1);
    }

}
