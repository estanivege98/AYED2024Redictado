package Parciales.Arboles.Parcial1562024;
import tp3.ejercicio1.*;
import TP2.Cola.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Parcial {
    private GeneralTree<Integer> arbol;

    public Parcial(GeneralTree<Integer> arbol){
        this.arbol = arbol;
    }

    public List<Integer> nivel(int num){
        List<Integer> lista = new ArrayList<Integer>();
        if(!this.arbol.isEmpty()){
            nivelAux(this.arbol, num, lista);
        }
        return lista;
    }

    private void nivelAux(GeneralTree<Integer> arbol, int num, List<Integer> lista){
        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        while(!cola.isEmpty()){
            GeneralTree<Integer> abAux = cola.dequeue();
            if(abAux != null){
                for(GeneralTree<Integer> hijo : abAux.getChildren()){
                    if(hijo.hasChildren()){
                        if(hijo.getChildren().size() >= num){
                            lista.add(hijo.getData());

                        }
                    }
                    cola.enqueue(hijo);
                }
            }
            else if(!cola.isEmpty()){
                cola.enqueue(null);
            }

        }

        //lista.remove(lista.size() -1);

    }

    public static void main (String[] args){
        List<GeneralTree<Integer>> hijos1 = new LinkedList<GeneralTree<Integer>>();
        hijos1.add(new GeneralTree<Integer>(-6));
        hijos1.add(new GeneralTree<Integer>(2));
        hijos1.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> arbol = new GeneralTree<Integer>(5, hijos1);

        List<GeneralTree<Integer>> hijos2 = new LinkedList<GeneralTree<Integer>>();
        hijos2.add(new GeneralTree<Integer>(28));
        hijos2.add(new GeneralTree<Integer>(55));
        hijos2.add(new GeneralTree<Integer>(18));
        GeneralTree<Integer> arbol2 = new GeneralTree<Integer>(22, hijos2);

        List<GeneralTree<Integer>> hijos3 = new LinkedList<GeneralTree<Integer>>();
        hijos3.add(new GeneralTree<Integer>(4));
        hijos3.add(new GeneralTree<Integer>(2));
        hijos3.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> arbol3 = new GeneralTree<Integer>(19, hijos3);

        List<GeneralTree<Integer>> hijos4 = new LinkedList<GeneralTree<Integer>>();
        hijos4.add(arbol);
        hijos4.add(arbol2);
        GeneralTree<Integer> arbol4 = new GeneralTree<Integer>(8, hijos4);

        List<GeneralTree<Integer>> hijos5 = new LinkedList<GeneralTree<Integer>>();
        hijos5.add(arbol3);
        GeneralTree<Integer> arbol5 = new GeneralTree<Integer>(-5, hijos5);

        List<GeneralTree<Integer>> hijos6 = new LinkedList<GeneralTree<Integer>>();
        hijos6.add(arbol4);
        hijos6.add(arbol5);
        GeneralTree<Integer> arbol6 = new GeneralTree<Integer>(10, hijos6);

        Parcial p = new Parcial(arbol6);
        System.out.println(p.nivel(1));
    }
}
