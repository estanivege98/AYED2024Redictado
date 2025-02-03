package Parciales.Grafos.Parcial28112022;

import TP5.ejercicio1.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parcial {

    public List<String> estadios(Graph<Estadio> mapaEstadios, String estadioOrigen, int cantKM){
        Vertex<Estadio> origen = this.buscar(mapaEstadios, estadioOrigen);
        List<String> listaEstadios = new ArrayList<String>();
        List<String> listaEstadiosMax = new ArrayList<String>();
        if(origen != null){
            boolean[] visitados = new boolean[mapaEstadios.getSize()];
            //visitados[origen.getPosition()] = true;
            dfs(origen, listaEstadios, listaEstadiosMax, visitados, mapaEstadios, cantKM);
        }
        return listaEstadiosMax;
    }

    private Vertex<Estadio> buscar(Graph<Estadio> mapaEstadios, String estadioOrigen){
        for(Vertex<Estadio> v : mapaEstadios.getVertices()){
            if(v.getData().getNombre().equals(estadioOrigen)){
                return v;
            }
        }
        return null;
    }

//    private Vertex<Estadio> buscarIteratos(Graph<Estadio> mapaEstadio, String estadiOrigen){
//        Vertex<Estadio> origen = null;
//        Iterator<Vertex<Estadio>> it = mapaEstadio.getVertices().iterator();
//        while (it.hasNext() && origen == null){
//            Vertex<Estadio> v = it.next();
//            if(v.getData().getNombre().equals(estadiOrigen)){
//                origen = v;
//            }
//        }
//        return origen;
//    }

    private void dfs(Vertex<Estadio> origen, List<String> le, List<String> lm, boolean[] visitados, Graph<Estadio> mapaEstadio, int cantKM){
        visitados[origen.getPosition()] = true;
        le.add(origen.getData().getNombre());
        List<Edge<Estadio>> adyacentes = mapaEstadio.getEdges(origen);
        for(Edge<Estadio> a : adyacentes){
            if(a.getWeight() <= cantKM){
                Vertex<Estadio> destino = a.getTarget();
                if(!visitados[destino.getPosition()]){
                    dfs(destino, le, lm, visitados, mapaEstadio, cantKM - a.getWeight());
                }
            }

        }
        if(le.size() > lm.size()){
            lm.clear();
            lm.addAll(new ArrayList<String>(le));
        }
        visitados[origen.getPosition()] = false;
        le.remove(le.size() -1);
    }
}
