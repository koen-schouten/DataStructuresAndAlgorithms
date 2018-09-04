package LinkedLists;

public class DoublyLinkedList<E> {
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
         * Refereert naar de vorige node in de lijst
         */
        private Node<E> prev;

        /**
         * Constructor voor de node
         * @param e het element dat in deze node wordt opgeslagen
         * @param n de volgende node in de lijst
         */
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
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
         * Geeft de vorige node in de lijst
         * @return de vorige node
         */
        public Node<E> getPrev(){
            return prev;
        }

        /**
         * Vervangt de volgende node met een nieuwe node
         * @param n de node waarmee de oude node vervangen moet worden
         */
        public void setNext(Node<E> n){
            next = n;
        }

        /**
         * Vervangt de vorige node met een nieuwe node
         * @param n de node waarmee de oude node vervangen moet worden
         */
        public void setPrev(Node<E> n){
            prev = n;
        }
    }

    /**
     * Een lege node aan de kop van de lijst
     */
    private Node<E> header;

    /**
     * Een lege node aan de staart van de lijst
     */
    private Node<E> trailer;

    /**
     * Aantal elementen in de lijst. Header en trailer worden niet meegeteld.
     */
    private int size = 0;

    /**
     * Constructor voor het creéeren van een lege DoublyLinkedList
     */
    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

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
            return header.getNext().getElement();
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
            return trailer.getPrev().getElement();
        }
    }

    /**
     * Voegt een element toe aan de kop de de lijst
     * @param e het element dat toegevoegd moet worden
     */
    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }

    /**
     * Voegt een element toe aan de staart de de lijst
     * @param e het element dat toegevoegd moet worden
     */
    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
    }

    /**
     * Verwijdert het element aan de kop van de lijst
     * @return het element aan de kop van de lijst
     */
    public E removeFirst(){
        if(isEmpty()){
            return null;
        } else{
            return remove(header.getNext());
        }
    }

    /**
     * Verwijdert het element aan de staart van de lijst
     * @return het element aan de staart van de lijst
     */
    public E removeLast(){
        if(isEmpty()){
            return null;
        } else{
            return remove(trailer.getPrev());
        }
    }

    /**
     * Voegt een element toe tussen 2 nodes
     * @param e het element dat toegevoegd word
     * @param predecessor de vorige node
     * @param succesor de volgende node
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> succesor){
        Node<E> newest = new Node<>(e, predecessor, succesor);
        predecessor.setNext(newest);
        succesor.setPrev(newest);
        size++;
    }

    /**
     * Verwijdert een node van de lijst en geeft de element van deze node
     * @param node de node die verwijdert word
     * @return de element van de node die verwijdert word.
     */
    private E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> succesor = node.getNext();
        predecessor.setNext(succesor);
        succesor.setPrev(predecessor);
        size--;
        return node.getElement();
    }


}
