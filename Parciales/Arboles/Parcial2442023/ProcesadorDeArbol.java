package Parciales.Arboles.Parcial2442023;

import TP2.BinaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class ProcesadorDeArbol {
    public BinaryTree<Integer> ab;

    public ProcesadorDeArbol(BinaryTree<Integer> ab) {
        this.ab = ab;
    }

    public Parcial procesar() {
        int cant = 0;
        List<BinaryTree<Integer>> lista = new ArrayList<>();
        if(!this.ab.isEmpty()){
            cant = helper(lista, ab);
        }
        return new Parcial(lista, cant);
    }

    private int helper(List<BinaryTree<Integer>> lista, BinaryTree<Integer> ab ){
        int cant = 0;
        int aux = ab.getData();
        if (aux % 2 == 0){
            cant++;
            if(ab.hasLeftChild() && ab.hasRightChild()){
                lista.add(ab);
            }
        }

        if(ab.hasLeftChild()){
            cant += helper(lista, ab.getLeftChild());
        }
        if(ab.hasRightChild()){
            cant += helper(lista, ab.getRightChild());
        }
        return cant;
    }

    public static void main(String[] args){
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.addRightChild(new BinaryTree<Integer>(-5));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
        ab.getLeftChild().getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(9));
        ab.getLeftChild().getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(16));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(18));
        ab.getRightChild().getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(8));
        ab.getRightChild().getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(24));
        System.out.println("Entre niveles");
        ab.entreNiveles(0, 4);

        ProcesadorDeArbol p = new ProcesadorDeArbol(ab);
        Parcial parc = p.procesar();

        System.out.println("");

        System.out.println(parc.getLista());
        System.out.println(parc.getCantPares());
    }
}
