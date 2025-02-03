package Parciales.Arboles;
import tp3.ejercicio1.*;

import java.util.LinkedList;
import java.util.List;
import TP2.Cola.*;

public class ParcialTema21562024 {
    private GeneralTree<Integer> arbolGeneral;


    public List<Integer> nivel(int num){
        List<Integer> listAux = new LinkedList<Integer>();
        if(arbolGeneral.isEmpty()){
            return null;
        }
        else{
            nivelAux(arbolGeneral, num, listAux);
        }
        return listAux;
    }

    /*private boolean cumple(GeneralTree<Integer> hijo, int num){
        return hijo.getChildren().size() >= num;
    }*/
    private void nivelAux(GeneralTree<Integer> ab, int num, List<Integer> lista){
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        cola.enqueue(ab);
        cola.enqueue(null);
        boolean encontro = false;
        boolean termino = true;
        while(!cola.isEmpty() && !encontro){
            GeneralTree<Integer> aux = cola.dequeue();
            if(aux != null){
                lista.add(aux.getData());
                List<GeneralTree<Integer>> hijo = aux.getChildren();
                if(hijo.size() < num){
                    termino = false;
                }
                for(GeneralTree<Integer> h : hijo){
                    cola.enqueue(h);
                }
            }
            else{
                if(!termino){
                    termino = true;
                    lista.clear();
                }
                else{
                    encontro = true;
                    //lista.clear();
                }
                if(!cola.isEmpty()){
                    cola.enqueue(null);
                }
            }

        }
    }
}
