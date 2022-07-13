package com.java.binarytree;

import java.util.*;

public class ZigzagTraversal {
    static ArrayList<ArrayList<Integer>> zigzagTraversal(Node root){
            Queue<Node> queue = new LinkedList<>();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            if(root == null) return list;

            queue.offer(root);
            boolean flag = true;

            while(!queue.isEmpty()){

                int level = queue.size();
                ArrayList<Integer> subList = new ArrayList<>(level);
                //iterate over all the element at this level//
                for(int i = 0; i < level; i++){
                    if(queue.peek().left != null) queue.offer(queue.peek().left);
                    if(queue.peek().right != null) queue.offer(queue.peek().right);

                    if(flag) subList.add(queue.poll().data);
                    else subList.add(0, queue.poll().data);
                }
                flag = !flag;
                list.add(subList);
            }
        return list;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ArrayList<ArrayList<Integer>> answer = zigzagTraversal(root);

        System.out.println("Zig-Zag traversal of Binary Tree ");
        for(int i= 0; i< answer.size(); i++){
            for(int j = 0; j < answer.get(i).size(); j++){
                System.out.print(answer.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
