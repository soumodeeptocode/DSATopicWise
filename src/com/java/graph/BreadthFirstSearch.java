package com.java.graph;

import java.util.*;

public class BreadthFirstSearch {

    static List<Integer> bfs(int v, List<List<Integer>> adjList){
        List<Integer> result = new ArrayList<>();
        boolean vis[] =  new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        //Adding the first element into the queue//
        q.add(0);
        //Mark the added element as visited//
        vis[0] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            result.add(node);

            for(Integer it: adjList.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(1);
        adjList.get(1).add(0);
        adjList.get(0).add(2);
        adjList.get(2).add(0);
        adjList.get(0).add(3);
        adjList.get(3).add(0);
        adjList.get(2).add(4);
        adjList.get(4).add(2);

        List<Integer> bfs = bfs(5, adjList);

        for(int i = 0; i < bfs.size(); i++){
            System.out.print(bfs.get(i) + " ");
        }

    }
}
