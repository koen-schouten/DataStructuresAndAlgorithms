package PositionalList;

public interface IPositionalList<E> {

    /**
     * Geeft het aantal elementen in de lijst
     * @return het aantal elementen in de lijst
     */
    int size();

    /**
     * Test of de lijst leeg is
     * @return true wanneer de lijst leeg is.
     */
    boolean isEmpty();

    /**
     * Geeft de laatste positie in de lijst
     * @return de laatste positie in de lijst
     */
    IPosition<E> first();

    /**
     * Geeft de eerste positie in de lijst
     * @return de eerste positie in de lijst
     */
    IPosition<E> last();

    /**
     * Geeft de positie voor de positie p
     * @param p een gegeven positite p
     * @return de positie voor p
     * @throws IllegalArgumentException
     */
    IPosition<E> before(IPosition<E> p) throws IllegalArgumentException;

    /**
     *  Geeft de positie na de positie p
     * @param p een gegeven positite p
     * @return de positie na p
     * @throws IllegalArgumentException
     */
    IPosition<E> after(IPosition<E> p) throws IllegalArgumentException;

    /**
     * Voegt een element toe voor aan de lijst
     * @param e de element die toegevoegd word.
     * @return de positie van het nieuwe element
     */
    IPosition<E> addFirst(E e);

    /**
     * Voegt een element toe achtet aan de lijst
     * @param e de element die toegevoegd word.
     * @return de positie van het nieuwe element
     */
    IPosition<E> addLast(E e);

    /**
     * Voegt een element e toe voor positie p.
     * @param p de positie
     * @param e de element die toegevoegd word.
     * @return de positie van het nieuwe element
     * @throws IllegalArgumentException
     */
    IPosition<E> addBefore(IPosition<E> p, E e) throws IllegalArgumentException;

    /**
     * Voegt een element e toe achter positie p.
     * @param p de positie
     * @param e het element die toegevoegd word.
     * @return de positie van het nieuwe element
     * @throws IllegalArgumentException
     */
    IPosition<E> addAfter(IPosition<E> p, E e) throws IllegalArgumentException;

    /**
     * Vervangt een element op positie p met een nieuwe element e
     * @param p de positie
     * @param e het element die toegevoegd word.
     * @return geeft het vervangen element
     * @throws IllegalArgumentException
     */
    E set(IPosition<E> p, E e) throws IllegalArgumentException;

    /**
     * Verwijder een element op positie p
     * @param p de positie
     * @return geeft het vervangen element
     * @throws IllegalArgumentException
     */
    E remove(IPosition<E> p) throws IllegalArgumentException;
}
