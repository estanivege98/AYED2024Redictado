package TP2.BinaryTree;
import java.util.*;
public class Programa {
    public static void main(String[] args){
        System.out.println("Test metodos Arboles");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        //ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        System.out.println(ab.contarHojas());
        System.out.println("Arbol original: ");
        ab.imprimirArbol();
        System.out.println("");
        System.out.println("Arbol espejo: ");
        //BinaryTree<Integer> abEspejo = ab.espejo();
        //abEspejo.imprimirArbol();
        ab.espejo2();
        ab.imprimirArbol();
        System.out.println("Impresion Arbol por niveles 0 y 2");
        ab.entreNiveles(0, 2);
    }
}
