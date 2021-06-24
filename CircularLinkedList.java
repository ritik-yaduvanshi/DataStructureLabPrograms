//Write a program to implement circular linked list

import java.util.Scanner;
class Node{
    private int data;
    private Node next;
    private Node prev;
    public Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
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

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
class CircularLinkedList{
    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int getSize(){
        return  size;
    }
    public void addLast(int element){
        Node node = new Node(element);
        if(isEmpty()){
            head = node;
            tail = node;
        }else{
            Node temp = tail;
            tail.setNext(node);
            node.setPrev(temp);
            tail = node;
        }
        size++;
        tail.setNext(head);
        head.setPrev(tail);
    }
    public void addFirst(int element){
        Node node = new Node(element);
        if(isEmpty()){
            head = node;
            tail = node;
        }
        else{
            Node temp = head;
            head.setPrev(node);
            node.setNext(temp);
            head = node;
        }
        size++;
        head.setPrev(tail);
        tail.setNext(head);
    }
    public void removeFirst(){
        if(!isEmpty()){
            Node temp = head;
            head = temp.getNext();
            size--;
            head.setPrev(tail);
            tail.setNext(head);
        }
        else{
            System.out.println("List is Empty!");
        }
    }
    public void removeLast(){
        if(!isEmpty()){
            Node temp = tail;
            tail = temp.getPrev();
            size--;
            tail.setNext(head);
            head.setPrev(tail);
        }
        else{
            System.out.println("List is Empty!");
        }
    }
    public void traverse(){
        if(!isEmpty()){
            Node temp = head;
            while(true){
                System.out.print(temp.getData()+" ");
                temp = temp.getNext();
                if(temp == head)break;
            }
            System.out.println();
        }
        else{
            System.out.println("Empty List!");
        }
    }
    public boolean search(int element){
        boolean res = false;
        if(!isEmpty()){
            Node temp = head;
            while (true){
                if(temp.getData() == element){
                    res = true;
                    break;
                }
                temp = temp.getNext();
                if(temp == head)break;
            }
        }else{
            System.out.println("Empty List!");
        }
        return res;
    }
}


public class CircularMainImplementation {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();
        list.addLast(10);
        list.addLast(12);
        list.addLast(21);
        list.traverse();
        System.out.println("Size : "+list.getSize());
        list.addFirst(30);
        list.addFirst(35);
        list.traverse();
        System.out.println("Size : "+list.getSize());
        System.out.println(list.search(39));
        list.removeFirst();
        list.traverse();
        System.out.println("Size : "+list.getSize());
        list.removeLast();
        list.traverse();
        System.out.println("Size : "+list.getSize());
    }
}
