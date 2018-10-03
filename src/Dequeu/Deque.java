package Dequeu;

import LinkedLists.DoublyLinkedList;


/**
 * Implementatie van een deque
 * We gebruiken een DoubleLinkedList voor de Deque omdat een DoubleLinkedList
 * alle methoden voor een deque al heeft geimplementeerd
 * @param <E> de elementen die aan de deque worden toegevoegd
 */
public class Deque<E> extends DoublyLinkedList<E> implements IDeque<E> {
}
