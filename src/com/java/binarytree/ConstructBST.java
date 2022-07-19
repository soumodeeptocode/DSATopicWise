package com.java.binarytree;

public class ConstructBST {

    public static Node bstFromPreOrder(int[] preOrder){
        return bstFromPreOrderRec(preOrder, Integer.MAX_VALUE, new int[]{0});
    }

    public static Node bstFromPreOrderRec(int[] preOrder, int bound, int[] i){
        if(i[0] == preOrder.length || preOrder[i[0]] > bound) return null;

        Node root = new Node(preOrder[i[0]++]);
        root.left = bstFromPreOrderRec(preOrder, root.data, i);
        root.right = bstFromPreOrderRec(preOrder, bound, i);
        return root;
    }

    static void doPrintInOrderTraversal(Node node){
        //base condition//
        if(node == null) return;

        doPrintInOrderTraversal(node.left);
        System.out.println(node.data);
        doPrintInOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        int preOrder[] = {8,5,1,7,10,12};



        Node root = bstFromPreOrder(preOrder);
        doPrintInOrderTraversal(root);

    }
}

