package Queue;

public interface ICircularQueue<E> extends IQueue<E>  {
    /**
     * Verplaats de element die vooraan in de queue ligt naar de achterkant van de queue
     * Doet niks als de queue leeg is
     */
    void rotate();
}
