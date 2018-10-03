package List;

public interface IList<E> {
    /**
     * geeft het aantal elementen in de lijst
     * @return het aatal elementen in de lijst
     */
    int size();

    /**
     * Kijkt of de lijst leeg is
     * @return true wanneer de lijst leeg is, anders false
     */
    boolean isEmpty();

    /**
     * Geeft een element op index i
     * @param i index
     * @return E element op index e
     * @throws IndexOutOfBoundsException
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Vervangd een element op index i met het gegeven element e
     * @param i index
     * @param e element
     * @return het nieuwe element
     * @throws IndexOutOfBoundsException
     */
    E set(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Voegt een nieuwe element toe op index i. Alle elementen schuiven 1 plaats op
     * @param i index
     * @param e element
     * @throws IndexOutOfBoundsException
     */
    void add(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Verwijdert en geeft een element op index i. Alle elementen schuiven 1 plaats terug
     * @param i index
     * @return het element op index i
     */
    E remove(int i);
}
