package Parciales.Arboles;

import java.util.*;

/* Objeto que controla la lista y el corte en la clase Parcial4 */
public class ObjectoNodo {
    private List<Integer> num;
    private boolean corte;

    public ObjectoNodo(){
        num = new LinkedList<Integer>();
        corte = true;
    }

    public List<Integer> getNum(){
        return num;
    }

    public boolean getCorte(){
        return corte;
    }

    public void agregarLista(int num){
        this.num.add(num);
    }

    public void setCorte(){
        corte = false;
    }
}
