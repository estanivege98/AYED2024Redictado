package TP2.ejercicio4;
import java.util.*;
import TP2.BinaryTree.BinaryTree;
public class RedBinariaLlena {
    private int retardoReenvioHelper(BinaryTree<Integer> ab, int retardo){
        if (ab.isLeaf()){
            return ab.getData() + retardo;
        }
        int retardoIzq = retardoReenvioHelper(ab.getLeftChild(), retardo + ab.getData());
        int retardoDer = retardoReenvioHelper(ab.getRightChild(), retardo + ab.getData());

        return Math.max(retardoIzq, retardoDer);
    }
    public int retardoReenvio(BinaryTree<Integer> ab){
        return retardoReenvioHelper(ab, 0);
    }

    public static void main(String[] args){
        /* Quiero armar el siguiente arbol */
        //       10
        //     /   \
        //    5     8
        //   / \   / \
        //  20  4 14 37
        BinaryTree<Integer> num10 = new BinaryTree<Integer>(10);
        BinaryTree<Integer> num5 = new BinaryTree<Integer>(5);
        BinaryTree<Integer> num8 = new BinaryTree<Integer>(8);
        BinaryTree<Integer> num20 = new BinaryTree<Integer>(20);
        BinaryTree<Integer> num14 = new BinaryTree<Integer>(14);
        BinaryTree<Integer> num37 = new BinaryTree<Integer>(37);
        BinaryTree<Integer> num4 = new BinaryTree<Integer>(4);

        num10.addLeftChild(num5);
        num10.addRightChild(num8);
        num5.addLeftChild(num20);
        num5.addRightChild(num4);
        num8.addLeftChild(num14);
        num8.addRightChild(num37);

        RedBinariaLlena red = new RedBinariaLlena();
        System.out.println(red.retardoReenvio(num10));
    }
}


