import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericArrayList<T> implements IList<T> {

    private T[] buffer;

    private final int INITIAL_BUFFER = 0;

    public GenericArrayList() {
        int initialCappacity = INITIAL_BUFFER;
        buffer = (T[]) new Object[initialCappacity];
    }

    @Override
    public void add(T elem) {
        T[] temp = (T[]) new Object[buffer.length + 1];
        int i;
        for (i = 0; i < buffer.length; i++) {
            temp[i] = buffer[i];
        }
        temp[i] = elem;
        buffer = temp;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException {
        IndexOutOfBoundsExceptionCheck(index);
        T[] temp = (T[]) new Object[buffer.length + 1];
        int tempIndex = 0;
        for (int i = 0; i <= buffer.length; i++) {
            if (i == index) {
                temp[tempIndex] = element;
                tempIndex++;

            }
            if (i == buffer.length)
                break;
            temp[tempIndex] = buffer[i];
            tempIndex++;
        }
        buffer = temp;

    }

    @Override
    public T set(int index, T element) {
        T oldItem = buffer[index];
        buffer[index] = element;
        return oldItem;
    }


    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        IndexOutOfBoundsExceptionCheck(index);
        return buffer[index];
    }

    @Override
    public int size() {
        return buffer.length;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        IndexOutOfBoundsExceptionCheck(index);

        T[] temp = (T[]) new Object[buffer.length - 1];
        T item = buffer[index];
        int tempIndex = 0;
        for (int i = 0; i < buffer.length; i++) {
            if (i == index) {
                i++;
            }
            if (i == buffer.length)
                break;

            temp[tempIndex] = buffer[i];
            tempIndex++;
        }
        buffer = temp;
        return item;
    }

    @Override
    public boolean remove(T elem) {
        T[] temp = (T[]) new Object[buffer.length - 1];
        boolean result = false;
        int tempIndex = 0;
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == elem) {
                result = true;
                i++;
            }
            if (i == buffer.length || tempIndex == temp.length)
                break;

            temp[tempIndex] = buffer[i];
            tempIndex++;
        }
        if (result) {
            buffer = temp;
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return buffer.length == 0;
    }

    @Override
    public boolean contains(T element) {
        for (int i = buffer.length - 1; i >= 0; i--) {
            if (buffer[i] == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericArrayListIterator();
    }


    private void IndexOutOfBoundsExceptionCheck(int index) {
        if (index > buffer.length)
            throw new IndexOutOfBoundsException("Index out of bounds");

    }

    class GenericArrayListIterator implements Iterator<T> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < buffer.length;
        }

        @Override
        public T next() {
            if (! hasNext())
                throw new NoSuchElementException();
            return buffer[cursor++];
        }
    }

}
