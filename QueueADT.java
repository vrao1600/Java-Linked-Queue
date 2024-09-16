package ADTs;

import Exceptions.EmptyCollectionException;

public interface QueueADT<T> extends CollectionADT<T> {
    public void enqueue(T element);

    public T dequeue() throws EmptyCollectionException;

    public T peek() throws EmptyCollectionException;
}
