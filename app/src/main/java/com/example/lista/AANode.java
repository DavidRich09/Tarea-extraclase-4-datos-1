package com.example.lista;

/**
 * Clase para los nodos del arbol AA
 */
public class AANode {

    public AANode left,right;
    public int element, level;

    /**
     * Primer constructor de la clase
     */
    public AANode(){
        this.element = 0;
        this.left = this;
        this.right = this;
        this.level = 0;
    }

    /**
     * Segundo constructor de la clase que recibe un numero y los nodos hijos.
     * @param num
     * @param left
     * @param right
     */
    public AANode(int num, AANode left, AANode right){
        this.element = num;
        this.left = left;
        this.right = right;
        this.level = 1;
    }

    /**
     * Tercer constructor que solamente recibe el numero
     * @param num
     */
    public AANode(int num){
        this(num, null, null);
    }

    /**
     * Obtener el elemento
     * @return int
     */
    public int getElement() {
        return element;
    }

    /**
     * Asigna el hijo izquierdo
     * @param left
     */
    public void setLeft(AANode left) {
        this.left = left;
    }

    /**
     * Asigna el hijo derecho
     * @param right
     */
    public void setRight(AANode right) {
        this.right = right;
    }

    /**
     * Obtiene el hijo izquierdo
     * @return
     */
    public AANode getLeft() {
        return left;
    }

    /**
     * Obtiene el hijo derecho
     * @return
     */
    public AANode getRight() {
        return right;
    }

    /**
     * Obtiene el nivel del nodo dentro del arbol
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * Asigna un valor al nivel del nodo dentro del arbol
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }
}
