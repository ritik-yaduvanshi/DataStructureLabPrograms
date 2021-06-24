//Write a program to Implement Singly linked list.

import java.util.ArrayList;
import java.util.Scanner;

class Node{
    private int data;
    private Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
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
class SinglyLinkedList{
    private Node head;
    private int size;

    public SinglyLinkedList(){
        head = null;
        size = 0;
    }

    public Node getHead() {
        return head;
    }
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head==null;
    }
    public void addFirst(int element){
        Node node = new Node(element);
        if(isEmpty()){
            head = node;
        }
        else{
            Node temp = head;
            head = node;
            node.setNext(temp);
        }
        size++;
    }
    public void addLast(int element){
        Node node = new Node(element);
        if(isEmpty()){
            head = node;
        }else{
            Node temp = head;
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
        size++;
    }
    public void removeFirst(){
        if(!isEmpty()){
            Node temp = head;
            head = temp.getNext();
            size--;
        }
        else{
            System.out.println("List is Already Empty!");
        }
    }
    public void removeLast(){
        if(!isEmpty()){
            Node temp = head;
            while(temp.getNext().getNext()!=null){
                temp = temp.getNext();
            }
            temp.setNext(null);
            size--;
        }
        else{
            System.out.println("List is Already Empty!");
        }
    }
    public void traverse(){
        Node temp = head;
        if(!isEmpty()){
            while(temp!=null){
                System.out.print(temp.getData()+" ");
                temp = temp.getNext();
            }
            System.out.println();
        }
        else{
            System.out.println("List is Empty!");
        }
    }
    public boolean search(int element){
        boolean res = false;
        if(!isEmpty()){
            Node temp = head;
            while(temp!=null){
                if(temp.getData() == element){
                    res = true;
                    break;
                }
                temp = temp.getNext();
            }
        }
        else{
            System.out.println("List is Empty!");
        }
        return res;
    }

}

public class SinglyMainImplementations {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(8);
        list.addLast(6);
        list.traverse();
        list.addFirst(9);
        list.addFirst(2);
        list.traverse();
        list.removeFirst();
        list.traverse();
        list.removeLast();
        list.traverse();
        System.out.println(list.search(1));


    }
}
