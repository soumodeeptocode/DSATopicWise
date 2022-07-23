package com.java.heap;

import java.util.PriorityQueue;

public class HeapSort {
    public static void heapSort(int[] arr){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> b-a);

        for(int i = 0; i < arr.length; i++){
            minHeap.add(arr[i]);
        }

        for(int i = 0; i < arr.length; i++){
            arr[i] = minHeap.poll();
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,7,11,30,8,38,2,45};

        heapSort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
