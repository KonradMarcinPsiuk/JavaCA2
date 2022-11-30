public class GenericQueue<T> implements IQueue<T>{
    //FIFO
    private IList<T> queueData = new GenericArrayList<>();
    @Override
    public void enqueue(T element) {
        queueData.add(element);
    }

    @Override
    public T dequeue() {
        return queueData.remove(0);
    }

    @Override
    public T first() {
        return queueData.get(0);
    }

    @Override
    public boolean empty() {
        return queueData.size()==0;
    }
}
