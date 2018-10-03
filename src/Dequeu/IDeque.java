package Dequeu;

public interface IDeque<E> {
    /**
     * Geeft het aantal elementen in de Deque
     * @return het aantal elementen in de Deque
     */
    int size();
    /**
     * Kijkt of de Deque leeg is
     * @return true wanneer de Deque leeg is, anders false
     */
    boolean isEmpty();

    /**
     * Geeft het element dat vooraan in de Deque ligt
     * @return E het element dat vooraan in de Deque ligt
     */
    E fist();

    /**
     * Geeft het element dat achteraan in de Deque ligt
     * @return E het element dat achteraan in de Deque ligt
     */
    E last();

    /**
     * Voegt een element toe vooraan aan de Deque
     * @param e het element dat toegevoegd moet worden
     */
    void addFirst(E e);

    /**
     * Voegt een element toe achteraan aan de Deque
     * @param e het element dat toegevoegd moet worden
     */
    void addLast(E e);

    /**
     * Geeft en verwijdert het element dat vooraan in de Deque ligt
     * @return E het element dat vooraan in de Deque ligt
     */
    E removeFirst();

    /**
     * Geeft en verwijdert het element dat achteraan in de Deque ligt
     * @return E het element dat achteraan in de Deque ligt
     */
    E removeLast();
}
