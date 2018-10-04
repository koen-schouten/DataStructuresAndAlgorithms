package Tree;

import PositionalList.IPosition;

import java.util.Iterator;

public interface ITree<E> extends Iterable<E>{
    /**
     * Geeft de root van de Tree
     * @return de root van de Tree
     */
    IPosition<E> root();

    /**
     * Geeft de parent van een positie p
     * @param p de positie
     * @return de parent van de positie
     * @throws IllegalArgumentException de gegeven positie bestaat niet
     */
    IPosition<E> parent(IPosition<E> p) throws IllegalArgumentException;

    /**
     * Geeft de children van een positie p
     * @param p de positie
     * @return de children van een positie
     * @throws IllegalArgumentException de gegeven positie bestaat niet
     */
    Iterable<IPosition<E>> children(IPosition<E> p) throws IllegalArgumentException;

    /**
     * Geeft het aantal children van een positie p
     * @param p de positie
     * @return het aantal children
     * @throws IllegalArgumentException de gegeven positie bestaat niet
     */
    int numChildren(IPosition<E> p) throws IllegalArgumentException;

    /**
     * Geeft aan of de positie tenminste 1 child heeft
     * @param p de positie
     * @return true wanneer de positie 1 of meer children heeft
     * @throws IllegalArgumentException de gegeven positie bestaat niet
     */
    boolean isInternal(IPosition<E> p) throws IllegalArgumentException;

    /**
     * Geeft aan of de positie geen child heeft
     * @param p de positie
     * @return true wanneer de positie geen children heeft
     * @throws IllegalArgumentException de gegeven positie bestaat niet
     */
    boolean isExternal(IPosition<E> p) throws IllegalArgumentException;

    /**
     * Geeft aan of de positie de root van de tree is
     * @param p de positie
     * @return true wanneer de positie de root van de tree is
     * @throws IllegalArgumentException de gegeven positie bestaat niet
     */
    boolean isRoot(IPosition<E> p) throws IllegalArgumentException;

    /**
     * Geeft het aantal elementen in de Tree
     * @return het aantal elementen
     */
    int size();

    /**
     * Test of de boom leeg is
     * @return true wanneer de boom leeg is
     */
    boolean isEmpty();

    /**
     * Geeft een Iterator voor alle elementen in de Tree
     * @return een iterator
     */
    Iterator<E> iterator();

    /**
     * Geeft een Iterable verzameling van alle elementen in de boom
     * @return
     */
    Iterable<IPosition<E>> positions();
}
