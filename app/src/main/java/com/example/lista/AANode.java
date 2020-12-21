package com.example.lista;

public class AANode {

    public AANode left,right;
    public int element, level;

    public AANode(){
        this.element = 0;
        this.left = this;
        this.right = this;
        this.level = 0;
    }

    public AANode(int num, AANode left, AANode right){
        this.element = num;
        this.left = left;
        this.right = right;
        this.level = 1;
    }

    public AANode(int num){
        this(num, null, null);
    }

    public int getElement() {
        return element;
    }

    public void setLeft(AANode left) {
        this.left = left;
    }

    public void setRight(AANode right) {
        this.right = right;
    }

    public AANode getLeft() {
        return left;
    }

    public AANode getRight() {
        return right;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
