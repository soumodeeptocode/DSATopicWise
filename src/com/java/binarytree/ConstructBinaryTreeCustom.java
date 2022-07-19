package com.java.binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConstructBinaryTreeCustom {
    public static Node constructBST(int[] levelOrder, int index){
        Node node = null;
        if(index < levelOrder.length && levelOrder[index] != -1){
                Node temp = new Node(levelOrder[index]);
                node = temp;
                node.left = constructBST(levelOrder, 2*index+1);
                node.right = constructBST(levelOrder, 2*index+2);
        }
        return node;
    }
    static void doPrintPostOrderTraversal(Node node){
        //base condition//
        if(node == null) return;

        doPrintPostOrderTraversal(node.left);
        doPrintPostOrderTraversal(node.right);
        System.out.println(node.data);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of nodes :: ");
        int n = Integer.parseInt(br.readLine());
        int[] levelOrder = new int[2*n+1];
        int i = 0;
        levelOrder[i] = 1;

        while(i < n){
            String[] input = br.readLine().split(" ");
            levelOrder[2*i+1] = Integer.parseInt(input[0]);
            levelOrder[2*i+2] = Integer.parseInt(input[1]);
            i++;
        }

        Node root = constructBST(levelOrder, 0);
        doPrintPostOrderTraversal(root);
    }
}
