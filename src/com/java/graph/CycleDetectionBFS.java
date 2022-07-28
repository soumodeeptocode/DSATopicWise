package com.java.graph;

import java.util.*;

class CycleNode{
    int curr_Node;
    int parent_Node;
    CycleNode(int curr_Node, int parent_Node){
        this.curr_Node = curr_Node;
        this.parent_Node = parent_Node;
    }
}

public class CycleDetectionBFS {

    static boolean checkForCycle(List<List<Integer>> adj, int value, boolean[] visited){

        Queue<CycleNode> bfsQueue = new LinkedList<>();

        bfsQueue.add(new CycleNode(value, -1));
        visited[value] = true;

        while(!bfsQueue.isEmpty()){
            int node = bfsQueue.peek().curr_Node;
            int parent = bfsQueue.peek().parent_Node;
            bfsQueue.remove();

            //Look for the neighbours//
            for(Integer it: adj.get(node)){
                if(!visited[it]){
                    bfsQueue.add(new CycleNode(it, node));
                    visited[it] = true;
                }else if(parent != it){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean visited[] = new boolean[V+1];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(checkForCycle(adj, i, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int V = 11;

        List<List<Integer>> adj = new ArrayList<>();
        //Adjacency List formation//
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        //edge 1 -- 2
        adj.get(1).add(2);
        adj.get(2).add(1);

        //edge 2--4
        adj.get(2).add(4);
        adj.get(4).add(2);

        //edge 3--5
        adj.get(3).add(5);
        adj.get(5).add(3);

        //edge 5--6
        adj.get(5).add(6);
        adj.get(6).add(5);

        //edge 5--10
        adj.get(5).add(10);
        adj.get(10).add(5);

        //edge 6--7
        adj.get(6).add(7);
        adj.get(7).add(6);

        //edge 7--8
        adj.get(7).add(8);
        adj.get(8).add(7);

        //edge 8--9
        adj.get(8).add(9);
        adj.get(9).add(8);

//        //edge 10--9
//        adj.get(10).add(9);
//        adj.get(9).add(10);

        boolean checkCycle = hasCycle(V, adj);
        if(checkCycle){
            System.out.println("Cycle detected");
        }else{
            System.out.println("No cycle detected");
        }

    }
}
