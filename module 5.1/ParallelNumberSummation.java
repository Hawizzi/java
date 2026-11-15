import java.util.Random;

public class ParallelNumberSummation {
    public static long calculateSum(int[] numbers, int threadCount) throws InterruptedException {
        if (numbers == null || threadCount <= 0) {
            throw new IllegalArgumentException("An array and a positive thread count are required.");
        }
        if (numbers.length == 0) { return 0; }
        int workers = Math.min(threadCount, numbers.length);
        SumWorker[] threads = new SumWorker[workers];
        for (int i = 0; i < workers; i++) {
            int start = (int) ((long) i * numbers.length / workers);
            int end = (int) ((long) (i + 1) * numbers.length / workers);
            threads[i] = new SumWorker(numbers, start, end);
        }
        for (SumWorker worker : threads) {
            worker.start();
        }
        long total = 0;
        try {
            for (SumWorker worker : threads) {
                worker.join();
                total += worker.getSum();
            }
        } catch (InterruptedException exception) {
            for (SumWorker worker : threads) {
                worker.interrupt();
            }
            throw exception;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] numbers = new int[100000];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000);
        }
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Array size: " + numbers.length);
        System.out.println("Available processor cores: " + cores);
        System.out.println("Worker threads: " + Math.min(cores, numbers.length));
        try {
            long start = System.nanoTime();
            long parallelSum = calculateSum(numbers, cores);
            long elapsed = System.nanoTime() - start;
            long sequentialSum = 0;
            for (int number : numbers) {
                sequentialSum += number;
            }
            System.out.println("Parallel sum: " + parallelSum);
            System.out.println("Sequential sum: " + sequentialSum);
            System.out.println("Results match: " + (parallelSum == sequentialSum));
            System.out.println("Parallel elapsed time: " + elapsed / 1000000.0 + " ms");
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println("Summation interrupted.");
        }
    }
}
