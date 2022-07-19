package com.java.binarytree;

import java.util.*;

public class CreateBTree {

    static Node buildTree(int[] inOrder, int[] postOrder){
        if(inOrder == null || postOrder == null || inOrder.length != postOrder.length){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++){
                    map.put(inOrder[i], i);
        }
        return buildTreeInPost(inOrder, 0, inOrder.length-1, postOrder, 0, postOrder.length-1, map);
    }

    private static Node buildTreeInPost(int[] inOrder, int is, int ie, int[] postOrder, int ps, int pe, Map<Integer, Integer> map){

        //base condition//
        if(ps > pe || is > ie) return null;

        Node root = new Node(postOrder[pe]);

        int rootIndex = map.get(postOrder[pe]);

        Node leftChild = buildTreeInPost(inOrder, is, rootIndex-1, postOrder, ps, ps+rootIndex-is-1, map);
        Node rightChild = buildTreeInPost(inOrder, rootIndex+1, ie, postOrder, ps+rootIndex-is, pe-1, map);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    static void doPrintInOrderTraversal(Node node){
        //base condition//
        if(node == null) return;

        doPrintInOrderTraversal(node.left);
        System.out.print(node.data);
        doPrintInOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        int inOrder[] = {40,20,50,10,60,30};
        int postOrder[] = {40,50,20,60,30,10};

        Node node = buildTree(inOrder, postOrder);

        doPrintInOrderTraversal(node);
    }
}
