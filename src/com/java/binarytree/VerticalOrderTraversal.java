package com.java.binarytree;

import java.util.*;


class Tuple{
    Node node;
    int row;
    int col;
    public Tuple(Node _node, int _row, int _col){
        this.node = _node;
        this.row = _row;
        this.col = _col;
    }
}

public class VerticalOrderTraversal {
    static List<List<Integer>> findVertical(Node node){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(node, 0, 0));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            Node curr_node = tuple.node; //node type extraction from tuple type//

            int x = tuple.row; //getting vertical value from tuple type//
            int y = tuple.col; //getting height value from tuple type//

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }

            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(curr_node.data);

            if(curr_node.left != null){
                q.offer(new Tuple(curr_node.left, x-1, y+1));
            }
            if(curr_node.right != null){
                q.offer(new Tuple(curr_node.right, x+1, y+1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: ys.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size() -1).add(nodes.poll());
                }
            }
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

        List<List<Integer>> list = findVertical(root);

        for(List<Integer> it: list){
            for(int data: it){
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }
}
