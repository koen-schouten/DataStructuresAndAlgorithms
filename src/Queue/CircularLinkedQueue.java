package Queue;

import LinkedLists.CircularlyLinkedList;

public class CircularLinkedQueue<E> implements ICircularQueue<E> {


    private CircularlyLinkedList<E> list = new CircularlyLinkedList<E>();

    /**
     * Constructor
     */
    public CircularLinkedQueue() { }

    /**
     * Verplaats de element die vooraan in de queue ligt naar de achterkant van de queue
     * Doet niks als de queue leeg is
     */
    @Override
    public void rotate() {
        list.rotate();
    }

    /**
     * Geeft het aantal elementen in de Queue
     *
     * @return het aantal elementen in de Queue
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Kijkt of de stack leeg is
     *
     * @return true wanneer de stack leeg is, anders false
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Voegt een element toe aan de Qeueu
     *
     * @param e het element dat toegevoegd moet worden
     */
    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    /**
     * Geeft het element dat vooraan in de Queue ligt
     *
     * @return E het element dat vooraan in de Queue ligt
     */
    @Override
    public E first() {
        return list.first();
    }

    /**
     * Geeft en verwijdert het element dat vooraan in de Queue ligt
     *
     * @return E het element dat vooraan in de Queue ligt
     */
    @Override
    public E dequeue() {
        return list.removeFirst();
    }
}
