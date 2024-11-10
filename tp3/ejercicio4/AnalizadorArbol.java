package tp3.ejercicio4;
import tp3.ejercicio1.GeneralTree;
import TP2.Cola.*;
import java.util.LinkedList;
import java.util.List;
public class AnalizadorArbol {
    private GeneralTree<AreaEmpresa> arbol;

    public AnalizadorArbol(GeneralTree<AreaEmpresa> arbol) {
        this.arbol = arbol;
    }

    /* se debe devolver el mayor promedio entre todos los valores promedios de los niveles */

    public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol){
        if(arbol.isEmpty()){
            return 0;
        }
        else{
            maximoAux(arbol);
        }
        return 0;
    }

    private double maximoAux(GeneralTree<AreaEmpresa> arbol){
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
        GeneralTree<AreaEmpresa> aux;
        cola.enqueue(arbol);
        cola.enqueue(null);
        int suma = 0;
        int cantidad = 0;
        double maximoProm = 0;
        while(!cola.isEmpty()){
            aux = cola.dequeue();
            if(aux != null){
                suma += aux.getData().getTardanza();
                cantidad++;
                for (GeneralTree<AreaEmpresa> hijo : aux.getChildren()){
                    cola.enqueue(hijo);
                }

            }
            else{
                if (cantidad > 0){
                    double promedio = suma/cantidad;
                    if(promedio > maximoProm){
                        maximoProm = promedio;
                    }
                }
                cantidad = 0;
                suma = 0;
                if(!cola.isEmpty()){
                    cola.enqueue(null);
                }
            }
        }
        return maximoProm;
    }
}
