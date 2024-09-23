package TP2.ejercicio5;
import java.util.*;
import TP2.BinaryTree.*;
import TP2.Cola.Queue;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }
    public int sumaElementosProfundidad(int p){
        if (arbol.isEmpty()) return 0;
        Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
        int suma = 0;
        int profAct = 0;
        cola.enqueue(arbol);
        cola.enqueue(null);

        while (!cola.isEmpty()){
            BinaryTree<Integer> nodoAct = cola.dequeue();
            if (nodoAct == null){
                profAct++;
                if(!cola.isEmpty()){
                    cola.enqueue(null);
                }
            }
            else{
                if(profAct == p){
                    suma += nodoAct.getData();
                }
                if(nodoAct.hasLeftChild()){
                    cola.enqueue(nodoAct.getLeftChild());
                }
                if(nodoAct.hasRightChild()){
                    cola.enqueue(nodoAct.getRightChild());
                }
            }

        }
        return suma;
    }
}
