package Queue;

import LinkedLists.SinglyLinkedList;

/**
 * Implementatie van een queue op basis van een SinglyLinkedList.
 * @param <E> de elementen in de queue
 */
public class LinkedQueue<E> implements IQueue<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<E>();

    public LinkedQueue(){}

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }


}
