package com.epam.dataStructures;

public class LinkedListQuestions {

    static Node head;
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = createLinkedList();
        printLinkedList(head);
        //Node newHead = reverseLinkedList(head, null);
        //System.out.println("Reverse : ");
        //printLinkedList(newHead);
        //System.out.println(findMiddle(head).data);
        printNthFromLast(4);
     }

    static void printNthFromLast(int n)
    {
        Node mainPointer = head;
        Node refPointer = head;

        int count = 0;
        if (head != null){
            while (count < n){
                if (refPointer == null){
                    System.out.println(n
                            + " is greater than the no "
                            + " of nodes in the list");
                    return;
                }
                refPointer = refPointer.next;
                count++;
            }

            if(refPointer == null)
            {
                if(head != null)
                    System.out.println("Node no. " + n +
                            " from last is " +
                            head.data);
            }
            else
            {
                while (refPointer != null)
                {
                    mainPointer = mainPointer.next;
                    refPointer = refPointer.next;
                }
                System.out.println("Node " + n +
                        " from last is " +
                        mainPointer.data);
            }
        }
    }

    static Node findMiddle(Node head)
    {
        int count = 0;
        Node mid = head;

        while (head != null)
        {
            if ((count % 2) == 1)
                mid = mid.next;
            ++count;
            head = head.next;
        }
        return mid;
    }

    private static void printLinkedList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    private static Node createLinkedList() {
        LinkedListQuestions list = new LinkedListQuestions();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(8);

        return head;
    }

    static Node reverseLinkedList(Node curr, Node prev)
    {
        if (head == null)
            return head;
        if (curr.next == null) {
            head = curr;
            curr.next = prev;
            return head;
        }
        Node next1 = curr.next;
        curr.next = prev;
        reverseLinkedList(next1, curr);
        return head;
    }
}
