/*Experiment 2
Consider a Singly linked list, where each node can store an integer value. You task is to form a number,
whose digits are stored in given singly linked list. The start node contain the first digit and last node contain the last digit
Method 
public int getNumber(SinglyLinkedList list){
}
For example:
1 >	8	 >	 6	>	2	 > null
Then you have to give output

1862
*/



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

    public boolean isEmpty(){
        return head==null;
    }
    public void addData(int element){
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

}

public class SinglyMainImplementation {
    public static int getNumber(SinglyLinkedList list){
        Node temp = list.getHead();
        String ref = "";
        while(temp!=null){
            ref +=temp.getData();
            temp = temp.getNext();
        }
        int number = Integer.parseInt(ref);
        return number;
    }
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        list.addData(1);
        list.addData(8);
        list.addData(6);
        list.addData(2);
        int res = getNumber(list);
        System.out.println("Number -> "+res);
    }
}
