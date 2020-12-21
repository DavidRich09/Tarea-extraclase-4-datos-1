package com.example.lista;

import java.util.ArrayList;
import java.util.List;

public class AATree {
    private AANode root;
    public String forma = "";
    private static AANode node = new AANode();

    public AATree(){
        root = node;
    }

    public void insert(int num){
        root = insertion(num, root);
    }

    private AANode insertion(int num, AANode node1){
        if (node1 == node){
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

    public String print(AANode root)
    {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<AANode> level = new ArrayList<AANode>();
        List<AANode> next = new ArrayList<AANode>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (AANode n : level) {
                if (n == node) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    int datoint = n.element;
                    String aa = String.valueOf(datoint);
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<AANode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);
                    forma+=c;

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                            forma += " ";
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                            forma += j % 2 == 0 ? " " : "─";
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        forma+=j % 2 == 0 ? "┌" : "┐";
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                            forma+=j % 2 == 0 ? "─" : " ";
                        }
                    }
                }
                System.out.println();
                forma += "\n";
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                    forma += " ";
                }
                System.out.print(f);
                forma+= f;
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                    forma+= " ";
                }
            }
            System.out.println();
            forma += "\n";

            perpiece /= 2;
        }

        return forma;
    }

    public AANode getRoot(){
        return root;
    }

    public void ResetString(){
        forma = "";
    }
}
