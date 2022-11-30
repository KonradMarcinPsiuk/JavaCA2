import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GenericLinkedListTests {

    GenericLinkedList<String> genericList;


    @BeforeEach
    void setup(){
        genericList = new GenericLinkedList<>();
    }

    @Test
    void add_AddTwoElements_ReturnTwo() {
        genericList.add("One");
        assertEquals(genericList.size(),1);

        genericList.add("Two");
        assertEquals(genericList.size(),2);
    }

    @Test
    void addByIndex_AddFourElements_CheckForCorrectIndex() {
        genericList.add(0,"Three");
        genericList.add(0,"One");
        genericList.add(1,"Two");
        genericList.add(3,"Four");

        assertEquals(genericList.get(0),"One");
        assertEquals(genericList.get(1),"Two");
        assertEquals(genericList.get(2),"Three");
        assertEquals(genericList.get(3),"Four");
    }

    @Test
    void addByIndex_AddToSecondIndex_ThrowException(){
        assertThrows(IndexOutOfBoundsException.class,()->{
            genericList.add(1,"Three");});
    }

    @Test
    void set_SetTwoValues_CheckIFSetCorrectly() {
        genericList.add("One");
        genericList.add("Two");

        genericList.set(0,"Three");
        genericList.set(1,"Four");

        assertEquals(genericList.get(0),"Three");
        assertEquals(genericList.get(1),"Four");
    }

    @Test
    void set_SetValueOutsideOFIndex_ThrowException() {
        assertThrows(IndexOutOfBoundsException.class,()->{
            genericList.set(1,"One");});
    }

    @Test
    void get_AddValueAndGetIt_CheckIfCorrectReturned() {
        genericList.add("One");
        genericList.add("Two");

        var one  = genericList.get(0);
        var two = genericList.get(1);

        assertEquals(one,"One");
        assertEquals(two,"Two");
    }

    @Test
    void get_GetValueOutsideTheIndex_ThrowException(){
        genericList.add("One");
        assertThrows(IndexOutOfBoundsException.class,()->{
            genericList.get(1);});
    }

    @Test
    void size_addTwoValues_CheckForSize() {
        genericList.add("One");
        genericList.add("Two");

        assertEquals(2, genericList.size());
    }

    @Test
    void removeByIndex_addThreeValuesRemoveTwo_CheckIfRemoved() {
        genericList.add("One");
        genericList.add("Two");
        genericList.add("Three");

        genericList.remove(0);
        genericList.remove(0);

        assertEquals(1, genericList.size());
        assertEquals("Three", genericList.get(0));
    }

    @Test
    void removeByElement_AddThreeItemsRemoveTwo_CheckIfRemoved() {
        genericList.add("One");
        genericList.add("Two");
        genericList.add("Three");

        var check1= genericList.remove("Two");
        var check2 = genericList.remove("Three");

        assertEquals(1, genericList.size());
        assertEquals("One", genericList.get(0));
        assertEquals(true,check1);
        assertEquals(true,check2);
    }

    @Test
    void removeByElement_AddThreeItemsRemoveDifferent_CheckIfNotRemoved() {
        genericList.add("One");
        genericList.add("Two");
        genericList.add("Three");

        var check = genericList.remove("Four");

        assertEquals(3, genericList.size());
        assertEquals(false,check);
    }

    @Test
    void isEmpty_CreateEmptyList_CheckIfEmpty() {
        assertEquals(true, genericList.isEmpty());
    }

    @Test
    void contains_AddTwoElements_CheckIfPresent() {
        genericList.add("One");
        genericList.add("Two");

        assertEquals(true, genericList.contains("One"));
        assertEquals(true, genericList.contains("Two"));
    }

    @Test
    void contains_AddTwoElements_CheckIfDifferentElementNotPresent() {
        genericList.add("One");
        genericList.add("Two");

        assertEquals(false, genericList.contains("Three"));
    }

    @Test
    void iterator_AddThreeElements_CheckIfReturnedCorrectly() {
        genericList.add("One");
        genericList.add("Two");
        genericList.add("Three");

        int i = 0;
        for (var element: genericList) {
            assertEquals(genericList.get(i),element);
            i++;
        }
    }
}
