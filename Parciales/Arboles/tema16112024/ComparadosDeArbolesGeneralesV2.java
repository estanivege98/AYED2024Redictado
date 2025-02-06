package Parciales.Arboles.tema16112024;

import tp3.ejercicio1.GeneralTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ComparadosDeArbolesGeneralesV2 {

    public boolean esInferiorProfundo(GeneralTree<Integer> arbol1, GeneralTree<Integer> arbol2){
        if(arbol1.isEmpty() || arbol2.isEmpty()){
            return false;
        }
        if(!arbol1.isEmpty() && arbol2.isEmpty()){
            return true;
        }
        else{
            return esInferiorProfundoHelper(arbol1, arbol2);
        }
    }

    private boolean esInferiorProfundoHelper(GeneralTree<Integer> ar1, GeneralTree<Integer> ar2){
        boolean ok = ar1.getData() < ar2.getData(); // Condicion 1
        /*if(!ar1.hasChildren() && ar2.hasChildren()){
            return false; // Condicion c1
        }*/
        if(!ar1.isLeaf() && ar2.isLeaf()){
            ok = false; // Condicion c2
        }
        if(ok && ar1.hasChildren() && ar2.hasChildren()){
            List<GeneralTree<Integer>> hijos1 = ar1.getChildren();
            List<GeneralTree<Integer>> hijos2 = ar2.getChildren();
            int sumaAr1 = calcular(ar1.getChildren());
            int sumaAr2 = calcular(ar2.getChildren());
            if(sumaAr1 > sumaAr2){
                ok = false; // Condicion 2a
            }
            if(ok){
                Iterator<GeneralTree<Integer>> it1 = hijos1.iterator();
                Iterator<GeneralTree<Integer>> it2 = hijos2.iterator();
                while(ok && it1.hasNext() && it2.hasNext()){
                    ok = esInferiorProfundoHelper(it1.next(), it2.next());
                }
            }
        }
        return ok;
    }

    private int calcular(List<GeneralTree<Integer>> hijos){
        int suma = 0;
        for(GeneralTree<Integer> h : hijos){
            suma += h.getData();
        }
        return suma;
    }

    public static void main(String[] args){

        /* ARBOL 1 */

        List<GeneralTree<Integer>> hijosA2 = new LinkedList<GeneralTree<Integer>>();
        hijosA2.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> A2 = new GeneralTree<Integer>(4, hijosA2);

        List<GeneralTree<Integer>> hijosA1 = new LinkedList<GeneralTree<Integer>>();
        hijosA1.add(A2);
        hijosA1.add(new GeneralTree<Integer>(3));
        hijosA1.add(new GeneralTree<Integer>(2));
        GeneralTree<Integer> A1 = new GeneralTree<Integer>(10, hijosA1);

        /* ARBOL 2 */

        List<GeneralTree<Integer>> hijosB2 = new LinkedList<GeneralTree<Integer>>();
        hijosB2.add(new GeneralTree<Integer>(2));
        hijosB2.add(new GeneralTree<Integer>(-2));
        hijosB2.add(new GeneralTree<Integer>(6));
        GeneralTree<Integer> B2 = new GeneralTree<Integer>(8, hijosB2);

        List<GeneralTree<Integer>> hijosB3 = new LinkedList<GeneralTree<Integer>>();
        hijosB3.add(new GeneralTree<Integer>(7));
        GeneralTree<Integer> B3 = new GeneralTree<Integer>(5, hijosB3);

        List<GeneralTree<Integer>> hijosB1 = new LinkedList<GeneralTree<Integer>>();
        hijosB1.add(B2);
        hijosB1.add(B3);
        GeneralTree<Integer> B1 = new GeneralTree<Integer>(15, hijosB1);

        /* Prueba */

        ComparadosDeArbolesGeneralesV2 comparador = new ComparadosDeArbolesGeneralesV2();
        System.out.println(comparador.esInferiorProfundo(A1, B1)); // Deberia dar true
    }

}
