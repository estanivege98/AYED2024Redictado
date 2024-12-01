/*Sea un árbol general en donde cada nodo tiene un valor numérico, usted debe devolver el camino
determinado por el valor que posee cada nodo. Es decir, el camino comienza en el nodo raíz, luego
debe seguir por el hijo que se encuentra en la posición indicada por el valor en el nodo raíz y así debe
seguir hasta llegar a su hoja. Para el siguiente árbol, el camino a retornar es GEC*/

package Parciales.Arboles;
import java.util.*;
import tp3.ejercicio1.GeneralTree;

public class Parcial5{
    public GeneralTree<ObPar5> arbol;

    public Parcial5(GeneralTree<ObPar5> arbol){
        this.arbol = arbol;
    }

    public List<String> camino(){
        ObPar5 objeto = new ObPar5();
        if(arbol.isEmpty()){
            return new LinkedList<String>();
        }
        else{
            List<String> lista = new LinkedList<String>();
            caminoAux(arbol, objeto, lista);
            return lista;    
        }

    }

    private void caminoAux(GeneralTree<ObPar5> ab, ObPar5 objeto, List<String> lista){
        lista.add(ab.getData().getNombre());
        if(ab.isLeaf()){
            return;
        }

        int contador = 1;
        int posición = ab.getData().getValor(); // valor que posee el nodo
        if(ab.getChildren().size() >= posición){
            for(GeneralTree<ObPar5> hijo : ab.getChildren()){
                if(contador == posición){
                    caminoAux(hijo, objeto, lista);
                }
                contador++;
            }
        }

    }

    public static void main(String[] args) {
    // Crear los nodos
    ObPar5 g = new ObPar5();
    ObPar5 e = new ObPar5();
    ObPar5 f = new ObPar5();
    ObPar5 j = new ObPar5();
    ObPar5 a = new ObPar5();
    ObPar5 b = new ObPar5();
    ObPar5 c = new ObPar5();
    g.setNombre("G");
    g.setValor(1);
    e.setNombre("E");
    e.setValor(3);
    f.setNombre("F");
    f.setValor(2);
    j.setNombre("J");
    j.setValor(5);
    a.setNombre("A");
    a.setValor(7);
    b.setNombre("B");
    b.setValor(4);
    c.setNombre("C");
    c.setValor(6);

    // Crear el árbol
    GeneralTree<ObPar5> raiz = new GeneralTree<>(g);
    GeneralTree<ObPar5> nodoE = new GeneralTree<>(e);
    GeneralTree<ObPar5> nodoF = new GeneralTree<>(f);
    GeneralTree<ObPar5> nodoJ = new GeneralTree<>(j);
    GeneralTree<ObPar5> nodoA = new GeneralTree<>(a);
    GeneralTree<ObPar5> nodoB = new GeneralTree<>(b);
    GeneralTree<ObPar5> nodoC = new GeneralTree<>(c);


    raiz.addChild(nodoE);
    raiz.addChild(nodoF);
    raiz.addChild(nodoJ);

    nodoE.addChild(nodoA);
    nodoE.addChild(nodoB);
    nodoE.addChild(nodoC);

    // Crear el objeto Parcial5
    Parcial5 parcial = new Parcial5(raiz);

    // Obtener y mostrar el camino
    List<String> camino = parcial.camino();
    System.out.println(camino); // Salida esperada: [G, E, C]
}
}