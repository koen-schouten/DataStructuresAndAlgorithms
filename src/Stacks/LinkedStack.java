package Stacks;

import LinkedLists.SinglyLinkedList;

import java.util.Stack;

public class LinkedStack<E> implements IStack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    /**
     * constructor voor het maken van een stack
     */
    public LinkedStack(){}

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }
}
