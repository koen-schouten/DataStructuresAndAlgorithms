/**
 *
 */
public interface IList<E> {
    /**
     * Geeft het aantal elementen in een lijst.
     * @return integer van het aantal elementen in een lijst
     */
    int size();

    /**
     * Geeft aan of een lijst leeg is.
     * @return boolean die aangeeft of de lijst leeg is
     */
    boolean isEmpty();

    /**
     * Geeft het element op index i
     * @param i de index
     * @return het element
     * @throws IndexOutOfBoundsException wanneer de gegeven index geen onderdeel van de lijst is.
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Vervangt een element op index i met een ander gegeven element. Geeft het element dat vervangen word.
     * @param i de index
     * @param e het nieuwe element
     * @return het oude element
     * @throws IndexOutOfBoundsException wanneer de gegeven index geen onderdeel van de lijst is.
     */
    E set(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Voegt een nieuwe element toe op index i. Alle andere elementen schuiven één plaats op.
     * @param i de index
     * @param e het nieuwe element
     * @throws IndexOutOfBoundsException wanneer de gegeven index geen onderdeel van de lijst is.
     */
    void add(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Verwijdert een element op index i uit de lijst. Alle element schijven één plaats op.
     * Geeft de verwijderde element.
     * @param i de index
     * @return de verwijderde element
     * @throws IndexOutOfBoundsException wanneer de gegeven index geen onderdeel van de lijst is.
     */
    E remove(int i) throws IndexOutOfBoundsException;
}
