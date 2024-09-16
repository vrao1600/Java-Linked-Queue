package DataStructures;

import Exceptions.EmptyCollectionException;
import ADTs.QueueADT;

/**
 * A LinkedQueue is a queue implementation using a singly linked list.
 * This class implements the QueueADT interface, providing the basic queue operations.
 * @param <T> the type of elements held in this queue, which must be comparable
 */
public class LinkedQueue<T extends Comparable<T>> implements QueueADT<T> {

    /**
     * The front of the queue.
     */
    private SinglyLinkedNode<T> front;

    /**
     * The rear of the queue.
     */
    private SinglyLinkedNode<T> rear;

    /**
     * The number of elements in the queue.
     */
    private int size;

    /**
     * Creates an empty queue.
     */
    public LinkedQueue() {
        front = rear = null;
        size = 0;
    }


    public void enqueue(T element) {
        SinglyLinkedNode<T> newNode = new SinglyLinkedNode<>(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }


    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        T result = front.getData();
        front = front.getNext();
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return result;
    }


    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        return front.getData();
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        SinglyLinkedNode<T> current = front;
        while (current != null) {
            sb.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return sb.toString().trim();
    }
}