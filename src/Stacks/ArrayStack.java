package Stacks;

public class ArrayStack<E> implements IStack<E> {

    /**
     * standaard capaciteit van de stack
     */
    private static final int CAPACITY = 1000;
    /**
     * array die gebruikt word voor het opslaan van elementen op de stack
     */
    private E[] data;
    /**
     * index van top element
     */
    private int t = -1;

    /**
     * Constructor voor het maken van een stack met de standaard capaciteit
     */
    public ArrayStack(){
        this(CAPACITY);
    }

    /**
     * Constructor voor het maken van een stack
     * @param capacity de capaciteit van de stack
     */
    public ArrayStack(int capacity){
        //Kan geen array van een generic maken
        //daarom maken we een array van objecst en casten we die naar de generic
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return (t - 1);
    }

    @Override
    public boolean isEmpty() {
        return ( t == -1);
    }

    @Override
    public void push(E e) throws IllegalStateException {
        if((size() == data.length)){
            throw new IllegalStateException("Stack is full");
        }
        t++;
        data[t] = e;
    }

    @Override
    public E top() {
        if (isEmpty()){
            return null;
        }
        else{
            return data[t];
        }
    }

    @Override
    public E pop() {
        if (isEmpty()){
            return null;
        }
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }
}
