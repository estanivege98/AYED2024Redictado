package Parciales.Arboles;
/* 1era fecha - 15/6/2024 - Tema 2 */
import tp3.ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;
import TP2.Cola.*;
public class Parcial1 {
    private GeneralTree<Integer> arbolGeneral;

    public Parcial1(GeneralTree<Integer> ab){
        this.arbolGeneral = ab;
    }

    public List<Integer> nivel(int num){
        List<Integer> lista = new LinkedList<Integer>();
        if(!arbolGeneral.isEmpty()){
            nivelAux(arbolGeneral, num, lista);
            //return lista;
        }
        return lista;
    }

    private void nivelAux(GeneralTree<Integer> arbol, int num, List<Integer> lista){
        GeneralTree<Integer> aux = new GeneralTree<Integer>();
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        boolean encontro = true;
        //int contador = 0;
        boolean termino = true;
        while(!cola.isEmpty() && encontro){
            aux = cola.dequeue();
            if(aux!=null){
                lista.add(aux.getData());
                List<GeneralTree<Integer>> hijos = aux.getChildren();
                if(hijos.size() < num && termino ){
                    termino = false;
                }
                for(GeneralTree<Integer> hijo : aux.getChildren()){
                    cola.enqueue(hijo);
                }
            }
            else{
                if(termino){
                    encontro = false;
                }
                else{
                    termino = true;
                    lista.clear();

                }
                //termino = true;
                if(!cola.isEmpty() && encontro){
                    cola.enqueue(null);
                }
            }
        }

    }
}
