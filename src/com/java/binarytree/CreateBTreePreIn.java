package com.java.binarytree;

import java.util.HashMap;
import java.util.Map;

public class CreateBTreePreIn {
    static Node buildTree(int[] inOrder, int[] preOrder){
        if(inOrder == null || preOrder == null || inOrder.length != preOrder.length){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++){
            map.put(inOrder[i], i);
        }

        return buildTreeInPre(inOrder, 0, inOrder.length-1, preOrder, 0, preOrder.length-1, map);
    }

    private static Node buildTreeInPre(int[] inOrder, int is, int ie, int[] preOrder, int ps, int pe, Map<Integer, Integer> map){

        //base condition//
        if(ps > pe || is > ie) return null;

        Node root = new Node(preOrder[ps]);

        int rootIndex = map.get(preOrder[ps]);
        int numberLeftChild = rootIndex - is;

        root.left = buildTreeInPre(inOrder, is, rootIndex-1, preOrder, ps+1, ps+numberLeftChild, map);
        root.right = buildTreeInPre(inOrder, rootIndex+1, ie, preOrder, ps+numberLeftChild+1, pe, map);
//        root.left = leftChild;
//        root.right = rightChild;
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
        int preOrder[] = {40,50,20,60,30,10};

        Node node = buildTree(inOrder, preOrder);

        //doPrintInOrderTraversal(node);
    }
}

