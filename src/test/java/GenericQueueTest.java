import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericQueueTest {

    private GenericQueue<String> genericQueue;

    @BeforeEach
    void setup() {
        genericQueue = new GenericQueue<>();
    }

    @Test
    void queue_AddTwoValuesAndRemove_CheckIfAddedAndRemoved() {
        genericQueue.enqueue("One");
        genericQueue.enqueue("Two");

        assertEquals("One", genericQueue.dequeue());
        assertEquals("Two", genericQueue.dequeue());
    }


    @Test
    void first_AddTwoValues_CheckIfFirstValueCorrect() {
        genericQueue.enqueue("One");
        genericQueue.enqueue("Two");

        assertEquals("One", genericQueue.first());
    }

    @Test
    void empty_CheckingIfNewQueueIsEmpty() {
        assertEquals(true, genericQueue.empty());
    }

    @Test
    void empty_AddElement_CheckingIfQueueIsNotEmpty() {
        genericQueue.enqueue("One");
        assertEquals(false, genericQueue.empty());
    }
}