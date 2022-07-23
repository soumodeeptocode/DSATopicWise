package com.java.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TopKElements {
    static List<Integer> topKLargestUsingMinHeap(int[] arr, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Integer> topK = new ArrayList<>(k);
        for(int i = 0 ; i < k; i++){
            minHeap.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++){
            if(arr[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        for(int i = 0; i < k; i++){
            topK.add(minHeap.poll());
        }
        return topK;
    }

    static List<Integer> topkLargestUsingMaxHeap(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> topK = new ArrayList<>(k);
        for(int i = 0; i < arr.length; i++){
            maxHeap.add(arr[i]);
        }

        for(int i = 0; i < k; i++){
            topK.add(0,maxHeap.poll());
        }

        return topK;
    }
    public static void main(String[] args) {
        int[] arr = {10,7,11,30,20,28,2,40};
        int k = 4;

        List<Integer> topKUsingMaxHeap = topkLargestUsingMaxHeap(arr, k);

        for(int i: topKUsingMaxHeap){
            System.out.print(i + " ");
        }

        System.out.println();

        List<Integer> topKUsingMinHeap = topKLargestUsingMinHeap(arr, k);

        for(int i: topKUsingMinHeap){
            System.out.print(i + " ");
        }

      //  System.out.println("The kth largest number - "+topkLargestUsingMaxHeap(arr, k));
      //  System.out.println("The kth largest number - "+topKLargestUsingMinHeap(arr, k));
    }
}
