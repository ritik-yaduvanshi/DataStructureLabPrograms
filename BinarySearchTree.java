//Write a program to implement Binary search tree (BST).

class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
class MyBinarySearchTree {
    private Node root;

    public boolean isEmpty(){
        if(root == null){
            return true;
        }
        return false;
    }
    public void insert(int element){
        Node node = new Node(element);
        if(isEmpty()){
            root = node;
        }
        else{
            Node temp = root;
            Node parent = null;
            while(temp != null){
                parent = temp;
                if(element <= temp.getData()){
                    temp = temp.getLeft();
                }
                else{
                    temp = temp.getRight();
                }
            }
            if(element <= parent.getData()){
                //new node will be left child
                parent.setLeft(node);
            }
            else{
                parent.setRight(node);
            }
        }
    }
    public void inOrder(Node node){
        if(node!=null){
            inOrder(node.getLeft());
            System.out.print(node.getData() + ", ");
            inOrder(node.getRight());
        }
    }
    public void preOrder(Node node){
        if(node != null ){
            System.out.print(node.getData() + ", ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    public void postOrder(Node node){
        if(node != null){
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + ", ");
        }
    }
    public boolean search(int searchElement){
        boolean response = false;
        Node temp = root;
        while(temp != null){
            if(searchElement == temp.getData()){
                response = true;
                break;
            }
            else if(searchElement < temp.getData()){
                temp = temp.getLeft();
            }
            else{
                temp = temp.getRight();
            }
        }


        return response;
    }
    public void delete(int deletingElement){
        Node temp = root;
        Node parent  = null;
        while(temp != null){
            if(deletingElement == temp.getData()){
                break;
            }
            else {
                parent = temp;
                if(deletingElement < temp.getData()){
                    temp = temp.getLeft();
                }
                else{
                    temp = temp.getRight();
                }
            }

        }
        if(temp != null){
            if(isLeaf(temp)){
                if(temp == root){
                    root = null;
                }
                else{
                    if(deletingElement < parent.getData()){
                        parent.setLeft(null);
                    }
                    else{
                        parent.setRight(null);
                    }
                }
            }

            else if (hasLeftChild(temp)){
                if(parent == null) {
                    root = root.getLeft();
                }
                else{
                    if(deletingElement < parent.getData()){
                        parent.setLeft(temp.getLeft());
                    }
                    else{
                        parent.setRight(temp.getLeft());
                    }
                }
            }
            else if(hasRightChild(temp)){
                if(parent == null){
                    root = root.getRight();
                }
                else{
                    if(deletingElement < parent.getData()){
                        parent.setLeft(temp.getRight());
                    }
                    else{
                        parent.setRight(temp.getRight());
                    }
                }
            }
            else{
                Node successor = getSuccessor(temp);
                delete(successor.getData());
                successor.setLeft(temp.getLeft());
                successor.setRight(temp.getRight());
                if(parent == null){
                    root = successor;
                }
                else{
                    if(deletingElement < parent.getData()){
                        parent.setLeft(successor);
                    }
                    else{
                        parent.setRight(successor);
                    }
                }
            }
        }
        else{
            System.out.println("cannot delete as element not present");
        }
    }

    private Node getSuccessor(Node node) {
        Node temp = node.getRight();
        while(temp.getLeft() != null){
            temp = temp.getLeft();
        }
        return temp;
    }

    private boolean hasRightChild(Node temp) {
        if(temp.getRight() != null && temp.getLeft() == null){
            return true;
        }
        return false;
    }

    private boolean hasLeftChild(Node temp) {
        if(temp.getLeft() != null && temp.getRight() == null){
            return true;
        }
        return false;
    }

    private boolean isLeaf(Node temp) {
        return temp.getLeft() == null && temp.getRight() == null;
    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        else{
            return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        }
    }
}
public class BinarySearchTree {
    public static void main(String[] args) {
        MyBinarySearchTree tree = new MyBinarySearchTree();
        tree.insert(50);
        tree.insert(8);
        tree.insert(72);
        tree.insert(6);
        tree.insert(9);
        tree.insert(65);
        tree.insert(56);
        
    }
}
