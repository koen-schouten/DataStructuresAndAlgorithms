package LinkedLists;

public class SinglyLinkedList<E> {
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

    /**
     * Eerste node van de lijst
     */
    private Node<E> head = null;
    /**
     * Laatste node van de lijst
     */
    private Node<E> tail = null;
    /**
     * Aantal nodes in de lijst
     */
    private int size = 0;

    /**
     * Lege constructor voor het creéeren van een lege LinkedList.
     */
    public SinglyLinkedList(){}

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
            return head.getElement();
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
     * Voegt een element toe aan de kop de de lijst
     * @param e het element dat toegevoegd moet worden
     */
    public void addFirst(E e){
        head = new Node<>(e, head);
        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    /**
     * Voegt een element toe aan de staart van de lijst
     * @param e het element dat toegevoegd moet worden
     */
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if(isEmpty()){
            head = newest;
        } else{
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    /**
     * Verwijdert het element aan de kop van de lijst
     * @return het element aan de kop van de lijst
     */
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(isEmpty()){
            tail = null;
        }
        return answer;
    }
}
