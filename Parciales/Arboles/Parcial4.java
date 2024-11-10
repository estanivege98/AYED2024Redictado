package Parciales.Arboles;
/* 1era fecha - 1/6/2024 - tema 1 */
//import tp3.*;
import tp3.ejercicio1.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class Parcial4 {
    private GeneralTree<Integer> arbol;

    public Parcial4(GeneralTree<Integer> arbol){
        this.arbol = arbol;
    }

    public List<Integer> camino(int num){
        ObjectoNodo objeto = new ObjectoNodo();
        if(arbol.isEmpty()){
            return new LinkedList<Integer>();
        }
        else{
            caminoAux(arbol, num, objeto);
            return objeto.getNum();
        }
    }

    private void caminoAux(GeneralTree<Integer> ab, int num, ObjectoNodo objeto){
        objeto.agregarLista(ab.getData());
        if(ab.isLeaf()){
            objeto.setCorte();
        }
        if(ab.getChildren().size() >= num && objeto.getCorte()){
            for(GeneralTree<Integer> hijo : ab.getChildren()){
                if(objeto.getCorte()){
                    caminoAux(hijo, num, objeto);
                }
            }
        }
        if(objeto.getCorte()){
            objeto.getNum().remove(objeto.getNum().size()-1);
        }
    }
}
