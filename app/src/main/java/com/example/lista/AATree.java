package com.example.lista;

public class AATree {
    private AANode root;
    private static AANode node = new AANode();

    public AATree(){
        root = node;
    }

    public void insert(int num){
        root = insertion(num, root);
    }

    private AANode insertion(int num, AANode node1){
        if (node1 == null){
            node1 = new AANode(num, node, node);
        } else if (num < node1.getElement()){
            node1.setLeft(insertion(num, node1.getLeft()));
        } else if (num > node1.getElement()){
            node1.setRight(insertion(num, node1.getRight()));
        } else{
            return node1;
        }
        node1 = Skew(node1);
        node1 = Split(node1);
        return node1;
    }

    public AANode Skew(AANode node1){
        if (node1 == node){
            return node;
        } else if (node1.getLeft() == node){
            return node1;
        } else if (node1.getLeft().getLevel() == node1.getLevel()){
            AANode left = node1.getLeft();
            node1.setLeft(left.getRight());
            left.setRight(node1);
            return left;
        }
        else
            return node1;
    }

    public AANode Split(AANode node1){
        if (node1 == node){
            return node;
        } else if (node1.getRight() == node || node1.getRight().getRight() == node ) {
            return node1;
        } else if (node1.getLevel() == node1.getRight().getRight().getLevel()){
            AANode right = node1.getRight();
            node1.setRight(right.getLeft());
            right.setLeft(node1);
            right.setLevel(right.getLevel() + 1);
            return right;
        }
        else
            return node1;
    }
}
