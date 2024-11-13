
package TP5.Ejercicio5;
import TP5.ejercicio1.*;
import TP5.Cola.*;
import java.util.List;
import java.util.LinkedList;
public class BancoItau {
    private Graph<Persona> grafo;

    public BancoItau(Graph<Persona> g){
        this.grafo = g;
    }

    private Vertex<Persona> buscar(Vertex<Persona> v, String nombre){
        for(Vertex<Persona> vertice : this.grafo.getVertices()){
            if(vertice.getData().getNombre().equals(nombre)){
                return vertice;
            }
        }
        return null;
    }

    public List<Persona> jubiladosMasCercano(Vertex<Persona> empleado, int distancia){
        Vertex<Persona> v1 = this.buscar(empleado, empleado.getData().getNombre());
        if(v1 == null) return null;
        List<Persona> jubilados = new LinkedList<>();
        boolean[] visitados = new boolean[this.grafo.getSize()];
        this.jubiladosMasCercanoHelper(v1, distancia, jubilados, visitados);
        return jubilados;
    }

    private void jubiladosMasCercanoHelper(Vertex<Persona> v1, int distancia, List<Persona> jubilados, boolean[] visitados){
        Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
        cola.enqueue(v1);
        cola.enqueue(null);
        visitados[v1.getPosition()] = true;
        boolean encontre = true;
        while(!cola.isEmpty() && encontre){
            Vertex<Persona> vAux = cola.dequeue();
            if(vAux != null){
                if(vAux.getData().getJubilado()){
                    jubilados.add(vAux.getData());
                }
                if(jubilados.size() == 40){
                    encontre = false;
                }
                for(Edge<Persona> e : this.grafo.getEdges(vAux)){
                    Vertex<Persona> e1 = e.getTarget();
                    if(!visitados[e1.getPosition()]){
                        visitados[e1.getPosition()] = true;
                        cola.enqueue(e1);
                    }
                    else{
                        if(distancia == 0){
                            encontre = false;
                        }
                        else{
                            distancia--;
                        }
                        if(!cola.isEmpty()){
                            cola.enqueue(null);
                        }
                    }
                }
            }
        }
    }
}
