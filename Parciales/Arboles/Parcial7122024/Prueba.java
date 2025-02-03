package Parciales.Arboles.Parcial7122024;

import tp3.ejercicio1.GeneralTree;
import java.util.ArrayList;
import java.util.List;

public class Prueba {

    public static void main(String[] args){
        // Creo los nodos
        Compuesto nodo1 = new Compuesto("Soft", 10);
        Compuesto nodo3 = new Compuesto("Hard", 30);
        Compuesto nodo4 = new Compuesto("Hard", 20);
        Compuesto nodo6 = new Compuesto("Med", 15);
        Compuesto nodo8 = new Compuesto("Hard", 35);
        Compuesto nodo9 = new Compuesto("Soft", 15);
        Compuesto raiz = new Compuesto();

        // Creo el Arbol
        GeneralTree<Compuesto> arbol = new GeneralTree<Compuesto>(raiz);
        GeneralTree<Compuesto> nodoA1 = new GeneralTree<Compuesto>(nodo1);
        GeneralTree<Compuesto> nodoA2 = new GeneralTree<Compuesto>(nodo1);
        GeneralTree<Compuesto> nodoA3 = new GeneralTree<Compuesto>(nodo3);
        GeneralTree<Compuesto> nodoA4 = new GeneralTree<Compuesto>(nodo4);
        GeneralTree<Compuesto> nodoA5 = new GeneralTree<Compuesto>(nodo3);
        GeneralTree<Compuesto> nodoA6 = new GeneralTree<Compuesto>(nodo6);
        GeneralTree<Compuesto> nodoA7 = new GeneralTree<Compuesto>(nodo6);
        GeneralTree<Compuesto> nodoA8 = new GeneralTree<Compuesto>(nodo8);
        GeneralTree<Compuesto> nodoA9 = new GeneralTree<Compuesto>(nodo9);

        // Agrego los hijos
        arbol.addChild(nodoA1);
        arbol.addChild(nodoA4);
        arbol.addChild(nodoA8);

        nodoA1.addChild(nodoA2);
        nodoA2.addChild(nodoA5);

        nodoA4.addChild(nodoA3);

        nodoA4.addChild(nodoA6);
        nodoA6.addChild(nodoA7);

        nodoA8.addChild(nodoA9);

        // Llamo a la resolución
        Estrategia es = new Estrategia();
        System.out.println("Mejor estrategia: " + es.mejorEstrategia(arbol));

    }
}
