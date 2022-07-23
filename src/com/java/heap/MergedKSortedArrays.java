package com.java.heap;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class MergedKSortedArrays {

    private static class HeapNode implements Comparable<HeapNode> {
        int x;
        int y;
        int value;
        HeapNode(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
        @Override
        public int compareTo(HeapNode o) {
            if(this.value <= o.value) return -1;
            else return 1;
        }
    }

    static List<Integer> mergeKSortedArrays(int[][] arr, int k){
        List<Integer> result = new ArrayList<>();

        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>();

        for(int i = 0 ; i < arr.length; i++){
            minHeap.add(new HeapNode(i, 0, arr[i][0]));
        }

        HeapNode curr = null;

        while(!minHeap.isEmpty()) {
            curr = minHeap.poll();
            result.add(curr.value);
            //check is for the next elements of curr exits//
            if (curr.y < (arr[curr.x].length - 1)) {
                minHeap.add(new HeapNode(curr.x, curr.y + 1, arr[curr.x][curr.y + 1]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {2,6,12},
                {1,9},
                {23, 34, 90, 100}
        };
        int k = arr.length;
        List<Integer> result = mergeKSortedArrays(arr, k);

        for(int i: result){
            System.out.print(i + " ");
        }
    }

}
