package LinkedLists;

public class CircularlyLinkedList<E> {
    private static class Node<E>{
        /**
         * Refereert naar het element dat in deze node is opgeslagen
         */
        private E element;

        /**
         * Refereert naar de volgende node in de lijst
         */
        private Node<E> next;

        /**
         * Constructor voor de node
         * @param e het element dat in deze node wordt opgeslagen
         * @param n de volgende node in de lijst
         */
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }

        /**
         * Geeft het element dat in deze node wordt opgeslagen
         * @return het element van deze node
         */
        public E getElement(){
            return element;
        }

        /**
         * Geeft de volgende node in de lijst
         * @return de volgende node
         */
        public Node<E> getNext(){
            return next;
        }

        /**
         * Vervangt de volgende node met een nieuwe node
         * @param n de node waarmee de oude node vervangen moet worden
         */
        public void setNext(Node<E> n){
            next = n;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    /**
     * Lege constructor voor het creéeren van een lege LinkedList.
     */
    public CircularlyLinkedList(){}

    /**
     * Geeft het aantal elementen in de lijst
     * @return een integer met het aantal elementen
     */
    public int size(){
        return size;
    }

    /**
     * Kijkt of de lijst leeg is.
     * @return true wanneer de lijst leeg is.
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Geeft de eerste element van de lijst
     * @return eerste element van de lijst
     */
    public E first(){
        if(isEmpty()){
            return null;
        } else{
            return tail.getNext().getElement();
        }
    }

    /**
     * Geeft de laatste element van de lijst
     * @return de laatste element van de lijst
     */
    public E last(){
        if(isEmpty()){
            return null;
        } else{
            return tail.getElement();
        }
    }

    /**
     * verplaatst de eerste element naar het einde van de lijst. Alle elementen schuiven 1 plaats op
     */
    public void rotate(){
        if(tail != null){
            tail = tail.getNext();
        }
    }

    /**
     * Voegt een element toe aan de kop de de lijst
     * @param e het element dat toegevoegd moet worden
     */
    public void addFirst(E e){
        if(isEmpty()){
            tail = new Node<E>(e, null);
            tail.setNext(tail);
        } else{
            Node<E> newest = new Node<E>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    /**
     * Voegt een element toe aan de staart van de lijst
     * @param e het element dat toegevoegd moet worden
     */
    public void addLast(E e){
        addFirst(e);
        tail = tail.getNext();
    }

    /**
     * Verwijdert het element aan de kop van de lijst
     * @return het element aan de kop van de lijst
     */
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        Node<E> head = tail.getNext();
        if(head == tail){
            tail = null;
        } else{
            tail.setNext(head.getNext());
        }
        size--;
        return head.getElement();
    }
}
