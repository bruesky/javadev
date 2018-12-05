package org.xkg.hellojava.datastructures;

public class LinkedList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int num = 0;

    public LinkedList() {

    }

    public void add(T data){
        Node<T> node = new Node(data);
        if (head==null){
            head = node;
        }else {
            tail.setNext(node);
            node.setPre(tail);
        }
        tail = node;
        num++;
    }

    public Node getHead(){
        return head;
    }

    public static void main(String[]args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(1);
        Node node = linkedList.getHead();
        while (true){
            if (node == null)
                break;
            System.out.println(node.getData());
            node = node.getNext();
        }
    }
}
