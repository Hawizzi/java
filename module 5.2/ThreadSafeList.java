import java.util.ArrayList;
import java.util.List;

public class ThreadSafeList<T> {
    private final ArrayList<T> elements = new ArrayList<>();

    public synchronized void add(T element) {
        elements.add(element);
    }

    public synchronized int size() {
        return elements.size();
    }

    public synchronized boolean remove(T element) {
        return elements.remove(element);
    }

    public synchronized List<T> snapshot() {
        return new ArrayList<>(elements);
    }
}
