package Parciales.Grafos.Parcial29062024;
import java.util.*;
import TP5.Cola.*;
import TP5.Cola.Queue;
import TP5.ejercicio1.*;
import TP5.ejercicio1.adjList.AdjListEdge;

public class Parcial {
    public List<Auxiliar> invitadoMasterClass(Graph<String> red, String usuario, int distacia, int limite){
        List<Auxiliar> aux = new ArrayList<Auxiliar>();
        if(!red.isEmpty())
        {
            Vertex<String> v = red.search(usuario);
            if(v != null)
            {
                helper(red, v, distacia, limite, aux);
            }
            //aux = helper(red, v, distacia, limite);

        }
        return aux;
    }

    private void helper(Graph<String> red, Vertex<String> v, int distancia, int limite, List<Auxiliar> aux){
        Queue<Vertex<String>> cola = new Queue<Vertex<String>>();
        cola.enqueue(v);
        cola.enqueue(null);
        boolean [] visitados = new boolean[red.getSize()];
        visitados[v.getPosition()] = true;
        int nivel = 1;
        int cant = 0;
        while(!cola.isEmpty() && nivel <= distancia && cant<=limite){
            Vertex<String> actual = cola.dequeue();
            if(actual != null){
                List<Edge<String>> adyacentes = red.getEdges(actual);
                Iterator<Edge<String>> iterador = adyacentes.iterator();
                while(iterador.hasNext() && cant<=limite){
                    Vertex<String> destino = iterador.next().getTarget();

                    if(!visitados[destino.getPosition()]){
                        visitados[destino.getPosition()] = true;
                        cola.enqueue(destino);
                        aux.add(new Auxiliar(destino.getData(), nivel));
                        cant++;
                    }
                }
            }
            else if(!cola.isEmpty()){
                nivel++;
                cola.enqueue(null);
            }
        }

    }
}
