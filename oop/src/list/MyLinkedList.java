package list;

public class MyLinkedList<E> implements MyList<E>{
    private Node<E> head;

    private int numNodes;

    public MyLinkedList(){
        this.head = null;
    }

    @Override
    public int getSize() {
        return numNodes;
    }

    @Override
    public E get(int index) {
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.getData();
    }

    @Override
    public void add(E e) {
        if (this.head == null) {
            this.head = new Node<>(e);
        }
        Node temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(e);
        numNodes++;
    }

    @Override
    public void add(int index, E e) {
        if (index > numNodes-1) {
            return;
        }
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean contain(E e) {
        return false;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public void clear() {

    }

    public class Node<E>{
        private Node<E> next;
        private E data;

        public Node(E e) {
            this.data = e;
        }

        public E getData(){
            return this.data;
        }
    }
}
