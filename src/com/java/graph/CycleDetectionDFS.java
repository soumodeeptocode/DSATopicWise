package com.java.graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionDFS {

    private static boolean checkForCycle(int curr_node, int parent_node, boolean visited[], List<List<Integer>> adj){
        visited[curr_node] = true;

        //Look for the neighbours in the adjacency List//

        for(Integer it: adj.get(curr_node)){
            if(visited[it] == false){
                if(checkForCycle(it, curr_node, visited, adj)){
                    return true;
                }
            }else if( it != parent_node){
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(int V, List<List<Integer>> adj){
        boolean visited[] = new boolean[V+1];

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(checkForCycle(i, -1, visited, adj)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 5;

        List<List<Integer>> adj = new ArrayList<>();
        //Adjacency List formation//
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        //edge 0 -- 1
        adj.get(0).add(1);
        adj.get(1).add(0);

        //edge 1--2
        adj.get(1).add(2);
        adj.get(2).add(1);

        //edge 2--3
        adj.get(2).add(3);
        adj.get(3).add(2);

        //edge 3--4
        adj.get(3).add(4);
        adj.get(4).add(3);

        //edge 1--4
        adj.get(1).add(4);
        adj.get(4).add(1);

        boolean checkCycle = hasCycle(V, adj);
        if(checkCycle){
            System.out.println("Cycle detected");
        }else{
            System.out.println("No cycle detected");
        }
    }
}
