package Parciales.Arboles.Parcial2442023;
import java.util.List;
import TP2.BinaryTree.*;
public class Parcial {
    private List<BinaryTree<Integer>> lista;
    private int cantPares;

    public Parcial(List<BinaryTree<Integer>> lista, int cantPares) {
        this.lista = lista;
        this.cantPares = cantPares;
    }

    public int getCantPares() {
        return cantPares;
    }

    public List<BinaryTree<Integer>> getLista() {
        return lista;
    }
}

