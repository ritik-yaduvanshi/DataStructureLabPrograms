//Write a program to implement Queue using Array.

import java.util.Scanner;
interface queueADT{
    void enqueue(int element);
    int dequeue();
    int peek();
    boolean isEmpty();
    int size();
    void traverse();
}
class MyQueue implements queueADT{
    private int[] arr;
    private int rear;
    private int front;
    private int size;

    public MyQueue(int size){
        this.size = size;
        arr = new int[size];
        rear = 0;
        front = 0;
    }

    @Override
    public void enqueue(int element) {
        if(rear!=size){
            arr[rear] = element;
            rear++;
        }else{
            System.out.println("Queue OverFlow");
        }
    }

    @Override
    public int dequeue() {
        int res = 0;
        if(!isEmpty()){
            res = arr[front];
            front++;
            size--;
        }else{
            System.out.println("Queue UnderFlow!");
        }
        return res;
    }

    @Override
    public int peek() {
        int res = 0;
        if(!isEmpty()){
            res = arr[front];
        }else{
            System.out.println("Queue Is Empty!");
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void traverse() {
        for (int i = front; i < rear; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}


public class QueueMainImplementation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of queue:");
        int size = scan.nextInt();
        MyQueue queue = new MyQueue(size);
        queue.enqueue(5);
        queue.enqueue(8);
        queue.enqueue(7);
        queue.traverse();
        System.out.println("Size of Queue :"+queue.size());
        System.out.println("Dequeue Element : "+queue.dequeue());
        System.out.println("Top Element of Queue : "+queue.peek());
        queue.traverse();
        System.out.println("Size of Queue :"+queue.size());
    }
}
