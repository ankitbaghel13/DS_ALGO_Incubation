package com.epam.dataStructures;

public class StackDS {

    int top=-1;
    int max=5;
    int stack_arr[] = new int[max];

    //push
    public void push(int element){
        if(isFull())
            throw new RuntimeException("Stack is full");
        top++;
        stack_arr[top] = element;
    }
    //pop
    public int pop(){
        if(isEmpty())
            throw new RuntimeException("Stack is empty");
        return stack_arr[top--];
    }
    //top
    public int top(){
        return stack_arr[top];
    }
    //isFull
    public boolean isFull(){
        return top==max-1 ? true : false;
    }
    //isEmpty
    public boolean isEmpty(){
        return top==-1 ? true : false;
    }
    //print stack
    public void printStack(){
        while(!isEmpty()){
            System.out.println(stack_arr[top--]);
        }
    }

    public static void main(String[] args) {
        StackDS stack = new StackDS();
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(4);
        stack.printStack();
    }
}
