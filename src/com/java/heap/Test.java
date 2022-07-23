package com.java.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<List<Integer>> st = new Stack<>();

        st.add(new ArrayList<>(Arrays.asList(1,2)));
        st.add(new ArrayList<>(Arrays.asList(3,4)));

        List<Integer> li = st.peek();
        for(int i: li) System.out.println(i);
    }
}
