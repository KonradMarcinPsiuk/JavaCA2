
import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericLinkedList<T> implements IList<T> {

    private Node head;
    private Node tail;

    private int size;

    public void addToStart(T value) {
        Node newNode = new Node(value);
        newNode.nextNode = head;
        head = newNode;
        size++;
    }

    public void addToEnd(T value) {
        Node newNode = new Node(value);
        addNodeToEnd(newNode);

    }

    private void addNodeToEnd(Node node) {
        tail.nextNode = node;
        tail = node;
        size++;
    }


    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.nextNode;
        }
    }

    @Override
    public void add(T elem) {
        Node newNode = new Node(elem);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            addNodeToEnd(newNode);
        }
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException {
        Node n = head;
        Node newNode = new Node(element);

        if (index == 0) {
            newNode.nextNode = head;
            head = newNode;
            return;
        }
        int i = 0;
        boolean exceptionFlag = true;
        while (n != null) {
            if (i == index - 1) {
                newNode.nextNode = n.nextNode;
                n.nextNode = newNode;
                exceptionFlag = false;
            }
            n = n.nextNode;
            i++;
        }
        if (exceptionFlag)
            throw new IndexOutOfBoundsException("Index out of bounds");

        size++;
    }

    @Override
    public T set(int index, T element) {
        Node n = head;
        Node newNode = new Node(element);

        if (index == 0) {
            var oldNode = head;
            newNode.nextNode = head.nextNode;
            head = newNode;
            return (T) oldNode.getData();
        }
        int i = 0;

        while (n != null) {
            if (i == index - 1) {
                var oldNode = n.nextNode;
                newNode.nextNode = oldNode.nextNode;
                n.nextNode = newNode;
                return (T) oldNode.getData();
            }
            n = n.nextNode;
            i++;
        }

        throw new IndexOutOfBoundsException("Index out of bounds");

    }

    @Override
    public T get(int index) {
        Node<T> n = head;
        for (int i = 0; i < index; i++) {
            if (n.nextNode == null)
                throw new IndexOutOfBoundsException("Index out of bounds");
            n = n.nextNode;
        }
        return n.getData();
    }


    /////track size
    @Override
    public int size() {
        return size;
    }

    /*
    //Dynamic size method
    @Override
    public int size() {
        int i =0;
        Node n = head;
        while(n!=null){
        n = n.nextNode;
            i++;
        }
        return i;
    }
    */


    @Override
    public T remove(int index) {
        if (index == 0) {
            Node temp = head;
            head = head.nextNode;
            size--;
            return (T) temp.getData();
        }

        Node<T> n = head;
        for (int i = 0; i < index - 1; i++) {
            if (n.nextNode == null)
                throw new IndexOutOfBoundsException("Index out of bounds");
            n = n.nextNode;
        }
        Node temp = n.nextNode;
        n.nextNode = n.nextNode.nextNode;
        if (n.nextNode == null)
            tail = n;
        size--;
        return (T) temp;
    }

    @Override
    public boolean remove(T elem) {
        Node<T> n = head;
        if (n.getData() == elem) {
            head = n.nextNode;
            size--;
            return true;
        }

        while (n.nextNode != null) {
            if (n.nextNode.getData() == elem) {
                n.nextNode = n.nextNode.nextNode;
                if (n.nextNode == null)
                    tail = n;
                size--;
                return true;
            }
            n = n.nextNode;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(T element) {
        Node<T> n = head;
        while (n != null) {
            if (n.getData() == element)
                return true;
            n = n.nextNode;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericLinkedListIterator();
    }


    class GenericLinkedListIterator implements Iterator<T> {

        Node cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            if (! hasNext())
                throw new NoSuchElementException();
            Node temp = cursor;
            cursor = temp.nextNode;
            return (T) temp.getData();
        }
    }

    class Node<T> {
        T data;
        Node nextNode = null;

        public T getData() {
            return data;
        }

        Node(T data) {
            this.data = data;
        }
    }

}
