package com.java.binarytree;

public class LevelOrderTraversal {
    private static int findHeightOfTree(Node node){
        if(node == null) return -1;

        return Math.max(findHeightOfTree(node.left), findHeightOfTree(node.right)) + 1;
    }
    static void doPrintLevelOrderTraversal(Node node){
        //base condition//
        if(node == null) return;

        int height = findHeightOfTree(node); //2
        int level = height + 1; // 3

        for(int i = 1; i <= level; i++){
            doPrintElementsAtLevelOrder(node, i);
            System.out.println();
        }
    }

    private static void doPrintElementsAtLevelOrder(Node node, int level){
        if(node == null) return;

        if(level == 1){
            System.out.print(node.data + " ");
            return;
        }

        doPrintElementsAtLevelOrder(node.left, level-1);
        doPrintElementsAtLevelOrder(node.right, level-1);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        doPrintLevelOrderTraversal(root);
    }
}

