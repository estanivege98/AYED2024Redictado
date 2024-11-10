package tp3.ejercicio1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import TP2.Cola.*;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}

	/* EJERCICIO 2 */

	public List<T> numerosImparesMayoresQuePreOrden(Integer n){
		List<T> lista = new ArrayList<T>();
		if(!this.isEmpty()){
			numerosImparesMayoresQuePreOrdenHelper(n, lista);
		}
		return lista;
	}
	private void numerosImparesMayoresQuePreOrdenHelper(Integer n, List<T> lista){
		if((Integer)this.getData() > n && (Integer)this.getData() % 2 != 0){
			lista.add(this.getData());
		}
		for(GeneralTree<T> hijo : this.getChildren()){
			hijo.numerosImparesMayoresQuePreOrdenHelper(n, lista);
		}
	}

	public List<T> numerosImparesMayoresQueInOrden(Integer n){
		List<T> lista = new ArrayList<T>();
		if(!this.isEmpty()){
			numerosImparesMayoresQueInOrdenHelper(n, lista);
		}
		return lista;
	}
	private void numerosImparesMayoresQueInOrdenHelper(Integer n, List<T> lista){
		List<GeneralTree<T>> hijos = this.getChildren();
		if(this.hasChildren()) {
			hijos.get(0).numerosImparesMayoresQueInOrdenHelper(n, lista);
		}
		int dato = (Integer) this.getData();
		if (dato > n && dato % 2 != 0) {
			lista.add(this.getData());
		}
		for (int i = 0; i< hijos.size(); i++){
			hijos.get(i).numerosImparesMayoresQueInOrdenHelper(n, lista);
		}
	}

	public List<T> numerosImparesMayoresQuePostOrden(Integer n){
		List<T> lista = new ArrayList<T>();
		if(!this.isEmpty()){
			numerosImparesMayoresQuePostOrdenHelper(n, lista);
		}
		return lista;
	}
	private void numerosImparesMayoresQuePostOrdenHelper(Integer n, List<T> lista){
		for(GeneralTree<T> hijo : this.getChildren()){
			hijo.numerosImparesMayoresQuePostOrdenHelper(n, lista);
		}
		if((Integer)this.getData() > n && (Integer)this.getData() % 2 != 0){
			lista.add(this.getData());
		}
	}

	public List<T> numerosImparesMayoresQuePorNivel(Integer n){
		List<T> lista = new ArrayList<T>();
		GeneralTree<T> abAux;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		while(!cola.isEmpty()){
			abAux = cola.dequeue();
			if (abAux != null) {
				if((Integer)abAux.getData() > n && (Integer)abAux.getData() % 2 != 0){
					lista.add(abAux.getData());
				}
				for(GeneralTree<T> hijo : abAux.getChildren()){
					cola.enqueue(hijo);
				}
			}
		}
		return lista;
	}

	/* EJERCICIO 3 */

	public int altura() {
		if (this.isEmpty())
			return 0;
		else return alturaHelper(this);
	}
	private int alturaHelper(GeneralTree<T> arbol) {
		if (arbol.isLeaf())
			return 1;
		else {
			int max = -1;
			for (GeneralTree<T> hijo : arbol.getChildren()) {
				int alturaHijo = alturaHelper(hijo);
				if (alturaHijo > max)
					max = alturaHijo;
			}
			return max + 1;
		}
	}

	public int nivel(T dato) {
		if (this.isEmpty())
			return 0;
		else return (!this.isLeaf() ? nivelHelper(this, dato, 0) : 1);
	}
	private int nivelHelper(GeneralTree<T> arbol, T dato, int nivel) {
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			GeneralTree<T> arbolAux = cola.dequeue();
			if (arbolAux != null) {
				if (arbolAux.getData().equals(dato))
					return nivel;
				for (GeneralTree<T> hijo : arbolAux.getChildren())
					cola.enqueue(hijo);
			} else {
				nivel++;
				if (!cola.isEmpty())
					cola.enqueue(null);
			}
		}
		return -1; // si el dato no se encuentra en el arbol
	}

	public int ancho() {
		if (this.isEmpty()) {
			return 0;
		}
		else return (!this.isLeaf() ? anchoHelper(this) : 1);
	}
	private int anchoHelper(GeneralTree<T> arbol){
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		int ancho = 0;
		int anchoAux = 0;
		while (!cola.isEmpty()) {
			GeneralTree<T> arbolAux = cola.dequeue();
			if (arbolAux != null) {
				anchoAux++;
				for (GeneralTree<T> hijo : arbolAux.getChildren())
					cola.enqueue(hijo);
			} else {
				if (anchoAux > ancho)
					ancho = anchoAux;
				anchoAux = 0;
				if (!cola.isEmpty())
					cola.enqueue(null);
			}
		}
		return ancho;
	}

	/* EJERCICIO 5 */
	/* Se dice que un nodo n es ancestro de un nodo m si existe un camino desde n a m. Implemente un
 	método en la clase GeneralTree con la siguiente firma: public boolean esAncestro(T a, T b): devuelve true si el valor “a” es ancestro del valor “b”. */

	public boolean esAncestro(T a, T b) {
		if (this.isEmpty())
			return false;
		else return esAncestroHelper(this, a, b);
	}
	private boolean esAncestroHelper(GeneralTree<T> arbol, T a, T b) {
		if (arbol.getData().equals(a)) {
			return contains(arbol, b);
		}
		for (GeneralTree<T> hijo : arbol.getChildren()) {
			if (esAncestroHelper(hijo, a, b)) {
				return true;
			}
		}
		return false;
	}
	private boolean contains(GeneralTree<T> arbol, T b){
		if (arbol.getData().equals(b)){
			return true;
		}
		for(GeneralTree<T> hijo : arbol.getChildren()){
			if(contains(hijo, b)){
				return true;
			}
		}
		return false;
	}

}