public class GenericStack<T> implements IStack<T> {
    //LIFO
    private IList<T> stackData = new GenericArrayList<>();

    @Override
    public void push(T element) {
        stackData.add(element);
    }

    @Override
    public T pop() {
        int lastIndex = stackData.size() - 1;
        return stackData.remove(lastIndex);
    }

    @Override
    public T peek() {
        return stackData.get(0);
    }

    @Override
    public boolean empty() {
        return stackData.size() == 0;
    }
}
