package Parciales.Grafos.Parcial2462023;

import TP5.ejercicio1.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parcial {

    public List<Objeto> resolver(Graph<String> sitios, String origen, String destino, List<String> evitar) {
        List<Objeto> lugares = new ArrayList<Objeto>();

        if(!sitios.isEmpty()){
            Vertex<String> origenVertex = sitios.search(origen);
            Vertex<String> destinoVertex = sitios.search(destino);
            if(origenVertex != null && destinoVertex != null){
                Objeto obj = new Objeto();
                boolean[] visitados = new boolean[sitios.getSize()];
                dfs(sitios, origenVertex, destinoVertex, lugares, evitar, visitados, 0, obj);
            }
        }
        return lugares;
    }

    private void dfs(Graph<String> sitios, Vertex<String> or, Vertex<String> des, List<Objeto> caminos, List<String> evitar, boolean[] visitados, int cuadras, Objeto obj){
        visitados[or.getPosition()] = true;
        obj.añadirLugar(or.getData());
        if(!or.equals(des)){
            List<Edge<String>> edges = sitios.getEdges(or);
            for(Edge<String> e : edges){
                Vertex<String> v = e.getTarget();
                int peso = e.getWeight();
                if(!visitados[v.getPosition()] && !contiene(evitar, v.getData())){
                    dfs(sitios, v, des, caminos, evitar, visitados, cuadras + peso, obj);
                }
            }
        }
        else{
            obj.setCantidadCuadras(cuadras);
            caminos.add(new Objeto(obj.getLugares(), obj.getCantidadCuadras()));
        }
        visitados[or.getPosition()] = false;
        obj.getLugares().remove(obj.getLugares().size() - 1);
    }

    private boolean contiene(List<String> lista, String lugar){
        Iterator<String> it = lista.iterator();
        boolean contiene = false;
        while (it.hasNext() && !contiene){
            if(it.next().equals(lugar)){
                contiene = true;
            }
        }
        return contiene;
    }
}
