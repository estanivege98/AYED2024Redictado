package Parciales.Arboles.ParcialPrueba;

import TP2.BinaryTree.BinaryTree;

public class ParcialNivelAbol {
    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(2));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
        ab.addRightChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(9));
        ab.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(4));

        NivelArbol a = new NivelArbol(ab);

        //Es necesario .getData(), porque si retorna null, se hace un .toString() a un objeto nulo, tirando nullPointerException.

        System.out.println(a.minEnArbol(1).getData());
        System.out.println(a.minEnArbol(2).getData());
        System.out.println(a.minEnArbol(3).getData());

        System.out.println("");

//        System.out.println(a.minEnNivelABSinNull(1).getData());
//        System.out.println(a.minEnNivelABSinNull(2).getData());
//        System.out.println(a.minEnNivelABSinNull(3).getData());
    }
}
