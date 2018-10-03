package Queue;

public interface IQueue<E> {
    /**
     * Geeft het aantal elementen in de Queue
     * @return het aantal elementen in de Queue
     */
    int size();

    /**
     * Kijkt of de Queue leeg is
     * @return true wanneer de Queue leeg is, anders false
     */
    boolean isEmpty();

    /**
     * Voegt een element toe aan de Queue
     * @param e het element dat toegevoegd moet worden
     */
    void enqueue(E e);

    /**
     * Geeft het element dat vooraan in de Queue ligt
     * @return E het element dat vooraan in de Queue ligt
     */
    E first();

    /**
     * Geeft en verwijdert het element dat vooraan in de Queue ligt
     * @return E het element dat vooraan in de Queue ligt
     */
    E dequeue();
}
