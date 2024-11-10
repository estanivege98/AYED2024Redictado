package Parciales.Arboles;

import TP2.BinaryTree.BinaryTree;

public class Parcial3Test {
    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(1);
        BinaryTree<Integer> a = new BinaryTree<Integer>(2);
        BinaryTree<Integer> b = new BinaryTree<Integer>(3);
        BinaryTree<Integer> c = new BinaryTree<Integer>(4);
        BinaryTree<Integer> d = new BinaryTree<Integer>(5);
        BinaryTree<Integer> e = new BinaryTree<Integer>(6);
        BinaryTree<Integer> f = new BinaryTree<Integer>(7);

        ab.addLeftChild(a);
        ab.addRightChild(b);

        a.addLeftChild(c);

        b.addLeftChild(d);
        b.addRightChild(e);

        d.addLeftChild(f);

        ab.entreNiveles(0,4);
        System.out.printf("Arbol nuevo\n");
        Parcial3 p = new Parcial3(ab);
        BinaryTree<Integer> nuevo = p.nuevoTree();
        nuevo.entreNiveles(0,4);
    }
}
