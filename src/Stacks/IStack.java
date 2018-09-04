package Stacks;

public interface IStack<E>{
    /**
     * Geeft het aantal elementen in de stack
     * @return het aantal elementen in de stack
     */
    int size();

    /**
     * Kijkt of de stack leeg is
     * @return true wanneer de stack leeg is, anders false
     */
    boolean empty();

    /**
     * Voegt een element toe aan de stack
     * @param e het element dat toegevoegd moet worden
     */
    void push(E e);

    /**
     * Geeft het element dat bovenop de stack ligt.
     * @return de bovenste element van de Stack
     */
    E top();

    /**
     * Geeft en verwijdered het element dat bovenop de stack ligt.
     * @return de bovenste element van de Stack
     */
    E pop();
}
