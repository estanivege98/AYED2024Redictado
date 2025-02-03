package Parciales.Arboles.ParcialPrueba;

import TP2.BinaryTree.BinaryTree;
import TP2.Cola.Queue;

public class NivelArbol {
    private BinaryTree<Integer> ab;

    public NivelArbol(BinaryTree<Integer> ab) {
        this.ab = ab;
    }

    public BinaryTree<Integer> minEnArbol(int n){
        BinaryTree<Integer> hojaMin = new BinaryTree<Integer>();
        if(!this.ab.isEmpty()){
            Queue<BinaryTree<Integer>> cola = new Queue<>();
            int min = Integer.MAX_VALUE;
            int nivelAct = 0;
            cola.enqueue(this.ab);
            cola.enqueue(null);
            while(!cola.isEmpty()){
                BinaryTree<Integer> abAux = cola.dequeue();
                if(abAux != null){
                    if(abAux.isLeaf() && nivelAct == n && abAux.getData() < min){
                        min = abAux.getData();
                        hojaMin = abAux;
                    }
                    else {
                        if (abAux.hasLeftChild()){
                            cola.enqueue(abAux.getLeftChild());
                        }
                        if (abAux.hasRightChild()){
                            cola.enqueue(abAux.getRightChild());
                        }
                    }
                }
                else if (!cola.isEmpty()){
                    nivelAct++;
                    cola.enqueue(null);
                }
            }
        }
        return hojaMin;
    }
}
