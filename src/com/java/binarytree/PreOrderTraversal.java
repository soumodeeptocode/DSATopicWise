package com.java.binarytree;

public class PreOrderTraversal {
    static void doPrintPreOrderTraversal(Node node){
        //base condition//
        if(node == null) return;

        System.out.println(node.data);
        doPrintPreOrderTraversal(node.left);
        doPrintPreOrderTraversal(node.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        doPrintPreOrderTraversal(root);
    }
}
