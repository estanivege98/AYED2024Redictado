package TP2.ejercicio3;
import TP2.BinaryTree.BinaryTree;
import java.util.*;
public class ContadorArbol {
    //private BinaryTree<Integer> arbol;

    public List<Integer> numerosParesInOrden(BinaryTree<Integer> ar, List<Integer> lista){
        if (ar.hasLeftChild()){
            numerosParesInOrden(ar.getLeftChild(), lista);
        }
        if (ar.getData() % 2 == 0){
            lista.add(ar.getData());
        }
        if (ar.hasRightChild()){
            numerosParesInOrden(ar.getRightChild(), lista);
        }
        return lista;
    }

    public List<Integer> numerosParesPostOrden(BinaryTree<Integer> ar, List<Integer> lista){
        if (ar.hasLeftChild()){
            numerosParesPostOrden(ar.getLeftChild(), lista);
        }
        if (ar.hasRightChild()){
            numerosParesPostOrden(ar.getRightChild(), lista);
        }
        if (ar.getData() % 2 == 0){
            lista.add(ar.getData());
        }
        return lista;
    }
}
