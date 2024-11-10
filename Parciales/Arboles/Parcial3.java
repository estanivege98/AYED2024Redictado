package Parciales.Arboles;
// Parcial 2da fecha - 29/6/2024 - Tema 1
import TP2.BinaryTree.*;
public class Parcial3 {
    private BinaryTree<Integer> ab;

    public Parcial3(BinaryTree<Integer> ab){
        this.ab = ab;
    }

    public BinaryTree<Integer> nuevoTree(){
        if(ab.isEmpty()){
            return new BinaryTree<Integer>();
        }
        else{
            BinaryTree<Integer> abAux = new BinaryTree<Integer>(ab.getData());
            nuevoTreeAux(ab, abAux);
            return abAux;
        }
    }

    private BinaryTree<Integer> nuevoTreeAux(BinaryTree<Integer> arbol, BinaryTree<Integer> nuevoArbol){
        if(arbol.hasLeftChild()){
            BinaryTree<Integer> aux = new BinaryTree<Integer>(arbol.getLeftChild().getData() + arbol.getData());
            nuevoArbol.addLeftChild(aux);
        }
        if(arbol.hasRightChild()){
            BinaryTree<Integer> aux = new BinaryTree<Integer>(arbol.getRightChild().getData());
            nuevoArbol.addRightChild(aux);
        }
        if(arbol.hasLeftChild()){
            nuevoTreeAux(arbol.getLeftChild(), nuevoArbol.getLeftChild());
        }
        if(arbol.hasRightChild()){
            nuevoTreeAux(arbol.getRightChild(), nuevoArbol.getRightChild());
        }
        return nuevoArbol;
    }

}
