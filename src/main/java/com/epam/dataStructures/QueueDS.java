package com.epam.dataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDS {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        int element = getNthElementFromQueue(queue,4);
        System.out.println(element);
    }

    private static int getNthElementFromQueue(Queue<Integer> queue, int n) {
        if(n>queue.size())
            return -1;

        while(n>1){
            queue.poll();
            n--;
        }
        return queue.poll();
    }
}
