//Write a program to implement Stack Using Array.

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
class StackUsingArray implements stackAdt{

    private int Max_Capacity;
    private int[] stack;
    int top;

    public StackUsingArray(int Max_Capacity){
        this.Max_Capacity = Max_Capacity;
        stack = new int[Max_Capacity];
        top = 0;
    }

    @Override
    public void push(int element) {
        if(top!=Max_Capacity){
            stack[top] = element;
            top++;
        }
        else{
            System.out.println("Stack OverFLow!");
        }
    }

    @Override
    public int pop() {
        int res = 0;
        if(!isEmpty()){
            top--;
            res = stack[top];
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
            res = stack[top-1];
        }
        else{
            System.out.println("Stack is Empty!");
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public void traverse() {
        if(!isEmpty()){
            for (int i = 0; i < top; i++) {
                System.out.print(stack[i]+" ");
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Size of Stack : ");
        int size = scan.nextInt();
        StackUsingArray stack = new StackUsingArray(size);
        System.out.println("Size Of Stack : "+stack.size());
        Random val = new Random();
        for (int i = 0; i < size; i++) {
            stack.push(val.nextInt(20));
        }
        stack.traverse();
        System.out.println("Size Of Stack : "+stack.size());
        System.out.println(stack.pop());
        System.out.println("Size Of Stack : "+stack.size());
        System.out.println(stack.peek());
        stack.push(20);
        stack.traverse();
        stack.push(30);
    }
}
