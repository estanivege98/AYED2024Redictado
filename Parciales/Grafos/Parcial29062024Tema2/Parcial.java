package Parciales.Grafos.Parcial29062024Tema2;

import TP5.ejercicio1.*;
import TP2.Cola.*;

import java.util.List;

public class Parcial {
    public Devolver nivelPopularidad(Graph<String> red, String usuario, int distancia, int umbral){
        //Devolver devolver = new Devolver(usuario, false);
        Devolver devolver = null;
        if(!red.isEmpty()){
            Vertex<String> or = red.search(usuario);
            if(or != null){
                devolver = bfs(red, or, distancia, umbral);
            }
        }
        return devolver;
    }

    private Devolver bfs(Graph<String> red, Vertex<String> or, int distancia, int umbral){
        int nivel = 1;
        int cant = 0;
        boolean [] visitados = new boolean[red.getSize()];
        visitados[or.getPosition()] = true;
        Queue<Vertex<String>> cola = new Queue<Vertex<String>>();
        cola.enqueue(or);
        cola.enqueue(null);
        while (!cola.isEmpty() && nivel != distancia){
            Vertex<String> actual = cola.dequeue();
            if(actual != null){
                List<Edge<String>> adyacentes = red.getEdges(actual);
                for(Edge<String> e : adyacentes){
                    Vertex<String> destino = e.getTarget();
                    if(!visitados[destino.getPosition()]){
                        visitados[destino.getPosition()] = true;
                        cola.enqueue(destino);

                    }
                }
            }
            else if(!cola.isEmpty()){
                cola.enqueue(null);
                nivel++;
            }
        }
        while (!cola.isEmpty() && nivel == distancia){
            Vertex<String> actual = cola.dequeue();
            if(actual != null){
                cant++;
            }
        }
        return new Devolver(cant, cant >= umbral);
    }
}
