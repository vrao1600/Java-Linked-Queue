package DataStructures;

import Exceptions.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedQueueTest {
    LinkedQueue<Integer> list = new LinkedQueue<Integer>();

    @Test
    public void testLinkedQueue() {
        // LinkedList
        assertEquals(0, list.size());

        list = new LinkedQueue<Integer>();
        assertEquals(0, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        try {
            list.enqueue(1);
            assertEquals(1, list.size());
            list.enqueue(2);
            assertEquals(2, list.size());
        } catch (Exception e) {
            fail("Shoud not throw exception here: " + e.toString());
        }

        try {
            list.dequeue();
            assertEquals(1, list.size());
            list.dequeue();
            assertEquals(0, list.size());
        } catch (EmptyCollectionException e) {
            fail("EmptyCollectionException should not be thrown here.");
        }
    }

    @Test
    public void testEnqueue() {

        try {
            list.enqueue(1);
        } catch (Exception e) {
            fail("Exception should not be thrown here: " + e.toString());
        }
        assertEquals(1, list.size());
        try {
            assertEquals(1, list.peek().intValue());
        } catch (Exception e) {
            fail("Exception should not be thrown here.");
        }

        try {
            list.enqueue(2);
        } catch (Exception e) {
            fail("Exception should not be thrown here: " + e.toString());
        }

        assertEquals(2, list.size());
        try {
            assertEquals(1, list.peek().intValue());
        } catch (Exception e) {
            fail("Exception should not be thrown here: " + e.toString());
        }
    }

    @Test
    public void testDequeue() {

        try {
            list.enqueue(1);
            list.enqueue(2);
            list.enqueue(3);
        } catch (Exception e) {
            fail("Exception should not be thrown here: " + e.toString());
        }

        try {
            assertEquals(3, list.size());
            Integer out = list.dequeue();
            assertEquals(1, out.intValue());
            assertEquals(2, list.size());
        } catch (Exception e) {
            fail("Exception should not be thrown here.");
        }

        try {
            assertEquals(2, list.size());
            Integer out = list.dequeue();
            assertEquals(2, out.intValue());
            assertEquals(1, list.size());
        } catch (Exception e) {
            fail("Exception should not be thrown here.");
        }

        try {
            Integer out = list.dequeue();
            assertEquals(3, out.intValue());
            assertEquals(0, list.size());
        } catch (Exception e) {
            fail("Exception should not be thrown here.");
        }

        try {
            list.dequeue();
        } catch (Exception e) {
            assertTrue("EmptyCollectionException should be thrown here.", e instanceof EmptyCollectionException);
        }
    }

    @Test
    public void testPeek() {

        try {
            list.enqueue(1);
        } catch (Exception e) {
            fail("Exception should not be thrown here: " + e.toString());
        }

        try {
            assertEquals(1, list.size());
            assertEquals(1, list.peek().intValue());
        } catch (Exception e) {
            fail("Exception should not be thrown here.");
        }

        try {
            list.enqueue(2);
        } catch (Exception e) {
            fail("Exception should not be thrown here: " + e.toString());
        }

        try {
            assertEquals(2, list.size());
            assertEquals(1, list.peek().intValue());
            list.dequeue();
            assertEquals(2, list.peek().intValue());
        } catch (Exception e) {
            fail("Exception should not be thrown here.");
        }

        try {
            list.dequeue();
        } catch (Exception e) {
            fail("Exception should not be thrown here: " + e.getMessage());
        }

        try {
            list.peek();
        } catch (Exception e) {
            assertTrue("EmptyCollectionException should be thrown here.", e instanceof EmptyCollectionException);
        }
    }
}
