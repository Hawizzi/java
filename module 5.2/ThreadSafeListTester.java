import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class ThreadSafeListTester {
    public static void main(String[] args) {
        try {
            runTest();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println("List test interrupted.");
        }
    }

    public static void runTest() throws InterruptedException {
        ThreadSafeList<String> list = new ThreadSafeList<>();
        int threadCount = 8;
        int itemsPerThread = 1000;
        CountDownLatch start = new CountDownLatch(1);
        Thread[] workers = new Thread[threadCount];
        for (int i = 0; i < workers.length; i++) {
            final int workerId = i;
            workers[i] = new Thread(() -> {
                try {
                    start.await();
                    for (int item = 0; item < itemsPerThread; item++) {
                        if (Thread.currentThread().isInterrupted()) { return; }
                        String value = workerId + ":" + item;
                        list.add(value);
                        if (item % 2 == 0) {
                            list.remove(value);
                        }
                        list.size();
                    }
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }
            }, "List worker " + i);
        }
        for (Thread worker : workers) { worker.start(); }
        start.countDown();
        try {
            for (Thread worker : workers) { worker.join(); }
        } catch (InterruptedException exception) {
            for (Thread worker : workers) { worker.interrupt(); }
            throw exception;
        }

        Set<String> expected = new HashSet<>();
        for (int worker = 0; worker < threadCount; worker++) {
            for (int item = 1; item < itemsPerThread; item += 2) {
                expected.add(worker + ":" + item);
            }
        }
        List<String> snapshot = list.snapshot();
        boolean correct = snapshot.size() == expected.size()
                && new HashSet<>(snapshot).equals(expected);
        System.out.println("Worker threads: " + threadCount);
        System.out.println("Total additions: " + threadCount * itemsPerThread);
        System.out.println("Total removals: " + threadCount * (itemsPerThread / 2));
        System.out.println("Expected final size: " + expected.size());
        System.out.println("Actual final size: " + list.size());
        System.out.println("All remaining elements match: " + correct);
        if (!correct) { throw new IllegalStateException("Concurrent list test failed."); }
        System.out.println("Thread-safe list test: PASS");
    }
}
