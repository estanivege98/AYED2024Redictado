package Parciales.Arboles;

import tp3.ejercicio1.GeneralTree;

import java.util.List;

public class Parcial4Test {

    public static void main (String[] args){
        GeneralTree<Integer> a = new GeneralTree<Integer>(10);
        GeneralTree<Integer> b = new GeneralTree<Integer>(8);
        GeneralTree<Integer> c = new GeneralTree<Integer>(42);
        GeneralTree<Integer> d = new GeneralTree<Integer>(-5);
        GeneralTree<Integer> e = new GeneralTree<Integer>(5);
        GeneralTree<Integer> f = new GeneralTree<Integer>(22);
        GeneralTree<Integer> g = new GeneralTree<Integer>(19);
        GeneralTree<Integer> h = new GeneralTree<Integer>(-9);
        GeneralTree<Integer> i = new GeneralTree<Integer>(-6);
        GeneralTree<Integer> j = new GeneralTree<Integer>(28);
        GeneralTree<Integer> k = new GeneralTree<Integer>(55);
        GeneralTree<Integer> m = new GeneralTree<Integer>(18);
        GeneralTree<Integer> n = new GeneralTree<Integer>(4);

        a.addChild(b);
        a.addChild(c);
        a.addChild(d);

        b.addChild(e);
        b.addChild(f);

        d.addChild(g);
        d.addChild(h);

        e.addChild(i);

        f.addChild(j);
        f.addChild(k);
        f.addChild(m);

        g.addChild(n);

        Parcial4 p = new Parcial4(a);
        List<Integer> lista = p.camino(3);
        for(Integer l : lista){
            System.out.println(l);
        }
    }
}
