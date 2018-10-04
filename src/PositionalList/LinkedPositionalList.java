package PositionalList;

import javax.swing.text.Position;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements IPositionalList<E>, Iterable {

    private static class Node<E> implements IPosition<E> {
        private E element;

        private Node<E> prev;
        private Node<E> next;

        /**
         * Constructor voor node
         *
         * @param e het element dat bij de node hoort
         * @param p de voorgaande posite
         * @param n de volgende positie
         */
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        @Override
        public E getElement() throws IllegalStateException {
            if (next == null) {
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    private Node<E> validate(IPosition<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null) {
            throw new IllegalArgumentException("p is no longer in the list");
        }
        return node;
    }

    private IPosition<E> position(Node<E> node) {
        if (node == header || node == trailer) { //Header en trailer bevatten nooit een element.
            return null;                       //De gebruiker mag deze niet zien
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public IPosition<E> first() {
        return position(header.getNext());
    }

    @Override
    public IPosition<E> last() {
        return position(trailer.getPrev());
    }

    @Override
    public IPosition<E> before(IPosition<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getPrev();
    }

    @Override
    public IPosition<E> after(IPosition<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getNext();
    }

    /**
     * Voegt een element toe tussen twee nodes
     *
     * @param e           het nieuwe element
     * @param predecessor de vorige node
     * @param successor   de volgende node
     * @return positie van de nieuwe element
     */
    private IPosition<E> addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(predecessor);
        size++;
        return newest;
    }

    @Override
    public IPosition<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    @Override
    public IPosition<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    @Override
    public IPosition<E> addBefore(IPosition<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    @Override
    public IPosition<E> addAfter(IPosition<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    @Override
    public E set(IPosition<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    @Override
    public E remove(IPosition<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setPrev(null);
        node.setPrev(null);
        return answer;
    }

    private class PositionIterator implements Iterator<IPosition<E>> {
        private IPosition<E> cursor = first();
        private IPosition<E> recent = null;

        @Override
        public boolean hasNext() {
            return (cursor != null);
        }

        @Override
        public IPosition<E> next() throws NoSuchElementException {
            if(cursor == null){
                throw new NoSuchElementException("Nothing Left");
            }
            recent = cursor;
            cursor = after(cursor);
            return recent;
        }

        public void remove() throws IllegalStateException{
            if( recent == null){
                throw new IllegalStateException("Nothing to remove");
            }
            LinkedPositionalList.this.remove(recent);
            recent = null;
        }
    }

    private class PositionIterable implements Iterable<IPosition<E>>{
        @Override
        public Iterator<IPosition<E>> iterator() {
            return new PositionIterator();
        }
    }

    public Iterable<IPosition<E>> positions(){
        return new PositionIterable();
    }

    private class ElementIterator implements Iterator<E>{

        Iterator<IPosition<E>> positionIterator = new PositionIterator();

        @Override
        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        @Override
        public E next() {
            return positionIterator.next().getElement();
        }

        public void remove(){
            positionIterator.remove();
        }
    }

    public Iterator<E> iterator(){
        return new ElementIterator();
    }

}
