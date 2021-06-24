//Write program to implement Queue using linked list

interface queueADT{
    void enqueue(int element);
    int dequeue();
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
class Queue implements queueADT{
    private Node rear;
    private Node front;
    private int size;

    public Queue(){
        front = null;
        rear = null;
        size = 0;
    }


    @Override
    public void enqueue(int element) {
        Node node = new Node(element);
        if(isEmpty()){
            rear = node;
            front = node;
        }else{
            rear.setNext(node);
            rear=node;
        }
        size++;
    }

    @Override
    public int dequeue() {
        int res = 0;
        if(!isEmpty()){
            if(front==null){
                rear = null;
            }else{
                res = front.getData();
                front = front.getNext();
            }
            size--;
        }
        return res;
    }

    @Override
    public int peek() {
        int res = 0;
        if(!isEmpty()){
            res = front.getData();
        }else{
            System.out.println("Empty Queue!");
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
        Node temp = front;
        while(temp!=null){
            System.out.print(temp.getData()+" ");
            temp = temp.getNext();
        }
        System.out.println();
    }
}
public class QueueLinkedListImplementation {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(2);
        queue.traverse();
        System.out.println("Size : "+queue.size());
        System.out.println("Dequeue Element : "+queue.dequeue());
        System.out.println("Top Element : "+queue.peek());
        System.out.println("Size : "+queue.size());
    }
}
