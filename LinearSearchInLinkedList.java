//Write a program to search an element with in linked list using linear search

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
class Imp{
    private Node head;
    private int size;

    public Imp(){
        head = null;
        size = 0;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void addLast(int element){
        Node node = new Node(element);
        if(!isEmpty()){
            Node temp = head;
            while(temp.getNext()!=null){
                temp=temp.getNext();
            }
            temp.setNext(node);
        }else{
            head = node;
        }
        size++;
    }
    public boolean LinearSearch(int element){
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
        }else{
            System.out.println("List is Empty!");
        }
        return res;
    }
}
public class LinearSearchInLinkedlist {
    public static void main(String[] args) {
        Imp list = new Imp();
        list.addLast(25);
        list.addLast(35);
        list.addLast(45);
        System.out.println(list.LinearSearch(35));
    }
}
