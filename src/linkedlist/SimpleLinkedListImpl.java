package linkedlist;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Node<E> firstElement;//001[007]
    protected int size;


    //O(1)
    @Override
    public void insertFirst(E value) {
        Node<E> node = new Node<>(value);//005
        node.next = firstElement;//003[007]
        firstElement = node;//001[005]
        size++;
    }

    //O(1)
    @Override
    public E removeFirst() {
        if (isEmpty())
            return null;

        E value = firstElement.value;
        firstElement = firstElement.next;

        size--;
        return value;
    }

    //O(N)
    @Override
    public boolean remove(E value) {
        Node<E> previous = null;
        Node<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }

            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }
        else if (current == firstElement) {
            firstElement = current.next;
        }
        else {
            previous.next = current.next;
        }

        size--;

        return true;
    }

    //O(N)
    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("----------");
        Node<E> current = firstElement;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println("----------");
    }

    @Override
    public E getFirstValue() {
        return firstElement != null ? firstElement.value : null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public boolean isFull() {
        return LinkedList.super.isFull();
    }

    @Override
    public Node<E> getFirst() {
        return firstElement;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
