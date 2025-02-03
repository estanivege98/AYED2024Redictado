package Parciales.Arboles.tema16112024;

import tp3.ejercicio1.GeneralTree;

import java.util.List;

public class ComparadorDeArbolesGenerales {

    public boolean esInferiorProfundo(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2){
        if(arbol1.isEmpty() || arbol2.isEmpty()){
            return false;
        }
        if(!arbol1.isEmpty() && arbol2.isEmpty()){
            return true;
        }
        else{
            return esInferiorProfundoHelper(arbol1, arbol2);
        }
    }

    private boolean esInferiorProfundoHelper(GeneralTree<Integer> ab1, GeneralTree<Integer> ab2){

        if(ab1.getData() >= ab2.getData()){
            return false;
        }
        if(!ab1.isLeaf() && ab2.isLeaf()){
            return false;
        }
        if(!ab1.isLeaf() && !ab2.isLeaf()){
            int sum1 = 0;
            int sum2 = 0;
            List<GeneralTree<Integer>> hijos1 = ab1.getChildren();
            List<GeneralTree<Integer>> hijos2 = ab2.getChildren();
            for(GeneralTree<Integer> h : hijos1){
                sum1 += h.getData();
            }
            for(GeneralTree<Integer> h : hijos2){
                sum2+= h.getData();
            }
            if(sum1>sum2){
                return false;
            }
            else{
                int iterar = 0;
                if(hijos1.size() > hijos2.size()){
                    iterar = hijos1.size() - (hijos1.size() - hijos2.size());
                }
                else{
                    iterar = hijos1.size();
                }
                for(int i=0; i<iterar; i++){
                    if(!esInferiorProfundoHelper(hijos1.get(i), hijos2.get(i))){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
