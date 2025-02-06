package Parciales.Arboles.Parcial28102023;

import TP2.BinaryTree.*;
import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {
    public BinaryTree<Numeros> sumAndDif(BinaryTree<Integer> a){
        BinaryTree<Numeros> b = new BinaryTree<Numeros>();
        if(!a.isEmpty()){
            sumAndDifHelper(a, b, 0, 0);
        }
        return b;
    }

    private void sumAndDifHelper(BinaryTree<Integer> ar1, BinaryTree<Numeros> ar2, int suma, int padre){
        int actual = ar1.getData();
        Numeros n = new Numeros(actual + suma, actual - padre);
        ar2.setData(n);
        if(ar1.hasLeftChild()){
            ar2.addLeftChild(new BinaryTree<Numeros>());
            sumAndDifHelper(ar1.getLeftChild(), ar2.getLeftChild(), suma + actual, actual);
        }
        if(ar1.hasRightChild()){
            ar2.addRightChild(new BinaryTree<Numeros>());
            sumAndDifHelper(ar1.getRightChild(), ar2.getRightChild(), suma + actual, actual);
        }

    }

    public static void main(String[] args) {
        System.out.println("Test Ejercicio9");
        ParcialArboles parcialArb = new ParcialArboles();

        BinaryTree<Integer> ab = new BinaryTree<Integer>(20);
        ab.addLeftChild(new BinaryTree<Integer>(5));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(-5));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(10));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.addRightChild(new BinaryTree<Integer>(30));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(50));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(-9));
        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(6));

        ab.entreNiveles(0, 4);
        System.out.println();
        System.out.println("Nuevo arbol:");
        parcialArb.sumAndDif(ab).entreNiveles(0, 4);
    }
}
