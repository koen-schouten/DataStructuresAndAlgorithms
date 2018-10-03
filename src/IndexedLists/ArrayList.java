package IndexedLists;

import java.lang.reflect.Array;

public class ArrayList<E> implements IList<E> {
    //Standaard capaciteit van de ArrayList
    public static final int CAPACITY = 16;

    private E[] data;

    private int size = 0;

    public ArrayList() {
        this(CAPACITY);
    }

    public ArrayList(int capacity){
        data = (E[]) new Object[capacity];
    }

    /**
     * Geeft het aantal elementen in een lijst.
     *
     * @return integer van het aantal elementen in een lijst
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Geeft aan of een lijst leeg is.
     *
     * @return boolean die aangeeft of de lijst leeg is
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Geeft het element op index i
     *
     * @param i de index
     * @return het element
     * @throws IndexOutOfBoundsException wanneer de gegeven index geen onderdeel van de lijst is.
     */
    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    /**
     * Vervangt een element op index i met een ander gegeven element. Geeft het element dat vervangen word.
     *
     * @param i de index
     * @param e het nieuwe element
     * @return het oude element
     * @throws IndexOutOfBoundsException wanneer de gegeven index geen onderdeel van de lijst is.
     */
    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    /**
     * Voegt een nieuwe element toe op index i. Alle andere elementen schuiven één plaats op.
     *
     * @param i de index
     * @param e het nieuwe element
     * @throws IndexOutOfBoundsException wanneer de gegeven index geen onderdeel van de lijst is.
     */
    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        if (size == data.length) {
            resize(2 * data.length);
        }

        for(int k = size-1; k>=i; k--){
            data[k+1] = data[k];
        }
        data[i] = e;
        size++;
    }

    /**
     * Verwijdert een element op index i uit de lijst. Alle element schijven één plaats op.
     * Geeft de verwijderde element.
     *
     * @param i de index
     * @return de verwijderde element
     * @throws IndexOutOfBoundsException wanneer de gegeven index geen onderdeel van de lijst is.
     */
    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for(int k = i; k < size-1; k++){
            data[k] = data[k+1];
        }
        data[size-1] = null;
        size--;
        return temp;
    }

    /**
     * Kijkt of de index tussen [0, n-1] ligt

     * @throws IndexOutOfBoundsException
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
        if(i<0 || i>=n){
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    /**
     * Vergroot de data array met de gegeven grootte.
     * @param capacity de capaciteit van de nieuwe array.
     */
    protected void resize(int capacity){
        E[] temp = (E[]) new Object[capacity];
        for(int k = 0; k < size; k++){
            temp[k] = data[k];
        }
        data = temp;
    }
}
