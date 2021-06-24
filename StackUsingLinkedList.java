//Write a program to implement Stack using linked list.

import java.util.Random;
import java.util.Scanner;

interface stackAdt{
    void push(int element);
    int pop();
    int peek();
    boolean isEmpty();
    int size();
    void traverse();
}
class Node{
    private int data;
    private Node next;
    public Node(int data){
        this.data = data;
        next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
class StackUsingLinkedList implements stackAdt{
    private Node top;
    private int size;

    public StackUsingLinkedList(){
        top = null;
        size = 0;
    }

    @Override
    public void push(int element) {
        Node node = new Node(element);
        node.setNext(top);
        top = node;
        size++;
    }

    @Override
    public int pop() {
        int res = 0;
        if(!isEmpty()){
            res = top.getData();
            top = top.getNext();
            size--;
        }
        else{
            System.out.println("Stack UnderFlow!");
        }
        return res;
    }

    @Override
    public int peek() {
        int res = 0;
        if(!isEmpty()){
            res = top.getData();
        }
        else{
            System.out.println("Stack is Empty!");
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void traverse() {
        if(!isEmpty()){
            Node temp = top;
            while(temp!=null){
                System.out.print(temp.getData()+" ");
                temp = temp.getNext();
            }
            System.out.println();
        }
        else{
            System.out.println("Stack is Empty!");
        }
    }
}
public class StackMainImplementation {
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.traverse();
        System.out.println("Pop Element :"+stack.pop());
        System.out.println("Top of Stack : "+stack.peek());
        stack.traverse();
    }
}
