import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {

    GenericStack<String> genericStack;

    @BeforeEach
    void setup() {
        genericStack = new GenericStack<>();
    }

    @Test
    void push_pop_AddTwoValuesAndRemove_CheckIfAddedAndRemoved() {
        genericStack.push("One");
        genericStack.push("Two");

        assertEquals("Two", genericStack.pop());
        assertEquals("One", genericStack.pop());
    }


    @Test
    void peek_AddTwoValues_CheckIfPeekCorrect() {
        genericStack.push("One");
        genericStack.push("Two");

        assertEquals("One", genericStack.peek());
    }

    @Test
    void empty_CheckingIfNewStackIsEmpty() {
        assertEquals(true, genericStack.empty());
    }

    @Test
    void empty_AddElement_CheckingIfStackIsNotEmpty() {
        genericStack.push("One");
        assertEquals(false, genericStack.empty());
    }
}