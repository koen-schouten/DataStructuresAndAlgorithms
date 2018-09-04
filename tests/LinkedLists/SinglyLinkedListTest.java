package LinkedLists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    @Test
    void size() {
        assertEquals(0, list.size());

        list.addFirst(1);
        assertEquals(1, list.size());

        list.addFirst(2);
        assertEquals(2, list.size());
    }

    @Test
    void isEmpty() {
        assertEquals(true, list.isEmpty());

        list.addFirst(1);
        assertEquals(false, list.isEmpty());
    }

    @Test
    void first() {
        assertEquals(null, list.first());

        list.addFirst(1);
        assertEquals(1,(int)list.first());

        list.addFirst(2);
        assertEquals(2,(int)list.first());

        list.addLast(3);
        assertEquals(2,(int)list.first());
    }

    @Test
    void last() {
        assertEquals(null, list.first());

        list.addFirst(1);
        assertEquals(1,(int)list.last());

        list.addFirst(2);
        assertEquals(1,(int)list.last());

        list.addLast(3);
        assertEquals(3,(int)list.last());
    }

    @Test
    void removeFirst() {
        assertEquals(null, list.removeFirst());

        list.addFirst(1);
        assertEquals(1, (int)list.removeFirst());
        assertEquals(true, list.isEmpty());

        list.addFirst(2);
        list.addFirst(3);
        assertEquals(3, (int)list.removeFirst());
        assertEquals(2, (int)list.removeFirst());
        assertEquals(true, list.isEmpty());

        list.addFirst(4);
        list.addLast(5);
        assertEquals(4, (int)list.removeFirst());
        assertEquals(5, (int)list.removeFirst());
        assertEquals(true, list.isEmpty());

    }
}