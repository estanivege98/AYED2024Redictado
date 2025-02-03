package Parciales.Arboles.Parcial7122024;

import tp3.ejercicio1.GeneralTree;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.MAX_VALUE;

public class Estrategia {

    public List<Compuesto> mejorEstrategia(GeneralTree<Compuesto> arbol){
        List<Compuesto> camino = new ArrayList<Compuesto>();
        List<Compuesto> mejorCamino = new ArrayList<Compuesto>();
        if(!arbol.isEmpty()){
            estrategiaHelper(arbol, camino, mejorCamino);
        }
        System.out.println("Mejor camino: " + mejorCamino.toString());
        return mejorCamino;

    }

    private double calculoCamino(List<Compuesto> camino){
        double total = 0;
        if(camino.isEmpty()){
            total = MAX_VALUE;
        }
        else{
            for(Compuesto compuesto : camino){
                total += (compuesto.getVueltas() * compuesto.tipoNeumatico()) + 10;
            }
        }
        return total - 10;
    }

    private void estrategiaHelper(GeneralTree<Compuesto> arbol, List<Compuesto> camino, List<Compuesto> mejorCamino){
        if(arbol.hasChildren()){
            for(GeneralTree<Compuesto> h : arbol.getChildren()){
                camino.add(h.getData());
                estrategiaHelper(h, camino, mejorCamino);
            }
        }
        else{
            double caminoActual = calculoCamino(camino);
            double mejorCaminoActual = calculoCamino(mejorCamino);
            if(caminoActual < mejorCaminoActual){
                mejorCamino.clear();
                mejorCamino.addAll(new ArrayList<Compuesto>(camino));
            }
        }
        if(camino.size() > 0){
            camino.remove(camino.size() - 1);
        }


    }
}
