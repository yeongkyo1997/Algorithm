//package dataStructure;
//
//
//public class LinkedStack<E> implements IStack<E> {
//    public Node<E> top;
//
//    @Override
//    public void push(E data) {
//        top = new Node<>(data, top);
//    }
//
//    @Override
//    public E pop() {
//        E data = top.data;
//        top = top.link;
//        return data;
//    }
//
//    @Override
//    public E peek() {
//        return top.data;
//    }
//
//    public static void main(String[] args) {
//        LinkedStack<Node> stack = new LinkedStack<>();
//        Node<Integer>
//    }
//
//    public class Node<T> {
//        T data;
//        Node<T> link;
//
//        public Node(T data, Node<T> link) {
//            this.data = data;
//            this.link = link;
//        }
//    }
//}