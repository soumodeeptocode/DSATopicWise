package com.java.binarytree;

public class CheckBST {

    private static boolean checkBST(Node node, int min, int max){
        //base condition//
        if(node == null) return true;
        if(node.data <= min || node.data >= max) return false;

       if(checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max)){
           return true;
       }
       return false;
    }

    public static boolean isValidBST(Node node){
        return checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        System.out.println("Is this a valid BST ? - "+isValidBST(root));
    }
}
