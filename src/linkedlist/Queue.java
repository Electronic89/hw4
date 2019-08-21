package linkedlist;

public interface Queue<E> extends ICollection {

    boolean insert(E value);

    E remove();

    E peek();

}