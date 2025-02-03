package Parciales.Grafos.Parcial29062024Tema1;

import Parciales.Grafos.Parcial29062024Tema2.Devolver;
import TP5.ejercicio1.Edge;
import TP5.ejercicio1.Graph;
import TP5.ejercicio1.Vertex;

import java.util.ArrayList;
import java.util.List;
import TP2.Cola.*;

public class Parcial {
    public List<Usuario> invitacionMasterClass(Graph<String> g, String usuario, int distancia, int limite){
        List<Usuario> lista = new ArrayList<Usuario>();
        if(!g.isEmpty()) {
            Vertex<String> origen = g.search(usuario);
            if(origen != null){
                bfs(g, origen, lista, distancia, limite);
            }
        }
        return lista;
    }

    private void bfs(Graph<String> g, Vertex<String> or, List<Usuario> lista, int distancia, int limite){
        int cant = 0;
        int nivel = 1;
        boolean [] visitados = new boolean[g.getSize()];
        visitados[or.getPosition()] = true;
        Queue<Vertex<String>> cola = new Queue<Vertex<String>>();
        cola.enqueue(or);
        cola.enqueue(null);
        while(!cola.isEmpty() && distancia >= nivel && cant < limite){
            Vertex<String> v = cola.dequeue();
            if(v != null){
                List<Edge<String>> ady = g.getEdges(v);
                for(Edge<String> e : ady){
                    Vertex<String> aux = e.getTarget();
                    if(!visitados[aux.getPosition()] && limite > cant){
                        visitados[aux.getPosition()] = true;
                        cant++;
                        cola.enqueue(aux);
                        lista.add(new Usuario(aux.getData(), nivel));
                    }
                }

            }
            else if (!cola.isEmpty()){
                nivel++;
                cola.enqueue(null);
            }
        }
    }
}
