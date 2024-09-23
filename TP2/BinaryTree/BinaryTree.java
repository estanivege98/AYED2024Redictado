package TP2.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
	    int leftC = 0;
		int rightC = 0;
		if(this.isEmpty()){
			return 0;
		}
		else if (this.isLeaf()){
			return 1;
		}
		else{
			if(this.hasLeftChild()){
				leftC = this.getLeftChild().contarHojas();
			}
			if(this.hasRightChild()){
				rightC = this.getRightChild().contarHojas();
			}
			return leftC + rightC;
		}
	}
		
		
    	 
    public BinaryTree<T> espejo(){
	    BinaryTree<T> arbolEspejo = new BinaryTree<T>(data);
	    if(this.hasLeftChild()){
			arbolEspejo.addRightChild(this.getLeftChild().espejo());
	    }   		  
		if(this.hasRightChild()){
			arbolEspejo.addLeftChild(this.getRightChild().espejo());
		}
 	    return arbolEspejo;
    }

	public void espejo2(){
		BinaryTree<T> aux;
		aux = this.getRightChild();
		this.addRightChild(this.getLeftChild());
		this.addLeftChild(aux);
		if(this.hasLeftChild()){
			this.getLeftChild().espejo2();
		}
		if(this.hasRightChild()){
			this.getRightChild().espejo2();
		}
		
	}

	// 0<=n<=m
	public void entreNiveles(int n, int m) {
		if (this.isEmpty() || n < 0 || m < n) return;
		// Creo una cola vacia y añado el arbol
		Queue<BinaryTree<T>> cola = new LinkedList<BinaryTree<T>>();
		cola.add(this);
		// Puntero al nodo actual
		BinaryTree<T> actual = null;
		// Mantiene el nivel del nodo actual
		int nivel = 0;
		while (!cola.isEmpty()) {
			// Incremento el nivel antes de procesar los nodos en ese nivel
			nivel++;
			// Calculo el numero de nodos del nivel
			int tamanio = cola.size();
			// Proceso cada nodo del nivel actual y los guardo en la cola
			while (tamanio > 0) {
				actual = cola.poll();
				// Imprimo el nodo si el nivel esta entre los argumentos dados
				if (nivel >= n && nivel <= m) {
					System.out.print(actual.getData() + " ");
				}
	
				if (actual.getLeftChild() != null) {
					cola.add(actual.getLeftChild());
				}
	
				if (actual.getRightChild() != null) {
					cola.add(actual.getRightChild());
				}
				tamanio--;
			}
			if (nivel >= n && nivel <= m) {
				System.out.println("");
			}
		}
	}
   public void imprimirArbol() {
   		if(this.hasLeftChild()) this.getLeftChild().imprimirArbol();
		System.out.print(this.getData() + " ");
		if(this.hasRightChild()) this.getRightChild().imprimirArbol();
	}
		
}

