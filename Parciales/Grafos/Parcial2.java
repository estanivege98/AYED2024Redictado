package Parciales.Grafos;
/* Grafos 15/6/2024 - Tema 2 */
import TP5.ejercicio1.*;
import java.util.*;
public class Parcial2 {

    private Vertex<Animales> buscar(Graph<Animales> sitios, String nombre) {
        for( Vertex<Animales> vertice:  sitios.getVertices()) {
            if (vertice.getData().getNombre().equals(nombre)) {
                return vertice;
            }
        }
        return null;
    }

    public List<String> resolver(Graph<Animales> sitios, int tiempo){
        List<String> lista = new LinkedList<String>();
        Vertex<Animales> v = buscar(sitios, "Entrada");
        if(v == null){
            return lista;
        }
        else{
            boolean[] visitados = new boolean[sitios.getSize()];
            resolverAux(sitios, v, tiempo, visitados, lista);
            return lista;
        }
    }

    public boolean resolverAux(Graph<Animales> sitios, Vertex<Animales> v, int tiempo, boolean[] visitados, List<String> lista){
        visitados[v.getPosition()] = true;
        lista.add(v.getData().getNombre());
        if(v.getData().getTiempo() <= tiempo){
            if(lista.size() == sitios.getSize()){
                return true;
            }
            tiempo -= v.getData().getTiempo();
            for(Edge<Animales> arista : sitios.getEdges(v)){
                Vertex<Animales> destino = arista.getTarget();
                if(!visitados[destino.getPosition()] && tiempo >= arista.getWeight()){
                    if(resolverAux(sitios, destino, tiempo - arista.getWeight(), visitados, lista)){
                        return true;
                    }
                }
            }
        }
        visitados[v.getPosition()] = false;
        lista.remove(lista.size()-1);
        return false;
    }
}