package Parciales.Arboles;

import tp3.ejercicio1.GeneralTree;
import java.util.LinkedList;
import java.util.List;

public class Parcial1Test {
    public static void main(String[] args) {
        //GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);

        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(-6));
        children2.add(new GeneralTree<Integer>(2));
        children2.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(5, children2);

        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(28));
        children3.add(new GeneralTree<Integer>(55));
        children3.add(new GeneralTree<Integer>(18));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(22, children3);

        List<GeneralTree<Integer>> children4 = new LinkedList<GeneralTree<Integer>>();
        children4.add(new GeneralTree<Integer>(4));
        children4.add(new GeneralTree<Integer>(2));
        children4.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> a4 = new GeneralTree<Integer>(19, children4);


        List<GeneralTree<Integer>> childen5 = new LinkedList<GeneralTree<Integer>>();
        childen5.add(a2);
        childen5.add(a3);
        GeneralTree<Integer> a5 = new GeneralTree<Integer>(8, childen5);

        List<GeneralTree<Integer>> childen6 = new LinkedList<GeneralTree<Integer>>();
        childen6.add(a4);
        GeneralTree<Integer> a6 = new GeneralTree<Integer>(-5, childen6);

        List<GeneralTree<Integer>> childen7 = new LinkedList<GeneralTree<Integer>>();
        childen7.add(a5);
        childen7.add(a6);
        GeneralTree<Integer> a = new GeneralTree<Integer>(10, childen7);


        Parcial1 recorrido = new Parcial1(a);

        List <Integer> lista = recorrido.nivel(3);
        for (Integer dato : lista) {
            System.out.println(dato);
        }
    }
}

