import java.util.*;

public class BlockingQueue<T> {

    private Queue<T> q = new LinkedList<T>();
    private int size;

    public BlockingQueue(int size) {
        this.size = size;
    }

    public synchronized void put (T t) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        q.add(t);
        notifyAll();
    }

    public synchronized T get () throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        T t = q.poll();
        notifyAll();
        return t;
    }

    private boolean isEmpty() {
        return q.size() == 0;
    }
    private boolean isFull() {
        return q.size() == size;
    }
}