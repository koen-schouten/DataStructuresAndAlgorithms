package PositionalList;

public interface IPosition<E> {
    /**
     * Geeft de element op een gegeven positie
     * @return het opgeslagen element
     * @throws IllegalStateException wanneer de positie niet geldig is.
     */
    E getElement() throws IllegalStateException;
}
